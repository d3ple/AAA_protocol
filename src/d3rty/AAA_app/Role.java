package d3rty.AAA_app;

public class Role {

    private int id;
    private User user;
    private String name;
    private String resource;

    public Role(int id, User user, String name, String resource) {
        this.id = id;
        this.user = user;
        this.name = name;
        this.resource = resource;
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getName() {
        return name;
    }

    public String getResource() {
        return resource;
    }
}
