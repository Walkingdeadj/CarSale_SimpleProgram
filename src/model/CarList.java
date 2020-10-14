package model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cars")
public class CarList {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CAR_ID")
	private int id;
	@Column(name="MODEL")
	private String model;
	@Column(name="MAKE")
	private String make;

	public CarList() {
		super();
	}
	
	public CarList(String model, String make) {
		super();
		this.model = model;
		this.make = make;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public String getMake() {
		return make;
	}
	
	public void setMake(String make) {
		this.make = make;
	}
	
	public String returnCarDetails() {
		return "Car's model is " + model + ",and it's make is " + make + " ;ID: " + id;
	}
}
