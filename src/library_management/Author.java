package library_management;

public class Author {
    private String id;
    private String name;
    private String sex;

    public Author(String id, String name, String sex) {
        this.id = id;
        this.name = name;
        this.sex = sex;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

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
}
