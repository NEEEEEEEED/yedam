package HW01_16.book;

public class ShopService {
	//싱글톤 메소드
	static ShopService instance = new ShopService();
	
	static ShopService getInstance() {
		return instance;
	}
}
