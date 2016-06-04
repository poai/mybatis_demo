package cn.com.zjf.model;

public class Order {

	private Integer id;
	private String info;
	private Float  price;
	
	/*订单所属的用户*/
	private User user;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", info=" + info + ", price=" + price + ", user=" + user + "]";
	}
	
	public Order() {
		// TODO Auto-generated constructor stub
	}

	public Order(Integer id, String info, Float price, User user) {
		super();
		this.id = id;
		this.info = info;
		this.price = price;
		this.user = user;
	}

	public Order(String info, Float price, User user) {
		super();
		this.info = info;
		this.price = price;
		this.user = user;
	}
	
}
