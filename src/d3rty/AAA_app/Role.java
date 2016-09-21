package d3rty.AAA_app;

/**
 * Created by Andrew on 21.09.2016.
 */
public class Role {
    final static int READ = 1;
    final static int WRITE = 2;
    final static int EXECUTE = 4;

    public int id;
    public int user_id;
    public String name;
    public String resourse;
    public Role(int id, int user_id, String name, String resourse){
        this.id = id;
        this.user_id = id;
        this.name = name;
        this.resourse = resourse;
    }
}
