/*

UML:


Actors
---------

Admin
Guest
Member
System


Use case
----------

add/update product (update catalog)
search product (by name or catagory)
add/remove/update item to cart
checkout cart items
make payment to place order
add new product category
send notifications


Componests
-----------------

Account

Guest

Catalog(Search)

Catagory

Product

Cart

Item

Order

OrderLog

ShipmentLog

Notification

Payment

*/


class Address{
	private String street;
	private String city;
	private String zipcode;
	private String state;
}

enum AccountStatus{
	ACTIVE,
	BLOCKED,
	BANNED,
	UNKOWN
}

enum OrderStatus{
	UNSHIPPED,
	SHIPPED,
	PENDING,
	COMPLETED,
	CANCELED,
	REFUND_APPLIED
}

enum ShipmentStatus{
	SHIPPED,
	PENDING,
	DELIVERED,
	ON_HOLD
}

enum PaymentStatus{
	UNPAID,
	PAID,
	CANCELLED,
	PENDING,
	DECLINED,
	ABANDONED
}

enum PaymentMode{
	CREDIT,
	DEBIT,
	NETBANKING,
	UPI,
	COD
}

class Person{
	private String id;
	private String name;
	private String email;
	private String phone;
	private Address address;
}

class Account{
	private String username;
	private String password
	Person person;

	List<CreditCard> card;
	List<BankAccount> bankAccount;

	addProducts();
	addProductReview();
	resetPassowrd();

}


abstract class Customer{
	ShoppingCart cart;
	Order order;

	addItemTocart();
	removeItemFromCart();
	getCartItem();
}


class Guest extends Customer{

	registerAccount();
}


class Member extends Customer{
	Account account;

	public OrderStatus placeOrder();

}

class ShoppingCart{
	private String id;
	private List<Item> items;

	public boolean addItem();
	public boolean removeItem();
	public boolean updateItem(Item item,int qty);
	public List<Item> getItems();
	public boolean checkout();
}

class OrderLog{
	private String orderNumber;
	private Date creationDate;
	private OrderStatus status;
}

class Order{
	private String orderNumber;
	private OrderStatus status;
	private List<OrderLog> orderLog;
	private Date orderDate;

	sendForShipment();
	makePayment(Payment payment);
	addOrderLog(OrderLog orderLog);
}

class Payment{
	private String txnId;
	private PaymentStatus paymentStatus;
	private PaymentMode paymentMode;

	payNow();
}

class CreditCard extends Payment{

	CreditCard(){
		super(PaymentMode.CREDIT);
	}
}


class Cash extends Payment{

	Cash(){
		super(PaymentMode.COD);
	}
}

class Item{
	private  String productId;
	private  int quantity;
	private  double price;

	public  updateQuantity(int qty);
}

class ProductCatagory{
	private String name;
	private String description;
}

class Product{
	private String id;
	private String name;
	private String description;
	private Double price;
	private ProductCatagory catagory;
	private int avalialbleQty;
}

class ProductReview{
	private int rating;
	private String review;
	private Member reviewer;
}

class Shipment{
	private String shipmentNumber;
	private Date shipmentDate;
	private Date arrival;
	private String shipmentMethod;
	private List<ShipmentLog>shipmentLogs;

	public boolean addShipment(ShipmentLog shipmentLogs);
	public ShipmentLog trackShipment(String shipmentNumber);
}


class ShipmentLog{
	private String shipmentNumber;
	private Date creationDate;
	private ShipmentStatus status;
}

interface Search{
	public List<Product> searchProductByName(String name);
	public List<Product> searchProductByCategory(String catagory);

}

public class Catalog implements Search{
	HashMap<String,List<Product>> productNames;
	HashMap<String,List<Product>> productCatagories;

	public List<Product> searchProductByName(String name){
		return productNames.get(name);
	}
	public List<Product> searchProductByCategory(String catagory){
		return productCatagories.get(catagory);
	}
}

public class Notification{
	private int notificationId;
	private Date creationDate;
	private String content;

	public boolean sendNotification(Account account);
}





















