
import java.util.Scanner;

public class DataSet {
	
	private double smallest;
	private double largest;
	private double total;
	private int count;
	
	public DataSet() {
		
		smallest = Double.MAX_VALUE;
		largest = 0;
		total = 0;
		count = 0;
		
	}
	
	public void add(double value) {
		
		if(value > largest) {
			largest = value;
		}
		
		if(value < smallest) {
			smallest = value;
		}
		
		total += value;
		count++;
		
	}
	
	public double getAverage() {
		return total/count;
	}
	
	public double getSmallest() {
		return smallest;
	}
	
	public double getLargest() {
		return largest;
	}
	
	public double getRange() {
		return largest - smallest;
	}

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		DataSet d = new DataSet();
		System.out.print("Enter your data! Hit enter between each number then type \"End\" "
				+ "and hit enter again to calculate" + "\n");
		
		while (in.hasNextInt()) {
			d.add(in.nextInt());
		}
		
		in.close();
		
		System.out.println("Largest:" + d.getLargest());
		System.out.println("Smallest:" +d.getSmallest());
		System.out.println("Range:" +d.getRange());
		System.out.println("Average:" +d.getAverage());
	}

}
