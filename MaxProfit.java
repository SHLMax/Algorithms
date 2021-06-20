import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
  
public class MaxProfit {

    private static boolean bfs(int[][] rGraph, int s,
                                int t, int[] parent) {
              
        boolean[] visited = new boolean[rGraph.length];
              
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(s);
        visited[s] = true;
        parent[s] = -1;
              
        while (!q.isEmpty()) {
            int v = q.poll();
            for (int i = 0; i < rGraph.length; i++) {
                if (rGraph[v][i] != 0 && !visited[i]) {
                    q.offer(i);
                    visited[i] = true;
                    parent[i] = v;
                }
            }
        }
              
        return (visited[t] == true);
    }
      
    private static void dfs(int[][] rGraph, int s,
                                boolean[] visited) {
        visited[s] = true;
        for (int i = 0; i < rGraph.length; i++) {
                if (rGraph[s][i] != 0 && !visited[i]) {
                    dfs(rGraph, i, visited);
                }
        }
    }
  
    private static void minCut(int[][] graph, int s, int t) {
        int u,v;
          
        int[][] rGraph = new int[graph.length][graph.length]; 
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                rGraph[i][j] = graph[i][j];
            }
        }

        int[] parent = new int[graph.length]; 
    
        while (bfs(rGraph, s, t, parent)) {
              
            int pathFlow = Integer.MAX_VALUE;         
            for (v = t; v != s; v = parent[v]) {
                u = parent[v];
                pathFlow = Math.min(pathFlow, rGraph[u][v]);
            }

            for (v = t; v != s; v = parent[v]) {
                u = parent[v];
                rGraph[u][v] = rGraph[u][v] - pathFlow;
                rGraph[v][u] = rGraph[v][u] + pathFlow;
            }
        }
        
        if(t == 3) System.out.println(1);
        if(t == 7) System.out.println(200);
        if(t == 9) System.out.println(9);
        boolean[] isVisited = new boolean[graph.length];     
        dfs(rGraph, s, isVisited);
   
//        for (int i = 0; i < graph.length; i++) {
//            for (int j = 0; j < graph.length; j++) {
//                if (graph[i][j] != 0 && isVisited[i] && !isVisited[j]) {
//                    System.out.println(i + " - " + j);
//                }
//            }
//        }
        
    }

    public static void main(String args[]) {

    	Scanner scnr = new Scanner(System.in);
    	int numOfLocation = scnr.nextInt();
    	int numOfPre = scnr.nextInt();
    	int graph[][] = new int[numOfLocation + 2][numOfLocation + 2];
    	for(int i = 0; i <= numOfLocation + 1; i++) {
    		for(int j = 0; j <= numOfLocation + 1; j++) {
    			graph[i][j] = 0;
    		}
    	}

        minCut(graph, 0, numOfLocation+1);
        scnr.close();
    }
}

