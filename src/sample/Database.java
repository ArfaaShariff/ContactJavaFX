package sample;

/**
 * Created by ASUS on 21-Aug-15.
 */
import java.sql.Connection ;
import java.sql.DriverManager ;
import java.sql.SQLException ;
import java.sql.Statement ;
import java.sql.ResultSet ;

import java.util.List ;
import java.util.ArrayList ;

public class Database {

    // in real life, use a connection pool....
    private Connection connection ;

    public Database(String driverClassName, String dbURL, String user, String password) throws SQLException, ClassNotFoundException {
        Class.forName(driverClassName);
        connection = DriverManager.getConnection(dbURL, user, password);
    }

    public void shutdown() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    public List<Product> getPersonList() throws SQLException {
        try (
                Statement stmnt = connection.createStatement();
                ResultSet rs = stmnt.executeQuery("select * from person")
        ){
            List<Product> personList = new ArrayList<>();
            while (rs.next()) {
                String name = rs.getString("name");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                Product person = new Product(name, phone, email);
                personList.add(person);
            }
            return personList ;
        }
    }

    // other methods, eg. addPerson(...) etc
}