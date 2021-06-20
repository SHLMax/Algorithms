import java.util.Arrays;
import java.util.Scanner;




public class NutAndBolt {

    int M;
    int N;
    
    public NutAndBolt(int a, int b) {
    	M = a;
    	N = b;
    }
    
    boolean bpm(boolean bpGraph[][], int u, 
                boolean seen[], int matchR[])
    {
        
        for (int v = 0; v < N; v++)
        {

            if (bpGraph[u][v] && !seen[v])
            {
                  
                seen[v] = true; 
  
                if (matchR[v] < 0 || bpm(bpGraph, matchR[v],
                                         seen, matchR))
                {
                    matchR[v] = u;
                    return true;
                }
            }
        }
        return false;
    }
  

    int maxBPM(boolean bpGraph[][])
    {

        int matchR[] = new int[N];
  
        for(int i = 0; i < N; ++i)
            matchR[i] = -1;
  
        int result = 0; 
        for (int u = 0; u < M; u++)
        {

            boolean seen[] =new boolean[N] ;
            for(int i = 0; i < N; ++i)
                seen[i] = false;
  
            if (bpm(bpGraph, u, seen, matchR))
                result++;
        }
        return result;
    }
  
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int numOfNut = scnr.nextInt();
		int numOfBol = scnr.nextInt();
		NutAndBolt NAB = new NutAndBolt(numOfNut,numOfBol);
		boolean[][] nutsNBolts = new boolean [numOfNut][numOfBol];
		for(int i = 0; i < numOfNut; i++) {
			for(int j = 0; j < numOfBol; j++) {
				if(scnr.nextInt() == 1)
					nutsNBolts[i][j] = true;
				else
					nutsNBolts[i][j] = false;
			}
		}
		System.out.println(NAB.maxBPM(nutsNBolts));

		scnr.close();
	}

}
