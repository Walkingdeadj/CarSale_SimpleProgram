package model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "buyer")
public class Buyer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="BUYER_ID")
	private int id;
	@Column(name="NAME")
	private String buyerName;
	@Column(name="PHONE_NUMBER")
	private String buyerPNum;
	
	public Buyer() {
		super();
	}
	
	public Buyer(int id, String buyerName, String buyerPNum) {
		super();
		this.id = id;
		this.buyerName = buyerName;
		this.buyerPNum = buyerPNum;
	}
	
	public Buyer(String buyerName, String buyerPNum) {
		super();
		this.buyerName = buyerName;
		this.buyerPNum = buyerPNum;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getBuyerName() {
		return buyerName;
	}
	
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}
	
	public String getBuyerPNum() {
		return buyerPNum;
	}
	
	public void setBuyerPNum(String buyerPNum) {
		this.buyerPNum = buyerPNum;
	}
	
	public String returnBuyerDetails() {
		return "The buyer's name: " + buyerName + " ;Phone number: " + buyerPNum + " ;ID: " + id;
	}
}
