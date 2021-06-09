/*

Use cases



Actors:

Customer
Waiter
Cook
Manager
System



UseCases

Customer,Manager -> 	reserveTable
Customer,Manager -> 	removeReservation
Waiter -> 				createOrder
Waiter -> 				addMeals
Cook -> 				prepareOrder 
Manager -> 				add/remove Waiter
		-> 				add/remove Cook
System -> 				showAvailableTables
	   -> 				Notify user 




"Components:"


*/

public enum MealType{
	FOOD,
	DRINKS,
	SHAKES,
	DESSERTS
}

public enum AccountStatus{
	AVITVE,
	BLOCKED,
	CLOSED
}

public enum BranchStatus{
	OPEN,
	CLOSED
}

public enum TableStatus{
	RESERVED,
	AVAILABLE
}

public enum PaymentType{
	NETBANKING,
	UPI,
	CREDITCARD,
	DEBITCARD,
	CASH
}

class Person{
	private String name;
	private String email;
	private String phone;
	private Account account;
}


class Account{
	private String id;
	private String username;
	private String password;
	private AccountStatus status;

	public void resetPassword();
}

class Customer extends Person{
	TableReservation reserveTable;
}

class Manager extends Person{
	TableReservation reserveTable;
}

class TableReservation{
	public static boolean reserveTable(Customer customer,Table table);
	public static boolean cancelReservation(Customer customer, Table table);
}

class Waiter extends Person{

	public boolean addMeal(Meal meal);
	public Order createOrder();
}

class Cook extends Person{
	prepareFood();
}


class Order{
	private String orderId;
	private List<Meal> mealItems;
	private Date createdAt;
	private Double totalAmount;
	private Customer customer;
}



public class Meal
{
	private String id;
	private List<String> mealitems;
	private Double price;

}

class SearchService{
	private List<Restraunt> restraunts;

	public Restraunt searchRestraunt(String name);
}

class Restraunt {
	private String name;
	private List<Branch> branches;

	public Branch searchBranch(Location location);
}

class Branch{
	private Strind id;
	private Menu menu;
	private List<Cook> cooks;
	private List<Waiter> waiters;
	private Manager manager;
	private List<Table> tables;
	private Location location;
	private BranchStatus status;


	public addTable();
	public removeTable();
	public showAvaliabeTables();
}

class Location{
	private String area;
	private String city;
	private String state;
	private String pincode;
}

class Table{
	private int id;
	private int capacity;
	private Customer reservedBy;
	private List<Meals> meals;
	private TableStatus status;
}

class Menu{
	List<Section> section;
}

class Section{
	List<Meal> meals;
	MealType type;
}

class Payment{
	String transactionId;
	PaymentType paymentType;
	Double amount;
	String name;
}



