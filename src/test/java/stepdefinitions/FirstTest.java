package stepdefinitions;

import java.util.Scanner;  
 public class FirstTest {

	public static void main(String[] args) {
		
		
		int x = 10;
		int z = 10;
		String y = "test";
		float q = 12;
		double w = 23.67;
		int c = -34;
		boolean learningJava = true;
		char a = 's';
		
		int sum = x+z;
		
		
//		System.out.println("This is our 2234234 first program");  
//		System.out.println("this is a int variable " + c);
//		System.out.println(x);
//		System.out.println(x+ y);
//		System.out.println( y+x);
//		System.out.println(x+z);
//		System.out.println(sum);
//		System.out.println(learningJava);
//		System.out.println(q);
//		
//		System.out.println(a+x);
		
		testtwo two = new testtwo();
		
		two.x = 10;
		two.add();
		
		FirstTest first = new FirstTest();
		
		Scanner scan=new Scanner(System.in);
		System.out.print("Enter the number of times to check: "); 
		int i= scan.nextInt(); 
		
		for (int j=0; j<i;j++) {
			  
			System.out.print("Enter the number: ");  
			int num=scan.nextInt(); 
			findEvenOdd(num);
			first.findEven(num);
			
		}	
		System.out.print("Testing is completed"); 
	}
	
	public static void findEvenOdd(int num)  
	{  
	//method body  
	if(num%2==0)   
	System.out.println(num+" is even");   
	else   
	System.out.println(num+" is odd");  
	}  
	
	
	public  void findEven(int num)  
	{  
	//method body  
	if(num%2==0)   
	System.out.println(num+" is even");   
	else   
	System.out.println(num+" is odd");  
	} 
	
	public class testthree{
		
		int y;
	}
	

	
	
}

 class testtwo{
	
	 int x = 0;
	  void add() {
		  
	 }
	
}
