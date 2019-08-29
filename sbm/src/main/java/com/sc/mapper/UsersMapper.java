package com.sc.mapper;

import com.sc.bean.Users;
import com.sc.bean.UsersExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UsersMapper {
    int countByExample(UsersExample example);

    int deleteByExample(UsersExample example);
    //ɾ������
    int deleteByPrimaryKey(Integer uid);
    //��ӷ���
    int insert(Users record);
    
    int insertSelective(Users record);
    //��ѯ����
    List<Users> selectByExample(UsersExample example);
    //ͨ��������ѯ����
    Users selectByPrimaryKey(Integer uid);

    int updateByExampleSelective(@Param("record") Users record, @Param("example") UsersExample example);

    int updateByExample(@Param("record") Users record, @Param("example") UsersExample example);

    int updateByPrimaryKeySelective(Users record);
    //�޸ķ���
    int updateByPrimaryKey(Users record);
}