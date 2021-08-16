package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    Connection con;
    String url="jdbc:sqlserver://localhost:1433;databaseName=bd_lavanderia";
    String user="elmanantial";
    String pass="elmanantial123";
    
    public Connection Conexion(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");          
            con=DriverManager.getConnection(url,user,pass);        
        } 
        catch(ClassNotFoundException e){
            System.out.println(e);
        }
        catch(SQLException e){
            System.out.println(e);
        }
        catch(Exception e){
            System.out.println(e);
        }
        return con;        
    }
    
    public static Connection getConexion(){ 
Connection con = null;
 try { Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
String url ="jdbc:sqlserver://localhost:1433;databaseName=bd_lavanderia"; 
String usr = "elmanantial"; 
String psw = "elmanantial123"; 
con = DriverManager.getConnection(url,usr,psw); } 
catch (ClassNotFoundException ex) { System.out.println("No hay Driver!!"); } 
catch (SQLException ex) 
{ System.out.println("Error con la BD"); }
 return con; }
}
