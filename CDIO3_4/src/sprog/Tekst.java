package sprog;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Tekst {
	
	
	public static String[] tekst = new String [100];
	
	public static void vaelgsprog(String sprog){
		
			InputStream in = Tekst.class.getResourceAsStream("/" + sprog + ".txt");

			Reader reader = null;
			try {
				reader = new InputStreamReader(in, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}

			Scanner scan = new Scanner(reader);

			int i = 1;
			while (scan.hasNextLine()) {
				String str = scan.nextLine();
				tekst[i] = str;
				i++;

			}
			scan.close();

	}
	
	public static String toString(int index){
		return tekst[index];
	}
	
	public static boolean sprogPasser(String sprog){
		if(sprog.equalsIgnoreCase("DANSK") || sprog.equalsIgnoreCase("ENGLISH"))
			return true;
		return false;
	}
	

}
