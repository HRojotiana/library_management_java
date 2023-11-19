package library_management;

import java.util.Date;
import java.util.Objects;

public class Book extends CrupdateBook{
    private String idAuthor;

    public Book(String id, String bookName, int pageNumbers, String topic, Date releaseDate, String status, String idAuthor) {
        super(id, bookName, pageNumbers, topic, releaseDate, status);
        this.idAuthor = idAuthor;
    }

    //Getter

    public String getIdAuthor() {
        return idAuthor;
    }

    //Setter
    public void setIdAuthor(String idAuthor) {
        this.idAuthor = idAuthor;
    }

    //toString


    @Override
    public String toString() {
        return "{" + super.toString() + "idAuthor='" + idAuthor + '\'' + "}";
    }

    //Equals and HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getIdAuthor(), book.getIdAuthor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getIdAuthor());
    }
}
