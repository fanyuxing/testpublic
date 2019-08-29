package com.sc.realm;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

public class CustomFormAuthentiCationFilter extends FormAuthenticationFilter {
	
	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws java.lang.Exception{
		System.out.println("�������Զ����������");
		//��ȡ����session�����֤���
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		String validateCode = (String)session.getAttribute("validateCode");
		
		//ȡ��ҳ�����֤�벢�Ա�
		String randomcode = req.getParameter("randomcode");
		if(randomcode != null && validateCode != null && !randomcode.equals(validateCode)){
			req.setAttribute("shiroLoginFailure", "randomCode");//����ʧ����Ϣ
			return true;//�ܾ����ʣ����ص�¼
		}
		return super.onAccessDenied(request, response);
	}
}
