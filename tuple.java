import java.util.Scanner;

public class tuple {
   int value;
   double number;
   int index;
   public tuple(int value, double number, int index) {
	   this.number = number;
	   this.value = value;
	   this.index = index;
   }
   public tuple(int index) {
	   this.index = index;
   }
   
   public static int log2(int i) {
	   return (int) Math.floor(Math.log(i)/Math.log(2));
   }
   
   
   public static void main(String[] args) {
   Scanner scnr = new Scanner(System.in);
   int n = scnr.nextInt();
   int num = (int) Math.pow(2, n);
   String number = scnr.next();
   char[] digits1 = number.toCharArray();
   int[] n1 = new int[num];
   for(int i = 0; i < num; ++i) {
      n1[i] = Character.getNumericValue(digits1[i]);
   }
   int n2;
   tuple[] tupleArray = new tuple[(int) Math.pow(2, n+1) - 1];
   tuple tp;
   for (int i = 0; i < num-1; i++) {
	   tp = new tuple(i);
	   tupleArray[i] = tp;
   }
   
   for (int i = 0; i < num; i++) {
	   n2 = n1[i];
	   tp = new tuple(n2,1,num+i);
	   tupleArray[num-1+i] = tp;
   }
   
   for (int i = num - 2; i >= 0; --i) {
	   if(log2(tupleArray[i].index + 1) % 2 == 0) { 
		  tupleArray[i].value = Math.min(tupleArray[(i+1)*2].value, tupleArray[(i+1)*2 - 1].value);
		  if(tupleArray[(i+1)*2].value == 0 && tupleArray[(i+1)*2 - 1].value == 0) {
			 tupleArray[i].number = 0.5 * (tupleArray[(i+1)*2].number) + 0.5 * (tupleArray[(i+1)*2 - 1].number);
		  }
		  if(tupleArray[(i+1)*2].value == 1 && tupleArray[(i+1)*2 - 1].value == 0) {
			 tupleArray[i].number = 0.5 * (tupleArray[(i+1)*2].number + tupleArray[(i+1)*2 - 1].number) + 0.5 * (tupleArray[(i+1)*2 - 1].number);	 
		  }
		  if(tupleArray[(i+1)*2].value == 0 && tupleArray[(i+1)*2 - 1].value == 1) {
			 tupleArray[i].number = 0.5 * (tupleArray[(i+1)*2].number) + 0.5 * (tupleArray[(i+1)*2].number + tupleArray[(i+1)*2 - 1].number);	 	 
		  }
		  if(tupleArray[(i+1)*2].value == 1 && tupleArray[(i+1)*2 - 1].value == 1) {
			 tupleArray[i].number = 2 * 0.5 * (tupleArray[(i+1)*2].number + tupleArray[(i+1)*2 - 1].number);		 
		  }
	   }
	   else {
		   tupleArray[i].value = Math.max(tupleArray[(i+1)*2].value, tupleArray[(i+1)*2 - 1].value);
		   if(tupleArray[(i+1)*2].value == 0 && tupleArray[(i+1)*2 - 1].value == 0) {
				 tupleArray[i].number = 2 * 0.5 * (tupleArray[(i+1)*2].number + tupleArray[(i+1)*2 - 1].number);
		   }
		   if(tupleArray[(i+1)*2].value == 1 && tupleArray[(i+1)*2 - 1].value == 0) {
				 tupleArray[i].number = 0.5 * (tupleArray[(i+1)*2].number + tupleArray[(i+1)*2 - 1].number) + 0.5 * (tupleArray[(i+1)*2].number);	 
		   }
		   if(tupleArray[(i+1)*2].value == 0 && tupleArray[(i+1)*2 - 1].value == 1) {
				 tupleArray[i].number = 0.5 * (tupleArray[(i+1)*2 - 1].number) + 0.5 * (tupleArray[(i+1)*2].number + tupleArray[(i+1)*2 - 1].number);	 	 
		   }
		   if(tupleArray[(i+1)*2].value == 1 && tupleArray[(i+1)*2 - 1].value == 1) {
				 tupleArray[i].number = 0.5 * (tupleArray[(i+1)*2].number) + 0.5 * (tupleArray[(i+1)*2 - 1].number);	 
		   }
	   }
   }
   scnr.close();
   System.out.print(tupleArray[0].number);
   
   }
}
