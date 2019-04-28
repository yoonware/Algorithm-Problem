import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {

	static int num_sim_user_topk;
	static int num_item_rec_topk;
	static int num_users;
	static int num_items;
	static int num_rows;
	static int num_reco_users;
	
	static int t1;
	static int t2;
	static double t3;
	
	static int recoUsers[];
	static HashMap<Integer, User> userMap;
	static ArrayList<Integer> itemList;
	
    public static void main(String[] args) {
    	userMap = new HashMap<>();
    	itemList = new ArrayList<>();
    	num_sim_user_topk = ss.nextInt();
    	num_item_rec_topk = ss.nextInt();
    	num_users = ss.nextInt();
    	num_items = ss.nextInt();
    	num_rows = ss.nextInt();
    	for(int i = 0; i < num_rows; i++) {
    		t1 = ss.nextInt();
    		t2 = ss.nextInt();
    		t3 = ss.nextDouble();
    		if(!userMap.containsKey(t1))
    			userMap.put(t1, new User(t1));
    		userMap.get(t1).put_ir(t2, t3);
    		if(!itemList.contains(t2))
    			itemList.add(t2);
    	}
    	num_reco_users = ss.nextInt();
    	recoUsers = new int[num_reco_users];
    	for(int i = 0; i < num_reco_users; i++)
    		recoUsers[i] = ss.nextInt();
    	Iterator<User> it = userMap.values().iterator();
    	while(it.hasNext())
    		it.next().make_r();
    	for(int i = 0; i < num_reco_users; i++) {
    		userMap.get(recoUsers[i]).make_si();
    		userMap.get(recoUsers[i]).make_ex();
    		userMap.get(recoUsers[i]).print();
    	}
    	System.out.println(sb.toString());
    }
    
    static class User {
    	int uNum;
    	double r;
    	HashMap<Integer, Double> irMap, siMap, exMap;
    	User(int u) {
    		uNum = u;
    		r = 0;
    		irMap = new HashMap<>();
    		siMap = new HashMap<>();
    		exMap = new HashMap<>();
    	}
    	void put_ir(int item, double rating) {
    		irMap.put(item, rating);
    	}
    	void make_r() {
    		double sigma = 0;
    		for (Map.Entry<Integer, Double> irEntry : irMap.entrySet())
    			sigma += irEntry.getValue();
    		r = sigma / irMap.size();
    	}
    	void make_si() {
    		for(Map.Entry<Integer, User> userEntry : userMap.entrySet()) {
    			int user = userEntry.getKey();
    			if(uNum != user)
    				siMap.put(user, make_simil(uNum, user));
        	}
    	}
    	void make_ex() {
    		int u[] = new int[num_sim_user_topk];
    		Iterator<Integer> it = sort_by_value(siMap).iterator();
    		for(int i = 0 ; i < num_sim_user_topk; i++)
    			u[i] = it.next();
    		for(int i = 0; i < itemList.size(); i++) {
    			int cand = itemList.get(i);
    			if(irMap.containsKey(cand))
    				continue;
    			int nothing = 0;
    			double k = 0, sigma = 0;
    			for(int j = 0 ; j < num_sim_user_topk; j++) {
    				if(!userMap.get(u[j]).irMap.containsKey(cand)) {
    					nothing++;
    					continue;
    				}
    				k += Math.abs(siMap.get(u[j]));
    				sigma += siMap.get(u[j]) * (userMap.get(u[j]).irMap.get(cand) - userMap.get(u[j]).r);
        		}
    			if(nothing == num_sim_user_topk) {
    				exMap.put(cand, (double) -5);
    				continue;
    			}
    			double result = r + (sigma / k);
    			exMap.put(cand, result);
    		}
    		for(int i = 0; i < num_items; i++)
    			if(!exMap.containsKey(i))
    				exMap.put(i, (double)-5);
    	}
    	void print() {
    		Iterator<Integer> it = sort_by_value(exMap).iterator();
    		for(int i = 0 ; i < num_item_rec_topk; i++)
    			sb.append(it.next() + " ");
    		sb.append("\n");
    	}
    }
    
    static double make_simil(int x, int y) {
    	double rx = userMap.get(x).r;
    	double ry = userMap.get(y).r;
    	double sigma_up = 0;
    	double sigma_d1 = 0;
    	double sigma_d2 = 0;
    	for(Map.Entry<Integer, Double> hxEntry : userMap.get(x).irMap.entrySet()) {
    		if(userMap.get(y).irMap.containsKey(hxEntry.getKey())) {
    			double rxi = hxEntry.getValue();
        		double ryi = userMap.get(y).irMap.get(hxEntry.getKey());
    			double a = rxi - rx;
    			double b = ryi - ry;
    			sigma_up += (a * b);
    			sigma_d1 += (a * a);
    			sigma_d2 += (b * b);
    		}
    	}
    	double result = sigma_up / (Math.sqrt(sigma_d1) * Math.sqrt(sigma_d2));
    	return Math.round(result * 100000) / 100000.0;
    }
    
    static List<Integer> sort_by_value(final HashMap<Integer, Double> map) {
        List<Integer> keys = new ArrayList<>();
        keys.addAll(map.keySet());
        Collections.sort(keys, new Comparator<Integer>() {
            public int compare(Integer o1,Integer o2) {
                Double d1 = map.get(o1);
                Double d2 = map.get(o2);
                return d2.compareTo(d1);
            }
        });
        return keys;
    }

    static class StringScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    String str = br.readLine();
                    if (str == null)
                        return null;
                    st = new StringTokenizer(str);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt() {
            return Integer.parseInt(next());
        }
        double nextDouble() {
        	return Double.parseDouble(next());
        }
    }

    static StringScanner ss = new StringScanner();
    static StringBuilder sb = new StringBuilder();

}