package ATMGUI;

import java.util.Scanner;

public class ATM implements MenuSetup {
	float balance;
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

	}

	public void menu(Data obj) {

		System.out.println("please enter valid number:-");
		System.out.println("1. check balance");
		System.out.println("2. deposite money");
		System.out.println("3. withdraw money");
		System.out.println("4. check another account ");
		System.out.println("5. exit");

		int x = sc.nextInt();
		if (x == 1) {
			check_balance();
		} else if (x == 2) {
			deposite_money();
		} else if (x == 3) {
			withdraw_money();
		} else if (x == 4) {
			check_another_account();
		} else if (x == 5) {
			System.out.println("Thanku for using ATM !");
		} else {
			System.out.println("Enter the valid Number");
			menu();
		}
	}

	@Override
	public void check_balance() {
		System.out.println("your balance " + balance);
	}

	@Override
	public void deposite_money() {
		System.out.println("enter your amount:-");
		float am = sc.nextFloat();
		balance = balance + am;
		System.out.println("amount deposite successfuly");

	}

	@Override
	public void withdraw_money() {
		System.out.println("enter amount :-");
		float am=sc.nextFloat();
		if(balance<=am) {
			balance=balance-am;
			System.out.println("withdraw successfuly");
		}else {
			System.out.println("insuficient balance");
		}
		
	}

	@Override
	public void check_another_account() {
		// TODO Auto-generated method stub

	}
}
