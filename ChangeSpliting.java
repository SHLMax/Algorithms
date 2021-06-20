import java.util.Arrays;
import java.util.Scanner;

public class ChangeSpliting {
	private int size;
	private int[] coins;
	
	public ChangeSpliting(int n) {
		this.size = n;
		coins = new int[size];
	}
	
	public void addCoins(int e, int i) {
		coins[i] = e;
	}
	
	public boolean ChangeSplit() {
		int sum = 0;
		Arrays.sort(coins);
		for(int i = 0; i < size; i++) {
			sum = sum + coins[i];
		}
		if (sum % 2 != 0) {
			return false;
		}
		
		return isSubsetSum(coins, size, sum/2);
	}
	public boolean isSubsetSum(int arr[], int n, int sum)
    {

        if (sum == 0)
            return true;
        if (n == 0 && sum != 0)
            return false;
 
        if (arr[n - 1] > sum)
            return isSubsetSum(arr, n - 1, sum);
 
        return isSubsetSum(arr, n - 1, sum)
            || isSubsetSum(arr, n - 1, sum - arr[n - 1]);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scnr = new Scanner(System.in);
		int numOfCoins = scnr.nextInt();
		ChangeSpliting CS = new ChangeSpliting(numOfCoins);
		for(int i = 0; i < numOfCoins; i++) {
			int coin = scnr.nextInt();
			CS.addCoins(coin,i);
		}
		if(CS.ChangeSplit()) {
			System.out.println("T");
		} else {
			System.out.println("F");
		}
		scnr.close();

	}

}
