package DTO;

public class MemberDTO {
	
	private String id;
	private String pwd;
	private String name;
	private String emai;
	private int orderCount;
	private int auth;	// 사용자인지 관리자인지 판단하는 변수 
	
	public MemberDTO() {
		
	}


	
	public MemberDTO(String id, String pwd, String name, String emai, int orderCount, int auth) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.emai = emai;
		this.orderCount = orderCount;
		this.auth = auth;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmai() {
		return emai;
	}

	public void setEmai(String emai) {
		this.emai = emai;
	}

	public int getAuth() {
		return auth;
	}

	public void setAuth(int auth) {
		this.auth = auth;
	}



	public int getOrderCount() {
		return orderCount;
	}



	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}



	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", pwd=" + pwd + ", name=" + name + ", emai=" + emai + ", orderCount="
				+ orderCount + ", auth=" + auth + "]";
	}
	
	
	
	
}
