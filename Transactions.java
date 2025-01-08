package banking;
import java.util.Scanner;
public class Transactions {
	int bal=0;
	int dep,with,trans;
	Scanner in;
	String message="";
	public Transactions(Scanner in) {
		this.in=in;
	}
	
	
	public  void bal(String message) {
		System.out.println("Your " +message+ " balance is " +bal);
	}
	
	
	public void deposit() {
		System.out.println("Please enter amount to deposit");
		dep=in.nextInt();
		if (dep>0) {
		bal+=dep;
		System.out.println("You have succesfully deposited $"+dep);
		bal("new");}
		else if(with<0) {
			System.out.println("Invalid amount Please input valid amount");
		}
		else {
			System.out.println("You have insufficient balance");
			bal("");
		}
	}
	public void withdraw() {
		System.out.println("Please enter amount to withdraw");
		with=in.nextInt();
		if (with>0&&with<bal) {
		bal-=with;
		System.out.println("You have succesfully withdrewn $"+with);
		bal("new");
		}
		else if(with<0) {
			System.out.println("Invalid amount Please input valid amount");
		}
		else {
			System.out.println("You have insufficient balance");
			bal("");
		}
	}
	
	public void transfer() {
			System.out.println("Please enter amount to transfer");
			trans=in.nextInt();
			if (trans>0 && trans<bal) {
			System.out.println("Enter the account number to transfer to:");
			String pnum=in.next();
			if (trans>0) {
			bal-=trans;
			System.out.println("You have succesfully deposited $"+dep+" to account number "+pnum);
			bal("new");}
			else if(with<0) {
				System.out.println("Invalid amount Please input valid amount");
			}
			else {
				System.out.println("You have insufficient balance");
				bal("");
			}
		}
}}