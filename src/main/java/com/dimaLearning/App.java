package com.dimaLearning;

import org.postgresql.Driver;

import java.sql.*;
import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String url = "jdbc:postgresql://localhost:5432/JdbcTest";
        String user = "postgres";
        String password = "0000";
        String readQuery = "select * from students";
        String writeQuery = "insert into students values(5, 'sava', 'sava@sava')";
        String updateQuery = "update students set name = 'Jason' where id = 5";
        String deleteQuery = "delete from students where id = 5";
        String prStatement = "insert into students values(?, ?, ?)";
        String deletePr = "delete from students where id=?";
        String updatePr = "update students set name = 'Sadiya' where id =?";
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to PostgreSQL database");
            /* This is all with statements */
           // Statement stmt = conn.createStatement();
            //This is for reading data from db
//            ResultSet set =  stmt.executeQuery(readQuery);
//
//            while (set.next()) {
//                System.out.println(set.getInt(1) + " - " + set.getString(2) + " - " + set.getString(3));
//            }

            // Other operations(update, create, delete works here)
            //stmt.execute(deleteQuery);

            /* Now PreparedStatements*/
            PreparedStatement ps = conn.prepareStatement(updatePr);
            ps.setInt(1, 4);
            //ps.setString(2, "Sad");
//            ps.setString(3, "Sadiya@gmail.com");

            ps.execute();
            conn.close();
        }
        catch (SQLException e){
            System.out.println("Sql excemption " + e);
        }

    }

}
