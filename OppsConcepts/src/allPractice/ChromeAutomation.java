package allPractice;

public class ChromeAutomation extends WebAutomation {
 
	public int x=20;

	
	@Override  //best practice
	public void launch() {
		System.out.println("launch chrome");
	}
	
	public void click() {
		System.out.println("click on chromeBrowser page element");
	}

	public void type() {
		System.out.println("type in chromeBrowser page element");
	}

	public void getinnerText() {
		System.out.println("get inner text in chromeBrowser page element ");
	}

	public void getText() {
		System.out.println("get text in the chromeBrowser page element");
	}

	public void getLocation() {

	}
}
