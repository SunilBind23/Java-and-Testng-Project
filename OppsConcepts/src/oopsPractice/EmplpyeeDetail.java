package oopsPractice;

public class EmplpyeeDetail {
	private int Id; ///1234
	private String Name;
	private double Salary;
	private double da,ta,hra,it,pf,grosSalary,netSalary;

	public int getId() {

		return Id; ///1234
	}

	public void setID(int newId) {
		this.Id = newId;

	}

	public String getName() {

		return Name;
	}

	public void setName(String newName) {
		this.Name = newName;

	}

	public double getSalary() {

		return Salary;
	}

	public void setSalary(double salary) {
		this.Salary = salary;
	}
	
	public void calData() {
		
		da=(Salary*5/100);
		ta=(Salary*3/100);
		hra=(Salary*10/100);
		it=(Salary*8/100);
		pf=(Salary*5/100);
		grosSalary=da+ta+hra+it+pf+Salary;
		netSalary=grosSalary-pf;
		
		
	}
	
	public void ShowData() {
		System.out.println("Employee Id => " + Id);
		System.out.println("Employee Name=> " + Name);
		System.out.println("Employee Net Salary=> " + netSalary );
	}
}
