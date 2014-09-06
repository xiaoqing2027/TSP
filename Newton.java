import java.text.DecimalFormat;
import java.util.Scanner;

public class Newton {
	public static float computer(float num) {
		float sqrRoot = 0;
		float temp =0;
		sqrRoot = num/2;
		while(abs(sqrRoot - temp)>=0.000001){
			temp = sqrRoot;
			sqrRoot = temp - (temp*temp - num)/(2*temp);
		}
		return sqrRoot;
	}


	private static double abs(float f) {
		if(f>=0)
		{ return f;}
		else{
		return -f;}
	}


	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		DecimalFormat fourDecimal = new DecimalFormat("0.00000");
		
		float Number = 0;
		
		System.out.println("Program: find square roots by Newton's Method");
		System.out.println("Please enter a number:");
		
		Number = sc.nextFloat();
		
		System.out.println("The square root of"+Number+"is"+fourDecimal.format(computer(Number)));
	    sc.close();
	}
}
