package banking;
import java.util.Scanner;

public class Banking {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Transactions t1 = new Transactions(in);
		boolean isRunning=true;
		boolean isTrue=true;
		while(isTrue) {
		System.out.println("Welcome to your online banking application.\nTo proceed please choose an option\n");
		System.out.println("0. Register\n1. Login");
		int choice = in.nextInt();
		if (choice==0) {
			System.out.println("Welcome to Furaha Banking Application");
		}
		else
		{
			while(isRunning) {
			System.out.println("Welcome back, to proceed please choose an option");
			System.out.println("0. Balance\n1. Deposit\n2. Withdraw\n3. Transfer Funds\n4. Exit");
			int choice1 = in.nextInt();
			switch (choice1) {
			case 0 -> t1.bal("");
			case 1 -> t1.deposit();
			case 2 -> t1.withdraw();
			case 3 -> t1.transfer();
			case 4 -> {isRunning=false;
			System.out.println("Thank you for Visiting Furaha");
			}
			default -> System.out.println("Stopped");
			}
			}
		
	}

}}}
