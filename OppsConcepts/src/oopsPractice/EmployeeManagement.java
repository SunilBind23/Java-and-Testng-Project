package oopsPractice;

import java.util.Scanner;

public class EmployeeManagement extends EmplpyeeDetail {
//	@Override
//	public int getId(int id) {
//
//		System.out.println("hello" + " " + id);
//		return id;
//	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		EmplpyeeDetail run = new EmployeeManagement();
		System.out.print("Enter Your id=>");
		int id=sc.nextInt();
		run.setID(id);
		run.setName("Sunil");
		run.setSalary(44500.00);
		run.calData();
		run.ShowData();
sc.close();
		// System.out.println(run.getId());

	}

}
