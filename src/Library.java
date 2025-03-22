import java.util.*;
import java.util.stream.Collectors;

public class Library {
    private List<Book> books = new ArrayList<>();
    private final Map<String, List<Book>> booksByAuthors = new HashMap<>();

    public void addBook(Book book) {
        books.add(book);
        saveBookByAuthor(book);
    }

    private void saveBookByAuthor(Book book) {
        List<Book> booksByAuthor = booksByAuthors.get(book.getAuthor());
        if (booksByAuthor == null) {
            List<Book> list = new ArrayList<>();
            list.add(book);
            booksByAuthors.put(book.getAuthor(), list);
        } else {
            booksByAuthor.add(book);
        }
    }

    public Map<String, List<Book>> getBooksByAuthors() {
        return booksByAuthors;
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

    public double averagePublicationYear() {
        return books.stream().collect(Collectors.averagingInt(Book::getYear));
    }

    public List<Book> filterByPages(int minPages) {
        return books.stream().filter(book -> book.getPages() >= minPages).toList();
    }

    public List<Book> sortByTitle() {
        return books.stream().sorted(Comparator.comparing(Book::getTitle)).toList();
    }

    public List<Book> sortByYearDescending() {
        return books.stream().sorted(Comparator.comparing(Book::getYear).reversed()).toList();
    }

    public Book searchByTitle(String title) {
        return books.stream()
                        .filter(book -> book.getTitle()
                        .equals(title))
                        .findFirst()
                        .orElse(null);
    }

    public String deleteByTitle(String title) {
        Book book = books.stream().filter(b -> b.getTitle().equals(title)).findFirst().orElse(null);
        if (book == null) {
            return "Книга не найдена";
        }
        books = books.stream().filter(bk -> !bk.getTitle().equals(title)).toList();
        booksByAuthors.computeIfPresent(book.getAuthor(),
                (k, booksByAuthor) -> booksByAuthor.stream().filter(bk -> !bk.getTitle().equals(title)).toList());

        return "Книга " + title + " удалена";
    }
}
