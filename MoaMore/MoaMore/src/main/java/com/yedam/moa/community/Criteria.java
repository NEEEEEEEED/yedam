package com.yedam.moa.community;

// 페이지 자체를 관리하는 객체로 페이지당 보여줄 개수를 담당한다
public class Criteria {
	
	
    private int page; // 현재 페이지 번호
    private int perPageNum; // 페이지당 보여줄 게시글의 개수
    private String id;
    public int getPageStart() {
        // 특정 페이지의 범위를 정하는 구간, 현재 페이지의 게시글 시작 번호
        // 0 ~ 10 , 10 ~ 20 이런식으로
        return (this.page -1) * perPageNum;
    }
    public String getId() {
    	return id;
    }
    public void setId(String id) {
    	this.id = id;
    }
 
    public Criteria() {
        // 기본 생성자 : 최초 게시판에 진입시 필요한 기본값
        this.page = 1;
        this.perPageNum = 5;
    }
 
    // 현재 페이지 번호 page : getter, setter
    public int getPage() {
        return page;
    }
 
    public void setPage(int page) {
        if(page <= 0) {
            this.page = 1;
            
        } else {
            this.page = page;
        }    
    }
 
    
    // 페이지당 보여줄 게시글의 개수 perPageNum : getter, setter
    public int getPerPageNum() {
        return perPageNum;
    }
 
    public void setPerPageNum(int perPageNum) {
        int cnt = this.perPageNum;
        
        if(perPageNum != cnt) {
            this.perPageNum = cnt;    
        } else {
            this.perPageNum = perPageNum;
        }
        
    }
    
    @Override
    public String toString() {
        return "Criteria [page=" + page + ", perPageNum=" + perPageNum + "]";
    }
    
}
