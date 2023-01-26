package com.yedam;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class EmpMain {
	Scanner sc = new Scanner(System.in);
	EmpDAO dao = new EmpDAO();

	public void exe() {

		while (true) {
			menu();
			int menu = sc.nextInt();

			if (menu == 5) {
				empDel();
			} else if (menu == 4) { // 사원번호, 급여 입력 updateEmp(int id, int sal)
				empUpt();
			} else if (menu == 3) {
				empInsert();
			} else if (menu == 2) {
				oneEmp();
			} else if (menu == 1) {
				searchEmp();
			} else if (menu == 0) {
				System.out.println("종료합니다.");
				break;
			}
		}
		System.out.println("end of program.");

		// 전체조회. (List, Map 사용
//		List<Map<String, Object>> result = dao.empList();
//		for(Map<String, Object> map : result) {
//			System.out.println("사원번호 : " + map.get("emp_id")+
//					", 이름 : " + map.get("first_name")+" "+map.get("last_name"));
//		}

	}

	private void menu() {
		System.out.println("1. 전체조회 | 2. 단건조회 | 3. 입력 | 4. 급여변경 | 5. 삭제 | 0.종료");
	}

	public void searchEmp() {
		// 전체조회
		List<EmpVO> list = dao.empVoList();
		for (EmpVO emp : list) {
			System.out.println(emp.toString());
		}

	}

	public void oneEmp() {
		// 단건조회
		System.out.println("조회할 사원번호> ");
		int id = sc.nextInt();

		EmpVO emp = dao.getEmp(id);
		if (emp == null) {
			System.out.println("조회된 정보 없음!!");
			return;
		}
		System.out.println("결과:" + emp);

	}

	public void empInsert() {
		// 입력 사번,last_name,email,입사일자,직무

		System.out.println("사번입력> ");
		int eid = sc.nextInt();
		sc.nextLine();

		System.out.println("이름입력> ");
		String name = sc.nextLine();

		System.out.println("이메일> ");
		String mail = sc.nextLine();

		System.out.println("입사일자> ");
		String hDate = sc.nextLine();

		System.out.println("직무> ");
		String job = sc.nextLine();

		EmpVO vo = new EmpVO();
		vo.setEmployeeId(eid);
		vo.setLastName(name);
		vo.setEmail(mail);
		vo.setHireDate(hDate);
		vo.setJobId(job);

		if (dao.addEmp(vo) > 0) {
			System.out.println("입력 성공");
		} else {
			System.out.println("처리중 에러");
		}

	}

	public void empUpt() {
		System.out.println("사번입력> ");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.println("급여입력> ");
		int sal = sc.nextInt();

		if (dao.updateEmp(id, sal) > 0) {
			System.out.println("수정 성공");
		} else {
			System.out.println("처리중 에러");
		}

	}

	public void empDel() {
		System.out.println("사번입력> ");
		int id = sc.nextInt();

		if (dao.deleteEmp(id) > 0) {
			System.out.println("삭제 성공");
		} else {
			System.out.println("처리중 에러");
		}

	}
}
