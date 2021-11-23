import java.util.Scanner;

public class spc1 {

	public static void main(String[] args) {
		System.out.println("Enter your first name");
		String firstName = new Scanner(System.in).next();
		System.out.println("Enter your last name");
		String lastName = new Scanner(System.in).next();
		System.out.println("Welcome to MACS, " + firstName + " " + lastName);

	}

}
