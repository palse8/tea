package beans;

public class Category {
	private String categoryNo;
	private String categoryName;
	public Category(String categoryNo, String categoryName) {
		super();
		this.categoryNo = categoryNo;
		this.categoryName = categoryName;
	}
	public String getCategoryNo() {
		return categoryNo;
	}
	public String getCategoryName() {
		return categoryName;
	}
	
	

}
