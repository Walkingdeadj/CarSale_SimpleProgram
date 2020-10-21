package controller;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Buyer;
import model.CarList;
import model.CarSale;

public class CarSaleHelper {
public static EntityManagerFactory emfactory2 = Persistence.createEntityManagerFactory("UsersCarSale");
	
	public void insertCarSale(CarSale cs) {
		EntityManager em = emfactory2.createEntityManager();
		em.getTransaction().begin();
		em.persist(cs);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<CarSale> getSaleLists(){
		EntityManager em = emfactory2.createEntityManager();
		List<CarSale> allCarSale = em.createQuery("SELECT i FROM CarSale i").getResultList();
		return allCarSale;
	}
	
	public void deleteList(CarSale toDelete) {
		EntityManager em = emfactory2.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<CarSale> typedQuery = em.createQuery("select detail from CarSale detail where detail.id = :selectedId", CarSale.class);
		typedQuery.setParameter("selectedId", toDelete.getId());

		// we only want one result
		typedQuery.setMaxResults(1);

		// get the result and save it into a new list item
		CarSale result = typedQuery.getSingleResult();

		// remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	

	public void cleanUp(){
		emfactory2.close();
	}

	public void deleteByID(Integer tempId) {
		EntityManager em = emfactory2.createEntityManager();
		em.getTransaction().begin();
		CarSale found = em.find(CarSale.class, tempId);
		em.close();
		deleteList(found);		
	}
	
	public CarSale serachForCarSaleById(Integer tempId) {
		EntityManager em = emfactory2.createEntityManager();
		em.getTransaction().begin();
		CarSale found = em.find(CarSale.class, tempId);
		em.close();
		return found;
	}
	
	public void updateSale(CarSale toEdit) {
		EntityManager em = emfactory2.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
}
