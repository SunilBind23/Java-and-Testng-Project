package oopsByRahulSir;

public abstract class WebAutomation {

	public abstract void find();
	
	public abstract void launch();
	
	public void close() {
		System.out.println("closing");
	}
	
	public void openUrl() {
		System.out.println("open url");
	}
}
