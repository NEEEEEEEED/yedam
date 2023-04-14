package com.yedam.spring.production.service;

import java.util.List;

import com.yedam.spring.common.Criteria;

public interface ProService {
	
	//생산계획 등록
	public String newPlanInsert(ProPlanVO proPlanArray);

	public List<OrderSheetVO> getOrdSheet();

	public List<BomVO> getBomInfo();
	
	public List<BomVO> getBomInfo(BomVO vo);

	public List<BomVO> getBomRscInfo(BomVO vo);

	public int getProPlanCnt();

	public List<ProPlanVO> getProPlans(Criteria cri);

	public String removePlan(String planCd);

	public String modifyProPlan(ProPlanVO vo);

	public List<OrderSheetVO> getprdtInfo();

	public List<ProPrcsVO> getprcsList(Criteria cri);

	public String addPrcs(ProPrcsVO vo);

	public String removePrcs(String prcsCd);

	public List<ProOrderVO> getProOrders(Criteria cri);

	public int getProOrderCnt();

	public List<ProPlanVO> getPlanToOrder();

	public List<BomVO> getBomStock(BomVO vo);

	public String plusPlanInsert(ProPlanVO proPlanVO);

	public List<BomVO> getRscStock(String edctsCd);

	public String modifyOrderStatus(String orderNo);

	public int getProPlanCnt(ProPlanVO vo);

	public List<ProPrcsVO> getPrcsFlow(ProPrcsVO vo);

	public List<ProPlanVO> getPlanDetail(ProPlanVO vo);

	public String checkOrderNo(String planCd);




	

}
