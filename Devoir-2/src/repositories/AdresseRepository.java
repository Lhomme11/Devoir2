package repositories;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Adresse;
import entities.Client;

public class AdresseRepository extends Database {
    private final  String SQL_SELECT_ALL="select * from adresse" ;
    private final  String SQL_INSERT="INSERT INTO `adresse` (`idAdresse`,`ville`,`quartier`,`numVilla`,`id`) VALUES (?,?,?,?,?)";

      public List<Adresse> selectAll(){
         List<Adresse> adresses=new ArrayList<>();
          try {
            openConnexion();
            initPreparedStatement(SQL_SELECT_ALL);
            ResultSet rs= executeSelect();
            while (rs.next()) {
                Client client=new Client();
                client.setId(rs.getInt("id_client"));
                client.setNomComplet(rs.getString("nomComplet"));
                client.setTelephone(rs.getString("telephone"));
                client.setEmail(rs.getString("email"));
                Adresse adresse=new Adresse();
                adresse.setId(rs.getInt("id_adresse"));
                adresse.setVille(rs.getString("ville"));
                adresse.setQuartier(rs.getString("quartir"));
                adresse.setNumVilla(rs.getString("numVilla"));
                adresses.add(adresse);

           }
           rs.close();
           closeConnexion();
        }
       catch (SQLException e) {
        System.out.println("Erreur de Connexion a la BD");
      }
       return  adresses;
      }
      public void insert(Adresse adresse){
        openConnexion();
        try {
            initPreparedStatement(SQL_INSERT);
             statement.setInt(1, adresse.getId());
             statement.setString(2, adresse.getVille());
             statement.setString(3, adresse.getQuartier());
             statement.setString(4, adresse.getNumVilla());
             statement.setInt(5, adresse.getClient().getId());

              int nbreLigne=statement.executeUpdate();
              closeConnexion();
            } catch (SQLException e) {
             e.printStackTrace();
            }
          
       }
    }


