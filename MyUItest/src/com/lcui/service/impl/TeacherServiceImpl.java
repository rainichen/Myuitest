package com.lcui.service.impl;
import java.util.List;																				
import org.springframework.beans.factory.annotation.Autowired;										
import com.lcui.po.*;
import com.lcui.mapper.TeacherMapper;
import com.lcui.service.TeacherService;
public class TeacherServiceImpl implements TeacherService{
	@Autowired
	private TeacherMapper TeacherMapper;
	@Override
	public List<Teacher> selectList(TeacherExample TeacherExample) {
		List<Teacher> list=TeacherMapper.selectByExample(TeacherExample);
		return list;
	}
	@Override
	public Teacher selectByPrimaryKey(Integer id) {
		Teacher Teacher=TeacherMapper.selectByPrimaryKey(id);
		return Teacher;
	}
	@Override
	public int count(){
		int count=TeacherMapper.countByExample(null);
		return count;
	}
	@Override
	public int insertSelective(Teacher Teacher){
		return TeacherMapper.insertSelective(Teacher);
	}
	@Override
	public int updateByExampleSelective(Teacher Teacher, TeacherExample example) {
		int i=TeacherMapper.updateByExampleSelective(Teacher, example);
		return i;
	}
	@Override
	public int deleteByExample(TeacherExample example) {
		int i=TeacherMapper.deleteByExample(example);
		return i;
	}
}
