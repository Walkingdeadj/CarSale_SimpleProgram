package controller;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import model.Buyer;
import model.CarList;

public class BuyerHelper {
	public static EntityManagerFactory emfactory1 = Persistence.createEntityManagerFactory("UsersCarSale");
	
	public void insertBuyer(Buyer b) {
		EntityManager em = emfactory1.createEntityManager();
		em.getTransaction().begin();
		em.persist(b);
		em.getTransaction().commit();
		em.close();
	}
	
	public void deleteBuyer(Buyer toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory1.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Buyer> typedQuery = em.createQuery( "select bu from Buyer bu where bu.buyerName = :selectedName and bu.buyerPNum = :selectedPhone",Buyer.class);
		// Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedName", toDelete.getBuyerName());
		typedQuery.setParameter("selectedPhone", toDelete.getBuyerPNum());

		// we only want one result
		typedQuery.setMaxResults(1);

		// get the result and save it into a new list item
		Buyer result = typedQuery.getSingleResult();

		// remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public Buyer searchForBuyerByID(int idToEdit) {
		EntityManager em = emfactory1.createEntityManager();
		em.getTransaction().begin();
		Buyer found = em.find(Buyer.class, idToEdit);
		em.close();
		return found;
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

	public void UpdateBuyer(Buyer buyerToUpdate) {
		// TODO Auto-generated method stub
		
	}
}
