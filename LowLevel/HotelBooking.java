/*
Guest search ,book  Receptionist
						checkin checkoit

Admin add,remove,edit room

Housekeeping updateHousekeeping logs

System  sendnotification,bill generation

*/

class Hotel{
	private String id;
	private String name;
	private Address location;
	private List<Room> rooms;
}


class Address{
	private  int pin;
	private  String street;
	private  String area;
	private  String city;
	private  String state;
	private  String country;
}

class Room{
	String roomNumber;
	RoomType type;
	RoomStatus status;
	List<RoomKey> keys;
	int capacity;
	Double bookingPrice;
	List<HouseKeeping> houseKeepingLogs;
}

enum RoomType{
	FAMILY_SUITE,
	STANDARD,
	DELUX
}

enum RoomStatus{
	AVAILABLE,
	RESERVED,
	SERVICE_IN_PROGRESS,
	NOT_AVAILABLE,
	OCCUPIED
}

class RoomKey{
	String id;
	String barcode;
	Date dateIssued;
	Boolean isMaster;
	Boolean isActive;

	public void assignRoom(Room room);
}

class HouseKeeping{
	String description;
	Date startDate;
	int duration;
	HouseKeeper houseKeeper;

	public void addRoom(Room room);
}

abstract class Person{
	private String name;
	private String email;
	private String phone;
	Account accountDetail;
}

public class Account{

	private String username;
	private String password;
	private AccountStatus status;
}

public class Guest extends Person{
	Search searchObj;
	Booking bookingObj;

	public List<RoomBooking> getAllBookings();
}


public class Receptionist extends Person{
	Search searchObj;
	Booking bookingObj;

	public void checkInGuest(Guest guest,RoomBooking bookingInfo);
	public void checkOutGuest(Guest guest,RoomBooking bookingInfo);
}


enum AccountStatus{
	ACTIVE,
	BLOCKED,
	CLOSED
}

class HouseKeeper extends Person{
	List<Room> getRoomServiced(Date date);
}

class Admin extends Person{
	addRoom(Room roomDetail);
	deleteRoom(String roomId);
	editRoom(Room roomDetail);
}

class Search{
	public List<Room> searchRoom(RoomType roomType,Date startDate,int duration);
}

class Booking{
	public RoomBooking createBooking(Guest info);
	public RoomBooking cancelBooking(int bookingId);
}

class RoomBooking{
	String bookingId;
	Date startDate;
	Int duration;
	BookingStatus status;
	List<Room> rooms;
	List<Guest> guests;
	BaseRoomCharge totalRoomCharge;
}

enum BookingStatus{
	COMPLETED,
	PENDING,
	CANCELLED,
	RESERVED
}

interface BaseRoomCharge{
	Double getCost();
}


class RoomCharge implements BaseRoomCharge{
	Double cost;

	Double getCost(){
		return cost;
	}

	void setCost(Double cost){
		this.cost = cost;
	}
}

class RoomServiceCharge implements BaseRoomCharge{

	Double cost;
	BaseRoomCharge baseRoomCharge;

	Double getCost(){
		baseRoomCharge.setCost(baseRoomCharge.getCost() + cost);
		return baseRoomCharge.getCost();
	}

	void setCost(Double cost){
		this.cost = cost;
	}
}


class InRoomPurchaseCharge implements BaseRoomCharge{

	Double cost;
	BaseRoomCharge baseRoomCharge;

	Double getCost(){
		baseRoomCharge.setCost(baseRoomCharge.getCost() + cost);
		return baseRoomCharge.getCost();
	} 

	void setCost(Double cost){
		this.cost = cost;
	}
}



