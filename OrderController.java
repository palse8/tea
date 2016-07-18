import java.sql.SQLException;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import beans.Card;
import beans.Cart;
import beans.Customer;
import beans.Order;
import beans.Product;
import beans.Reciever;
import dao.OrderDAO;
import dao.ProductDAO;

public class OrderController {
	
	public String addCart(HttpServletRequest request){
		String nextPage = "ProductInfo.jsp";
		String error = "";
		String pNo = request.getParameter("productNo");
		String size = request.getParameter("size");
		int quantity = -1;
		
		HttpSession hs = request.getSession();
		Cart c = (Cart)hs.getAttribute("cart");
		
		try{
			quantity = Integer.parseInt(request.getParameter("quantity"));
			if(quantity < 0){
				error = error + "注文個数は1以上の整数で入力してください<br>";
			}
		}catch(NumberFormatException e){
			error = error + "注文個数は半角数字で入力してください<br>";
		}
		if(pNo != null && size != null && !pNo.isEmpty() && !size.isEmpty()){
			String[] pCheck = pNo.split("-");
			if(pCheck.length != 3 || pCheck[0].length() != 2 || pCheck[1].length() != 4 || pCheck[2].length() != 1){
				error = error + "商品番号エラー<br>";
			}else if(size != "XS" || size != "SS" || size != "S" || size != "M" || size != "L" || size != "LL" || size != "XL"){
				error = error + "サイズエラー<br>";
			}
			if(error.isEmpty()){
				ProductDAO pDAO = new ProductDAO(ConnectionHelper.getConnection());
				try {
					Product p = pDAO.selectProduct(pNo, size);
					if(p.getInventory() < quantity){
						error = error + "在庫がありません<br>";
					}else{
						p.setQuantity(quantity);
						c.addCartInfo(p);
						hs.setAttribute("cart", c);
						nextPage = "CheckOrderProduct.jsp";
					}
				} catch (SQLException e) {
					error = error + "データベース接続エラー<br>";
				}
			}
		}else{
			error = error + "個数を入力してください<br>";
		}
		request.setAttribute("Error", error);
		
		return nextPage;
	}
	
	public String addInputInfo(HttpServletRequest request){
		String customerName = request.getParameter("customerName");
		String customerNameKana = request.getParameter("customerNameKana");
		String customerZip = request.getParameter("customerZip");
		String customerAddress = request.getParameter("customerAddress");
		String customerAddressKana = request.getParameter("customerAddressKana");
		String customerTel = request.getParameter("customerTel");
		String recieverName = request.getParameter("recieverName");
		String recieverNameKana = request.getParameter("recieverNameKana");
		String recieverZip = request.getParameter("recieverZip");
		String recieverAddress = request.getParameter("recieverAddress");
		String recieverAddressKana = request.getParameter("recieverAddressKana");
		String recieverTel = request.getParameter("recieverTel");
		String creditBrand = request.getParameter("creditBrand");
		String creditNo = request.getParameter("creditNo");
		String creditSecurity = request.getParameter("creditSecurity");
		String creditLimit = request.getParameter("creditLimit");
		String creditName = request.getParameter("creditName");
		String deliveryDate = request.getParameter("deliveryDate");
		
		String error = "";
		String nextPage = "InputPrivateInfo.jsp";
		
		if(customerName == null || customerName.isEmpty() || recieverName == null || recieverName.isEmpty()){
			error = error + "指名を入力してください<br>";
		}
		if(customerNameKana == null || customerNameKana.isEmpty() || recieverNameKana == null || recieverNameKana.isEmpty()){
			error = error + "指名(フリガナ)を入力してください<br>";
		}
		if(customerZip == null || customerZip.isEmpty() || recieverZip == null || recieverZip.isEmpty()){
			error = error + "郵便番号を入力してください<br>";
		}
		if(customerAddress == null || customerAddress.isEmpty() || recieverAddress == null || recieverAddress.isEmpty()){
			error = error + "住所を入力してください<br>";
		}
		if(customerAddressKana == null || customerAddressKana.isEmpty() || recieverAddressKana == null || recieverAddressKana.isEmpty()){
			error = error + "住所(フリガナ)を入力してください<br>";
		}
		if(customerTel == null || customerTel.isEmpty() || recieverTel == null || recieverTel.isEmpty()){
			error = error + "電話番号を入力してください<br>";
		}
		if(customerZip.length() != 7 || recieverZip.length() != 7){
			error = error + "郵便番号は7桁の半角数字で入力してください<br>";
		}
		try{
			Integer.parseInt(customerZip);
			Integer.parseInt(recieverZip);
		}catch(NumberFormatException e){
			error = error + "郵便番号に入力できるのは半角数字のみです<br>";
		}
		if(customerTel.length() > 11 || customerTel.length() < 10 || recieverTel.length() > 11 || recieverTel.length() < 10 ){
			error = error + "電話番号は10~11桁の半角数字で入力してください<br>";
		}
		try{
			Integer.parseInt(customerTel);
			Integer.parseInt(recieverTel);
		}catch(NumberFormatException e){
			error = error + "電話番号に入力できるのは半角数字のみです<br>";
		}
		try{
			Integer.parseInt(creditNo);
		}catch(NumberFormatException e){
			error = error + "カード番号に入力できるのは半角数字のみです<br>";
		}
		try{
			Integer.parseInt(creditLimit);
			String creditYear = creditLimit.substring(0, 2);
			int creditManth = Integer.parseInt(creditLimit.substring(2));
			if(creditYear.length() != 2){
				error = error + "有効期限の年は2桁で入力してください<br>";
			}
			if(creditManth < 1 || creditManth > 12){
				error = error + "有効期限の月は1~12の間で入力してください<br>";
			}
		}catch(NumberFormatException e){
			error = error + "電話番号に入力できるのは半角数字のみです<br>";
		}
		
		if(error.isEmpty()){
			Customer cus = new Customer(customerName, customerNameKana, customerZip, customerAddress, customerAddressKana, customerTel);
			Reciever rec = new Reciever(recieverName, recieverNameKana, recieverZip, recieverAddress, recieverAddressKana, recieverTel);
			Card car = new Card(creditBrand, creditNo, creditSecurity, creditLimit, creditName);
			Order ord = new Order("0000/00/00",deliveryDate,"AA-0000-000000",cus,rec,car);
			HttpSession hs = request.getSession();
			hs.setAttribute("order",ord);
			nextPage = "CheckOrderInfo.jsp";
		}
		
		request.setAttribute("Error", error);
		
		return nextPage;
		
	}
	
	public String register(HttpServletRequest request){
		String error = "";
		String nextPage = "CheckOrderInfo.jsp";
		String orderNo = null;
		
		HttpSession hs = request.getSession();
		Order ord = (Order)hs.getAttribute("order");
		Cart car = (Cart)hs.getAttribute("cart");
		OrderDAO oDAO = new OrderDAO(ConnectionHelper.getConnection());
		
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int manth = now.get(Calendar.DAY_OF_MONTH);
		int day = now.get(Calendar.DATE);
		
		String sManth = String.format("%02d", manth);
		String sDay = String.format("%02d", day);
		
		ord.setOrderDate(String.valueOf(year) + "/" + sManth + "/" + sDay);
		
		try {
			orderNo = oDAO.insertOrder(ord,car);
		} catch (SQLException e) {
			error = "データベース接続エラー<br>";
		}
		if(error.isEmpty()){
			car.clearCart();
			hs.removeAttribute("order");
			request.setAttribute("orderNo", orderNo);
			nextPage = "Complete.jsp";
		}else{
			request.setAttribute("Error", error);
		}
		return nextPage;
	}
	
	public String deleteCart(HttpServletRequest request){
		String nextPage = "CheckOrderProduct.jsp";
		String error = "";
		String productNo = request.getParameter("productNo");
		String size = request.getParameter("size");
		
		if(productNo != null && size != null && !productNo.isEmpty() && !size.isEmpty()){
			String[] pCheck = productNo.split("-");
			if(pCheck.length != 3 || pCheck[0].length() != 2 || pCheck[1].length() != 4 || pCheck[2].length() != 1){
				error = error + "商品番号エラー<br>";
			}else if(size != "XS" || size != "SS" || size != "S" || size != "M" || size != "L" || size != "LL" || size != "XL"){
				error = error + "サイズエラー<br>";
			}else{
				HttpSession hs = request.getSession();
				Cart cart = (Cart)hs.getAttribute("cart");
				cart.delete(productNo, size);
				hs.setAttribute("cart", cart);
			}
		}else{
			error = error + "商品番号・サイズのNULL空エラー";
		}
		return nextPage;
		
	}
	
	public String changeCart(HttpServletRequest request){
		String nextPage = "CheckOrderProduct.jsp";

		String error = "";
		String productNo = request.getParameter("productNo");
		String size = request.getParameter("size");
		int quantity = -1;
		
		try{
			quantity = Integer.parseInt(request.getParameter("quantity"));
			if(quantity < 0){
				error = error + "注文個数は1以上の整数で入力してください<br>";
			}
		}catch(NumberFormatException e){
			error = error + "注文個数は半角数字で入力してください<br>";
		}
		if(productNo != null && size != null && !productNo.isEmpty() && !size.isEmpty()){
			String[] pCheck = productNo.split("-");
			if(pCheck.length != 3 || pCheck[0].length() != 2 || pCheck[1].length() != 4 || pCheck[2].length() != 1){
				error = error + "商品番号エラー<br>";
			}else if(size != "XS" || size != "SS" || size != "S" || size != "M" || size != "L" || size != "LL" || size != "XL"){
				error = error + "サイズエラー<br>";
			}else{
				HttpSession hs = request.getSession();
				Cart cart = (Cart)hs.getAttribute("cart");
				//error
				cart.changeCart(productNo, size, size, quantity);
				hs.setAttribute("cart", cart);
			}
		}else{
			error = error + "商品番号・サイズのNULL空エラー";
		}
		
		request.setAttribute("Error", error);
		
		return nextPage;	
	}
	
	public String order(HttpServletRequest request){
		return "InputPrivateInfo.jsp";
	}
	
	

}
