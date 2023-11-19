package library_management;

import java.util.Objects;

public class User {
    private String id;
    private String name;
    private String reference;

    //Constructor

    public User(String id, String name, String reference) {
        this.id = id;
        this.name = name;
        this.reference = reference;
    }

    //Getter

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getReference() {
        return reference;
    }

    //Setter

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    //toString

    @Override
    public String toString() {
        return "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", reference='" + reference + '\'' ;
    }


    //Equals and hashcode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(getId(), user.getId()) && Objects.equals(getName(), user.getName()) && Objects.equals(getReference(), user.getReference());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getReference());
    }
}
