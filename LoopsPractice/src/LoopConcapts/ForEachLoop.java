package LoopConcapts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

public class ForEachLoop {
	public static void main(String[] args) {

		String stdnt[][] = new String[4][4];
		stdnt[0][0] = "sunil";
		stdnt[0][1] = "Moni";
		stdnt[0][2] = "Anupam";
		stdnt[0][3] = "Saurabh";

		stdnt[1][0] = "Ramu";
		stdnt[1][1] = "Ajeet";
		stdnt[1][2] = "Manish";
		stdnt[1][3] = "Kajal";

		stdnt[2][0] = "alok";
		stdnt[2][1] = "Sonu";
		stdnt[2][2] = "Rakesh";
		stdnt[2][3] = "Rohit";

		stdnt[3][0] = "Arun";
		stdnt[3][1] = "Pritam";
		stdnt[3][2] = "Dipak";
		stdnt[3][3] = "Dipu";

		String stdnt2[][] = { { "sunil", "Moni", "Anupam", "Saurabh" }, { "Ramu", "Ajeet", "Manish", "Kajal" },
				{ "alok", "Sonu", "Rakesh", "Rohit" }, { "Arun", "Pritam", "Dipak", "Dipu" },

		};
		//ArrayList<String> al= new ArrayList<String>;
		
		

//		 for (String val[] : stdnt2) {
//		 System.out.println((val));//when run this line then print there address
//		 System.out.println(Arrays.toString(val)); // when run this line then print
//		 }

		for (String std[] : stdnt2) {
			for (String val : std) {

				System.out.println(val);
			}
			System.out.println();
		}

//double randomValue=Math.random();

		/*
		 * Random random = new Random(); int randomValue = 33 + random.nextInt(99); //
		 * nextInt(99) generates a value between 0 and 66, inclusive
		 * //System.out.println(randomValue);
		 */

		int marks[] = new int[100];
		int sum = 0;
		Random random = new Random();
		int size = marks.length;
		for (int i = 0; i < size; i++) {

			int randomValue = 33 + random.nextInt(67);

			marks[i] = randomValue;
			sum += marks[i];
			System.out.println(marks[i] + "\t" + i);
		}

		System.out.println("sum of all marks=>" + sum);
	}
}
