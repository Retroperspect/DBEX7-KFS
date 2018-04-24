import java.util.Date;

public class Node {
    public int node_id;
    public String name;
    public String job;
    public Date birthday;

    public Node(int node_id, String name, String job, Date birthday)
    {
        this.node_id = node_id;
        this.name = name;
        this.job = job;
        this.birthday = birthday;
    }
}
