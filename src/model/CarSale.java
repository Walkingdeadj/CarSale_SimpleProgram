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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sales")
public class CarSale {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="SALE_ID")
	private int id;
	@Column(name="SALE_DATE")
	private LocalDate saleDate;
	@Column(name="PRICE")
	private int price;
	@OneToOne(cascade={CascadeType.PERSIST}, fetch=FetchType.EAGER)	
	@JoinColumn(name="BUYER_ID")
	private Buyer buyer;
	/**
	@ManyToOne (cascade=CascadeType.PERSIST)
	@JoinColumn(name="CAR_ID")
	private CarList carList;
	*/
	@OneToOne(cascade={CascadeType.PERSIST}, fetch=FetchType.EAGER)	
	@JoinColumn(name="CAR_ID")
	private CarList listOfCars;
			
	public CarSale() {
		super();
	}
	
	public CarSale(int id, LocalDate saleDate, int price, Buyer buyer, CarList listOfCars) {
		super();
		this.id = id;
		this.saleDate = saleDate;
		this.price = price;
		this.buyer = buyer;
		this.listOfCars = listOfCars;
	}
	
	public CarSale(LocalDate saleDate, int price, Buyer buyer, CarList listOfCars) {
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
	
	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}	
	
	
	public CarList getListOfCars() {
		return listOfCars;
	}

	public void setListOfCars(CarList listOfCars) {
		this.listOfCars = listOfCars;
	}

	public String toString() {
		return "ID: " + id + "Sale Date: " + saleDate + " ;Price: " + price + " ;Buyer: " + buyer + " ;List of cars: " + listOfCars;
	}
}
