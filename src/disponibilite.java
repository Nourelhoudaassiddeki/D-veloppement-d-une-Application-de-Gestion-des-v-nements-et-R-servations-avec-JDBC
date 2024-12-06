import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import java.util.Scanner;
    import java.sql.Date;
public class disponibilite {

    public static void main(String[] args) {
      
        String url = "jdbc:postgresql://localhost:5432/demo";
        String username = "postgres";
        String password = "thebigboss"; 
        
        try (
            Connection conn = DriverManager.getConnection(url, username, password);
            Scanner scann= new Scanner(System.in);
        ) {

System.out.println("Enter id salle");
int id_salle=scann.nextInt();
System.out.println("Enter id terrain");
int id_terrain=scann.nextInt();
scann.nextLine();
System.out.println("Enter date de reservation");
String date_reseravation=scann.nextLine();
Date datereserve = Date.valueOf(date_reseravation);
String sql = "SELECT COUNT(*) FROM reservation " +"WHERE date_reservation = ? " +"AND (id_salle = ? OR id_terrain = ?)";

PreparedStatement stmt = conn.prepareStatement(sql);

stmt.setDate(1,datereserve);
stmt.setInt(2, id_salle);
stmt.setInt(3, id_terrain);
ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1); 
            if (count==0) {
                System.out.println("Salle ou terrain disponible pour la date : " + datereserve);
            } else {
                System.out.println("Salle ou terrain non disponible pour la date : " + datereserve);
            }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

