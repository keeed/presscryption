/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presscryption.medicinemanagement.data.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kedren Villena
 */
public class SQLiteConnector {
    
    public static Connection connect(String connectionString) {
        Connection connection = null;
        
        try {
            Class.forName("org.sqlite.JDBC");

            connection = DriverManager.getConnection(connectionString);
            
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(SQLiteConnector.class.getName()).log(Level.SEVERE, null, ex);
        }

        return connection;
    }
    
    public static boolean Connect(String connectionString) {
        Connection connection = null;
        boolean connectionSuccessful = false;
        
        try {
            Class.forName("org.sqlite.JDBC");
            
            connection = DriverManager.getConnection(connectionString);        
            
            if (connection != null) {
                connectionSuccessful = true;
            }
            
            connection.close();
        } catch (SQLException | ClassNotFoundException ex) { 
            Logger.getLogger(SQLiteConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return connectionSuccessful;
    } 
}
