package com.lcui.service.impl;
import java.util.List;																				
import org.springframework.beans.factory.annotation.Autowired;										
import com.lcui.po.*;
import com.lcui.mapper.CourseMapper;
import com.lcui.service.CourseService;
public class CourseServiceImpl implements CourseService{
	@Autowired
	private CourseMapper CourseMapper;
	@Override
	public List<Course> selectList(CourseExample CourseExample) {
		List<Course> list=CourseMapper.selectByExample(CourseExample);
		return list;
	}
	@Override
	public Course selectByPrimaryKey(Integer id) {
		Course Course=CourseMapper.selectByPrimaryKey(id);
		return Course;
	}
	@Override
	public int count(){
		int count=CourseMapper.countByExample(null);
		return count;
	}
	@Override
	public int insertSelective(Course Course){
		return CourseMapper.insertSelective(Course);
	}
	@Override
	public int updateByExampleSelective(Course Course, CourseExample example) {
		int i=CourseMapper.updateByExampleSelective(Course, example);
		return i;
	}
	@Override
	public int deleteByExample(CourseExample example) {
		int i=CourseMapper.deleteByExample(example);
		return i;
	}
}
