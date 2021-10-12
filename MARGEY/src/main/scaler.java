package main;

import java.util.*;

public class scaler {
	
	public static void main(String[] args) 
	{ 
		scaler b = new scaler();
		String result = b.calculator();
		System.out.println(result);
	}

   public String calculator() {
	   
	   double h;
	   double w;
	   double h1;
	   double w1;
       String result = null;
	   boolean run = true;
	   
	   System.out.println("Do you want to calculate a width or a height? (h for height, w for width)");
	   
	   while (run==true) {
		   
		   Scanner sc = new Scanner(System.in);
		   String c = sc.next();
	   
		   switch(c){
		   case "W":
		   case "w":
			   System.out.println("Calculating a width! Please enter the width of your current image");
        
			   w = sc.nextDouble();
        
			   System.out.println("Please enter the height of your current image");
        
			   h = sc.nextDouble();
        
			   System.out.println("Please enter the height of your scaled image");
        
			   h1 = sc.nextDouble();
        
			   w1 = (w/h)*h1;
        
			   //System.out.println("New width = " + w1 + " NIIIIIIICE");
			   result = "New width = " + w1 + " NIIIIIIICE";
			   run = false;
			   break;
        
		   case "H":
		   case "h":
        
			   System.out.println("Calculating a height! Please enter the height of your current image");
        
			   h = sc.nextDouble();
        
			   System.out.println("Please enter the width of your current image");
        
			   w = sc.nextDouble();
        
			   System.out.println("Please enter the width of your scaled image");
        
			   w1 = sc.nextDouble();
        
			   h1 = (h/w)*w1;
        
			   //System.out.println("BOOYA! New height = " + h1);
			   
			   result = "BOOYA! New height = " + h1;
			   run = false;
		   
			   break;
        
		   default:
			   System.out.println("Please enter h or w");
			   
		   }
		   sc.close();
	   	}
	   return result;
    }
}