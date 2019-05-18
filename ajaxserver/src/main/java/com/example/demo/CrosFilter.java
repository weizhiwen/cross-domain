package com.example.demo;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;

public class CrosFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse res = (HttpServletResponse) response;
		HttpServletRequest req = (HttpServletRequest) request;

		String origin = req.getHeader("Origin");
		if (!StringUtils.isEmpty(origin)) {
			// 支持所有域名访问，带 Cookie 的跨域请求头字段设置
			res.addHeader("Access-Control-Allow-Origin", origin);
		}

		res.addHeader("Access-Control-Allow-Methods", "*");

		// 非简单请求通过预检命令请求头字段设置，注意这里request和response中的header字段名称并不一样
		String headers = req.getHeader("Access-Control-Request-Headers");
		System.out.println(headers);
		if (!StringUtils.isEmpty(headers)) {
			// 支持所有的自定义请求头
			res.addHeader("Access-Control-Allow-Headers", headers);
		}
//		res.addHeader("Access-Control-Allow-Headers", "content-type, x-header1, x-header2");
		res.addHeader("Access-Control-Max-Age", "3600");

		// 带 Cookie 的跨域请求头字段设置，
		// 且 Access-Control-Allow-Origin 字段必须是全匹配，不能使用 * 号
		res.addHeader("Access-Control-Allow-Credentials", "true");

		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {

	}

}
