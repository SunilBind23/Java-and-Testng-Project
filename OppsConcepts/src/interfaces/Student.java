package interfaces;

public class Student implements StudentDetails {

	private int rollNo;
	private String name;
	int marks;

	@Override
	public void getData() {
		this.rollNo=489723940;
		this.name="sunil";
	}

	@Override
	public void calData() {
		
	}

	@Override
	public void showData() {
		// TODO Auto-generated method stub

	}

}
