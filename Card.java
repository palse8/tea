package beans;

public class Card {
	private String creditBrand;
	private String creditNo;
	private String creditSecurity;
	private String creditLimit;
	private String creditName;
	
	public Card(String creditBrand, String creditNo, String creditSecurity, String creditLimit, String creditName) throws IllegalArgumentException{
		
		if(creditBrand.length() > 11){
			throw new IllegalArgumentException("creditBand error");
		}
		if(creditNo.length() > 16){
			throw new IllegalArgumentException("creditNo error");
		}
		if(creditSecurity.length() > 4){
			throw new IllegalArgumentException("creditSecurity error");
		}
		if(creditLimit.length() > 4){
			throw new IllegalArgumentException("creditLimit error");
		}
		if(creditName.length() > 41){
			throw new IllegalArgumentException("creditName error");
		}
		
		this.creditBrand = creditBrand;
		this.creditNo = creditNo;
		this.creditSecurity = creditSecurity;
		this.creditLimit = creditLimit;
		this.creditName = creditName;
	}

	public String getCreditBrand() {
		return creditBrand;
	}

	public String getCreditNo() {
		return creditNo;
	}

	public String getCreditSecurity() {
		return creditSecurity;
	}

	public String getCreditLimit() {
		return creditLimit;
	}

	public String getCreditName() {
		return creditName;
	}
	
	

}
