package model;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "carsale")
public class CarSale {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="SALE_ID")
	private int id;
	@Column(name="SALE_DATE")
	private LocalDate saleDate;
	@Column(name="PRICE")
	private int price;
	@ManyToOne (cascade=CascadeType.PERSIST)
	@JoinColumn(name="BUYER_ID")
	private Buyer buyer;
	/**
	@ManyToOne (cascade=CascadeType.PERSIST)
	@JoinColumn(name="CAR_ID")
	private CarList carList;
	*/
	@OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	@JoinTable(
			name = "CARS_ON_LIST",
			joinColumns={ @JoinColumn(name="SALE_ID", referencedColumnName="SALE_ID") },
		    inverseJoinColumns={ @JoinColumn(name="CAR_ID", referencedColumnName="CAR_ID", unique=true) }
	)
	private List<CarList> listOfCars;
			
	public CarSale() {
		super();
	}
	
	public CarSale(int id, LocalDate saleDate, int price, Buyer buyer, List<CarList> listOfCars) {
		super();
		this.id = id;
		this.saleDate = saleDate;
		this.price = price;
		this.buyer = buyer;
		this.listOfCars = listOfCars;
	}
	
	public CarSale(LocalDate saleDate, int price, Buyer buyer, List<CarList> listOfCars) {
		super();
		this.saleDate = saleDate;
		this.price = price;
		this.buyer = buyer;
		this.listOfCars = listOfCars;
	}
	
	public CarSale(LocalDate saleDate, int price, Buyer buyer) {
		super();
		this.saleDate = saleDate;
		this.price = price;
		this.buyer = buyer;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public LocalDate getSaleDate() {
		return saleDate;
	}
	
	public void setSaleDate(LocalDate saleDate) {
		this.saleDate = saleDate;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	public Buyer getBuyer() {
		return buyer;
	}
	
	public void setShopper(Buyer buyer) {
		this.buyer = buyer;
	}
	
	public List<CarList> getListOfCars() {
		return listOfCars;
	}


	public void setListOfItems(List<CarList> listOfCars) {
		this.listOfCars = listOfCars;
	}

	
	
	public String toString() {
		return "ID: " + id + "Sale Date: " + saleDate + " ;Price: " + price + " ;Buyer: " + buyer + " ;List of cars: " + listOfCars;
	}
}
