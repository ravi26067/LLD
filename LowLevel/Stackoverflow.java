"List of Api's"

get /search

get /question/{qid}

post /question

post /question/{qid}/answer

post /answer/{aid}

post /question/{qid}/addflag

post /answer/{aid}/addglag

put /question/{qid}

put /answer/{aid}

delete /question/{qid}

delete /answer/{aid}

get /{uid}/details

post /question/{qid}/upvote

post /question/{qid}/downvote

post /answer/{aid}/upvote

post /answer/{aid}/downvote


"Classes"

public enum AccountStatus{
	ACTIVE,
	BLOCKED,
	BLACKLISTED,
	CLOSDED
}

public enum QuestionStatus{
	OPEN,CLOSED,ON_HOLD,DELETED
}

public enum QuestionClosingRemark{
	DUPLICATE,
	OFF_TOPIC,
	TOO_BORED,
	NOT_USEFUL,
	TOO_SIMPLE
}

public class User{
	private String id;
	private String name;
	private String email;
	private String phoneno;
	private Address address;
}

public class Address{
	private String street;
	private String city;
	private String country;
	private String pincode;
}

public class Account extends User{
	private String username;
	private String password;
	private AccountStatus status;
	private Integer reputation;

	public boolean resetPassword();
}

public class Member extends Account{
	Account account;
	List<Badges> badges;

	public int getReputation();
	public boolean postQuestion(Question question);
	public boolean addTags(Tags tag);
	public String getEmail();
}

public class Admin{
	private boolean blockMember(Member member);
	private boolean unblockMember(Member member);
}

public class Moderator{
	private boolean closeQuestion(Question question);
	private boolean undeleteQuestion(Question question);
}

public class Photos{
	private String id;
	private String name;
	private String path;
	private Date creationTime;
	private Member member;

	public boolean delete();
}

public class Bounty{
	private String id;
	Date expiry;

	boolean updateReutation(int reputation);
} 

public interface Search{
	public static List<Question> searchQuestion();
}

public class Question{
	String title;
	String description;
	Member askingMember;
	List<Photos> photos;
	List<Answer> answers;
	List<Comment> comments;
	Bounty bounty;
	Integer viewCount;
	Integer voteCount;
	Date creationTime;
	Date updateTime;
	QuestionStatus status;
	QuestionClosingRemark remark;

	public boolean addComment(Comment comment);
	public boolean addBounty(Bounty bounty);
	public boolean increaseVote();
	public boolean addAnswer(Answer answer);

	public static List<Question> searchQuestion();

}

class Comment{
	private String commentText;
	private Member member;
	private Date creationTime;
	private Date updateTime;
	private Integer voteCount;
	private Integer flagCount;

	public boolean increaseVote();
	public boolean increaseFlagCount();

}

public class Tags{
	private String name;
	private String description;
	private Long dailyCount;
	private Long weeklyCount;
}

public class Answer{
	private String answerText;
	private String description;
	private Member member;
	private List<Photos> photos;
	private List<Comment> comments;
	private Integer voteCount;
	private Integer flagCount;
	private Date creationTime;
	private Date updateTime;

	public boolean addComment();
	public boolean increaseVote();
	public boolean increaseFlagCount();
}

public class SOFService{
	private Map<String,Question> questions;
	private Map<String,Answer> questions;
	private List<Member> members;

	postQuestion(String userid, Question question, Tags tag, Bounty bounty);
	addAnswer(String userid, String questionId);
	addComment(String userid, String questionid, String answerId, Comment comment);
	updateQuestion(Question question, Tags tag, Bounty bounty);
	updateAnswer(Answer answer, String questionId);
	updateComment(String userid, String questionid, String answerId, Comment comment);
	searchQuestion(String text);

	//for moderators
	closeQuestion(Question question);
	undeleteQuestion(Question question);

	//for admin
	blockAccount(Member member);
	activateAccount(Member member);

}


