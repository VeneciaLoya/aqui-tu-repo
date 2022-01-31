package conexiondb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class conexion {
    
    private Connection connection;
    private Statement statmen;
    

    public conexion(String url, String user, String passWord){

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, passWord);

        } catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch(SQLException e) {
            e.printStackTrace();

        }
    }

    public void ejecutar (String sql ) throws SQLException{
        connection.createStatement().execute(sql);
    } 

    public ResultSet query(String sqlQuery) throws SQLException{
        Statement statmen = connection.createStatement();
        return statmen.executeQuery(sqlQuery);
    }
}
