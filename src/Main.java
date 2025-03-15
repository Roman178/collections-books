public class Main {
    public static void main(String[] args) {

        Library library = new Library();

        library.addBook(new Book("1984", "George Orwell", "Dystopian", 1949, 328));
        library.addBook(new Book("Brave New World", "Aldous Huxley", "Dystopian", 1932, 311));
        library.addBook(new Book("The Catcher in the Rye", "J.D. Salinger", "Classic", 1951, 277));
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee", "Classic", 1960, 281));
        library.addBook(new Book("The Hobbit", "J.R.R. Tolkien", "Fantasy", 1937, 310));
        library.addBook(new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling", "Fantasy", 1997, 223));

//        System.out.println("Книги Джорджа Оруэлла: " + library.findByAuthor("George Orwell"));
//        System.out.println("Книги жанра 'Dystopian': " + library.findByGenre("Dystopian"));
//        System.out.println("Книги после 1950 года: " + library.findBooksAfterYear(1950));
//        System.out.println("Уникальные авторы: " + library.getUniqueAuthors());
//        System.out.println("Группировка по жанрам: " + library.groupByGenre());
        System.out.println("Количество книг жанра 'Fantasy': " + library.countBooksByGenre("Fantasy"));
//        System.out.println("Средний год выпуска книг: " + library.averagePublicationYear());
//        System.out.println("Книги с более чем 250 страницами: " + library.filterByPages(250));
//        System.out.println("Книги, отсортированные по названию: " + library.sortByTitle());
//        System.out.println("Книги, отсортированные по убыванию года: " + library.sortByYearDescending());
    }
}