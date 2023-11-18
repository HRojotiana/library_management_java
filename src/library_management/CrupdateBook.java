package library_management;

import java.util.Date;
import java.util.Objects;

public class CrupdateBook {
    private String id;
    private String bookName;
    private int pageNumbers;
    private String topic;
    private Date releaseDate;
    private String status;

    public CrupdateBook(String id, String bookName, int pageNumbers, String topic, Date releaseDate, String status) {
        this.id = id;
        this.bookName = bookName;
        this.pageNumbers = pageNumbers;
        this.topic = topic;
        this.releaseDate = releaseDate;
        this.status = status;
    }

    //getter
    public String getId() {
        return id;
    }

    public String getBookName() {
        return bookName;
    }

    public int getPageNumbers() {
        return pageNumbers;
    }

    public String getTopic() {
        return topic;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public String getStatus() {
        return status;
    }

    //Setter
    public void setId(String id) {
        this.id = id;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setPageNumbers(int pageNumbers) {
        this.pageNumbers = pageNumbers;
    }

    public void setTopic(String topic) {
        if(topic.equalsIgnoreCase("romance") || topic.equalsIgnoreCase("comedy") || topic.equalsIgnoreCase("other")) {
            this.topic = topic;
        }
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setStatus(String status) {
        if(status.equalsIgnoreCase("borrowed") || status.equalsIgnoreCase("available")) {
            this.status = status;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CrupdateBook that)) return false;
        return getPageNumbers() == that.getPageNumbers() && Objects.equals(getId(), that.getId()) && Objects.equals(getBookName(), that.getBookName()) && Objects.equals(getTopic(), that.getTopic()) && Objects.equals(getReleaseDate(), that.getReleaseDate()) && Objects.equals(getStatus(), that.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getBookName(), getPageNumbers(), getTopic(), getReleaseDate(), getStatus());
    }
}
