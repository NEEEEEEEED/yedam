package homework;

public class Item {
	//필드
	String item;
	int price;
	//생성자
	Item() {
			
	}
	//메소드
	void getPrice() {
		System.out.println(item + " : " + price + "원");
	}
}
