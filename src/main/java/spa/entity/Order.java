package spa.entity;

// 預約訂單
public class Order {
	
	private Integer id; // 訂單編號
	private String userName; // 客戶名稱(登入帳號)
	private Integer spaId; // 按摩服務編號
	private Integer spaTime ; // 按摩服務時間
	private Integer spaPrice ; // 按摩服務價格
	private Integer masterId; // 師傅編號
	
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
	public Integer getSpaId() {
		return spaId;
	}
	public void setSpaId(Integer spaId) {
		this.spaId = spaId;
	}
	public Integer getSpaTime() {
		return spaTime;
	}
	public void setSpaTime(Integer spaTime) {
		this.spaTime = spaTime;
	}
	public Integer getSpaPrice() {
		return spaPrice;
	}
	public void setSpaPrice(Integer spaPrice) {
		this.spaPrice = spaPrice;
	}
	public Integer getMasterId() {
		return masterId;
	}
	public void setMasterId(Integer masterId) {
		this.masterId = masterId;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", userName=" + userName + ", spaId=" + spaId + ", spaTime=" + spaTime
				+ ", spaPrice=" + spaPrice + ", masterId=" + masterId + "]";
	}
	
	
	
}