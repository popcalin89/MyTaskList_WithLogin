import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by caly on 7/17/2016.
 */
public class AccesDB {

    public static int isUserInDB(String username, String password) throws ClassNotFoundException, SQLException {
        // 1. load driver
        Class.forName("org.postgresql.Driver");
        int userid = -1;

        // 2. define connection params to db
        final String URL = "jdbc:postgresql://54.93.65.5:5432/4_Calin";
        final String USERNAME = "fasttrackit_dev";
        final String PASSWORD = "fasttrackit_dev";

        // 3. obtain a connection
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // 4. create a query statement
        Statement st = conn.createStatement();

        // 5. execute a query
        ResultSet rs = st.executeQuery("SELECT * FROM login where username='" + username + "' and password='" + password + "'");

        // 6. iterate the result set and print the values

        while (rs.next()) {
            userid = rs.getInt("id");
        }

        // 7. close the objects
        rs.close();
        st.close();
        conn.close();

        return userid;
    }


    public static List readTasks(Integer iduser) throws ClassNotFoundException, SQLException {


        // 1. load driver
        Class.forName("org.postgresql.Driver");

        // 2. define connection params to db
        final String URL = "jdbc:postgresql://54.93.65.5:5432/4_Calin";
        final String USERNAME = "fasttrackit_dev";
        final String PASSWORD = "fasttrackit_dev";

        // 3. obtain a connection
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // 4. create a query statement
        Statement st = conn.createStatement();

        // 5. execute a query
        ResultSet rs = st.executeQuery("SELECT id,task FROM tasklist where iduser='" + iduser + "'");

        // 6. iterate the result set and print the values

        List<TaskBean> listOfTasks = new ArrayList();
        while (rs.next()) {

            // creez un bean de tipul tweetbean , adica un rand din db
            TaskBean task = new TaskBean();

            task.setTask(rs.getString("task").trim());
            task.setId(rs.getLong("id"));


            //scriu obiectul(randul) in lista
            listOfTasks.add(task);

        }

        System.out.println("dimensiunea listei:" + listOfTasks.size());
        // 7. close the objects
        rs.close();
        st.close();
        conn.close();

        return listOfTasks;
    }

    public static void addTask(String textToTask, Integer iduser) throws ClassNotFoundException, SQLException {
        // 1. load driver
        Class.forName("org.postgresql.Driver");

        // 2. define connection params to db
        final String URL = "jdbc:postgresql://54.93.65.5:5432/4_Calin";
        final String USERNAME = "fasttrackit_dev";
        final String PASSWORD = "fasttrackit_dev";

        // 3. obtain a connection
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // 4. create a query statement
        PreparedStatement pSt = conn.prepareStatement("INSERT INTO tasklist (iduser,task) VALUES (?,?)");
        pSt.setInt(1, iduser);
        pSt.setString(2, textToTask);
        System.out.println("adus cu succes");

        // 5. execute a prepared statement
        int rowsInserted = pSt.executeUpdate();

        // 6. close the objects
        pSt.close();
        conn.close();
    }


    public static void removeTask(Integer id) throws ClassNotFoundException, SQLException {
        // 1. load driver
        Class.forName("org.postgresql.Driver");

        // 2. define connection params to db
        final String URL = "jdbc:postgresql://54.93.65.5:5432/4_Calin";
        final String USERNAME = "fasttrackit_dev";
        final String PASSWORD = "fasttrackit_dev";

        // 3. obtain a connection
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // 4. create a query statement
        PreparedStatement pSt = conn.prepareStatement("DELETE FROM tasklist WHERE id=?");
        pSt.setInt(1, id);

        // 5. execute a prepared statement
        int rowsDeleted = pSt.executeUpdate();
        if(rowsDeleted!=0)
            System.out.println("Deleting row...");
        else if (rowsDeleted==0)
        {
            System.out.println("Row has been deleted successfully.");
        }


        // 6. close the objects
        pSt.close();
        conn.close();
    }
}