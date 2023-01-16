package com.yedam.java;

public class Product {
	// 상품의 정보를 담는 클래스 / 3개의 멤버

	// 필드 - 해당 클래스가 가지는 모든 정보
	private String proName; // 상품명
	private int proPrice; // 상품가격
	// 생성자 - 인스턴스를 생성할 때 필요한 프로세스를 담은 메소드

	public Product(String proName, int proPrice) {
		this.proName = proName;
		this.proPrice = proPrice;
	}

	// 메소드 - 해당 클래스가 가지는 모든 기능
	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public int getProPrice() {
		return proPrice;
	}

	public void setProPrice(int proPrice) {
		this.proPrice = proPrice;
	}

}
