/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entidades.Player;
import entidades.Team;
import javax.ejb.Stateless;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

/**
 *
 * @author alejandroquiros
 */
@Stateless
public class BasketSessionBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
       @PersistenceUnit
        EntityManagerFactory emf;
        public  List findAll(){
        return 
            emf.createEntityManager().createNamedQuery
            ("Player.findAll").getResultList();
        }
        
        public void InsertTeam(String team){
            Team t = new Team();
            
            emf.createEntityManager().persist(t);
        }
        
        public void insertPlayer(Player player){
        emf.createEntityManager().persist(player);
    }
    }
