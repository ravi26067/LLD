/*
UML
------
Admin - trackofTeams
		 trackofMatches
		 show live commentry
		 recordStatus of matches,tournaments and players



Actors
----------
Admin - addMatch(ODI,T20,TEST),
		addTeams,
		addTournament,
		addStadium,
		addUmpire,
		addRefree,
		addNews
		addInnings,
		addOver,
		addBall
		addPlayer,
		addSquad,
		addPlaying11,
		addContract

Commentator - addCommentry()

Viwers - viewCommentry()



Components
------------
Team
Tournamant
Stadium
Player
Playing11
PlayingSquad
Match (ODI,T20,TEST)
Innings
Over
Ball
Commentator
PointsTable


*/


public class Tournamant{
	String name;
	Address address;
	List<Match> matches;
	List<Team> teams;

}

public class Match{
	List<Innings> innings;
	Team[] teams;
	MatchFormat format;
	MatchResult result;
	Date startTime;
	Integer oversCount;
	Rules rules;
	List<Umpire> umpires;
	List<Commentator> commentator;

	public Integer getRuns(Team team);
	public Team getWinner();
	public Player getManOfTheMatch();
	public boolean assingStadium(Stadium stadium);
	public boolean assingUmpire(Umpire umpire);
}

public class Odi extends Match{
	
	public void setMatchFormat(){
		format = MatchFormat.ODI;
	}

	public void setOversCount(){
		oversCount = 50;
	}
}

public class T20 extends Match{

	public void setMatchFormat(){
		format = MatchFormat.T20;
	}

	public void setOversCount(){
		oversCount = 20;
	}
}

public class Test extends Match{

	public void setMatchFormat(){
		format = MatchFormat.TEST;
	}
}

public class Innings{
	Integer number;
	Date startTime;
	List<Over> overs;
	
	public boolean addOver();
	public Integer getTotalRunsForTheInnigns();
	public Integer getTotalOversForTheInnings();
}
public class Over{
	List<Balls> 
}
public class Team{
	Integer id;
	String country;
	PlayingSquad playingSqad;
	Playing11 playing11;
}

public class Stadium{
	List<Match> matchVenue;
}

enum BowlType{
	NO_BALL,
	NORMAL,
	WIDE,
	WICKET
}

enum RUNS{
	SINGLE,
	DOUBLE,
}

enum MatchFormat{
	ODI,
	T20,
	TEST
}

enum MatchResult{
	IN_PROGRESS,
	DELAYED,
	CANCELLED,
	COMPLETED,
	DRAW
}

enum WicketType{
	LBW,
	BOLD,
	STUMP_OUT,
	CAUGHT_OUT,
	HIT_WICKET,
	RETIRED_HURT,
	RUN_OUT
}

public class Ball{
	Player facingBall;
	Player bowling;
	Runs runs;
	BowlType type;
	Commentry commentry;
	Wicket wicket;

	public int getRuns();
	public boolean updatePlayerRuns();

}

public class Wicket{
	WicketType type;
	Player playerOut;
	Player caughtBy;
	Player stumpOutBy;
	Player runOutBy;
}

class Address{
	private String street;
	private String city;
	private String country;
	private Integer pincode;
}


public class Person{
	String name;
	String phone;
	Address address;
}

public class Player extends Person{
	Integer jerseyNo;
	Map<MatchFormat,Double> runs;
	Map<MatchFormat,Ball> balls;

	public int getTotalRuns(MatchFormat format);
}



public class Playing11{
	List<Player> players;
	public boolean addPlayer(Player player);
}
public class PlayingSquad{
	List<Player> players;

	public boolean updateContract();
	public boolean addPlayer(Player player);
}

public class Umpire extends Person{
	Double numberOfMatchsAttended;
}

public class Commentator extends Person{

	public boolean addCommentry(Commentry commentry);
}
public class Commentry{
	String text;
	Date createdAt;
	Commentator createdBy;
}
public class PointsTable{
	Map<Team,Integer> matchOutcomes;
}






