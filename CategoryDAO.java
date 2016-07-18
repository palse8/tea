package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Category;

public class CategoryDAO {
	private Connection con = null;
	
	public CategoryDAO(Connection con) throws IllegalArgumentException{
		if(con != null){
			this.con = con;
		}else{
			throw new IllegalArgumentException("DB missing");
		}
	}
	
	public ArrayList<Category> searchAllCategory() throws SQLException{
		ArrayList<Category> categoryList = new ArrayList<Category>();
		
		String sql = "SELECT category_no, category_name FROM category";
		
		PreparedStatement pst = con.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		
		while(rs.next()){
			String cateNo = rs.getString("category_no");
			String cateName = rs.getString("category_name");
			Category cate = new Category(cateNo, cateName);
			categoryList.add(cate);
		}
		
		try {
			if(pst != null) pst.close();
		} catch (SQLException e) {}
		try {
			if(con != null) con.close();
		} catch (SQLException e) {}
		
		if(categoryList.size() == 0){
			categoryList = null;
		}
		
		return categoryList;
	}
}
