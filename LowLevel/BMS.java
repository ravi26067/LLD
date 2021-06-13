class BMSService{
	List<CinemaHall> cinemas;

	List<Movie> getMovies(Date date,String city);
	List<CinemaHall> getCinemaHalls(String city);
}

public class CinemaHall{
	String cinemaHallId;
	String cinemaHallName;
	Address address;

	List<Audi> audiList;

	public Map<Date,Movie> getMovies(List<Date> dateList);
	public Map<Date,Show> getShows(List<Date> dateList);
}

public class Address{
	private String street;
	private String city;
	private String zipcode;
	private String state;
}

public class Audi{
	String id;
	String name;
	int totalSeats;
	List<Shows> shows;


}

public class Show{
	String showId;
	Date startTime;
	Date endTime;
	Movie movie;
	CinemaHall cinemaPlayedAt;	
	List<Seat> seats;
}


public class Seat{
	String seatId;
	SeatType type;
	SeatStatus status;
	double price;
}

enum SeatType{
	DELUXE,
	VIP,
	ECONOMY,
	OTHER
}

enum SeatStatus{
	AVAILABLE,
	BOOKED,
	RESERVED,
	NOT_AVAILABLE
}

public class Movie{
	String id;
	String name;
	String description;
	int durationInMins
	Genre genre;
	Date releaseDate;

}



enum Genre{
	SCI_FI,
	ROM_COM,
	ACTION,
	HORROR
}

public class User{
	String uid;
	Search searchObj;
}

public class Account{
	username;
	password;

	public boolean resetPassword();
}

public class SystemMember{
	Account account;
	String name;
	String email;
	String phone;

}

public class Member extends SystemMember{

	public boolean makeBooking(Booking booking);
	public List<Booking> getBookings();
}

public class Admin extends SystemMember{
	public boolean addMovie(Movie movie);
	public boolean addShows(Show show);
}

public class Search{
	public List<Movie> searchByName(String name);
	public List<Movie> searchByCity(String city);
	public List<Movie> searchByReleaseDate(Date date);
	public List<Movie> searchByLanguage(String language);
}

enum BookingStatus{
	CONFIRMED,
	RESERVED,
	PENDING,
	CANCELLED,

}

public class Booking{
	String id;
	Date bookingDate;
	Audi audi;
	Show show;
	Member member;
	List<Seat> seats;
	BookingStatus bookingStatus;
	Payment paymentObj;
}

public class Payment{
	double amount;
	String transactionId;
	Date paymentDate;
	PaymentStatus status;
}

enum PaymentStatus{
	UNPAID,
	PENDING,
	COMPLETED,
	DECLINED,
	CANCELLED
}
