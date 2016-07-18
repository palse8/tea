package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import beans.Product;

public class ProductDAO {
	private Connection con = null;
	
	public ProductDAO(Connection con) throws IllegalArgumentException{
		if(con != null){
			this.con = con;	
		}else{
			throw new IllegalArgumentException("DB error");
		}
	}
	
	public Product selectProduct(String productNo, String size) throws SQLException{
		Product p = null;
		
		String sql = "SELECT product_no, size, picture_file, product_name,"
				+ " product_description, inventory, unit_price, color, category_no "
				+ "FROM product where product_no=? and size=?";
		
		PreparedStatement pst = con.prepareStatement(sql);
		
		pst.setString(1, productNo);
		pst.setString(2, size);
		
		ResultSet rs = pst.executeQuery();
		
		if(rs.next()){
			String pNo = rs.getString("product_no");
			String pSize = rs.getString("product_size");
			String pFile = rs.getString("picture_file");
			String pName = rs.getString("product_name");
			String pDescription = rs.getString("product_description");
			int inventory = rs.getInt("inventory");
			int unitPrice = rs.getInt("unit_price");
			String color = rs.getString("color");
			String categoryNo = rs.getString("category_no");
			
			p = new Product(pSize,pNo,pFile,pName,pDescription,inventory,unitPrice,color,categoryNo,0);
		}
		try {
			if(pst != null) pst.close();
		} catch (SQLException e) {}
		try {
			if(con != null) con.close();
		} catch (SQLException e) {}

		return p;
		
	}
	
	public ArrayList<Product> searchProduct(String categoryNo, String productName) throws SQLException{
		ArrayList<Product> productList = new ArrayList<Product>();
		
		String sql = "SELECT product_no, size, pricture_file, product_name,"
				+ "product_description, inventory, unit_price, color, category_no"
				+ "FROM product WHERE category_no=? and product_name LIKE %?%";
		
		PreparedStatement pst = con.prepareStatement(sql);
		
		pst.setString(1, categoryNo);
		pst.setString(2, productName);
		
		ResultSet rs = pst.executeQuery();
		
		while(rs.next()){
			String pNo = rs.getString("product_no");
			String pSize = rs.getString("product_size");
			String pFile = rs.getString("picture_file");
			String pName = rs.getString("product_name");
			String pDescription = rs.getString("product_description");
			int inventory = rs.getInt("inventory");
			int unitPrice = rs.getInt("unit_price");
			String color = rs.getString("color");
			String categoryNoDB = rs.getString("category_no");
			
			Product p = new Product(pSize,pNo,pFile,pName,pDescription,inventory,unitPrice,color,categoryNoDB,0);
			productList.add(p);
		}
		
		try {
			if(pst != null) pst.close();
		} catch (SQLException e) {}
		try {
			if(con != null) con.close();
		} catch (SQLException e) {}
		
		if(productList.size() == 0){
			productList = null;
		}
		
		return productList;
		
	}
	
	public ArrayList<Product> searchAllProduct() throws SQLException{
		
		ArrayList<Product> productList = new ArrayList<Product>();
		
		String sql = "SELECT product_no, size, picture_file, product_name,"
				+ "product_description, inventory, unit_price, color, category_no"
				+ " FROM product";
		Statement pst = con.createStatement();

		ResultSet rs = pst.executeQuery(sql);

		while(rs.next()){
			String pNo = rs.getString("product_no");
			String pSize = rs.getString("size");
			String pFile = rs.getString("picture_file");
			String pName = rs.getString("product_name");
			String pDescription = rs.getString("product_description");
			int inventory = rs.getInt("inventory");
			int unitPrice = rs.getInt("unit_price");
			String color = rs.getString("color");
			String categoryNoDB = rs.getString("category_no");
			
			Product p = new Product(pSize,pNo,pFile,pName,pDescription,inventory,unitPrice,color,categoryNoDB,0);
			productList.add(p);
		}
		
		try {
			if(pst != null) pst.close();
		} catch (SQLException e) {}
		try {
			if(con != null) con.close();
		} catch (SQLException e) {}
		
		if(productList.size() == 0){
			productList = null;
		}
		
		return productList;
		
	}
	
	public int getInventory(String productNo, String newSize) throws SQLException{
		String sql = "SELECT inventory FROM product WHERE product_no=? and size=?";
		
		int inventory = -1;
		
		PreparedStatement pst = con.prepareStatement(sql);
		
		pst.setString(1, productNo);
		pst.setString(2, newSize);
		
		ResultSet rs = pst.executeQuery();
		
		if(rs.next()){
			inventory = rs.getInt("inventory");
		}
		try {
			if(pst != null) pst.close();
		} catch (SQLException e) {}
		try {
			if(con != null) con.close();
		} catch (SQLException e) {}
		
		return inventory;
	}
	

}
