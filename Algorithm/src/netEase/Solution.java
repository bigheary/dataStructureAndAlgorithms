package netEase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
import java.util.TreeMap;



class Diagraph {
	private final int V;
	private int E;
	private LinkedList<Integer>[] adj;
	
	public Diagraph(int V){
		this.V = V;
		this.E = 0;
		adj = (LinkedList<Integer>[])new LinkedList[V];
		for(int v = 0; v < V; v++){
			adj[v] = new LinkedList<>();
		}
	}
	
	public void addEdge(int v, int w){
		adj[v].add(w);
		E++;
	}
	
	public int V(){
		return V;
	}
	
	public Iterable<Integer> adj(int v){
		return adj[v];
	}
	
	public Diagraph reverse(){
		Diagraph R = new Diagraph(V);
		for(int v = 0; v < V; v++){
			for (int w: adj(v)){
				R.addEdge(w, v);
			}
		}
		return R;
	}
	
}

class DirectedCycle {
	private boolean[] marked;
	private int[] edgeTo;
	private Stack<Integer> cycle;
	private boolean[] onStack;
	
	public DirectedCycle(Diagraph G){
		onStack = new boolean[G.V()];
		edgeTo = new int[G.V()];
		marked = new boolean[G.V()];
		for(int v = 0; v < G.V(); v++){
			if(!marked[v]) dfs(G, v);
		}
	}
	
	public void dfs(Diagraph G, int v){
		onStack[v] = true;
		marked[v] = true;
		for(int w : G.adj(v)){
			if (this.hasCycle()) {
				return;
			}else if(!marked[w]){
				edgeTo[w] = v;
				dfs(G, w);
			}else if(onStack[w]){
				cycle = new Stack<Integer>();
				for(int x = v; x != w; x = edgeTo[x]){
					cycle.push(x);
				}
				cycle.push(v);
				cycle.push(w);
			}
		}
		onStack[v] = false;
	}
	
	public boolean hasCycle(){
		return cycle != null;
	}
	
	

}


class DepthFirstOrder {
	private boolean[] marked;
	private Stack<Integer> reversePost;
	
	public DepthFirstOrder(Diagraph G){
		reversePost = new Stack<Integer>();
		marked = new boolean[G.V()];
		
		for(int v = 0; v < G.V(); v++){
			if(!marked[v]) dfs(G, v);
		}
	}
	
	private void dfs(Diagraph G, int v) {
		marked[v] = true;
		for(int w : G.adj(v))
			if(!marked[w])
				dfs(G, w);
		
		reversePost.push(v);
	}
	
	public Iterable<Integer> reversePost(){
		return reversePost;
	}
}

class Topological {

	private Iterable<Integer> order;
	
	public Topological(Diagraph G){
		DirectedCycle cyclefinder = new DirectedCycle(G);
		if(!cyclefinder.hasCycle()){
			DepthFirstOrder dfs = new DepthFirstOrder(G);
			
			order = dfs.reversePost();
		}
	}
	
	public Iterable<Integer> order(){
		return order;
	}
}





public class Solution {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
        BufferedReader stdin = new BufferedReader(
        		new InputStreamReader(System.in));
        String T;
        T = stdin.readLine();
        for (int t = 0; t < Integer.parseInt(T); t++) {
			String N = stdin.readLine();
			LinkedList<String> lineInfo = new LinkedList<>();
			Diagraph G = new Diagraph(Integer.parseInt(N));
			LinkedList<String> filename = new LinkedList<>();
			for (int n = 0; n < Integer.parseInt(N); n++) {
				String line = stdin.readLine();
				lineInfo.add(line);
			}
			
			TreeMap<String, LinkedList<Integer>> tm = new TreeMap<>();
			for(int n = 0; n < Integer.parseInt(N); n++){
				String[] params = lineInfo.get(n).split(" ");
				filename.add(params[0]);
				LinkedList<Integer> nodeList = new LinkedList<>();
				nodeList.add(n);
				if(params.length > 2){
					int[] index = new int[params.length - 2];
					for(int i = 2; i < params.length; i++)
						index[i-2] = (Integer.parseInt(params[i]));
					Arrays.sort(index);
					for(int i =index.length-1; i > 0 ; i--){
						nodeList.add(index[i]);
					}
				}
				tm.put(params[0], nodeList);				
			}
			
			//建图
			for(int n = 0; n < Integer.parseInt(N); n++){
				Iterator<String, >
				G.addEdge(v, w);
			}
			
			Topological tpg = new Topological(G);
			
			if(tpg.order() == null){
				System.out.println("ERROR");
				System.out.println();
			}else {
				for(int v: tpg.order()){
					System.out.println(filename.get(v));
				}
				System.out.println();
			}	
		}
	}

}
