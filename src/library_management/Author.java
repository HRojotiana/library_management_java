package library_management;

import java.util.Objects;

public class Author {
    private String id;
    private String name;
    private String sex;

    public Author(String id, String name, String sex) {
        this.id = id;
        this.name = name;
        this.sex = sex;
    }

    //Getter
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    //Setter
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        if(sex.equalsIgnoreCase("F") || sex.equalsIgnoreCase("M")){
            this.sex = sex;
        }
    }

    //toString
    @Override
    public String toString() {
        return "{"+ "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' + "}" ;
    }

    //Equals and Hashcode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author author)) return false;
        return Objects.equals(getId(), author.getId()) && Objects.equals(getName(), author.getName()) && Objects.equals(getSex(), author.getSex());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getSex());
    }
}
