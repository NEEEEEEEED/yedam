package com.yedam.moa.admin.web;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.moa.admin.service.AdminService;
import com.yedam.moa.admin.service.PostListVO;
import com.yedam.moa.comm.CommVO;
import com.yedam.moa.comm.service.Impl.CommServiceImpl;
import com.yedam.moa.mem.MemVO;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
public class AdminController {

	@Autowired
	AdminService adminService;

	@Autowired
	CommServiceImpl comm;

	@GetMapping("/getCommonCode")
	@ResponseBody
	public Map<String, List<CommVO>> getCommonCode() {
		return comm.getCodes("I");
	}

	@GetMapping("/admin")
	public String job() {
		return "admin/dashboard";
	}

	@GetMapping("/member/common")
	public String commonMember() {
		return "admin/commonMember";
	}

	@GetMapping("/getUserInfo")
	@ResponseBody
	public List<MemVO> getUserInfo() {
		return adminService.getUserInfo();
	}

	@PostMapping("/getUserDetail")
	@ResponseBody
	public MemVO getUserDetails(@RequestBody String email) {
		//인코딩된 이메일을 디코딩하는 부분
		String decoded = null;
		try {
			decoded = URLDecoder.decode(email, "UTF-8");
			decoded = decoded.substring(0, URLDecoder.decode(email, "UTF-8").length()-1);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return adminService.getUserDetails(decoded);
	}
	
	@PostMapping("/modifyUser")
	@ResponseBody
	public String modifyUser(@RequestBody MemVO memVo) {
		//인코딩된 이메일을 디코딩하는 부분
		System.out.println(memVo);
		return adminService.modifyUser(memVo);
	}

	@PostMapping("/getUserPost")
	@ResponseBody
	public Map<String, List<PostListVO>> getUserPost(@RequestParam String id) {
		System.out.println(id);
		return adminService.getUserPost(id);
	}
}
