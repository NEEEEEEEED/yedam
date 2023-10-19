package test03;

public class SimplePayment implements Payment {
	public double simplePaymentRatio;
	
	public SimplePayment(double simplePaymentRatio) {
		this.simplePaymentRatio = simplePaymentRatio;
		System.out.println("*** 간편결제 시 할인정보");
	}
	

	@Override
	public int online(int price) {
		price = (int)(price - (price*(simplePaymentRatio+ONLINE_PAYMENT_RATIO)));
		return price;
	}

	@Override
	public int offline(int price) {
		price = (int)(price - (price*(simplePaymentRatio+OFFLINE_PAYMENT_RATIO)));
		return price;
	}

	@Override
	public void showInfo() {
		System.out.println("온라인 결제시 총 할인율 : "+(simplePaymentRatio+ONLINE_PAYMENT_RATIO));
		System.out.println("오프라인 결제시 총 할인율 : "+(simplePaymentRatio+OFFLINE_PAYMENT_RATIO));


	}

}
