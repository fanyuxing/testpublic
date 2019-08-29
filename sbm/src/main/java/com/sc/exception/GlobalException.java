package com.sc.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class GlobalException implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2,
			Exception arg3) {
		System.out.println(arg3);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:../img/error1.jpg");
		return modelAndView;
	}

}
