package co.yedam.emp.vo;

import javax.websocket.server.ServerEndpoint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//@Getter 
//@Setter 
//@AllArgsConstructor //생성자
//@ToString
@Data //어지간한거 다 있음
public class EmpVO {
	private int employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String jobId;
	private String hireDate;

}
