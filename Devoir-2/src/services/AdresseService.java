package services;
import java.util.List;
import entities.Adresse;
import repositories.AdresseRepository;

public class AdresseService {
          
        //Dependances
        AdresseRepository adresseRepository=new AdresseRepository();
        public void ajouterAdresse(Adresse adresse){
            adresseRepository.insert(adresse);
        }
    
        public List<Adresse> listerAdresse(){
            return adresseRepository.selectAll();
        }
    }
     

