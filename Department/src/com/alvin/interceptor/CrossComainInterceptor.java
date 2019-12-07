package com.alvin.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alvin.action.BaseAction;
import com.alvin.common.CodeResult;

import net.sf.json.JSONObject;

/**
 * 跨域拦截器
 * @author Alvin
 *
 */
public class CrossComainInterceptor extends BaseAction implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		String Referer=request.getHeader("Referer");
		if (Referer==null||Referer.indexOf("swagger-ui")>0) {
			return true;
		}
		crossComain(response, request);
		 
		if (Referer.indexOf("login")<0&&getAdmin(request)==null) {
			jsonObj=new JSONObject();
			CodeResult.setResult(jsonObj, 100);
			super.out(response, jsonObj);
			return false;
		}
		return true;
	}

}
