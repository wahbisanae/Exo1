
package h1;
import ma.projet.entity.Produit;
import ma.projet.util.NewHibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;
import java.util.List;
import ma.projet.service.ProduitService;
import ma.projet.entity.Produit;
import ma.projet.util.NewHibernateUtil;

public class H1 {

   
    public static void main(String[] args) {
        // NewHibernateUtil.getSessionFactory().openSession();
         ProduitService pr = new ProduitService();
       
         pr.create(new Produit("Adidas","ref1",new Date(),125.5,"des1"));
         pr.create(new Produit("Puma","ref2",new Date(),300,"des2"));
         pr.create(new Produit("Nike","ref3",new Date(),125.5,"des3"));
         pr.create(new Produit("Fila","ref4",new Date(),125.5,"des4"));
         pr.create(new Produit("Reebok","ref5",new Date(),125.5,"des5"));
         
         for(Produit p : pr.findAll())
             System.out.println(p.getId()+", "+p.getMarque()+", "+p.getReference()+", "+p.getPrix()+", "+p.getDateAchat());
          Produit produit1 = pr.findById(2);
         if (produit1 != null) {
            System.out.println("Produit trouvé : " + produit1.getMarque() + ", " + produit1.getReference() + ", " + produit1.getPrix() + ", " + produit1.getDateAchat());
        } else {
            System.out.println("Aucun produit trouvé avec l'ID 2.");
        }
         Produit produit2 = pr.findById(3);
         if (produit2 !=null){
             pr.delete(produit2);
         }
         
           Produit produit3 = pr.findById(1);
            if (produit3 !=null){
            produit3.setMarque("Zara");
            produit3.setDesignation("newref1");
            produit3.setPrix(800);
            produit3.setDateAchat(new Date());
            produit3.setDesignation("newdes1");  
            pr.update(produit3);
            
         }
           else {
            System.out.println("Aucun produit trouvé avec l'ID 1.");
        }
            List<Produit> Produits = pr.findAll();
            for (Produit p : Produits) {
            if (p.getPrix()> 100){
                System.out.println(""+p.getMarque()+", " +p.getReference()+","+ p.getPrix() + ","+ p.getDateAchat());    
            }
            else{
                System.out.println("aucun produit n'a un peix plusque 100  dh");
            }       
    }
             
            
    }
}
        
        
        

         
    

