package test;

import javax.swing.plaf.basic.BasicArrowButton;

import org.bouncycastle.jcajce.provider.symmetric.AES.PBEWithSHAAnd256BitAESBC;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByName;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;

public class Automate {
 
	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("http://localhost:8888/");
		
		By sc= By.xpath("//input[@name='user_name']");
		WebElement we1=driver.findElement(sc);
		we1.sendKeys("admin");
		 
		By sb=By.xpath("//input[@name='user_password']");  
		WebElement we2=driver.findElement(sb);
		we2.sendKeys("admin");
		
		By sa=By.xpath("//input[@id='submitButton']");
		WebElement we3=driver.findElement(sa);
		we3.click();
		
		By lead=By.linkText("Leads");
		WebElement ld=driver.findElement(lead);
		ld.click();
		
		By sd=By.xpath("//img[@alt='Create Lead...']");
		WebElement we4=driver.findElement(sd);
		we4.click();
		
		By se=By.xpath("//select[@name='salutationtype']");
		WebElement we5=driver.findElement(se);
		we5.click();
		we5.sendKeys("mr");
		we5.click();
		
		By sf=By.xpath("//input[@name='firstname']");
		WebElement fname=driver.findElement(sf);
		fname.sendKeys("Shubham");
		
		By sg=By.xpath("//input[@name='lastname']");
		WebElement lname=driver.findElement(sg);
		lname.sendKeys("Verma");
		
		By sh=By.xpath("//input[@name='company']");
		WebElement company=driver.findElement(sh);
		company.sendKeys("EVS Institute");
		
//		By si=By.xpath("//input[@tabindex name='designation']");
//		WebElement we9=automate.findElement(si);
//		we9.sendKeys("EVS Institute");
		
		By sj=By.xpath("//select[@name='leadsource']");
		WebElement leadsource=driver.findElement(sj);
		leadsource.click();
		leadsource. sendKeys("Self Generated");
		leadsource.click();
		
		By sk=By.xpath("//select[@name='industry']");
		WebElement industry=driver.findElement(sk);
		industry.click();
		industry.sendKeys("Education");
		industry.click();
		
		By sl=By.xpath("//input[@id='phone']");
		WebElement phone=driver.findElement(sl);
		phone.sendKeys("0542-456776");
		
		
		By sm=By.xpath("//input[@id='mobile']");
		WebElement mobile=driver.findElement(sm);
		mobile.sendKeys("7068152039"); 
		
		By sn=By.xpath("//input[@id='email']");
		WebElement email=driver.findElement(sn);
		email.sendKeys("vv290160@gmail.com");
		
		By so=By.xpath("//select[@name='leadstatus']");
		WebElement leadstatus=driver.findElement(so);
		leadstatus.click();
		leadstatus.sendKeys("Pre Qualified");
		
		By sp=By.xpath("//select[@name='rating']");
		WebElement rating=driver.findElement(sp);
		rating.click();
		rating.sendKeys("Active");
		
		By sq=By.xpath("//textarea[@name='lane']");
		WebElement street=driver.findElement(sq);
		street.sendKeys("Siyaraha Mondh Chauraha near BSNL Tawer , Bhadohi.");
		
		By sr=By.xpath("//input[@id='code']");
		WebElement pincode=driver.findElement(sr);
		pincode.sendKeys("221406");
		
		
		By ss=By.xpath("//input[@id='country']");
		WebElement country=driver.findElement(ss);
		country.sendKeys("India");
		
		By sv1=By.xpath("//input[@id='pobox']");
		WebElement pobox=driver.findElement(sv1);
		pobox.sendKeys("Mondh");
		
		By st=By.xpath("//input[@id='city']");
		WebElement city=driver.findElement(st);
		city.sendKeys("Bhadohi");
		
		By su=By.xpath("//input[@id='state']");
		WebElement state=driver.findElement(su);
		state.sendKeys("Utter_Pradesh");
		
		By sv=By.xpath("//textarea[@name='description']");
		WebElement xyz=driver.findElement(sv);
		xyz.sendKeys("Requirment for interior decoration. This is only for practise");
		
		By sw=By.xpath("//input[@title='Save [Alt+S]']");
		WebElement save=driver.findElement(sw);
		save.click();		
		
		
		By sx=By.xpath("//textarea[@id='txtbox_ModCommentsDetailViewBlockCommentWidget']");
		WebElement comment=driver.findElement(sx);
		comment.sendKeys("Hello Everyone");
		
		By sy=By.xpath("(//input[@class='crmbutton small save'])[25]");
		WebElement save2=driver.findElement(sy);
		save2.click();
	 	
		
		  //  starting tag                                            closing tag
		///         <span  attribute="attrValue">dfgdfgdgffgfdgs</span>
		                                  //     innertext
		// <span class="dvHeaderText">[ LEA29 ] Verma Shubham -  Lead Information</span>

		//  	<img src="themes/softed/images/showPanelTopLeft.gif"></img>
	
		// we want to fetch and print lead no of newly created lead
		
		By header=By.xpath("//span[@class='dvHeaderText']");
		WebElement headerElement=driver.findElement(header);
		String headerText=headerElement.getText();
		System.out.println(headerText);
		
		
		By byEdit=By.xpath("//input[@title='Edit [Alt+E]']");
		WebElement weEdit=driver.findElement(byEdit);
		
		String editButtonText=weEdit.getAttribute("value");
		System.out.println(editButtonText);
		
		Dimension size=weEdit.getSize();
		int height=size.getHeight();
		int width=size.getWidth();
		System.out.println(height);
		System.out.println(width);
		
		
		
		/////  how to fetch written text from text box
		///  whatever we write in text box, it goes to value attribute of that text box
		/// so we will call getAttribute method and will pass "value" as attribute
		
		/// there is a button and its text is coming from value attribute how to fetch it.
		
		/// 
		///  getText method fetch and returns innertext of element
		///  if any element's text is coming from value attribute then getTextmethod will return blank
		///  text between starting and closing tag is called innertext
		////  browser close
		
		
		
		driver.close();
		
    }
	
	
	
	///  xpath basic syntax   --    //tagname[@attributename='attributevalue']
	///  xpath  with indexing ==     (//tagname[@attributename='attributevalue'])[indexnumber]
	
	////  NoSuchElementException
	///  xpath  ==  0 of 0  ,  1 of 1 , 1 of many  
	////  
	/// xpath -  1 of 1 -  unique xpath
	
	
	
	
	
	
}
