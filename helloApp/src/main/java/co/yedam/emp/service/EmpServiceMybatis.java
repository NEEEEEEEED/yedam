package co.yedam.emp.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import co.yedam.common.DataSource;
import co.yedam.emp.vo.EmpVO;

//EmpServiceImpl : jdbc
//EmpServiceMybatis : mybatis
public class EmpServiceMybatis implements EmpService {

	SqlSessionFactory sessionFactory = DataSource.getInstance();
	SqlSession session = sessionFactory.openSession();
	
	@Override
	public List<EmpVO> empList() {
		//session 객체가 mapper파일dmf 활용
		return session.selectList("co.yedam.emp.mapper.EmpMapper.empList");
	}

	@Override
	public int addEmp(EmpVO emp) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public EmpVO getEmp(int empId) {
		return session.selectOne("co.yedam.emp.mapper.EmpMapper.getEmp", empId);
	}

	@Override
	public int modEmp(EmpVO emp) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Map<String, String> jobList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int removeEmp(EmpVO empid) {
		// TODO Auto-generated method stub
		return 0;
	}

}
