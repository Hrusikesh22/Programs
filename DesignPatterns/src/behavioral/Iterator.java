package behavioral;

/*
 * Traversing the collection of objects in a DEFINED MANNER without exposing its internal structure
 * of elements or collection itself. ITERATORS bear that responsibility.
 * iterator supports multiple simultaneous traversals of a collection from start to end in forward, backward or both directions.
 * https://howtodoinjava.com/design-patterns/behavioral/iterator-design-pattern/
 * 
 */
public class Iterator {
	public static void main(String[] args) 
    {
        Book[] Books = new Book[5];
        Books[0] = new Book("Book1");
        Books[1] = new Book("Book2");
        Books[2] = new Book("Book3");
        Books[3] = new Book("Book4");
        Books[4] = new Book("Book5");
         
        MyList<Book> list = new BookList(Books);
         
        MyIterator<Book> iterator = list.iterator();
         
        while(iterator.hasNext()) {
            Book currentBook = iterator.next();
            System.out.println(currentBook.getName());
        }
    }
}

interface MyIterator<T> {
	void reset();
	boolean hasNext();
	T next();
	T current();
}

class BookIterator implements MyIterator<Book> {

	private Book[] books;
	private int index;
	
	public BookIterator(Book[] books) { this.books = books; }
	
	//Iterator keeps track of index and work accordingly.
	//Below are not fully implemented.
	
	@Override
    public void reset() {
        index = 0;
    }
 
    @Override
    public Book next() { 
        return books[index++];
    }
 
    @Override
    public Book current() {
        return books[index];
    }
 
    @Override
    public boolean hasNext() {
        if(index >= books.length)
            return false;
        return true;
    }
}

interface MyList<E> { 
	MyIterator<E> iterator(); 
}

class BookList implements MyList<Book>
{
    private Book[] books;
     
    public BookList(Book[] books)
    {
        this.books = books;
    }
     
    @Override
    public MyIterator<Book> iterator() {
        return new BookIterator(books);
    }
}

class Book {
	private String name;
	public Book(String name) {this.name = name;}
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
}