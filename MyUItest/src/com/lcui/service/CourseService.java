package com.lcui.service;
import java.util.List;																				
import com.lcui.po.*;
public interface CourseService{
public List<Course> selectList(CourseExample CourseExample);
	Course selectByPrimaryKey(Integer id);
	int count();
	int insertSelective(Course Course);
	int updateByExampleSelective(Course record,CourseExample example);
	int deleteByExample(CourseExample example) ;
}
