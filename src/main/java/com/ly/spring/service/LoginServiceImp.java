package com.ly.spring.service;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImp implements LoginService {

	@Override
	public Integer tologin(String usr, String pwd) {
		// TODO Auto-generated method stub
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(usr,pwd);
		try {
			subject.login(token);
			return 1;
		} catch (UnknownAccountException e) {
			// TODO: handle exception登录失败 ：用户不存在
			return 0;
		}catch (IncorrectCredentialsException e) {
			// TODO: handle exception密码错误
			return 2;
		}
		
	}

}
