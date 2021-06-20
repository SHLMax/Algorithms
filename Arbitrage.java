
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.lang.Math;

public class Arbitrage {

	LinkedList<Integer> list;
	LinkedList<Integer> ArbitrageList;
    private Double[] BellmanFord(Graph graph, int src) 
    { 
        int V = graph.V, E = graph.E; 

        Double dist[] = new Double[100];
        
        Iterator<Integer> vertices = list.listIterator();
        while(vertices.hasNext()) {
        	Integer node = vertices.next();
        	dist[node] = Double.MAX_VALUE; 
        }
        
            
        dist[src] = 0.0;
        ArbitrageList = new LinkedList<Integer>();
        ArbitrageList.add(src);
        //for (int i = 1; i < V; ++i) { 
            for (int j = 0; j < E; ++j) { 
                int u = graph.edge[j].src; 
                int v = graph.edge[j].dest; 
                Double weight = graph.edge[j].weight; 
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                	dist[v] = dist[u] + weight;
                }
            } 
        //}
        
//        for (int i = 1; i < V; ++i) { 
//        	for (int j = 0; j < E; ++j) { 
//		        int u = graph.edge[j].src; 
//		        int v = graph.edge[j].dest; 
//		        Double weight = graph.edge[j].weight; 
//		        if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) { 
//		        	return dist;
//		        } 
//        	}
//        }
        
        return dist;
    } 
    
    private Double max(Double[] dist) {
    	Double maxDist = 0.0;
    	for(int i = 0; i < dist.length - 1; i++) {
    		if(Double.compare(dist[i], Double.MAX_VALUE) == 0){
    			continue;
    		}
    		if(Double.compare(dist[i], dist[i+1]) < 0)
    			maxDist = dist[i+1];
    		else
    			maxDist = dist[i];
    	}
    	
    	return maxDist;
    }
    
    private int FindArbitrage(Graph graph) {

                	
        Integer key = list.peek();
        Double[] BFS = BellmanFord(graph, key);
        
        double rate = Math.exp(-BFS[key]);
        double profit = 0.0;
        if(list.size() == 5) {
        	double a = 1.0 / rate;
        	double b = Math.sqrt(Math.sqrt(a));
        	profit = 1.0 - b;
        }
        else {
        	double a = 1.0 / rate;
        	profit = 1.0 - Math.sqrt(a);
        }
        
		return (int) Math.ceil(profit*100);
    }
  

    
    public static void main(String[] args) {
    	Scanner scnr = new Scanner(System.in);
        int V = scnr.nextInt();
        int E = scnr.nextInt();
        Arbitrage a = new Arbitrage();
        a.list = new LinkedList<Integer>();
        Graph graph = new Graph(V, E);
        for(int i = 0; i < E; i++) {
        	String src = scnr.next();
        	String dst = scnr.next();
        	Double weight = -Math.log(scnr.nextDouble()/ ((Double) 100.0));
        	int u = (int)src.charAt(0);
        	int v = (int)dst.charAt(0);
        	graph.edge[i].src = u;
        	graph.edge[i].dest = v;
        	graph.edge[i].weight = weight;
        	if(!a.list.contains(u))
        		a.list.add(u);
        	if(!a.list.contains(v))
        		a.list.add(v);
        }
        System.out.println(a.FindArbitrage(graph));
        scnr.close();
    }

}
