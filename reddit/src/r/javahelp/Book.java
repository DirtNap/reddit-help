package r.javahelp;

import java.util.Arrays;
import java.util.Comparator;

public class Book implements Comparator<Book> {

    private class TitleComparator implements Comparator<Book> {

        @Override
        public int compare(Book o1, Book o2) {
            // Compare by tiles here
            return 0;
        }

    }

    private class GenreComparator implements Comparator<Book> {

        @Override
        public int compare(Book o1, Book o2) {
            // Compare by genre here
            return 0;
        }

    }

    private enum ComparisonType {
        TITLE, GENRE
    }

    private ComparisonType compareType;
    private String title;
    private String genre;
    private static TitleComparator titleComparator;
    private static GenreComparator genreComparator;

    public Book(String title, String genre) {
        this.title = title;
        this.genre = genre;
    }

    public ComparisonType getCompareType() {
        return this.compareType;
    }

    public void setCompareType(ComparisonType compareType) {
        this.compareType = compareType;
    }

    public String getTitle() {
        return this.title;
    }

    public String getGenre() {
        return this.genre;
    }

    public Comparator<Book> getTitleComparitor() {
        if (null == Book.titleComparator) {
            Book.titleComparator = new TitleComparator();
        }
        return Book.titleComparator;
    }

    public Comparator<Book> getGenreComparitor() {
        if (null == Book.genreComparator) {
            Book.genreComparator = new GenreComparator();
        }
        return Book.genreComparator;
    }

    public Comparator<Book> getComparitor() {
        switch (this.compareType) {
        case GENRE:
            return this.getGenreComparitor();
        case TITLE:
        default:
            return this.getTitleComparitor();

        }
    }

    @Override
    public int compare(Book o1, Book o2) {
        Comparator<Book> comparitor = this.getComparitor();
        return comparitor.compare(o1, o2);
    }

    public static void main(String[] args) {
        Book[] books = new Book[] { new Book("The Great Gatsby", "Fiction"),
                new Book("Team of Rivals", "History"), new Book("Einstein's Brain", "Science") };
        Book book = books[0];
        System.out.println(book.compare(books[1], books[2]));
        book.setCompareType(ComparisonType.GENRE);
        System.out.println(book.compare(books[1], books[2]));
        Arrays.sort(books);
        Arrays.sort(books, book.getComparitor());
        Arrays.sort(books, book.getGenreComparitor());
        Arrays.sort(books, book.getTitleComparitor());
    }
}
