package com.example.demo;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin // Spring支持的跨域注解
public class TestController {
	@GetMapping("get1")
	private ResultBean get1() {
		System.out.println("TestController.get1()");
		return new ResultBean("get1 ok");
	}

	@PostMapping("/postJson")
	public ResultBean postJson(@RequestBody User user) {
		System.out.println("TestController.postJson()");
		return new ResultBean("postJson " + user.getName());
	}

	@GetMapping("/getCookie")
	public ResultBean getCookie(@CookieValue("cookie1") String cookie1) {
		System.out.println("TestController.getCookie()");
		return new ResultBean("getCookie " + cookie1);
	}

	@GetMapping("/getHeader")
	public ResultBean getHeader(@RequestHeader("x-header1") String header1,
			@RequestHeader("x-header2") String header2) {
		System.out.println("TestController.getHeader()");
		return new ResultBean("getHeader " + header1 + " " + header2);
	}
}
