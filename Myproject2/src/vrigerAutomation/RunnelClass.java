package vrigerAutomation;

public class RunnelClass  {
	public static void main(String[] args) throws InterruptedException {
//		LoginFunctionality lg=new LoginFunctionality();
//		System.out.println("hello");
//		lg.login();
//		System.out.println("hello");
		//lg.closeBrowser();
		
		
		AccountTestScript run=	new AccountTestScript();
//	    run.testcreateAccountFunctionslity();
//	    Thread.sleep(2000);
//		run.testEditAccountfunctionality();
		Thread.sleep(2000);
		//run.testDeleteAccountFunctionality();
		run.searchAccountFunctionality();

//		run.login();
//		run.closeBrowser();
	}

}
