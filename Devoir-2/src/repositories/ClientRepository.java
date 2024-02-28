package repositories;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Client;

public class ClientRepository extends Database {
      private final  String SQL_SELECT_ALL="select * from client" ;
      private final  String SQL_SELECT_BY_TEL="Select * from client where telephone_client like ? " ;
      private final String SQL_INSERT="INSERT INTO `client` (`id`,`nomComplet`,`telephone`,`email`) VALUES (?,?,?,?)";
      public List<Client> selectAll(){
         List<Client> clients=new ArrayList<>();
          try {
            openConnexion();
            initPreparedStatement(SQL_SELECT_ALL);
            ResultSet rs= executeSelect();
            while (rs.next()) {
               //Une ligne ==> rs de la requete
                Client client=new Client();
                client.setId(rs.getInt("id_client"));
                client.setNomComplet(rs.getString("nom_client"));
                client.setTelephone(rs.getString("telephone_client"));
                client.setEmail(rs.getString("email_client"));
                clients.add(client);

           }
           rs.close();
           closeConnexion();
        }
       catch (SQLException e) {
        System.out.println("Erreur de Connexion a la BD");
      }
       return  clients;
       }
       public Client selectClientByTel(String tel){
        Client client=null;
        try {
            openConnexion();
            initPreparedStatement(SQL_SELECT_BY_TEL);
            statement.setString(1, tel);
            ResultSet rs= executeSelect();
            if (rs.next()) {
               //Une ligne ==> rs de la requete
                client=new Client();
                client.setId(rs.getInt("id_client"));
                client.setNomComplet(rs.getString("nom_client"));
                client.setTelephone(rs.getString("telephone_client"));
                client.setEmail(rs.getString("email_client"));
            }
            statement.close();
            rs.close();
            conn.close();
       } 
       catch (SQLException e) {
         System.out.println("Erreur de Connexion a la BD");
       }
           return client;
      }
       public  void insert(Client client){
        openConnexion();
        try {
            initPreparedStatement(SQL_INSERT);
            statement.setInt(1, client.getId());
            statement.setString(2, client.getNomComplet());
            statement.setString(3, client.getTelephone());
            statement.setString(4, client.getEmail());
            int nbreLigne=executeUpdate();
           closeConnexion();
         } catch (SQLException e) {
          e.printStackTrace();
         }
      }
    }


