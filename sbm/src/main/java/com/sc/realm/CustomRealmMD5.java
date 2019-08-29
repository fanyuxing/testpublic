package com.sc.realm;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.sc.bean.SysPermission;
import com.sc.bean.SysUser;
import com.sc.service.SysPermissionService;
import com.sc.service.SysUserService;

public class CustomRealmMD5 extends AuthorizingRealm {
	@Autowired
	SysUserService sysUserService;
	@Autowired
	SysPermissionService sysPermissionService;
	//�û���Ȩ
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		
		System.out.println("��ʼ��Ȩ");
		SysUser sysuser = (SysUser)arg0.getPrimaryPrincipal();
		ArrayList<String> perms = new ArrayList<String>();
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		List<SysPermission> list = sysPermissionService.selectByUid(sysuser.getId());
		if(list != null && list.size() > 0){
			for (SysPermission sp : list) {
				perms.add(sp.getPercode());
				System.out.println(sp.getName());
			}
			info.addStringPermissions(perms);
		}
		return info;
	}

	
	//�û���֤
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
		//��ȡ��¼������û���
		String uname = (String)arg0.getPrincipal();
		System.out.println("��¼�û�:"+uname);
		
		SysUser user = sysUserService.login(uname);
		
		if(user == null)return null;
		
		SimpleAuthenticationInfo sa = 
				new SimpleAuthenticationInfo(user, user.getPassword(),ByteSource.Util.bytes(user.getSalt()), super.getName());
		
		
		return sa;
	}

}
