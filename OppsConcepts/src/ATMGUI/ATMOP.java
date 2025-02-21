package ATMGUI;

import java.util.HashMap;
import java.util.Scanner;

public class ATMOP extends ATM {
	int balance;
	Scanner sc = new Scanner(System.in);
	HashMap<Integer, Data> map = new HashMap();

	public ATMOP() {
		int balance;

		System.out.println("Welcome to our ATM :");

	}

	public void op() {
		 ATMOP rn = new ATMOP();
		System.out.println("enter your pincode");
		int pincode = sc.nextInt();
		if (map.containsKey(pincode) == true) {
			Data obj = map.get(pincode);
			
		} else {
			System.out.println("please create account first");
			System.out.println("setYour pincode");
			int pin = sc.nextInt();
			Data obj = new Data();
			map.put(pin, obj);
			manu(obj);
		}
	}
}
