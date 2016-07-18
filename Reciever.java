package beans;

import java.io.Serializable;

public class Reciever implements Serializable{
	
	private String recieverName;
	private String recieverNameKana;
	private String recieverZip;
	private String recieverAddress;
	private String recieverAddressKana;
	private String recieverTel;
	
	public Reciever(String recieverName, String recieverNameKana, String recieverZip, String recieverAddress,
			String recieverAddressKana, String recieverTel) throws IllegalArgumentException{
		if(recieverName.length() > 41){
			throw new IllegalArgumentException("reciverName error");
		}
		if(recieverNameKana.length() > 41){
			throw new IllegalArgumentException("reciverNameKana error");
		}
		if(recieverZip.length() > 7){
			throw new IllegalArgumentException("reciverZip error");
		}
		if(recieverAddress.length() > 256){
			throw new IllegalArgumentException("reciverAddress error");
		}
		if(recieverAddressKana.length() > 256){
			throw new IllegalArgumentException("reciverAddressKana error");
		}
		if(recieverTel.length() > 11){
			throw new IllegalArgumentException("reciverTel error");
		}
		
		this.recieverName = recieverName;
		this.recieverNameKana = recieverNameKana;
		this.recieverZip = recieverZip;
		this.recieverAddress = recieverAddress;
		this.recieverAddressKana = recieverAddressKana;
		this.recieverTel = recieverTel;
	}

	public String getRecieverName() {
		return recieverName;
	}

	public String getRecieverNameKana() {
		return recieverNameKana;
	}

	public String getRecieverZip() {
		return recieverZip;
	}

	public String getRecieverAddress() {
		return recieverAddress;
	}

	public String getRecieverAddressKana() {
		return recieverAddressKana;
	}

	public String getRecieverTel() {
		return recieverTel;
	}
	
	

}
