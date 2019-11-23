import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution {
	
	static int n, num, root, node, miss;
	static HashMap<Integer, Child> tree;
	static String s;
	static Child c;
	
    public static void main(String[] args) {
    	n = ss.nextInt();
    	tree = new HashMap<>();
    	for(int i = 0; i < n; i++) {
    		s = ss.next();
    		if(s.equals("i")) {
    			num = ss.nextInt();
    			if(tree.size() == 0)
    				tree.put(root = num,  new Child());
    			if(!tree.containsKey(num))
    				insert();
    		}
    		else
    			miss += down(ss.next());
    	}
    	System.out.println("#1" + " " + miss);
    }
    
    static class Child {
    	int L;
    	int R;
    	Child() {
    		L = -1;
    		R = -1;
    	}
    }
    
    static void insert() {
    	tree.put(num, new Child());
    	node = root;
    	while(true) {
    		c = tree.get(node);
    		if(num < node) {
    			if(c.L == -1) {
    				c.L = num;
    				return;
    			}
    			node = c.L;
    		}
    		else {
    			if(c.R == -1) {
    				c.R = num;
    				return;
    			}
    			node = c.R;
    		}
    	}
    }
    
    static int down(String order) {
    	node = root;
    	while(order.length() != 0) {
    		c = tree.get(node);
    		if(order.charAt(0) == 'L') {
    			if(c.L == -1)
    				return 1;
    			node = c.L;
    		}
    		else {
    			if(c.R == -1)
    				return 1;
    			node = c.R;
    		}
    		order = order.substring(1);
    	}
    	return 0;
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
    }

    static StringScanner ss = new StringScanner();
    static StringBuilder sb = new StringBuilder();
    
}