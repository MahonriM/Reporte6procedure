package reporte6;
import java.sql.*;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.Scanner;
/* @author Mahonri Mtz*/
public class Reporte6 {
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        String srt="jdbc:sqlserver://localhost;databaseName=Test;integratedSecurity=true;";
        int idMunicipio;
        System.out.print("Ingresa el id del municipio");
        idMunicipio=sc.nextInt();
        try{
        Connection con= DriverManager.getConnection(srt);
        CallableStatement stm;
        stm=con.prepareCall("{call spreporte6(?)}");
        stm.setInt(1, idMunicipio);
        ResultSet mostrar;
        mostrar=stm.executeQuery();
        while(mostrar.next()){
           System.out.println("Cantida de camiones"+" "+mostrar.getString("camiones")+" "
                   +"Cantidad de chofer "+" "+mostrar.getString("chofer"));
        }
        }
        catch(Exception ex){
            System.out.println("No conetado");
            System.out.println("Eres el mejor programador del mundo");
        }
        
    }
    
}
