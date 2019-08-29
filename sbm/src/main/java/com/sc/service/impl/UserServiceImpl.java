package com.sc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sc.bean.Users;
import com.sc.bean.UsersExample;
import com.sc.bean.UsersExample.Criteria;
import com.sc.mapper.UsersMapper;
import com.sc.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UsersMapper usersMapper;
	
	
	
	@Override
	public void addUsers(Users u) {
		if(u != null){
			this.usersMapper.insert(u);
		}
	}

	@Override
	public void updateUsers(Users u) {
		if(u != null && u.getUid() != null){
			this.usersMapper.updateByPrimaryKey(u);
		}
	}

	@Override
	public void delUsers(Users u) {
		if(u != null && u.getUid() != null){
			this.usersMapper.deleteByPrimaryKey(u.getUid());
		}
	}

	@Override
	public Users getUserById(Integer uid) {
		if(uid != null){
			return this.usersMapper.selectByPrimaryKey(uid);
		}
		return null;
	}

	@Override
	public List<Users> selectUsers() {
		return this.usersMapper.selectByExample(null);
	}

	@Override
	public Users login(String uanme, String upass) {
		if(uanme != "" && upass != ""){
			UsersExample usersExample = new UsersExample();
			Criteria create = usersExample.createCriteria();
			create.andUnameEqualTo(uanme);
			create.andUpassEqualTo(upass);
			List<Users> list = this.usersMapper.selectByExample(usersExample);
			if(list != null && list.size() > 0){
				return list.get(0);
			}
		}
		return null;
	}

	//��ҳ����
	@Override
	public PageInfo<Users> selectUsersPage(Integer pageNum, Integer pageSize, Users users) {
		//���ÿ�ʼ��ҳ
		PageHelper.startPage(pageNum, pageSize);
		//���ò�ѯ�����û��ķ���
		List<Users> list = this.usersMapper.selectByExample(null);
		//��װlist��pageinfo
		PageInfo<Users> pageInfo = new PageInfo<Users>(list);
		return pageInfo;
	}

}
