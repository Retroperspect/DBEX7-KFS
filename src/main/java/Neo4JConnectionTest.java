import org.junit.jupiter.api.Test;

import org.neo4j.driver.v1.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author not Helge :P
 */
public class Neo4JConnectionTest {

    /*
    public static void main(String[] args) {
        Driver driver = GraphDatabase.driver(
                "bolt://192.168.33.10:7687",
                AuthTokens.basic( "neo4j", "class" ) );
        Session session = driver.session();

        // Run a query matching all nodes
        StatementResult result = session.run(
                "MATCH (s:Person)" +
                        "RETURN s.name AS name, s.job AS job");

        while ( result.hasNext() ) {
            Record record = result.next();
            System.out.println( record.get("name").asString() + " -> " +
                    record.get("job").asString());
        }
        session.close();
        driver.close();
    }
    */

    @Test
    public void RunAllTheQueriesx1() throws ParseException {
        int attempts = 20;
        Random random = new Random();
        ArrayList<Node> fullList = new ArrayList<Node>();
        ArrayList<Node> tempList;
        ArrayList<Long> time = new ArrayList<Long>();
        for (int i = 0; i < attempts; i++) {
            long timer = System.currentTimeMillis();
            tempList = AllPeopleEndosedByPersonx1(0 + random.nextInt(499999));
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
    public void RunAllTheQueriesx2() throws ParseException {
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
    public void RunAllTheQueriesx3() throws ParseException {
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
    public void RunAllTheQueriesx4() throws ParseException {
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
    public void RunAllTheQueriesx5() throws ParseException {
        int attempts = 20;
        Random random = new Random();
        ArrayList<Node> fullList = new ArrayList<Node>();
        ArrayList<Node> tempList;
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
    public void TestAllPeopleEndosedByPersonx1() throws ParseException {
        Driver driver = GraphDatabase.driver(
                "bolt://192.168.33.10:7687",
                AuthTokens.basic( "neo4j", "class" ) );
        Session session = driver.session();

        // Run a query matching all nodes
        /*
        StatementResult result = session.run(
                "MATCH (x:Person)-[:ENDORSES]->(" +
                        ")-[:ENDORSES]->(" +
                        ")-[:ENDORSES]->(" +
                        ")-[:ENDORSES]->(" +
                        ")-[:ENDORSES]->(other) " +
                        "WHERE ID(x)= {0} " +
                        "return DISTINCT ID(other), other.name, other.job, other.birthday");
                        */
        ArrayList<Node> people = new ArrayList<Node>();
        StatementResult result = session.run(
                "MATCH (x:Person)-[:ENDORSES]->(" +
                        "other) " +
                        "WHERE ID(x)= " + 100 + " " +
                        "return DISTINCT ID(other), other.name, other.job, other.birthday");

        while ( result.hasNext() ) {
            Record record = result.next();
            int node_id = record.get("ID(other)").asInt();
            //System.out.println(record.get("ID(other)").asInt());

            String name = record.get("other.name").asString();
            //System.out.println(record.get("other.name").asString());

            String job = record.get("other.job").asString();
            //System.out.println(record.get("other.job").asString());

            String temp = record.get("other.birthday").asString();
            Date birthday = new SimpleDateFormat("yyyy-mm-dd").parse(temp);
            //System.out.println(record.get("other.birthday").asString());

            people.add(new Node(node_id,name,job,birthday));
            //System.out.println(people.get(0).node_id + " " + people.get(0).name + " " + people.get(0).job + " " + people.get(0).birthday);
        }
        for (int i = 0; i < people.size(); i++) {
            System.out.println(people.get(i).node_id + " " + people.get(i).name + " " + people.get(i).job + " " + people.get(i).birthday);
        }
        System.out.println(people.size());

        session.close();
        driver.close();
    }

    public ArrayList<Node> AllPeopleEndosedByPersonx1(int personid) throws ParseException {
        Driver driver = GraphDatabase.driver(
                "bolt://192.168.33.10:7687",
                AuthTokens.basic( "neo4j", "class" ) );
        Session session = driver.session();

        // Run a query matching all nodes
        /*
        StatementResult result = session.run(
                "MATCH (x:Person)-[:ENDORSES]->(" +
                        ")-[:ENDORSES]->(" +
                        ")-[:ENDORSES]->(" +
                        ")-[:ENDORSES]->(" +
                        ")-[:ENDORSES]->(other) " +
                        "WHERE ID(x)= {0} " +
                        "return DISTINCT ID(other), other.name, other.job, other.birthday");
                        */
        ArrayList<Node> people = new ArrayList<Node>();
        StatementResult result = session.run(
                "MATCH (x:Person)-[:ENDORSES]->(" +
                        "other) " +
                        "WHERE ID(x)= " + personid + " " +
                        "return DISTINCT ID(other), other.name, other.job, other.birthday");

        while ( result.hasNext() ) {
            Record record = result.next();
            int node_id = record.get("ID(other)").asInt();
            //System.out.println(record.get("ID(other)").asInt());

            String name = record.get("other.name").asString();
            //System.out.println(record.get("other.name").asString());

            String job = record.get("other.job").asString();
            //System.out.println(record.get("other.job").asString());

            String temp = record.get("other.birthday").asString();
            Date birthday = new SimpleDateFormat("yyyy-mm-dd").parse(temp);
            //System.out.println(record.get("other.birthday").asString());

            people.add(new Node(node_id,name,job,birthday));
            //System.out.println(people.get(0).node_id + " " + people.get(0).name + " " + people.get(0).job + " " + people.get(0).birthday);
        }
        /*
        for (int i = 0; i < people.size(); i++) {
            System.out.println(people.get(i).node_id + " " + people.get(i).name + " " + people.get(i).job + " " + people.get(i).birthday);
        }

        System.out.println(people.size());
        */

        session.close();
        driver.close();
        return people;
    }

    @Test
    public void TestAllPeopleEndosedByPersonx2() throws ParseException {
        Driver driver = GraphDatabase.driver(
                "bolt://192.168.33.10:7687",
                AuthTokens.basic( "neo4j", "class" ) );
        Session session = driver.session();

        // Run a query matching all nodes
        /*
        StatementResult result = session.run(
                "MATCH (x:Person)-[:ENDORSES]->(" +
                        ")-[:ENDORSES]->(" +
                        ")-[:ENDORSES]->(" +
                        ")-[:ENDORSES]->(" +
                        ")-[:ENDORSES]->(other) " +
                        "WHERE ID(x)= {0} " +
                        "return DISTINCT ID(other), other.name, other.job, other.birthday");
                        */
        ArrayList<Node> people = new ArrayList<Node>();
        StatementResult result = session.run(
                "MATCH (x:Person)-[:ENDORSES]->(" +
                        ")-[:ENDORSES]->(other) " +
                        "WHERE ID(x)= " + 100 + " " +
                        "return DISTINCT ID(other), other.name, other.job, other.birthday");

        while ( result.hasNext() ) {
            Record record = result.next();
            int node_id = record.get("ID(other)").asInt();
            //System.out.println(record.get("ID(other)").asInt());

            String name = record.get("other.name").asString();
            //System.out.println(record.get("other.name").asString());

            String job = record.get("other.job").asString();
            //System.out.println(record.get("other.job").asString());

            String temp = record.get("other.birthday").asString();
            Date birthday = new SimpleDateFormat("yyyy-mm-dd").parse(temp);
            //System.out.println(record.get("other.birthday").asString());

            people.add(new Node(node_id,name,job,birthday));
            //System.out.println(people.get(0).node_id + " " + people.get(0).name + " " + people.get(0).job + " " + people.get(0).birthday);
        }
        for (int i = 0; i < people.size(); i++) {
            System.out.println(people.get(i).node_id + " " + people.get(i).name + " " + people.get(i).job + " " + people.get(i).birthday);
        }
        System.out.println(people.size());

        session.close();
        driver.close();
    }

    public ArrayList<Node> AllPeopleEndosedByPersonx2(int personid) throws ParseException {
        Driver driver = GraphDatabase.driver(
                "bolt://192.168.33.10:7687",
                AuthTokens.basic( "neo4j", "class" ) );
        Session session = driver.session();

        // Run a query matching all nodes
        /*
        StatementResult result = session.run(
                "MATCH (x:Person)-[:ENDORSES]->(" +
                        ")-[:ENDORSES]->(" +
                        ")-[:ENDORSES]->(" +
                        ")-[:ENDORSES]->(" +
                        ")-[:ENDORSES]->(other) " +
                        "WHERE ID(x)= {0} " +
                        "return DISTINCT ID(other), other.name, other.job, other.birthday");
                        */
        ArrayList<Node> people = new ArrayList<Node>();
        StatementResult result = session.run(
                "MATCH (x:Person)-[:ENDORSES]->(" +
                        ")-[:ENDORSES]->(other) " +
                        "WHERE ID(x)= " + personid + " " +
                        "return DISTINCT ID(other), other.name, other.job, other.birthday");

        while ( result.hasNext() ) {
            Record record = result.next();
            int node_id = record.get("ID(other)").asInt();
            //System.out.println(record.get("ID(other)").asInt());

            String name = record.get("other.name").asString();
            //System.out.println(record.get("other.name").asString());

            String job = record.get("other.job").asString();
            //System.out.println(record.get("other.job").asString());

            String temp = record.get("other.birthday").asString();
            Date birthday = new SimpleDateFormat("yyyy-mm-dd").parse(temp);
            //System.out.println(record.get("other.birthday").asString());

            people.add(new Node(node_id,name,job,birthday));
            //System.out.println(people.get(0).node_id + " " + people.get(0).name + " " + people.get(0).job + " " + people.get(0).birthday);
        }
        /*
        for (int i = 0; i < people.size(); i++) {
            System.out.println(people.get(i).node_id + " " + people.get(i).name + " " + people.get(i).job + " " + people.get(i).birthday);
        }

        System.out.println(people.size());
        */
        session.close();
        driver.close();
        return people;
    }

    @Test
    public void TestAllPeopleEndosedByPersonx3() throws ParseException {
        Driver driver = GraphDatabase.driver(
                "bolt://192.168.33.10:7687",
                AuthTokens.basic( "neo4j", "class" ) );
        Session session = driver.session();

        // Run a query matching all nodes
        /*
        StatementResult result = session.run(
                "MATCH (x:Person)-[:ENDORSES]->(" +
                        ")-[:ENDORSES]->(" +
                        ")-[:ENDORSES]->(" +
                        ")-[:ENDORSES]->(" +
                        ")-[:ENDORSES]->(other) " +
                        "WHERE ID(x)= {0} " +
                        "return DISTINCT ID(other), other.name, other.job, other.birthday");
                        */
        ArrayList<Node> people = new ArrayList<Node>();
        StatementResult result = session.run(
                "MATCH (x:Person)-[:ENDORSES]->(" +
                        ")-[:ENDORSES]->(" +
                        ")-[:ENDORSES]->(other) " +
                        "WHERE ID(x)= " + 100 + " " +
                        "return DISTINCT ID(other), other.name, other.job, other.birthday");

        while ( result.hasNext() ) {
            Record record = result.next();
            int node_id = record.get("ID(other)").asInt();
            //System.out.println(record.get("ID(other)").asInt());

            String name = record.get("other.name").asString();
            //System.out.println(record.get("other.name").asString());

            String job = record.get("other.job").asString();
            //System.out.println(record.get("other.job").asString());

            String temp = record.get("other.birthday").asString();
            Date birthday = new SimpleDateFormat("yyyy-mm-dd").parse(temp);
            //System.out.println(record.get("other.birthday").asString());

            people.add(new Node(node_id,name,job,birthday));
            //System.out.println(people.get(0).node_id + " " + people.get(0).name + " " + people.get(0).job + " " + people.get(0).birthday);
        }
        for (int i = 0; i < people.size(); i++) {
            System.out.println(people.get(i).node_id + " " + people.get(i).name + " " + people.get(i).job + " " + people.get(i).birthday);
        }
        System.out.println(people.size());

        session.close();
        driver.close();
    }

    public ArrayList<Node> AllPeopleEndosedByPersonx3(int personid) throws ParseException {
        Driver driver = GraphDatabase.driver(
                "bolt://192.168.33.10:7687",
                AuthTokens.basic( "neo4j", "class" ) );
        Session session = driver.session();

        // Run a query matching all nodes
        /*
        StatementResult result = session.run(
                "MATCH (x:Person)-[:ENDORSES]->(" +
                        ")-[:ENDORSES]->(" +
                        ")-[:ENDORSES]->(" +
                        ")-[:ENDORSES]->(" +
                        ")-[:ENDORSES]->(other) " +
                        "WHERE ID(x)= {0} " +
                        "return DISTINCT ID(other), other.name, other.job, other.birthday");
                        */
        ArrayList<Node> people = new ArrayList<Node>();
        StatementResult result = session.run(
                "MATCH (x:Person)-[:ENDORSES]->(" +
                        ")-[:ENDORSES]->(" +
                        ")-[:ENDORSES]->(other) " +
                        "WHERE ID(x)= " + personid + " " +
                        "return DISTINCT ID(other), other.name, other.job, other.birthday");

        while ( result.hasNext() ) {
            Record record = result.next();
            int node_id = record.get("ID(other)").asInt();
            //System.out.println(record.get("ID(other)").asInt());

            String name = record.get("other.name").asString();
            //System.out.println(record.get("other.name").asString());

            String job = record.get("other.job").asString();
            //System.out.println(record.get("other.job").asString());

            String temp = record.get("other.birthday").asString();
            Date birthday = new SimpleDateFormat("yyyy-mm-dd").parse(temp);
            //System.out.println(record.get("other.birthday").asString());

            people.add(new Node(node_id,name,job,birthday));
            //System.out.println(people.get(0).node_id + " " + people.get(0).name + " " + people.get(0).job + " " + people.get(0).birthday);
        }
        /*
        for (int i = 0; i < people.size(); i++) {
            System.out.println(people.get(i).node_id + " " + people.get(i).name + " " + people.get(i).job + " " + people.get(i).birthday);
        }

        System.out.println(people.size());
        */
        session.close();
        driver.close();
        return people;
    }

    @Test
    public void TestAllPeopleEndosedByPersonx4() throws ParseException {
        Driver driver = GraphDatabase.driver(
                "bolt://192.168.33.10:7687",
                AuthTokens.basic( "neo4j", "class" ) );
        Session session = driver.session();

        // Run a query matching all nodes
        /*
        StatementResult result = session.run(
                "MATCH (x:Person)-[:ENDORSES]->(" +
                        ")-[:ENDORSES]->(" +
                        ")-[:ENDORSES]->(" +
                        ")-[:ENDORSES]->(" +
                        ")-[:ENDORSES]->(other) " +
                        "WHERE ID(x)= {0} " +
                        "return DISTINCT ID(other), other.name, other.job, other.birthday");
                        */
        ArrayList<Node> people = new ArrayList<Node>();
        StatementResult result = session.run(
                "MATCH (x:Person)-[:ENDORSES]->(" +
                        ")-[:ENDORSES]->(" +
                        ")-[:ENDORSES]->(" +
                        ")-[:ENDORSES]->(other) " +
                        "WHERE ID(x)= " + 100 + " " +
                        "return DISTINCT ID(other), other.name, other.job, other.birthday");

        while ( result.hasNext() ) {
            Record record = result.next();
            int node_id = record.get("ID(other)").asInt();
            //System.out.println(record.get("ID(other)").asInt());

            String name = record.get("other.name").asString();
            //System.out.println(record.get("other.name").asString());

            String job = record.get("other.job").asString();
            //System.out.println(record.get("other.job").asString());

            String temp = record.get("other.birthday").asString();
            Date birthday = new SimpleDateFormat("yyyy-mm-dd").parse(temp);
            //System.out.println(record.get("other.birthday").asString());

            people.add(new Node(node_id,name,job,birthday));
            //System.out.println(people.get(0).node_id + " " + people.get(0).name + " " + people.get(0).job + " " + people.get(0).birthday);
        }
        for (int i = 0; i < people.size(); i++) {
            System.out.println(people.get(i).node_id + " " + people.get(i).name + " " + people.get(i).job + " " + people.get(i).birthday);
        }
        System.out.println(people.size());

        session.close();
        driver.close();
    }

    public ArrayList<Node> AllPeopleEndosedByPersonx4(int personid) throws ParseException {
        Driver driver = GraphDatabase.driver(
                "bolt://192.168.33.10:7687",
                AuthTokens.basic( "neo4j", "class" ) );
        Session session = driver.session();

        // Run a query matching all nodes
        /*
        StatementResult result = session.run(
                "MATCH (x:Person)-[:ENDORSES]->(" +
                        ")-[:ENDORSES]->(" +
                        ")-[:ENDORSES]->(" +
                        ")-[:ENDORSES]->(" +
                        ")-[:ENDORSES]->(other) " +
                        "WHERE ID(x)= {0} " +
                        "return DISTINCT ID(other), other.name, other.job, other.birthday");
                        */
        ArrayList<Node> people = new ArrayList<Node>();
        StatementResult result = session.run(
                "MATCH (x:Person)-[:ENDORSES]->(" +
                        ")-[:ENDORSES]->(" +
                        ")-[:ENDORSES]->(" +
                        ")-[:ENDORSES]->(other) " +
                        "WHERE ID(x)= " + personid + " " +
                        "return DISTINCT ID(other), other.name, other.job, other.birthday");

        while ( result.hasNext() ) {
            Record record = result.next();
            int node_id = record.get("ID(other)").asInt();
            //System.out.println(record.get("ID(other)").asInt());

            String name = record.get("other.name").asString();
            //System.out.println(record.get("other.name").asString());

            String job = record.get("other.job").asString();
            //System.out.println(record.get("other.job").asString());

            String temp = record.get("other.birthday").asString();
            Date birthday = new SimpleDateFormat("yyyy-mm-dd").parse(temp);
            //System.out.println(record.get("other.birthday").asString());

            people.add(new Node(node_id,name,job,birthday));
            //System.out.println(people.get(0).node_id + " " + people.get(0).name + " " + people.get(0).job + " " + people.get(0).birthday);
        }
        /*
        for (int i = 0; i < people.size(); i++) {
            System.out.println(people.get(i).node_id + " " + people.get(i).name + " " + people.get(i).job + " " + people.get(i).birthday);
        }

        System.out.println(people.size());
        */

        session.close();
        driver.close();
        return people;
    }

    @Test
    public void TestAllPeopleEndosedByPersonx5() throws ParseException {
        Driver driver = GraphDatabase.driver(
                "bolt://192.168.33.10:7687",
                AuthTokens.basic( "neo4j", "class" ) );
        Session session = driver.session();

        // Run a query matching all nodes
        /*
        StatementResult result = session.run(
                "MATCH (x:Person)-[:ENDORSES]->(" +
                        ")-[:ENDORSES]->(" +
                        ")-[:ENDORSES]->(" +
                        ")-[:ENDORSES]->(" +
                        ")-[:ENDORSES]->(other) " +
                        "WHERE ID(x)= {0} " +
                        "return DISTINCT ID(other), other.name, other.job, other.birthday");
                        */
        ArrayList<Node> people = new ArrayList<Node>();
        StatementResult result = session.run(
                "MATCH (x:Person)-[:ENDORSES]->(" +
                        ")-[:ENDORSES]->(" +
                        ")-[:ENDORSES]->(" +
                        ")-[:ENDORSES]->(" +
                        ")-[:ENDORSES]->(other) " +
                        "WHERE ID(x)= " + 100 + " " +
                        "return DISTINCT ID(other), other.name, other.job, other.birthday");

        while ( result.hasNext() ) {
            Record record = result.next();
            int node_id = record.get("ID(other)").asInt();
            //System.out.println(record.get("ID(other)").asInt());

            String name = record.get("other.name").asString();
            //System.out.println(record.get("other.name").asString());

            String job = record.get("other.job").asString();
            //System.out.println(record.get("other.job").asString());

            String temp = record.get("other.birthday").asString();
            Date birthday = new SimpleDateFormat("yyyy-mm-dd").parse(temp);
            //System.out.println(record.get("other.birthday").asString());

            people.add(new Node(node_id,name,job,birthday));
            //System.out.println(people.get(0).node_id + " " + people.get(0).name + " " + people.get(0).job + " " + people.get(0).birthday);
        }
        for (int i = 0; i < people.size(); i++) {
            System.out.println(people.get(i).node_id + " " + people.get(i).name + " " + people.get(i).job + " " + people.get(i).birthday);
        }
        System.out.println(people.size());

        session.close();
        driver.close();
    }

    public ArrayList<Node> AllPeopleEndosedByPersonx5(int personid) throws ParseException {
        Driver driver = GraphDatabase.driver(
                "bolt://192.168.33.10:7687",
                AuthTokens.basic( "neo4j", "class" ) );
        Session session = driver.session();

        // Run a query matching all nodes
        /*
        StatementResult result = session.run(
                "MATCH (x:Person)-[:ENDORSES]->(" +
                        ")-[:ENDORSES]->(" +
                        ")-[:ENDORSES]->(" +
                        ")-[:ENDORSES]->(" +
                        ")-[:ENDORSES]->(other) " +
                        "WHERE ID(x)= {0} " +
                        "return DISTINCT ID(other), other.name, other.job, other.birthday");
                        */
        ArrayList<Node> people = new ArrayList<Node>();
        StatementResult result = session.run(
                "MATCH (x:Person)-[:ENDORSES]->(" +
                        ")-[:ENDORSES]->(" +
                        ")-[:ENDORSES]->(" +
                        ")-[:ENDORSES]->(" +
                        ")-[:ENDORSES]->(other) " +
                        "WHERE ID(x)= " + personid + " " +
                        "return DISTINCT ID(other), other.name, other.job, other.birthday");

        while ( result.hasNext() ) {
            Record record = result.next();
            int node_id = record.get("ID(other)").asInt();
            //System.out.println(record.get("ID(other)").asInt());

            String name = record.get("other.name").asString();
            //System.out.println(record.get("other.name").asString());

            String job = record.get("other.job").asString();
            //System.out.println(record.get("other.job").asString());

            String temp = record.get("other.birthday").asString();
            Date birthday = new SimpleDateFormat("yyyy-mm-dd").parse(temp);
            //System.out.println(record.get("other.birthday").asString());

            people.add(new Node(node_id,name,job,birthday));
            //System.out.println(people.get(0).node_id + " " + people.get(0).name + " " + people.get(0).job + " " + people.get(0).birthday);
        }
        /*
        for (int i = 0; i < people.size(); i++) {
            System.out.println(people.get(i).node_id + " " + people.get(i).name + " " + people.get(i).job + " " + people.get(i).birthday);
        }

        System.out.println(people.size());
        */

        session.close();
        driver.close();
        return people;
    }
}