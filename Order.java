package beans;

public class Order {
	private String orderDate;
	private String deliveryDate;
	private String orderNo;
	private Customer customer;
	private Reciever reciever;
	private Card card;
	
	public Order(String orderDate, String deliveryDate, String orderNo, Customer customer, Reciever reciever,
			Card card) throws IllegalArgumentException{
		if(orderDate.length() != 10){
			throw new IllegalArgumentException("orderDate error");
		}
		if(deliveryDate.length() != 10){
			throw new IllegalArgumentException("deliveryDate error");
		}
		if(orderNo.length() != 16){
			throw new IllegalArgumentException("orderNo error");
		}
		char[] chars1 = orderDate.toCharArray();
		for(int i = 0; i < chars1.length; i++){
			if(String.valueOf(chars1[i]).getBytes().length < 2){
			}else{
				throw new IllegalArgumentException("orderDate han error");
			}
		}
		char[] chars2 = deliveryDate.toCharArray();
		for(int i = 0; i < chars2.length; i++){
			if(String.valueOf(chars2[i]).getBytes().length < 2){
			}else{
				throw new IllegalArgumentException("deliveryDate han error");
			}
		}
		this.orderDate = orderDate;
		this.deliveryDate = deliveryDate;
		this.orderNo = orderNo;
		this.customer = customer;
		this.reciever = reciever;
		this.card = card;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) throws IllegalArgumentException{
		char[] chars1 = orderDate.toCharArray();
		for(int i = 0; i < chars1.length; i++){
			if(String.valueOf(chars1[i]).getBytes().length < 2){
			}else{
				throw new IllegalArgumentException("orderDate han error");
			}
		}
		if(orderDate.length() == 10){
			this.orderDate = orderDate;
		}else{
			throw new IllegalArgumentException("orderDate error");
		}
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) throws IllegalArgumentException{
		char[] chars2 = deliveryDate.toCharArray();
		for(int i = 0; i < chars2.length; i++){
			if(String.valueOf(chars2[i]).getBytes().length < 2){
			}else{
				throw new IllegalArgumentException("deliveryDate han error");
			}
		}
		if(deliveryDate.length() == 10){
			this.deliveryDate = deliveryDate;
		}else{
			throw new IllegalArgumentException("deliveryDate error");
		}
		
	}

	public String getOrderNo() {
		return orderNo;
	}

	public Customer getCustomer() {
		return customer;
	}

	public Reciever getReciever() {
		return reciever;
	}

	public Card getCard() {
		return card;
	}
	
	public void setOrderNo(String orderNo){
		this.orderNo = orderNo;
	}
	
}
