package co.yedam.emp.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import co.yedam.common.DataSource;
import co.yedam.emp.vo.EmpVO;
import co.yedam.member.mapper.MemberMapper;

//EmpServiceImpl : jdbc
//EmpServiceMybatis : mybatis
public class EmpServiceMybatis implements EmpService {
	//mybatis 사용을 위한 필수요소
	SqlSessionFactory sessionFactory = DataSource.getInstance();
	SqlSession session = sessionFactory.openSession(); //true => 자동 커밋;
	
	@Override
	public List<EmpVO> empList() {
		//session 객체가 mapper파일dmf 활용
		return session.selectList("co.yedam.emp.mapper.EmpMapper.empList");
	}

	@Override
	public int addEmp(EmpVO emp) {
		int r = session.insert("co.yedam.emp.mapper.EmpMapper.addEmp",emp);
		if(r>0) {
			session.commit();
		} else {
			session.rollback();
		}
		return r;
	}

	@Override
	public EmpVO getEmp(int empId) {
		return session.selectOne("co.yedam.emp.mapper.EmpMapper.getEmp", empId);
	}

	@Override
	public int modEmp(EmpVO emp) {
		int r = session.update("co.yedam.emp.mapper.EmpMapper.modEmp",emp);
		if(r>0) {
			session.commit();
		} else {
			session.rollback();
		}
		return r;
	}

	@Override
	public Map<String, String> jobList() {
		return  session.selectMap("co.yedam.emp.mapper.EmpMapper.jobList","jobs");
	}

	@Override
	public int removeEmp(int id) {
		int r = session.delete("co.yedam.emp.mapper.EmpMapper.removeEmp",id);
		if(r>0) {
			session.commit();
		} else {
			session.rollback();
		}
		return r;
	}

}
