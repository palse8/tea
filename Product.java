package beans;

public class Product {
	
	private String size;
	private String productNo;
	private String picture;
	private String productName;
	private String productDescription;
	private int inventory;
	private int unitPrice;
	private String color;
	private String category;
	private int quantity;
	
	public Product(String size, String productNo, String picture, String productName, String productDescription,
			int inventory, int unitPrice, String color, String category, int quantity) {
		
		this.size = size;
		this.productNo = productNo;
		this.picture = picture;
		this.productName = productName;
		this.productDescription = productDescription;
		this.inventory = inventory;
		this.unitPrice = unitPrice;
		this.color = color;
		this.category = category;
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		if(quantity > inventory){
			throw new IllegalArgumentException("zaiko error");
		}
		this.quantity = quantity;
	}

	public String getSize() {
		return size;
	}

	public String getProductNo() {
		return productNo;
	}

	public String getPicture() {
		return picture;
	}

	public String getProductName() {
		return productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public int getInventory() {
		return inventory;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public String getColor() {
		return color;
	}

	public String getCategory() {
		return category;
	}
	
	public void setSize(String size){
		this.size = size;
	}
	
	

}

