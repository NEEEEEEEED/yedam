package test02;

public class TossCard extends Card {
	public String company = "Toss";
	public String cardStaff;

	public TossCard(String cardNo, String validDate, String cvc, String cardStaff) {
		super(cardNo, validDate, cvc);
		this.cardStaff = cardStaff;
	}

	@Override
	public void showCardInfo() {
		System.out.printf("카드정보 - Card NO, %s\n담당직원 - %s, %s\n", cardNo, cardStaff, company);
	}

}
