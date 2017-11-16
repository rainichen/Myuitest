package com.lcui.service.impl;
import java.util.List;																				
import org.springframework.beans.factory.annotation.Autowired;										
import com.lcui.po.*;
import com.lcui.mapper.UserMapper;
import com.lcui.service.UserService;
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper UserMapper;
	@Override
	public List<User> selectList(UserExample UserExample) {
		List<User> list=UserMapper.selectByExample(UserExample);
		return list;
	}
	@Override
	public User selectByPrimaryKey(Integer id) {
		User User=UserMapper.selectByPrimaryKey(id);
		return User;
	}
	@Override
	public int count(){
		int count=UserMapper.countByExample(null);
		return count;
	}
	@Override
	public int insertSelective(User User){
		return UserMapper.insertSelective(User);
	}
	@Override
	public int updateByExampleSelective(User User, UserExample example) {
		int i=UserMapper.updateByExampleSelective(User, example);
		return i;
	}
	@Override
	public int deleteByExample(UserExample example) {
		int i=UserMapper.deleteByExample(example);
		return i;
	}
}
