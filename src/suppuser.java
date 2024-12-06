import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;


public class suppuser{
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/demo";
        String username = "postgres";
        String password = "thebigboss"; 
Scanner scann= new Scanner(System.in);
System.out.println("Enter your id");
int id=scann.nextInt();
        String query = "delete FROM users where id_user=?";
     
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
          PreparedStatement st=conn.prepareStatement(query);
            st.setInt(1, id);
            st.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
        }
        scann.close();
    }
}