/*

UML
---

Actors
-------

Passenger - book tickets to travel , schedule , reserve , cancel flight
Admin - add/rm flightDetails
FrontDeskOfficer - reserve/cancel flight
Pilot/Crew - can view assigned fights
System - notifications, iternity changes , flight status updates

Use cases
------------

search flights for given date and time and source and destination
create/modify/view reservation (frontdesk,customer)
assign seats to passenger (admin)
make payment for reservation (customer)
update flight schedule (admin)
assign pilots and crew (admin)


components
-----------

Airline
Airport
Aircraft
Flight
FlightInstance
FLightReservaton
Passengers
Iterninty
Payment

*/




enum FlightStatus{
	ACTIVE,
	DELAYED,
	SCHEDULED,
	CANCELLED,
	DIVERTED,
	LANDED,
	IN_AIR,
	DEPARTED
}

enum PaymentStatus{
	UNPAID,
	PAID,
	CANCELLED,
	DECLINED,
	ABANDONED,
	PENDING
}


enum ReservationStatus{
	REQUESTED,
	PENDING,
	CONFIRMED,
	CANCELLED,
	ABANDONED
}

enum SeatType{
	REGULER,
	EMERGENCY_EXIT,
}

enum SeatClass{
	BUISNESS,
	ECONOMY,
	ECONOMY_PLUS,
	FIRST_CLASS
}

enum AccountStatus{
	ACTIVE,
	CANCEELD,
	BLOCKED,
	BLACKLISTED,
	CLOSED
}

class Address{
	private String street;
	private String city;
	private String zipcode;
	private String state;
	private String country;
}

class Account {
	private String id;
	private String password;

	AccountStatus status;

	resetPassword();
}

abstract class Person{
	private String name;
	private String email;
	private String phone;
	private Address address;

	Accoun account;

}

class Customer extends Person{
	String frequentFlyerNumber;
	List<Iternity> getIternityList();
}

class Passenger{
	private String name;
	private String passportNumber;
	private Date dob;

	getPassportNumber();
}

class Airport{
	private String name;
	private String code;
	private Address address;

	List<Flight> getFlights();
}

class Aircreaft{
	private String name;
	private String model;
	private int manufacturingYear;
	private List<Seat> seats;

	List<FlightInstance> getFlights();
}

class Seat{
	private String seatNumber;
	private SeatType type;
	private SeatClass class;

}

class FlightSeat extends Seat{
	double fare;

	public double getFare();
}

class Fight{
	String flightNumber;
	Airport departure;
	Airport arrival;
	private int dutationInMinutes;

	List<FlightInstance> flightInstances;
	List<WeekSchedule> weeklySchedle;
	List<CustomSchedule> customSchedule;
}

class FLightInstances{
	Date departureTime;
	int gateNo;
	FlightStatus status;
	Aircreaft aircraft;

	boolean cancel();
	List<Passengers> updateStatus(FlightStatus status);
}

class WeekSchedule{
	Date weekDate;
	Time departureTime;
}

class CustomSchedule{
	Date customDate;
	Time departureTime;
}

class FlightReservation{
	String reservationNumber;
	FlightInstance flight;
	Map<Passengers,Seat> seatMap;
	Date creationDate;
	ReservationStatus status;

	getReservationDetails();
	List<Passenger> getPassengers()
}

class Iternity{
	String customerId;
	Airport startingAirport;
	Airport finalAirport;
	Date creationDate;
	List<FlightReservation> reservations;

	getReservations();
	makeReservation();
	makePayment()

}










