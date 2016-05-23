import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String fileName = "C:/Users/Kunal/Documents/Java/Library_project/booklist.txt";	
		
		int count;
		
		count = countLines(fileName);
		
		System.out.println("Number of rows is: " + count);
		CreateBookList(fileName, count);

	}

	private static void DisplayBookList(Book[] mybooks, int rowcount) {
		// TODO Auto-generated method stub
		
		for (int i = 0; i < rowcount; ++i){
			System.out.println(mybooks[i].getbookid());
			System.out.println(mybooks[i].gettitle());
			System.out.println(mybooks[i].getauthor());
		}
	}

	private static void CreateBookList(String fileName, int rowcount) throws IOException {
		// TODO Auto-generated method stub
		
		Book[] myBooks = new Book[rowcount];
				
		for (int i = 0; i < rowcount; ++i)
			myBooks[i] = new Book();
		// The above declaration is imp. I made a mistake on this and it wasted 2 hours
		// This is unlike C++
	
		Scanner inFile = new Scanner(new FileReader(fileName));
		
		String str = "";
		
		int count_delimiter = 0;
		int line_counter = 0;
		//int position = 0;
		ArrayList<Integer> position = new ArrayList<Integer>();
		
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String line = "";

		while((line = br.readLine()) != null) {  
			
			count_delimiter = 0;
			
			String[] split = line.split("/|");
			System.out.println("Length of line is: " + split.length);
			
			for (int i = 0; i < split.length; i++) {
				//System.out.println(split[i]);
				if (split[i].equals("|")){
					position.add(count_delimiter, i);
					++count_delimiter;
				}			
			}	
			
			System.out.println("Count of pipes is: " + count_delimiter);
			
			//for (int i = 0; i <= count_delimiter; ++i)
			//	System.out.println("position of pipe is: " + position.get(i));
			
			// Get the string for each delimiter
			for (int i = 0; i <= count_delimiter; ++i){

				str = "";
				// Scenario 1: If  i = 0 which is the 1st delimiter
				// get the string from 0 to position of i - 1
				// Scenario 2: if i = count_delimiter 
				// get the string from (position of i) + 1 to end of line
				// Scenario 3: if i < count_delimiter and i <> 0
				// get the string from (position of i) + 1 to (position of i+1) -1 
				
				if (i == 0)
				{
					for (int j = 0; j < position.get(i); ++j){
						str = str + split[j];
					}
					//System.out.println(str);
					myBooks[line_counter].setauthor(str);
					myBooks[line_counter].setid(line_counter);
				}
				else if (i == count_delimiter)
				{
					for (int k = position.get(i-1) + 1; k < split.length; ++k){
						str = str + split[k];
						//System.out.println(str);
						//System.out.println(k);
					}
					myBooks[line_counter].settitle(str);
				}
				else if (i < count_delimiter && i != 0)
				{
					for (int l = (position.get(i) + 1); l <= (position.get(i+1) + -1); ++l)
					{
						str = str + split[l];
					}
					//mybooks is not called here...will need to insert code here when the time comes
				}
			}

			++line_counter;
			
		}
		
		DisplayBookList(myBooks, rowcount);
	}

	public static int countLines(String filename) throws IOException {
	    InputStream is = new BufferedInputStream(new FileInputStream(filename));
	    try {
	        byte[] c = new byte[1024];
	        int count = 0;
	        int readChars = 0;
	        boolean empty = true;
	        while ((readChars = is.read(c)) != -1) {
	            empty = false;
	            for (int i = 0; i < readChars; ++i) {
	                if (c[i] == '\n') {
	                    ++count;
	                }
	            }
	        }
	        return (count == 0 && !empty) ? 1 : count;
	    } finally {
	        is.close();
	    }
	}
}
