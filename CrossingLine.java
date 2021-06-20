import java.util.Scanner;

public class CrossingLine {
	
	public static int count(int[] line1, int[] line2) {
		int count = 0;		
		for(int i = 0; i < line1.length; i++) {		
			if(line1[i] == 0) {
				continue;
			}
			int countRight = countRight(line1, i);
			int countLeft = countLeft(line2, indexOf(line2, line1[i]));
			if(countRight > countLeft) {
				count = count + countLeft;
			} else{
				count = count + countRight;
			}
		}
		return count;
	}
	
	public static int countRight(int[] arr, int e) {
		int count = 0;
		for(int i = e + 1; i < arr.length; i++) {
			if(arr[i] > 0) {
				count++;
			}
		}
		return count;
	}
	
	public static int countLeft(int[] arr, int e) {
		int count = 0;
		for(int i = e - 1; i > 0; i--) {
			if(arr[i] > 0) {
				count++;
			}
		}
		return count;
	}
	
	public static int indexOf(int[] arr, int e) {
		int index = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == e) {
				index = i;
				return index;
			}
		}
		return index;
	}
	public static void main(String[] args) {
		int[] line1 = new int[(int) Math.pow(10, 6)];
		int[] line2 = new int[(int) Math.pow(10, 6)];
		Scanner scnr = new Scanner(System.in);
		int size = scnr.nextInt();
		for(int i = 1; i <= size; i ++) {
			line1[scnr.nextInt()] = i;
		}
		for(int i = 1; i <= size; i ++) {
			line2[scnr.nextInt()] = i;
		}
		scnr.close();
		System.out.print(count(line1, line2));
	}

}
