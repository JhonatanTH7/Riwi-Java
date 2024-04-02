package WorkPOO.Exercise1.Classes;

public class Book {
    private String title;
    private String author;
    private String releaseDate;
    private boolean borrowed;

    public Book(String title, String author, String releaseDate, boolean borrowed) {
        this.title = title;
        this.author = author;
        this.releaseDate = releaseDate;
        this.borrowed = borrowed;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }

    public void changeLendingStatus() {
        this.borrowed = !this.borrowed;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", borrowed=" + borrowed +
                '}';
    }
}
