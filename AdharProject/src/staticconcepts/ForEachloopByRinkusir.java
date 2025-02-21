package staticconcepts;

public class ForEachloopByRinkusir {

	public static void main(String[] args) {
			
		String stdnt[][]=new String[4][4];
		stdnt[0][0]="sunil";
		stdnt[0][1]="Moni";
		stdnt[0][2]="Anupam";
		stdnt[0][3]="Saurabh";
		
		stdnt[1][0]="Ramu";
		stdnt[1][1]="Ajeet";
		stdnt[1][2]="Manish";
		stdnt[1][3]="Kajal";
		
		stdnt[2][0]="alok";
		stdnt[2][1]="Sonu";
		stdnt[2][2]="Rakesh";
		stdnt[2][3]="Rohit";
		
		stdnt[3][0]="Arun";ṇ
		stdnt[3][1]="Pritam";
		stdnt[3][2]="Dipak";
		stdnt[3][3]="Dipi";
		
		for (String val[] : stdnt) 
			System.out.println(val);
		
		
	}

}
