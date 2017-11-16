package com.lcui.service;
import java.util.List;																				
import com.lcui.po.*;
public interface TeacherService{
public List<Teacher> selectList(TeacherExample TeacherExample);
	Teacher selectByPrimaryKey(Integer id);
	int count();
	int insertSelective(Teacher Teacher);
	int updateByExampleSelective(Teacher record,TeacherExample example);
	int deleteByExample(TeacherExample example) ;
}
