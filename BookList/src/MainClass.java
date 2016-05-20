import java.io.*;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		int size = 1000;
	
		CreateBookList(size);
	
	}

	private static void CreateBookList(int size) throws IOException {
		// TODO Auto-generated method stub
		
		Book[] myBooks = new Book[size];

		//Create connection to the file
		
		String fileName = "C:/Users/Kunal/workspace/BookList/src/booklist.txt";
		Scanner inFile = new Scanner(new FileReader(fileName));
		
		String title;
		String author;
		int count = 0;
		
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String line = "";
		 
		while((line = br.readLine()) != null) {  

			String[] split = line.split("/|");
			System.out.println(split.length);
			
			for (int i = 0; i < split.length; i++) {
				System.out.println(split[i]);
			}	
		}
		
		
	}

}
