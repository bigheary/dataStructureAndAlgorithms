package beautyOfProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

class StdIOUtils {

	//将空白符全部去掉
	public static String[] splitBySpace(String str){
		return str.split("\\s+");
	}
	
	//将string数组转换为int数组
	public static int[] strParseInt(String[] str){
		int[] t = new int[str.length];
		for(int i = 0; i < str.length; i++){
			t[i] = Integer.parseInt(str[i]);
		}
		return t;
	}
}

class Bag{
	private int toV;
	private int weight;
	public Bag(int v, int weight){
		this.toV = v;
		this.weight = weight;
	}
	public int getWeight(){
		return weight;
	}
	public void setWeight(int w){
		this.weight = w;
	}
	
	public void setV(int v){
		this.toV = v;
	}
	public int getToV(){
		return toV;
	}
}

class Graph{
	private LinkedList<Bag>[] adj;
	private int V;
	
	public Graph(int V){
		this.V = V;
		adj = (LinkedList<Bag>[])new LinkedList[V];
		for(int v = 0; v < V; v++)
			adj[v] = new LinkedList<>();
	}
	
	public void addEdge(int u, int v, int w){
		adj[u].add(new Bag(v, w));
		adj[v].add(new Bag(u, w));
	}
	
	public LinkedList<Bag> getAdj(int u){
		return adj[u];
	}
	
	public int getV(){
		return V;
	}
	
}

public class MinEnemySearchingValue {
	private Graph graph;
	private boolean[] marked;
	private int maxPathLength;
	private int target;
	
	public void setMaxPathLength(int K){
		maxPathLength = K;
	}
	public void setTarget(int T){
		target = T;
	}
	public void setGraph(Graph graph){
		this.graph = graph;
	}
	
	public boolean dfs(int v, int pathLength, int enemySearchingValue){
		if(pathLength > maxPathLength)
			return false;
		marked[v] = true;
		if (target == v) {
			return true;
		}
		for(Bag b:graph.getAdj(v)){
			if (b.getWeight() > enemySearchingValue) {
				continue;
			}
			if (!marked[b.getToV()]) {
				if(dfs(b.getToV(), pathLength+1, enemySearchingValue)){
					return true;
				}
			}
		}
		marked[v] = false;
		return false;
	}
	
	public boolean canGetToTarget(int enemySearchingValue){
		marked = new boolean[graph.getV()];
		if(dfs(1, 0, enemySearchingValue))
			return true;
		return false;
	}
	
	public int getMinumEnemySearchingValue(Graph graph, int L, int R){
		setGraph(graph);
		if(!canGetToTarget(R))
			return -1;
		if(canGetToTarget(L))
			return L;
		int mid;
		while(L < R-1){
			mid = (L+R)/2;
			if (canGetToTarget(mid)) {
				R = mid;
			}else {
				L = mid;
			}
		}
		return R;
	}
	
	public static void main(String[] args) throws IOException{
		//input
		BufferedReader stdin = new BufferedReader(
		       new InputStreamReader(System.in));
		
		// get NMKT
		String s = stdin.readLine();
		int[] params = StdIOUtils.strParseInt(StdIOUtils.splitBySpace(s));
		int N = params[0];
		int M = params[1];
		int K = params[2];
		int T = params[3];
		
		// graph L R
		Graph graph = new Graph(N+1);
		int L = 0, R = 0;
		s = stdin.readLine();
		params = StdIOUtils.strParseInt(StdIOUtils.splitBySpace(s));
		graph.addEdge(params[0], params[1], params[2]);
		L = params[2];
		R = params[2];
		
		for(int m = 1; m < M; m++){
			s = stdin.readLine();
			params = StdIOUtils.strParseInt(StdIOUtils.splitBySpace(s));
			graph.addEdge(params[0], params[1], params[2]);
			if(L > params[2])
				L = params[2];
			else if(R < params[2])
				R = params[2];
		}
		
		// find min searchingenemeyValue
		MinEnemySearchingValue msv = new MinEnemySearchingValue();
		msv.setMaxPathLength(K);
		msv.setTarget(T);
		System.out.println(msv.getMinumEnemySearchingValue(graph, L, R));
	}
}
