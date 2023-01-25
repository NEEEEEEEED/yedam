package com.yedam.review;

import java.util.List;

public class Lotto {
	
	//클래스로 사용할 경우
	private List<int[]> lottoNo;
	private String name;



	public List<int[]> getLottoNo() {
		return lottoNo;
	}

	public void setLottoNo(List<int[]> lottoNo) {
		if(this.lottoNo == null) {
			this.lottoNo = lottoNo;			
		} else {
			this.lottoNo.add(lottoNo.get(0));
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
