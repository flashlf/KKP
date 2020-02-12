package koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class konek {  
private Connection koneksi;     
      
    public Connection connect(){
    if(koneksi==null){  
        try{
            Class.forName ("com.mysql.jdbc.Driver");
            System.out.println("Berhasil Koneksi");
      
        }catch (ClassNotFoundException ex) {
            System.out.println("Gagal Koneksi "+ex);
        } 
        String url = "jdbc:mysql://localhost/trw";
        try{
            koneksi = DriverManager.getConnection(url,"root",""); 
            System.out.println("Berhasil Koneksi Database");
        } catch (SQLException ex){
            System.out.println("Gagal Koneksi Database"+ex);
        }
    }
    return koneksi;
    }    
}