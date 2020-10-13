package controller;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import model.Buyer;

public class BuyerHelper {
	public static EntityManagerFactory emfactory1 = Persistence.createEntityManagerFactory("UsersCarSaleList");
	
	public void insertBuyer(Buyer b) {
		EntityManager em = emfactory1.createEntityManager();
		em.getTransaction().begin();
		em.persist(b);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Buyer> showAllBuyers(){
		EntityManager em = emfactory1.createEntityManager();
		@SuppressWarnings("unchecked")
		List<Buyer> allBuyers = em.createQuery("SELECT i FROM Buyer i").getResultList();
		return allBuyers;
	}
	
	public void cleanUp(){
		emfactory1.close();
	}
}
