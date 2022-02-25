package bookapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import bookapi.entity.Book;

//@Service								// Service work as way as component , but here it is somewhat more readable
@Component
public class BookService_withoutDB {
    
    private static List<Book> booklist = new ArrayList<>();

    static{
//    	booklist.add(new Book(101, "Knowledge World book"  , "Nirbhay Sinha"));
//        booklist.add(new Book(102, "Java world book"       , "Rahul Sinha"));
//        booklist.add(new Book(103, "Python world book" 	   , "Vikash Sharma"));
//        booklist.add(new Book(104, "Ruby world book" 	   , "Shyam Kumar"));
//        booklist.add(new Book(105, "MongoDB world book"    , "Priya Mehta"));
//        booklist.add(new Book(106, "PostgreSQL world book" , "Govind Kumar"));
//        booklist.add(new Book(107, "MySQL world book" 	   , "Shubham Tiwari"));
    }

    // Get All Books
    public List<Book> getAllBooks()
    {
        return booklist;
    }

    // Get single Book by ID
    public Book getSingleBookById(int id)
    {
        Book book = null;
        try {
			book = booklist.stream().filter(e->e.getId()==id).findFirst().get();
		} 
        catch (Exception e) {
			e.printStackTrace();
		}
        
//        for(Book b : booklist) 
//        {
//        	if(b.getId()==id) {
//        		book=b;
//        		break;
//        	}
//        }
        
        return book;
    }

	public Book saveBook(Book b) 
	{
		try {
			booklist.add(b);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}
    
//	public List<Book> deleteBookById(int bid)
//	{
//		try {
//			booklist = booklist.stream().filter(book -> book.getId()!=bid).collect(Collectors.toList());
//		} 
//		catch (Exception e) {
//			e.printStackTrace();
//		}
//		return booklist;
//	}

	public void deleteBookById(int bid)
	{
		try {
			booklist = booklist.stream().filter(book -> book.getId()!=bid).collect(Collectors.toList());
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public List<Book> updateBook(int bid, Book newbook) 
	{
		try {
			booklist = booklist.stream().map(b->{							// map ke "b" aapko Book ka ek-ek obj deta jayega, but it will also expect one obj of same type in return.  
				if(b.getId()==bid)
				{
					b.setTitle(newbook.getTitle());
					b.setAuthor(newbook.getAuthor());
				}
				return b;
			}).collect(Collectors.toList());
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return booklist;
	}
	
	
}
