package com.yedam.java.ch01_01;

public class DmbCellPhoneExample {

	public static void main(String[] args) {
		//DmbCellPhone 인스턴스
		DmbCellPhone dmbCellPhone = new DmbCellPhone("갤럭시","용달블루",10);

		//CellPhone의 필드
		System.out.println("모델 : " + dmbCellPhone.model);
		System.out.println("색 : " + dmbCellPhone.color);
		
		//DmbCellPhone의 필드
		System.out.println("채널 : " + dmbCellPhone.channel);
		
		//CellPhone의 메소드
		dmbCellPhone.powerOn();
		dmbCellPhone.bell();
		dmbCellPhone.sendVoice("여보세요.");
		dmbCellPhone.receiveVoice("안녕하세요! 저는 홍길동입니다.");
		
		//DmbCellPhone의 메소드
		dmbCellPhone.turnOnDmb();
		
	}

}
