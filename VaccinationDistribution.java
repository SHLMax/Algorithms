import java.util.Arrays;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Scanner;


public class VaccinationDistribution {
	
    protected class Vertex {
    	public int u;
    	public int v;
    	public Vertex(int x, int y) {
    		u = x;
    		v = y;
    	}
    }
    
	protected Hashtable<Integer, LinkedList<Vertex>> vertices;
	Vertex[] VArray;
	public int[] Edge;
	private int V;
	private int E;
	private int K;
	
	public VaccinationDistribution(int x, int y, int z) {
		V = x;
		K = y;
		E = z;
		Edge = new int[E];
		vertices = new Hashtable<>();
		VArray = new Vertex[V];
		
    }
	
	public void isConnected(boolean[][] g, int x) {
		for(int i = 0; i < g[x].length; i ++) {
			
		}
	}
	
	public int findMaxEdge() {
		int[] MSTEdge = new int[V-1];
		boolean[][] IsInGraph = new boolean[V][V];
		int c = 0;
		for(int i = 0; i < Edge.length; i++) {
			int weight = Edge[i];
			for(int j = 0; j < vertices.get(weight).size(); j++) {
				int x = vertices.get(weight).get(j).u;
				int y = vertices.get(weight).get(j).v;
				if(!IsInGraph[x-1][y-1]) {
					MSTEdge[c] = Edge[i];
					IsInGraph[x-1][y-1] = true;					
					c++;
				}
			}
		}
		
		return MSTEdge[V-K];
	}
	
	
    public void start(int x, int y, int z, int index) {
		Vertex vertex = new Vertex(x,y);
		Edge[index] = z;
		LinkedList<Vertex> vs = new LinkedList<Vertex>();
		vs.add(vertex);
		if(vertices.containsKey(z)) {
			vertices.get(z).add(vertex);
		} else {
			vertices.put(z, vs);
		}
    }

    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scnr = new Scanner(System.in);
		int n = scnr.nextInt();
		int k = scnr.nextInt();
		int m = scnr.nextInt();
		VaccinationDistribution VD = new VaccinationDistribution(n,k,m);
		for(int i = 0; i < m; i++) {
			int u = scnr.nextInt();
			int v = scnr.nextInt();
			int w = scnr.nextInt();
			VD.start(u, v, w, i);
		}
		Arrays.sort(VD.Edge);
		System.out.print(VD.findMaxEdge());
		scnr.close();
	}

}
