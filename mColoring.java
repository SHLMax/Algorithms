import java.util.Scanner;

public class mColoring {
    private int V = 0;
    int color[];
 
    mColoring(int v){
    	this.V = v;
    }

    boolean isSafe(int v, int graph[][], int color[],
                   int c)
    {
        for (int i = 0; i < V; i++)
            if (graph[v][i] == 1 && c == color[i])
                return false;
        return true;
    }
 
    boolean graphColoringUtil(int graph[][], int m,
                              int color[], int v)
    {

        if (v == V)
            return true;
 
        for (int c = 1; c <= m; c++)
        {

            if (isSafe(v, graph, color, c))
            {
                color[v] = c;
 
                if (graphColoringUtil(graph, m,
                                      color, v + 1))
                    return true;
 
                color[v] = 0;
            }
        }
 
        return false;
    }
 
    boolean graphColoring(int graph[][], int m)
    {

        color = new int[V];
        for (int i = 0; i < V; i++)
            color[i] = 0;
 
        if (!graphColoringUtil(graph, m, color, 0))
        {
            
            return false;
        }
        
        return true;
    }
 
    public static void main(String args[])
    {
        
    	Scanner scnr = new Scanner(System.in);
    	int V = scnr.nextInt();
    	mColoring Coloring = new mColoring(V);
    	int E = scnr.nextInt();
    	int k = scnr.nextInt();
    	int[][] graph = new int[V][V];
    	for(int i = 0; i < E; i++) {
    		int u = scnr.nextInt() - 1;
    		int v = scnr.nextInt() - 1;
    		graph[u][v] = 1;
    		graph[v][u] = 1;
    	}
    	
    	scnr.close();
    	if(Coloring.graphColoring(graph, k))
    		System.out.println("True");
    	else
    		System.out.println("False");
        //System.out.print(Coloring.graphColoring(graph, k));
        
    }
}