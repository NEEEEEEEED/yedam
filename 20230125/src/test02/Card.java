package test02;

public class Card {
	public String cardNo;
	public String validDate;
	public String cvc;
	
	public Card(String cardNo, String validDate, String cvc) {
		this.cardNo = cardNo;
		this.validDate = validDate;
		this.cvc = cvc;
	}

	public String getCardNo() {
		return cardNo;
	}

	public String getValidDate() {
		return validDate;
	}

	public String getCvc() {
		return cvc;
	}
	
	public void showCardInfo() {
		System.out.printf("카드정보 ( Card NO : %s, 유효기간 : %s, CVC : %s\n",cardNo,validDate,cvc);
	}

	
	
	
	
	
}
