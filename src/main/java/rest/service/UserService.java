package rest.service;

// SingleTon (單例服務)
public class UserService {
	private static UserService _instance = new UserService();
	private UserService() {
		
	}
	public static UserService getUserServiceInstance() {
		return _instance;
	}
	
}
