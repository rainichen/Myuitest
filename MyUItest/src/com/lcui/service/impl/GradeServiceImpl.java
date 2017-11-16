package com.lcui.service.impl;
import java.util.List;																				
import org.springframework.beans.factory.annotation.Autowired;										
import com.lcui.po.*;
import com.lcui.mapper.GradeMapper;
import com.lcui.service.GradeService;
public class GradeServiceImpl implements GradeService{
	@Autowired
	private GradeMapper GradeMapper;
	@Override
	public List<Grade> selectList(GradeExample GradeExample) {
		List<Grade> list=GradeMapper.selectByExample(GradeExample);
		return list;
	}
	@Override
	public Grade selectByPrimaryKey(Integer id) {
		Grade Grade=GradeMapper.selectByPrimaryKey(id);
		return Grade;
	}
	@Override
	public int count(){
		int count=GradeMapper.countByExample(null);
		return count;
	}
	@Override
	public int insertSelective(Grade Grade){
		return GradeMapper.insertSelective(Grade);
	}
	@Override
	public int updateByExampleSelective(Grade Grade, GradeExample example) {
		int i=GradeMapper.updateByExampleSelective(Grade, example);
		return i;
	}
	@Override
	public int deleteByExample(GradeExample example) {
		int i=GradeMapper.deleteByExample(example);
		return i;
	}
}
