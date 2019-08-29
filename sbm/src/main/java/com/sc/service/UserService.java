package com.sc.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.sc.bean.Users;

public interface UserService {
	//����û�
	public void addUsers(Users u);
	//�����û�
	public void updateUsers(Users u);
	//ɾ���û�
	public void delUsers(Users u);
	//�����û�id�����û�
	public Users getUserById(Integer uid);
	//��ȡ�û�list
	public List<Users> selectUsers();
	
	//��ȡ�û�list��ҳ
	public PageInfo<Users> selectUsersPage(
			Integer pageBum,Integer pageSize,Users users);
	
	//�û���¼
	public Users login(String uanme,String upass);

}
