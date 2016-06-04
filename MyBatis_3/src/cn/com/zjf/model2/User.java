package cn.com.zjf.model2;

public class User {
	private Integer id;
	private String userName;
	private String userSex;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserSex() {
		return userSex;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	public User(Integer id, String userName, String userSex) {
		super();
		this.id = id;
		this.userName = userName;
		this.userSex = userSex;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String userName, String userSex) {
		super();
		this.userName = userName;
		this.userSex = userSex;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", userSex=" + userSex + "]";
	}
	
	
}
