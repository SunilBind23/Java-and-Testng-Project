package exceptionHandling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.imageio.stream.FileImageOutputStream;

public class ExceptionHandling {

	public static void main(String[] args)  {
		try {
			FileInputStream file=	new FileInputStream("c://asdf//abc.txt");// checked exception
			System.out.println(file);
		} catch (Exception e) {
			System.out.println(e);
			System.out.println(e.getMessage().toString());
			e.getStackTrace();
		}
		
		
		
	}

}
