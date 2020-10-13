package controller;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.CarList;

public class CarListHelper {
	public static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("UsersCarSale");
	
	public void insertCar(CarList ci) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(ci);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<CarList> showAllCars(){
		EntityManager em = emfactory.createEntityManager();
		List<CarList> allCars = em.createQuery("SELECT i FROM CarList i").getResultList();
		return allCars;
	}

	
	public void deleteCar(CarList toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<CarList> typedQuery = em.createQuery( "select ci from CarList ci where ci.model = :selectedModel and ci.make = :selectedMake",CarList.class);
		// Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedModel", toDelete.getModel());
		typedQuery.setParameter("selectedMake", toDelete.getMake());

		// we only want one result
		typedQuery.setMaxResults(1);

		// get the result and save it into a new list item
		CarList result = typedQuery.getSingleResult();

		// remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public CarList searchForCarById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		CarList found = em.find(CarList.class, idToEdit);
		em.close();
		return found;
	}
	
	public void updateCar(CarList toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<CarList> searchForCarByModel(String model) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<CarList> typedQuery = em.createQuery("select ci from CarList ci where ci.model = :selectedModel", CarList.class);
		typedQuery.setParameter("selectedModel", model);

		List<CarList> foundCars = typedQuery.getResultList();
		em.close();
		return foundCars;
	}
	
	public List<CarList> searchForCarByMake(String make) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<CarList> typedQuery = em.createQuery("select ci from CarList ci where ci.make = :selectedMake", CarList.class);
		typedQuery.setParameter("selectedMake", make);

		List<CarList> foundCars = typedQuery.getResultList();
		em.close();
		return foundCars;
	}
	
	
	public void cleanUp(){
		emfactory.close();
	}
}
