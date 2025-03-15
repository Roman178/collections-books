public class Book {
    private String title;
    private String author;
    private String genre;
    private int year;
    private int pages;

    public Book(String title, String author, String genre,
                int year, int pages) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.year = year;
        this.pages = pages;
    }

    public int getPages() {
        return pages;
    }

    public String getGenre() {
        return genre;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }
}
