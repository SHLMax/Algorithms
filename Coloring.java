import java.util.Scanner;
 
// This class represents an undirected graph using adjacency list
public class Coloring
{
 
  // Number of vertices in the graph
  private int V = 0;
  Coloring(int v){
	  this.V = v;
  }
  /* A utility function to print solution */
  public void printSolution(int[] color)
  {
    System.out.println("Solution Exists:"  +
                       " Following are the assigned colors ");
    for (int i = 0; i < V; i++)
      System.out.print("  " + color[i]);
    System.out.println();
  }
 
  // check if the colored
  // graph is safe or not
  public boolean isSafe(boolean[][] graph, int[] color)
  {
    // check for every edge
    for (int i = 0; i < V; i++)
      for (int j = i + 1; j < V; j++)
        if (graph[i][j] && color[j] == color[i])
          return false;
    return true;
  }
 
  /* This function solves the m Coloring
    problem using recursion. It returns
    false if the m colours cannot be assigned,
    otherwise, return true and prints
    assignments of colours to all vertices.
    Please note that there may be more than
    one solutions, this function prints one
    of the feasible solutions.*/
  public boolean graphColoring(boolean[][] graph, int m,
                               int i, int[] color)
  {
    // if current index reached end
    if (i == V) {
 
      // if coloring is safe
      if (isSafe(graph, color))
      {
 
        return true;
      }
      return false;
    }
 
    // Assign each color from 1 to m
    for (int j = 1; j <= m; j++)
    {
      color[i] = j;
 
      // Recur of the rest vertices
      if (graphColoring(graph, m, i + 1, color))
        return true;
      color[i] = 0;
    }
    return false;
  }
    public static void main(String args[])
    {
    	Scanner scnr = new Scanner(System.in);
    	int V = scnr.nextInt();
    	Coloring c = new Coloring(V);
    	int E = scnr.nextInt();
    	int k = scnr.nextInt();
    	boolean[][] graph = new boolean[V][V];
    	for(int i = 0; i < E; i++) {
    		int u = scnr.nextInt() - 1;
    		int v = scnr.nextInt() - 1;
    		graph[u][v] = true;
    	}
    	
    	int[] color = new int[V];
        for (int i = 0; i < V; i++)
          color[i] = 0;

        System.out.println(c.graphColoring(graph, k, 0, color));
 
        scnr.close();
    }
}
