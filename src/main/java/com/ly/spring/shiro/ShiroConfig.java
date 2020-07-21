package com.ly.spring.shiro;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.collections.functors.TruePredicate;
import org.apache.ibatis.annotations.Property;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class ShiroConfig {
	@Bean
	public ShiroFilterFactoryBean getShiroFilterFactoryBean(
			@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		// 安全管理
		shiroFilterFactoryBean.setSecurityManager(securityManager);

		// 内置过滤器 anon:无需认证 authc:必须认证才可访问 user 使用rememberMe的功能可以直接访问 perms 必须得到资源授权 role
		// 必须得到权限授权
		Map<String, String> filterMap = new LinkedHashMap<String, String>();
		//过滤
	
		filterMap.put("/a/**","perms[a]");
		filterMap.put("/admin/**", "authc");
	
		//跳转登录页面
		shiroFilterFactoryBean.setLoginUrl("/login.html");
		//授权:当授权拦截后shiro会自动跳转到未授权界面
		shiroFilterFactoryBean.setUnauthorizedUrl("/unAuth.html");
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
		return shiroFilterFactoryBean;
	}

	@Bean(name = "securityManager")
	public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(userRealm);
		return securityManager;

	}

	@Bean(name = "userRealm")
	public UserRealm getRealm() {
		return new UserRealm();
	}

	/*
	 * @Bean
	 * 
	 * @DependsOn("lifecycleBeanPostProcessor") public static
	 * DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
	 * DefaultAdvisorAutoProxyCreator creator = new
	 * DefaultAdvisorAutoProxyCreator(); //这一句比较重要
	 * creator.setProxyTargetClass(true); return creator;
	 * 
	 * }
	 * 
	 * @Bean("lifecycleBeanPostProcessor") public LifecycleBeanPostProcessor
	 * lifecycleBeanPostProcessor() { return new LifecycleBeanPostProcessor(); }
	 */
}
