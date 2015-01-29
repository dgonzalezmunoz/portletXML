package com.web.handlers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Handler {
	public  String  processor(HttpServletRequest request, HttpServletResponse response );

}
