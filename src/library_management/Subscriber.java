package library_management;

import java.util.Date;
import java.util.Objects;

public class Subscriber extends User{
    private Date birthdate;

    //Constructor
    public Subscriber(String id, String name, String reference, Date birthdate) {
        super(id, name, reference);
        this.birthdate = birthdate;
    }

    //Getter
    public Date getBirthdate() {
        return birthdate;
    }

    //Setter
    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    //toString


    @Override
    public String toString() {
        return "{" + super.toString() +
                "birthdate=" + birthdate +
                "} ";
    }

    //Equals and hashcode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Subscriber that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getBirthdate(), that.getBirthdate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getBirthdate());
    }
}
