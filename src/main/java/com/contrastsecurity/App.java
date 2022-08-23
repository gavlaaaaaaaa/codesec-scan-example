package com.contrastsecurity;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mysql.cj.jdbc.MysqlDataSource;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
		MysqlDataSource mysqlDS = null;
		mysqlDS = new MysqlDataSource();
        mysqlDS.setURL("jdbc:mysql://localhost:3306/test");
        mysqlDS.setUser("test");
        mysqlDS.setPassword("test");

        getUser(mysqlDS, "test123");
    }

    public static void getUser(DataSource dataSource, String userId){
        try(Connection connection = dataSource.getConnection(); Statement statement = connection.createStatement()){
            statement.execute("SELECT * FROM user WHERE id = " + userId);
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
}
