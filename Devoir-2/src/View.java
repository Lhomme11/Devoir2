import java.util.List;
import java.util.Scanner;

import entities.Adresse;
import entities.Client;
import services.ClientService;

public class View {
    public static void main(String[] args) throws Exception {
       int choix;
        Scanner sc=new Scanner(System.in);
        String nomClient=sc.nextLine();  
        String telephone=sc.nextLine();
        String email=sc.nextLine();
        Adresse adresseService=new Adresse();
       ClientService clientService =new ClientService();
        do {
            System.out.println("1-Créer un client");
            System.out.println("2-Lister les clients"); 
            System.out.println("3-Ajouter  un  adresse et lui associer un client");
            System.out.println("4-Lister les adresse en affichant le nom du client"); 
            System.out.println("5-Quitter"); 
             choix=sc.nextInt();
             sc.nextLine();
            switch (choix) {
                case 1:
                System.out.println("Entrer le nom complet du client");
                nomClient=sc.nextLine();  
                System.out.println("Entrer le telephone du client");
                telephone=sc.nextLine();
                System.out.println("Entrer l'email du client");
                email=sc.nextLine();
                Client cl=new Client();
                 cl.setNomComplet(nomClient);
                 cl.setTelephone(telephone);
                 cl.setEmail(email);
                clientService.ajouterClient(cl);
               break;
                case 2:
                List<Client> client=  clientService.listerClient();
                for (Client client1: client) {
                     System.out.println("Nom "+ client1.getNomComplet());
                     System.out.println("Telephone "+ client1.getTelephone());
                     System.out.println("Email "+ client1.getEmail());
                     System.out.println("=================================");
                }
                    break;
                case 3:
                System.out.println("Entrer le nom de la ville");
                String ville=sc.nextLine();
                System.out.println("Entrer le nom du quartier");
                String quartier=sc.nextLine();
                System.out.println("Entrer le numéro de la villa");
                String numVilla=sc.nextLine();
                System.out.println("Entrer le Telephone du client");
                      telephone=sc.nextLine(); 
                      //Rechercher un client a travers son tel(Use Case)
                        client = clientService.rechercherClientParTel(telephone);
                         if (client==null) {
                            System.out.println("Entrer le nom complet du client");
                            nomClient=sc.nextLine();  
                            System.out.println("Entrer le telephone du client");
                            telephone=sc.nextLine();
                            System.out.println("Entrer l'email du client");
                            email=sc.nextLine();
                            cl.setNomComplet(nomClient);
                            cl.setTelephone(telephone);
                            cl.setEmail(email);
                            clientService.ajouterClient(cl);
                          }
                          Adresse adresse=new Adresse();
                          adresse.setVille(ville);
                          adresse.setQuartier(quartier);
                          adresse.setNumVilla(numVilla);
                          adresse.setClient(cl);
                          adresseService.ajouterAdresse(adresse);

                    break;
                case 4:
                    
                    break;
                
                default:
                    break;
            }
        }while (choix!=5);
    }
}
