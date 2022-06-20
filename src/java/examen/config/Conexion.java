package examen.config;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
     private static final String URL="jdbc:mysql://b94v82g5ze512qzjlfrp-mysql.services.clever-cloud.com:3306/b94v82g5ze512qzjlfrp";
    private static final String USER = "ueybozrashkumgrb";
    private static final String PASS = "VaEP32e9sRCOxzrayKGX";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static Connection cx = null;
    public static Connection getConexion(){
        try {
            Class.forName(DRIVER);
            if(cx==null){
                cx = DriverManager.getConnection(URL, USER, PASS);
                
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    return cx;
    }
}
