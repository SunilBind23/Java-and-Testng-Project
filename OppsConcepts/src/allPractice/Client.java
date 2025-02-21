package allPractice;

import java.util.Scanner;

public interface Client {
	void input(); // both method by default public and abstract

	void output();

	int x = 100;
}


class Sunil implements Client {
	String name;
	double salary;

	@Override
	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name:");
		name = sc.nextLine();
		System.out.println("Enter salary");
		salary = sc.nextDouble();

	}

	@Override
	public void output() {
		System.out.println(name + " " + salary);
	}

	public static void main(String[] args) {
		Client c = new Sunil();
		System.out.println(c.x);

	}
}