package DTO;

public class CoffeeOrderDTO {
	
	private int orderCount;
	private String userId;
	private String coffeeName;
	private String WDATE;
	private int syrup;
	private int whipping;
	private int shot;
	private String Size;
	private int coffeeCount;
	private int total;
	
	public CoffeeOrderDTO() {
	}
	
	public CoffeeOrderDTO(int orderCount, String userId, String coffeeName, String wDATE, int syrup, String size,
			int whiping, int shot, int coffeeCount, int total) {
		
		this.orderCount = orderCount;
		this.userId = userId;
		this.coffeeName = coffeeName;
		WDATE = wDATE;
		this.syrup = syrup;
		Size = size;
		this.whipping = whiping;
		this.shot = shot;
		this.coffeeCount = coffeeCount;
		this.total = total;
	}





	public int getOrderCount() {
		return orderCount;
	}

	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCoffeeName() {
		return coffeeName;
	}

	public void setCoffeeName(String coffeeName) {
		this.coffeeName = coffeeName;
	}

	public String getWDATE() {
		return WDATE;
	}

	public void setWDATE(String wDATE) {
		WDATE = wDATE;
	}

	public int getSyrup() {
		return syrup;
	}

	public void setSyrup(int syrup) {
		this.syrup = syrup;
	}

	public String getSize() {
		return Size;
	}

	public void setSize(String size) {
		Size = size;
	}

	public int getCoffeeCount() {
		return coffeeCount;
	}

	public void setCoffeeCount(int coffeeCount) {
		this.coffeeCount = coffeeCount;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	public int getShot() {
		return shot;
	}

	public void setShot(int shot) {
		this.shot = shot;
	}
	
	public int getWhipping() {
		return whipping;
	}

	public void setWhipping(int whipping) {
		this.whipping = whipping;
	}

	@Override
	public String toString() {
		return "CoffeeOrderDTO [orderCount=" + orderCount + ", userId=" + userId + ", coffeeName=" + coffeeName
				+ ", WDATE=" + WDATE + ", syrup=" + syrup + ", whipping=" + whipping + ", shot=" + shot + ", Size="
				+ Size + ", coffeeCount=" + coffeeCount + ", total=" + total + "]";
	}


	
	
	
}
