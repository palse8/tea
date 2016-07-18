package beans;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private ArrayList<Product> cartList;
	
	public Cart(){
		cartList = new ArrayList<Product>();
	}
	
	//syoukei
	public int subTotalCalc(){
		int subTotal = 0;
		for(Product p : cartList){
			subTotal += p.getUnitPrice() * p.getQuantity();
		}
		return subTotal;
	}
	
	public int calcTax(){
		double taxRate = 0.08;
		double d_subTotal = 0;
		d_subTotal = (double)subTotalCalc() * taxRate;
		int subTotal = (int) d_subTotal;
		return subTotal;
	}
	
	public int calcTotal(){
		return subTotalCalc() + calcTax();
	}
	
	public int calcSendFee(){
		int sendFee = 540;
		if(subTotalCalc() >= 10000){
			sendFee = 0;
		}
		return sendFee;
	}
	
	public void addCartInfo(Product p){
		for(Product cp : cartList){
			if(cp.getProductNo().equals(p.getProductNo()) && cp.getSize().equals(p.getSize())){
				cp.setQuantity(cp.getQuantity() + p.getQuantity());
			}else{
				cartList.add(p);
			}
		}
	}
	
	public void changeCart(String productNo, String size, String newSize, int quantity){
		for(Product p : cartList){
			if(p.getProductNo().equals(productNo) && p.getSize().equals(size)){
				p.setQuantity(quantity);
			}else if(p.getProductNo().equals(productNo) && p.getSize().equals(size)){
				p.setSize(newSize);
				p.setQuantity(quantity);
			}
		}
		
	}
	
	public void delete(String productNo, String size){
		int i;
		for(i = 0; i<cartList.size(); i++){
			if(cartList.get(i).getProductNo().equals(productNo) && cartList.get(i).equals(size)){
				cartList.remove(i);
			}
		}
	}
	
	public int sumProduct(){
		int sum=0;
		for(Product p : cartList){
			sum += p.getQuantity();
		}
		return sum;
	}
	
	public ArrayList<Product> getCartList(){
		return cartList;
	}
	
	public void clearCart(){
		cartList.clear();
		
	}

}
