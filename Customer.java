package beans;

import java.io.Serializable;

public class Customer implements Serializable{
	private String customerName;
	private String customerNameKana;
	private String customerZip;
	private String customerAddress;
	private String customerAddressKana;
	private String customerTel;
	
	public Customer(String customerName, String customerNameKana, String customerZip, String customerAddress,
			String customerAddressKana, String customerTel) throws IllegalArgumentException{
		if(customerName.length() > 41){
			throw new IllegalArgumentException("customerName error");
		}
		if(customerNameKana.length() > 41){
			throw new IllegalArgumentException("customerNameKana error");
		}
		if(customerZip.length() > 7){
			throw new IllegalArgumentException("customerZip error");
		}
		if(customerAddress.length() > 256){
			throw new IllegalArgumentException("customerAddress error");
		}
		if(customerAddressKana.length() > 256){
			throw new IllegalArgumentException("customerAddressKana error");
		}
		if(customerTel.length() > 11){
			throw new IllegalArgumentException("customerTel error");
		}
		
		this.customerName = customerName;
		this.customerNameKana = customerNameKana;
		this.customerZip = customerZip;
		this.customerAddress = customerAddress;
		this.customerAddressKana = customerAddressKana;
		this.customerTel = customerTel;
	}

	public String getcustomerName() {
		return customerName;
	}

	public String getcustomerNameKana() {
		return customerNameKana;
	}

	public String getcustomerZip() {
		return customerZip;
	}

	public String getcustomerAddress() {
		return customerAddress;
	}

	public String getcustomerAddressKana() {
		return customerAddressKana;
	}

	public String getcustomerTel() {
		return customerTel;
	}

}
