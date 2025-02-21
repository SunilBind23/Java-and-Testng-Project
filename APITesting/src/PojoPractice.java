
public class PojoPractice {
	private String name;
	private int rollNo;

	// getter
	public int getRollNo() {
		return this.rollNo;
	}
//setter
	public void setRoll(int rollNum) {
		if(rollNum<=0) {
			throw new  IllegalArgumentException("Invalid task");
		}
		this.rollNo = rollNum;
	}
//getter
	public String getName() {
		return this.name;
	}
//setter
	public void setName(String Name) {
		this.name = Name;
	}

	public void display() {
		System.out.println(this.name);
		System.out.println(this.rollNo);
	}

}
