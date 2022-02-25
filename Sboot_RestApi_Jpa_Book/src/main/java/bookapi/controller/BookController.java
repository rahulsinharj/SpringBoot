package bookapi.controller;

import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import bookapi.entity.Book;
import bookapi.service.BookService;
import bookapi.service.BookService_withoutDB;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;	
	
//	@Autowired
//	private BookService_withoutDB bookService2;
	
	
//    @GetMapping("/books")										// Handler for - Getting All Books 
//    public List<Book> getAllBooks() 
//    {
//    	return this.bookService.getAllBooks();
//    }
    
    @GetMapping("/books")										// Handler for - Getting All Books 
    public ResponseEntity<List<Book>> getAllBooks() 
    {
    	List<Book> allBooks = this.bookService.getAllBooks();
    	if(allBooks.size() <= 0) 														// If no books found, then we should return Response as "Not Found" as STATUS to the front server 
    	{
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    	}
    	
    	return ResponseEntity.status(HttpStatus.OK).body(allBooks);
    }
    
    
    
//    @GetMapping("/books/{id}")									// Handler for - Getting Single Book 
//    public Book getSingleBook(@PathVariable("id") int id) 
//    {
//    	Book b= this.bookService.getSingleBookById(id);
//    		System.out.println(b);
//    	return b;
//    }
     
    @GetMapping("/books/{id}")									// Handler for - Getting Single Book 
    public ResponseEntity<Book> getSingleBook(@PathVariable("id") int id) 
    {
    	Book b= this.bookService.getSingleBookById(id);
    	if(b == null) {
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    	}
    		System.out.println(b);
    	return ResponseEntity.of(Optional.of(b));
    }
    
    
/*   [POST MAPPING] ::
 -------------------------------------------------------------------------------------------------------------------*/
    
//    @PostMapping("/books")										// Handler for - Creating new Book
//    public Book addBook(@RequestBody Book book) 				// @RequestBody - same way @RequestParam
//    {
//    	Book b = this.bookService.saveBook(book);
//    	return b ;
//    }
    
    
    // Post and get all BOOKS :
//    @PostMapping("/books")										// Handler for - Creating new Book
//    public ResponseEntity<List<Book>> addBookandSee(@RequestBody Book book) 				// @RequestBody - same way @RequestParam
//    {
//    	List<Book> b = null;
//    	try {
//			b= this.bookService.saveBookandGetAll(book);
//			return ResponseEntity.status(HttpStatus.CREATED).body(b);
//		} 
//    	catch (Exception e) {
//			e.printStackTrace();
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//    	}
//    }
    
    
//     POST and get that only added book ::
    @PostMapping("/books")										// Handler for - Creating new Book
    public ResponseEntity<Book> addBook(@RequestBody Book book) 				// @RequestBody - same way @RequestParam
    {
    	Book b = null;
    	try {
			b= this.bookService.saveBook(book);
			return ResponseEntity.status(HttpStatus.CREATED).body(b);
		} 
    	catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    	}
    }
    
    
/*   [UPDATE MAPPING] ::
 -------------------------------------------------------------------------------------------------------------------*/
    
    // Updating and 
    @PutMapping("/books/{bookId}")
    public ResponseEntity<Book> updateBook(@PathVariable("bookId") int bookId, @RequestBody Book book )		// Handler for - updating single Book
    {
    	Book updatedbook = null;
    	try {
			updatedbook = this.bookService.updateBook(bookId, book);
			return ResponseEntity.status(HttpStatus.CREATED).body(updatedbook);
    	} 
    	catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
    }
    
    
/*   [DELETE MAPPING] ::
 -------------------------------------------------------------------------------------------------------------------*/    
    
//    @DeleteMapping("/books/{bookId}")
//    public List<Book> deleteBook(@PathVariable("bookId") int bookId )		// Handler for - deleting single Book
//    {
//    		return this.bookService.deleteBookById(bookId);
//    }
	   
	@DeleteMapping("/books/{bookId}")
	public ResponseEntity<Void> deleteBook(@PathVariable("bookId") int bookId )		// Handler for - deleting single Book
	{
		try {
			this.bookService.deleteBookById(bookId);
//			return ResponseEntity.ok().build();
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
				
		}
	  	catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}	
	  
    
    
    
}
