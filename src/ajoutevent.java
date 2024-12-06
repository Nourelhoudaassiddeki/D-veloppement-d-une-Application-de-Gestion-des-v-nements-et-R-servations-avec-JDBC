import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.sql.Date;
public class ajoutevent{
public static void main(String[] args) {
    
    String url = "jdbc:postgresql://localhost:5432/demo";
    String username = "postgres";
    String password = "thebigboss"; 

    try (
        Connection conn = DriverManager.getConnection(url, username, password);
        Scanner scanner = new Scanner(System.in)
    ) {
       
        System.out.println("Enter your event:");
        String eventname = scanner.nextLine();

        System.out.println("Enter date event:");
        String dateevent= scanner.nextLine();

        System.out.println("enter description?");
        String description = scanner.nextLine();
        System.out.println("utilisateur que tu veux souhaite donner l'evenement");
        int id= scanner.nextInt();
        Date event = Date.valueOf(dateevent);
     
        String sql = "INSERT INTO events (nom_event,date_event,description,id_user) VALUES (?, ?, ?,?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, eventname);
            pstmt.setDate(2, event);
            pstmt.setString(3, description);
            pstmt.setInt(4, id);
            // Execute the query
            int rowsInserted = pstmt.executeUpdate();
            System.out.println(rowsInserted + " row(s) inserted successfully!");
        }
      
    } catch (Exception e) {
        e.printStackTrace();
    }
}
}

