
    import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Create {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/demo";
        String username = "postgres";
        String password = "thebigboss";

        String users = "CREATE TABLE users (" +
                "id_user SERIAL PRIMARY KEY," +
                "nom VARCHAR(50)," +
                "prenom VARCHAR(50)," +
                "type VARCHAR(20)" +
                ");";

        String events ="create table events("+
"id_event SERIAL PRIMARY KEY,"+
"nom_event VARCHAR(20),"+
"date_event DATE NOT NULL,"+
"description VARCHAR(20),"+
"id_user int,"+
"FOREIGN KEY (id_user) references users(id_user)"+
");";

    

        String salle ="create table salle(\r\n" + 
                                        "id_salle SERIAL PRIMARY KEY,\r\n" + 
                                        "nom_salle varchar(20),\r\n" +
                                        "capacite varchar(20)\r\n" +
                                        ");";

         String terrain="create table terrains(\r\n" +
                        "id_terrain SERIAL PRIMARY KEY,\r\n" +
                        "nom_terrain varchar(20),\r\n" +
                        "type varchar(20)\r\n" +
                        ");";
           String reservation="create table reservation\r\n" +
                              "(\r\n" +
                              "id_reservation SERIAL PRIMARY KEY,\r\n" +
                              "id_user INT NOT NULL,\r\n" +
                              "id_event INT NOT NULL,\r\n" +
                              "id_salle INT NOT NULL,\r\n" +
                              "id_terrain INT NOT NULL, \r\n" +
                              "FOREIGN KEY (id_user) REFERENCES  users(id_user),\r\n" +
                              "FOREIGN KEY (id_event) REFERENCES  events(id_event),\r\n" +
                              "FOREIGN KEY (id_salle) REFERENCES  salle(id_salle),\r\n" + 
                              "FOREIGN KEY (id_terrain) REFERENCES  terrains(id_terrain)\r\n" + 
                              ");\r\n" ; 
                                          
        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement()) {

      stmt.execute(users);
        stmt.execute(events);
        stmt.execute(terrain);
            stmt.execute(salle);
            stmt.execute(reservation);

            System.out.println("Tables created successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

