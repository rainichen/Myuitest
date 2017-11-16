package com.lcui.service;
import java.util.List;																				
import com.lcui.po.*;
public interface UserService{
public List<User> selectList(UserExample UserExample);
	User selectByPrimaryKey(Integer id);
	int count();
	int insertSelective(User User);
	int updateByExampleSelective(User record,UserExample example);
	int deleteByExample(UserExample example) ;
}
