package oopsByRahulSir;

public class Voting {
	private int age;
	private int adharNo;
	private int getAdharNo() {
		
		return adharNo;
	}
	public void setAge(int AgeValue) {
		if (AgeValue >= 18) {
			age = AgeValue;
		} else {
			System.out.println("you are not eligible ");
		}

	}

	public int getAge() {
		return age;
	}

	public void devote() {

	}

	public void smoking() {

	}

}
