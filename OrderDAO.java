package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import beans.Cart;
import beans.Order;
import beans.Product;

public class OrderDAO {
	private Connection con = null;
	
	
	public OrderDAO(Connection con) throws IllegalArgumentException{
		if(con != null){
			this.con = con;
		}else{
			throw new IllegalArgumentException("DB error");
		}
	}
	public String insertOrder(Order order,Cart cart) throws SQLException{
		String noSql = "SELECT max(order_no) FROM orders WHERE "
				+ "substring(order_no,6,4) = DATE_FORMAT(now(),'%Y')";
		String insertSql = "INSERT INTO order VALUSE (?,?,?,?,?,?,?,?,?,?,"
				+ "?,?,?,?,?,?,?,?,?,?)";
		String insertCartSql = "INSERT INTO order_product VALUSE (?,?,?,?)";
		
		Calendar now = Calendar.getInstance();
		
		String headCode = "S001";
		
		String nowOrderNo = null;
		String newOrderNo = null;
		
		PreparedStatement noPst = con.prepareStatement(noSql);
		PreparedStatement insertPst = con.prepareStatement(insertSql);
		PreparedStatement insertCartPst = con.prepareStatement(insertCartSql);
		
		ResultSet rs = noPst.executeQuery();
		
		if(rs.next()){
			nowOrderNo = rs.getString("max(order_no)");
		}
		
		if(nowOrderNo == null){
			String nowYear = String.valueOf(now.get(Calendar.YEAR));
			nowOrderNo = headCode + "-" + nowYear + "-000001";
		}else{
			String[] nowOrderNoArray = nowOrderNo.split("-");
			
			int nowNo = Integer.parseInt(nowOrderNoArray[2]);
			
			nowOrderNo = nowOrderNo.substring(0, 10) + String.format("%06d", nowNo + 1);
		}
		
		order.setOrderNo(newOrderNo);
		
		insertPst.setString(1, order.getOrderNo());
		insertPst.setString(2, order.getOrderDate());
		insertPst.setString(3, order.getDeliveryDate());
		insertPst.setString(4, order.getCustomer().getcustomerName());
		insertPst.setString(5, order.getCustomer().getcustomerNameKana());
		insertPst.setString(6, order.getCustomer().getcustomerZip());
		insertPst.setString(7, order.getCustomer().getcustomerAddress());
		insertPst.setString(8, order.getCustomer().getcustomerAddressKana());
		insertPst.setString(9, order.getCustomer().getcustomerTel());
		insertPst.setString(10, order.getReciever().getRecieverName());
		insertPst.setString(11, order.getReciever().getRecieverNameKana());
		insertPst.setString(12, order.getReciever().getRecieverZip());
		insertPst.setString(13, order.getReciever().getRecieverAddress());
		insertPst.setString(14, order.getReciever().getRecieverAddressKana());
		insertPst.setString(15, order.getReciever().getRecieverTel());
		insertPst.setString(16, order.getCard().getCreditBrand());
		insertPst.setString(17, order.getCard().getCreditNo());
		insertPst.setString(18, order.getCard().getCreditSecurity());
		insertPst.setString(19, order.getCard().getCreditLimit());
		insertPst.setString(20, order.getCard().getCreditName());
		
		insertPst.executeUpdate();
		
		ArrayList<Product> cartList = new ArrayList<Product>();
		for(Product p : cartList){
			insertCartPst.setString(1, newOrderNo);
			insertCartPst.setString(2, p.getProductNo());
			insertCartPst.setString(3, p.getSize());
			insertCartPst.setInt(4, p.getQuantity());
			insertCartPst.executeUpdate();
		}
		
		return newOrderNo;		
	}
	
	

}
