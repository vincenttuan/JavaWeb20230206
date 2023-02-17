package spa.dao;

import java.util.ArrayList;
import java.util.List;

import spa.entity.Master;
import spa.entity.Order;
import spa.entity.Spa;

public class SpaDao {
	// 資料庫
	private static List<Spa> spaList;
	private static List<Master> masterList;
	private static List<Order> orderList;
	
	static {
		spaList = List.of(
				new Spa(1, "SPA", "", 90, 1500),
				new Spa(2, "推拿", "", 60, 1000),
				new Spa(3, "足底按摩", "", 30, 600),
				new Spa(4, "指壓", "", 60, 1200),
				new Spa(5, "油壓", "", 60, 1380),
				new Spa(6, "泰式按摩", "", 90, 1680)
		);
		masterList = List.of(
				new Master(101, "John"), new Master(102, "Mary"), new Master(103, "Bob")
		);
		orderList = new ArrayList<>();
	}
	
	public List<Spa> queryAllSpas() { // 查詢所有 SPA 服務項目
		return spaList;
	}
	
	public List<Master> queryAllMasters() { // 查詢所有按摩師傅
		return masterList;
	}
	
	
	
	
	
}
