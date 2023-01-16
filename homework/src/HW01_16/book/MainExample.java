package HW01_16.book;

public class MainExample {

	public static void main(String[] args) {
		//MemberServics
				MemberService memberService = new MemberService();
				boolean result = memberService.login("hong", "12345");
				if(result) {
					System.out.println("로그인 되었습니다.");
					memberService.logout("hong");
				}else {
					System.out.println("id 또는 password가 올바르지 않습니다.");
				}
				
				//Printer
				Printer printer = new Printer();
				printer.println(10);
				printer.println(true);
				printer.println(5.7);
				printer.println("홍길동");
				
				//SingleTon
				ShopService obj1 = ShopService.getInstance();
				ShopService obj2 = ShopService.getInstance();
				
				if(obj1 == obj2) {
					System.out.println("같은 ShopService 객체입니다.");
				}else {
					System.out.println("다른 ShopService 객체입니다.");
				}
	}

}
