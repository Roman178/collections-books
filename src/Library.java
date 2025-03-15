import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Library {
    List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> findByAuthor(String author) {
        return books.stream().filter(book -> book.getAuthor().equals(author)).toList();
    }

    public List<Book> findByGenre(String genre) {
        return books.stream().filter(book -> book.getGenre().equals(genre)).toList();
    }

    public List<Book> findBooksAfterYear(int year) {
        return books.stream().filter(book -> book.getYear() > year).toList();
    }

    public Set<String> getUniqueAuthors() {
        return new HashSet<>(books.stream().map(Book::getAuthor).toList());
    }

    public Map<String, List<Book>> groupByGenre() {
        HashMap<String, List<Book>> booksMap = new HashMap<>();

        books.forEach(book -> {
            if (booksMap.containsKey(book.getGenre())) {
                booksMap.get(book.getGenre()).add(book);
            } else {
                List<Book> booksByGenre = new ArrayList<>();
                booksByGenre.add(book);
                booksMap.put(book.getGenre(), booksByGenre);
            }
        });

        return booksMap;
    }

    public long countBooksByGenre(String genre) {
        return this.findByGenre(genre).stream().count();
    }

//    public double averagePublicationYear() {
//        books.stream().mapToInt())
//    }
}
