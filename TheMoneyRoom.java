import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class TheMoneyRoom {
	
	public static int moneyRoom(int[] list) {
		int indexOfEnter = 0;
		int c = 0;
		for(int i = 0; i < list.length; i++) {
			if(list[i]>0) {
				indexOfEnter = i;
				break;
			} else {
				c++;
			}
		}
		if(c == list.length) {
			return 0;
		}
		ArrayList<Integer> money = new ArrayList<Integer>();

		for(int j = indexOfEnter; j < list.length; j++) {
			int sum = 0;
			for(int i = indexOfEnter; i <= j;i++) {
				sum = sum + list[i];
			}
			money.add(sum);
		}

		int max = Collections.max(money);
//		for(int i = 0; i < money.size() - 1; i++) {
//			if(money.get(i) <= money.get(i+1)) {
//				max = money.get(i+1);
//			} else {
//				max = money.get(i);
//			}
//			
//		}
			
		return max;
	}
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int n = scnr.nextInt();
		int[] list = new int[n];
		for(int i = 0; i < list.length; i++) {
			list[i] = scnr.nextInt();
		}
		int money = moneyRoom(list);
		System.out.println(money);
		scnr.close();
	}

}
