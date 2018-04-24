import org.junit.jupiter.api.Test;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.*;
import java.util.Date;
import java.util.stream.Stream;

/**
 *
 * @author not Helge :P
 */
public class MySqlConnectionTest {

    private static final String IP	     = "192.168.33.10";
    private static final String PORT     = "3306";
    public  static final String DATABASE = "project";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "rootpwd";

    /*
    public static void main(String[] args) {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        String url = "jdbc:mysql://192.168.33.10:3306/project";
        String user = "root";
        String password = "rootpwd";

        String query = "select * from nodes where node_id in (select target_node_id from edges where source_node_id = (select node_id from nodes where node_id = " + 50 + "));";

        try {

            con = DriverManager.getConnection(url, user, password);

            st = con.createStatement();
            rs = st.executeQuery(query);
            System.out.println("node_id, name, job, birthday");
            while (rs.next()) {
                System.out.println(rs.getString("node_id") + "," + rs.getString("name") + "," + rs.getString("job") + "," + rs.getString("birthday"));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            System.err.println(ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
                System.err.println(ex);
            }
        }
    }
    */

    @Test
    public void RunAllTheQueriesx1()
    {
        int attempts = 20;
        Random random = new Random();
        ArrayList<Node> fullList = new ArrayList<Node>();
        ArrayList<Node> tempList;
        ArrayList<Long> time = new ArrayList<Long>();
        for (int i = 0; i < attempts; i++) {
            long timer = System.currentTimeMillis();
            tempList = AllPeopleEndosedByPerson(0 + random.nextInt(499999));
            for (Node person: tempList
                 ) {
                fullList.add(person);
            }
            timer = System.currentTimeMillis() - timer;
            System.out.println(timer + " was the time on round #" + i);
            time.add(timer);
        }
        System.out.println(fullList.size());
        Collections.sort(time);
        System.out.println(time.get(10) + " was the median of the loop");
        System.out.println(time.stream().mapToLong(val -> val).average().getAsDouble() + " was the average of the loop");
    }

    @Test
    public void RunAllTheQueriesx2()
    {
        int attempts = 20;
        Random random = new Random();
        ArrayList<Node> fullList = new ArrayList<Node>();
        ArrayList<Node> tempList;
        ArrayList<Long> time = new ArrayList<Long>();
        for (int i = 0; i < attempts; i++) {
            long timer = System.currentTimeMillis();
            tempList = AllPeopleEndosedByPersonx2(0 + random.nextInt(499999));
            for (Node person: tempList
                    ) {
                fullList.add(person);
            }
            timer = System.currentTimeMillis() - timer;
            System.out.println(timer + " was the time on round #" + i);
            time.add(timer);
        }
        System.out.println(fullList.size());
        Collections.sort(time);
        System.out.println(time.get(10) + " was the median of the loop");
        System.out.println(time.stream().mapToLong(val -> val).average().getAsDouble() + " was the average of the loop");
    }

    @Test
    public void RunAllTheQueriesx3()
    {
        int attempts = 20;
        Random random = new Random();
        ArrayList<Node> fullList = new ArrayList<Node>();
        ArrayList<Node> tempList;
        ArrayList<Long> time = new ArrayList<Long>();
        for (int i = 0; i < attempts; i++) {
            long timer = System.currentTimeMillis();
            tempList = AllPeopleEndosedByPersonx3(0 + random.nextInt(499999));
            for (Node person: tempList
                    ) {
                fullList.add(person);
            }
            timer = System.currentTimeMillis() - timer;
            System.out.println(timer + " was the time on round #" + i);
            time.add(timer);
        }
        System.out.println(fullList.size());
        Collections.sort(time);
        System.out.println(time.get(10) + " was the median of the loop");
        System.out.println(time.stream().mapToLong(val -> val).average().getAsDouble() + " was the average of the loop");
    }

    @Test
    public void RunAllTheQueriesx4()
    {
        int attempts = 20;
        Random random = new Random();
        ArrayList<Node> fullList = new ArrayList<Node>();
        ArrayList<Node> tempList;
        ArrayList<Long> time = new ArrayList<Long>();
        for (int i = 0; i < attempts; i++) {
            long timer = System.currentTimeMillis();
            tempList = AllPeopleEndosedByPersonx4(0 + random.nextInt(499999));
            for (Node person: tempList
                    ) {
                fullList.add(person);
            }
            timer = System.currentTimeMillis() - timer;
            System.out.println(timer + " was the time on round #" + i);
            time.add(timer);
        }
        System.out.println(fullList.size());
        Collections.sort(time);
        System.out.println(time.get(10) + " was the median of the loop");
        System.out.println(time.stream().mapToLong(val -> val).average().getAsDouble() + " was the average of the loop");
    }

    @Test
    public void RunAllTheQueriesx5()
    {
        int attempts = 20;
        Random random = new Random();
        ArrayList<Node> fullList = new ArrayList<Node>();
        ArrayList<Node> tempList = new ArrayList<Node>();;
        ArrayList<Long> time = new ArrayList<Long>();
        for (int i = 0; i < attempts; i++) {
            long timer = System.currentTimeMillis();
            tempList = AllPeopleEndosedByPersonx5(0 + random.nextInt(499999));

            for (Node person: tempList
                    ) {
                fullList.add(person);
            }
            timer = System.currentTimeMillis() - timer;
            System.out.println(timer + " was the time on round #" + i);
            time.add(timer);

        }
        System.out.println(fullList.size());
        Collections.sort(time);
        System.out.println(time.get(10) + " was the median of the loop");
        System.out.println(time.stream().mapToLong(val -> val).average().getAsDouble() + " was the average of the loop");
    }

    @Test
    public void TestAllPeopleEndosedByPerson()
    {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        String url = "jdbc:mysql://192.168.33.10:3306/project";
        String user = "root";
        String password = "rootpwd";

        String query = "select * from nodes where node_id in (select target_node_id from edges where source_node_id = (select node_id from nodes where node_id = " + 100 + "));";
        //String query = "select * from nodes where node_id in " +
                //"(select target_node_id from edges where source_node_id = " + 100 +");";

        try {

            con = DriverManager.getConnection(url, user, password);

            st = con.createStatement();
            rs = st.executeQuery(query);
            System.out.println("node_id, name, job, birthday");
            ArrayList<Node> people = new ArrayList<Node>();
            while (rs.next()) {
                int node_id = rs.getInt("node_id");
                String name = rs.getString("name");
                String job = rs.getString("job");
                Date birthday = rs.getDate("birthday");
                people.add(new Node(node_id,name,job,birthday));
            }
            int i = 0;
            for (Node item: people) {
                i++;
                System.out.println(item.node_id + "," + item.name + "," + item.job + "," + item.birthday);
            }
            System.out.println(i);

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            System.err.println(ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
                System.err.println(ex);
            }
        }
    }

    public ArrayList<Node> AllPeopleEndosedByPerson(int personid)
    {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        String url = "jdbc:mysql://192.168.33.10:3306/project";
        String user = "root";
        String password = "rootpwd";

        String query = "select * from nodes where node_id in (select target_node_id from edges where source_node_id = (select node_id from nodes where node_id = " + personid + "));";
        ArrayList<Node> people = new ArrayList<Node>();
        try {

            con = DriverManager.getConnection(url, user, password);

            st = con.createStatement();
            rs = st.executeQuery(query);
            //System.out.println("node_id, name, job, birthday");
            while (rs.next()) {
                int node_id = rs.getInt("node_id");
                String name = rs.getString("name");
                String job = rs.getString("job");
                Date birthday = rs.getDate("birthday");
                people.add(new Node(node_id,name,job,birthday));
            }
            /*
            int i = 0;
            for (Node item: people) {
                i++;
                System.out.println(item.node_id + "," + item.name + "," + item.job + "," + item.birthday);
            }
            System.out.println(i);
            */
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            System.err.println(ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
                System.err.println(ex);
            }
        }
        return people;
    }

    @Test
    public void TestAllPeopleEndosedByPersonx2()
    {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        String url = "jdbc:mysql://192.168.33.10:3306/project";
        String user = "root";
        String password = "rootpwd";

        String query = "select * from nodes where node_id in (select target_node_id from edges where source_node_id in (select node_id from nodes where node_id in " +
                "(select target_node_id from edges where source_node_id in (select node_id from nodes where node_id = " + 100 + "))));";
        //String query = "select * from nodes where node_id in " +
                //"(select target_node_id from edges where source_node_id in " +
                //"(select target_node_id from edges where source_node_id = " + 100 +"));";

        try {

            con = DriverManager.getConnection(url, user, password);

            st = con.createStatement();
            rs = st.executeQuery(query);
            System.out.println("node_id, name, job, birthday");
            ArrayList<Node> people = new ArrayList<Node>();
            while (rs.next()) {
                int node_id = rs.getInt("node_id");
                String name = rs.getString("name");
                String job = rs.getString("job");
                Date birthday = rs.getDate("birthday");
                people.add(new Node(node_id,name,job,birthday));
            }
            int i = 0;
            for (Node item: people) {
                i++;
                System.out.println(item.node_id + "," + item.name + "," + item.job + "," + item.birthday);
            }
            System.out.println(i);

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            System.err.println(ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
                System.err.println(ex);
            }
        }
    }

    public ArrayList<Node> AllPeopleEndosedByPersonx2(int personid)
    {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        String url = "jdbc:mysql://192.168.33.10:3306/project";
        String user = "root";
        String password = "rootpwd";

        String query = "select * from nodes where node_id in (select target_node_id from edges where source_node_id in (select node_id from nodes where node_id in " +
                "(select target_node_id from edges where source_node_id in (select node_id from nodes where node_id = " + personid + "))));";

        ArrayList<Node> people = new ArrayList<Node>();
        try {

            con = DriverManager.getConnection(url, user, password);

            st = con.createStatement();
            rs = st.executeQuery(query);
            //System.out.println("node_id, name, job, birthday");
            while (rs.next()) {
                int node_id = rs.getInt("node_id");
                String name = rs.getString("name");
                String job = rs.getString("job");
                Date birthday = rs.getDate("birthday");
                people.add(new Node(node_id,name,job,birthday));
            }
            /*
            int i = 0;
            for (Node item: people) {
                i++;
                System.out.println(item.node_id + "," + item.name + "," + item.job + "," + item.birthday);
            }
            System.out.println(i);
            */
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            System.err.println(ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
                System.err.println(ex);
            }
        }
        return people;
    }

    @Test
    public void TestAllPeopleEndosedByPersonx3()
    {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        String url = "jdbc:mysql://192.168.33.10:3306/project";
        String user = "root";
        String password = "rootpwd";

        String query = "select * from nodes where node_id in (select target_node_id from edges where source_node_id in (select node_id from nodes where node_id in " +
                "(select target_node_id from edges where source_node_id in (select node_id from nodes where node_id in " +
                "(select target_node_id from edges where source_node_id in (select node_id from nodes where node_id = " + 100 + "))))));";
        //String query = "select * from nodes where node_id in " +
                //"(select target_node_id from edges where source_node_id in " +
                //"(select target_node_id from edges where source_node_id in " +
                //"(select target_node_id from edges where source_node_id = " + 100 +")));";

        try {

            con = DriverManager.getConnection(url, user, password);

            st = con.createStatement();
            rs = st.executeQuery(query);
            System.out.println("node_id, name, job, birthday");
            ArrayList<Node> people = new ArrayList<Node>();
            while (rs.next()) {
                int node_id = rs.getInt("node_id");
                String name = rs.getString("name");
                String job = rs.getString("job");
                Date birthday = rs.getDate("birthday");
                people.add(new Node(node_id,name,job,birthday));
            }
            int i = 0;
            for (Node item: people) {
                i++;
                System.out.println(item.node_id + "," + item.name + "," + item.job + "," + item.birthday);
            }
            System.out.println(i);

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            System.err.println(ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
                System.err.println(ex);
            }
        }
    }

    public ArrayList<Node> AllPeopleEndosedByPersonx3(int personid)
    {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        String url = "jdbc:mysql://192.168.33.10:3306/project";
        String user = "root";
        String password = "rootpwd";

        String query = "select * from nodes where node_id in (select target_node_id from edges where source_node_id in (select node_id from nodes where node_id in " +
                "(select target_node_id from edges where source_node_id in (select node_id from nodes where node_id in " +
                "(select target_node_id from edges where source_node_id in (select node_id from nodes where node_id = " + personid + "))))));";

        ArrayList<Node> people = new ArrayList<Node>();
        try {

            con = DriverManager.getConnection(url, user, password);

            st = con.createStatement();
            rs = st.executeQuery(query);
            //System.out.println("node_id, name, job, birthday");
            while (rs.next()) {
                int node_id = rs.getInt("node_id");
                String name = rs.getString("name");
                String job = rs.getString("job");
                Date birthday = rs.getDate("birthday");
                people.add(new Node(node_id,name,job,birthday));
            }
            /*
            int i = 0;
            for (Node item: people) {
                i++;
                System.out.println(item.node_id + "," + item.name + "," + item.job + "," + item.birthday);
            }
            System.out.println(i);
            */
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            System.err.println(ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
                System.err.println(ex);
            }
        }
        return people;
    }

    @Test
    public void TestAllPeopleEndosedByPersonx4()
    {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        String url = "jdbc:mysql://192.168.33.10:3306/project";
        String user = "root";
        String password = "rootpwd";

        String query = "select * from nodes where node_id in (select target_node_id from edges where source_node_id in (select node_id from nodes where node_id in " +
                "(select target_node_id from edges where source_node_id in (select node_id from nodes where node_id in " +
                "(select target_node_id from edges where source_node_id in (select node_id from nodes where node_id in " +
                "(select target_node_id from edges where source_node_id in (select node_id from nodes where node_id = " + 100 + "))))))));";
        //String query = "select * from nodes where node_id in " +
                //"(select target_node_id from edges where source_node_id in " +
                //"(select target_node_id from edges where source_node_id in " +
                //"(select target_node_id from edges where source_node_id in " +
                //"(select target_node_id from edges where source_node_id = " + 100 +"))));";

        try {

            con = DriverManager.getConnection(url, user, password);

            st = con.createStatement();
            rs = st.executeQuery(query);
            System.out.println("node_id, name, job, birthday");
            ArrayList<Node> people = new ArrayList<Node>();
            while (rs.next()) {
                int node_id = rs.getInt("node_id");
                String name = rs.getString("name");
                String job = rs.getString("job");
                Date birthday = rs.getDate("birthday");
                people.add(new Node(node_id,name,job,birthday));
            }
            for (Node item: people) {
                System.out.println(item.node_id + "," + item.name + "," + item.job + "," + item.birthday);
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            System.err.println(ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
                System.err.println(ex);
            }
        }
    }

    public ArrayList<Node> AllPeopleEndosedByPersonx4(int personid)
    {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        String url = "jdbc:mysql://192.168.33.10:3306/project";
        String user = "root";
        String password = "rootpwd";

        String query = "select * from nodes where node_id in (select target_node_id from edges where source_node_id in (select node_id from nodes where node_id in " +
                "(select target_node_id from edges where source_node_id in (select node_id from nodes where node_id in " +
                "(select target_node_id from edges where source_node_id in (select node_id from nodes where node_id in " +
                "(select target_node_id from edges where source_node_id in (select node_id from nodes where node_id = " + personid + "))))))));";
        ArrayList<Node> people = new ArrayList<Node>();
        try {

            con = DriverManager.getConnection(url, user, password);

            st = con.createStatement();
            rs = st.executeQuery(query);
            //System.out.println("node_id, name, job, birthday");
            while (rs.next()) {
                int node_id = rs.getInt("node_id");
                String name = rs.getString("name");
                String job = rs.getString("job");
                Date birthday = rs.getDate("birthday");
                people.add(new Node(node_id,name,job,birthday));
            }
            /*
            int i = 0;
            for (Node item: people) {
                i++;
                System.out.println(item.node_id + "," + item.name + "," + item.job + "," + item.birthday);
            }
            System.out.println(i);
            */

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            System.err.println(ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
                System.err.println(ex);
            }
        }
        return people;
    }

    @Test
    public void TestAllPeopleEndosedByPersonx5()
    {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        String url = "jdbc:mysql://192.168.33.10:3306/project";
        String user = "root";
        String password = "rootpwd";


        String query = "select * from nodes where node_id in (select target_node_id from edges where source_node_id in (select node_id from nodes where node_id in " +
                "(select target_node_id from edges where source_node_id in (select node_id from nodes where node_id in " +
                "(select target_node_id from edges where source_node_id in (select node_id from nodes where node_id in " +
                "(select target_node_id from edges where source_node_id in (select node_id from nodes where node_id in " +
                "(select target_node_id from edges where source_node_id in (select node_id from nodes where node_id = " + 100 + "))))))))));";
        /*
        String query = "select * from nodes where node_id in " +
                "(select target_node_id from edges where source_node_id in " +
                "(select target_node_id from edges where source_node_id in " +
                "(select target_node_id from edges where source_node_id in " +
                "(select target_node_id from edges where source_node_id in " +
                "(select target_node_id from edges where source_node_id = " + 100 +")))));";
                */

        try {

            con = DriverManager.getConnection(url, user, password);

            st = con.createStatement();
            rs = st.executeQuery(query);
            System.out.println("node_id, name, job, birthday");
            ArrayList<Node> people = new ArrayList<Node>();
            while (rs.next()) {
                int node_id = rs.getInt("node_id");
                String name = rs.getString("name");
                String job = rs.getString("job");
                Date birthday = rs.getDate("birthday");
                people.add(new Node(node_id,name,job,birthday));
            }
            for (Node item: people) {
                System.out.println(item.node_id + "," + item.name + "," + item.job + "," + item.birthday);
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            System.err.println(ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
                System.err.println(ex);
            }
        }
    }

    public ArrayList<Node> AllPeopleEndosedByPersonx5(int personid)
    {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        String url = "jdbc:mysql://192.168.33.10:3306/project";
        String user = "root";
        String password = "rootpwd";

        String query = "select * from nodes where node_id in (select target_node_id from edges where source_node_id in (select node_id from nodes where node_id in " +
                "(select target_node_id from edges where source_node_id in (select node_id from nodes where node_id in " +
                "(select target_node_id from edges where source_node_id in (select node_id from nodes where node_id in " +
                "(select target_node_id from edges where source_node_id in (select node_id from nodes where node_id in " +
                "(select target_node_id from edges where source_node_id in (select node_id from nodes where node_id = " + personid + "))))))))));";

        ArrayList<Node> people = new ArrayList<Node>();
        try {

            con = DriverManager.getConnection(url, user, password);

            st = con.createStatement();
            rs = st.executeQuery(query);
            //System.out.println("node_id, name, job, birthday");
            while (rs.next()) {
                int node_id = rs.getInt("node_id");
                String name = rs.getString("name");
                String job = rs.getString("job");
                Date birthday = rs.getDate("birthday");
                people.add(new Node(node_id,name,job,birthday));
            }
            /*
            int i = 0;
            for (Node item: people) {
                i++;
                System.out.println(item.node_id + "," + item.name + "," + item.job + "," + item.birthday);
            }
            System.out.println(i);
            */

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            System.err.println(ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
                System.err.println(ex);
            }
        }
        return people;
    }

}