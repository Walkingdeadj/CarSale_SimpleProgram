package controller;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.CarSale;

public class CarSaleHelper {
public static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("UsersCarSaleList");
	
	public void insertCarSale(CarSale cs) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(cs);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<CarSale> getSaleLists(){
		EntityManager em = emfactory.createEntityManager();
		List<CarSale> allCarSale = em.createQuery("SELECT i FROM CarSale i").getResultList();
		return allCarSale;
	}
	
	public void deleteList(CarSale toDelete) {
		EntityManager em = emfactory.createEntityManager();
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
		emfactory.close();
	}
}
