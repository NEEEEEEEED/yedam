package test02;

public class DGBCard extends Card {
	public String company = "대구은행";
	public String cardStaff;

	public DGBCard(String cardNo, String validDate, String cvc, String cardStaff) {
		super(cardNo, validDate, cvc);
		this.cardStaff = cardStaff;
	}

	@Override
	public void showCardInfo() {
		System.out.printf("카드정보 (Card NO : %s, 유효기간 : %s, CVC : %s\n담당직원 - %s, %s\n", cardNo, validDate, cvc, cardStaff,
				company);
	}

}
