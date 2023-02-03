package co.yedam.emp.service;

import java.util.List;

import co.yedam.emp.dao.EmpDAO;
import co.yedam.emp.vo.EmpVO;

public class EmpServiceImpl implements EmpService {
	//jdbc활용 db처리.
	EmpDAO dao = EmpDAO.getInstance();
	
	@Override
	public List<EmpVO> empList() {	
		return dao.empList();
	}

	@Override
	public int addEmp(EmpVO emp) {
		return dao.insertEmp(emp);
		
	}

	@Override
	public EmpVO getEmp(int empId) {
		return dao.searchEmp(empId);
	}

	@Override
	public int modEmp(EmpVO emp) {
		return dao.updateEmp(emp);
	}
}
