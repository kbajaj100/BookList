import java.io.FileReader;

public class Book {

	private String title = "";
	private String author = "";
	private int book_id = 0;
	
	void settitle(String t){
		title = t;
	}
	
	void setauthor(String a){
		author = a;
	}

	void setid(int line_counter) {
		// TODO Auto-generated method stub
		book_id = line_counter;
	}
	
	String gettitle(){
		return title;
	}
	
	String getauthor(){
		return author;
	}
	
	int getbookid(){
		return book_id;
	}
}
