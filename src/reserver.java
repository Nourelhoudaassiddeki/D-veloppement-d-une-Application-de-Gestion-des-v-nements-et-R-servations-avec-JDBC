
    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import java.util.Scanner;
    import java.sql.Date;

    public class reserver {
            public static void main(String[] args) {
  
        String url = "jdbc:postgresql://localhost:5432/demo";
        String username = "postgres";
        String password = "thebigboss"; 
        
        try (
            Connection conn = DriverManager.getConnection(url, username, password);
            Scanner scann= new Scanner(System.in);
        ) {

System.out.println("Enter id user");
int id_user=scann.nextInt();
System.out.println("Enter id salle");
int id_salle=scann.nextInt();
System.out.println("Enter id terrain");
int id_terrain=scann.nextInt();
scann.nextLine();
System.out.println("Enter date de reservation");
String date_reseravation=scann.nextLine();
System.out.println("Enter id event");
int id_event=scann.nextInt();

Date datereserve = Date.valueOf(date_reseravation);

    String rechercher = "SELECT COUNT(*) FROM reservation WHERE date_reservation = ? AND (id_salle = ? OR id_terrain = ?)";
        PreparedStatement checkStmt = conn.prepareStatement(rechercher);
        checkStmt.setDate(1,datereserve );
        checkStmt.setInt(2, id_salle);
        checkStmt.setInt(3, id_terrain);

        ResultSet rs = checkStmt.executeQuery();
        rs.next();
        if (rs.getInt(1) > 0) {
            System.out.println("La salle ou le terrain est déjà réservé pour cette date.");
            return;
        }
        String a = "INSERT INTO reservation (id_user, id_event, id_salle, id_terrain, date_reservation) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement insertStmt = conn.prepareStatement(a);
        insertStmt.setInt(1, id_user);
        insertStmt.setInt(2, id_event);
        insertStmt.setInt(3, id_salle);
        insertStmt.setInt(4, id_terrain);
        insertStmt.setDate(5, datereserve);

        int rowsInserted = insertStmt.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("Réservation effectuée avec succès !");
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}
}
