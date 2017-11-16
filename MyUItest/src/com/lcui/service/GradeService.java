package com.lcui.service;
import java.util.List;																				
import com.lcui.po.*;
public interface GradeService{
public List<Grade> selectList(GradeExample GradeExample);
	Grade selectByPrimaryKey(Integer id);
	int count();
	int insertSelective(Grade Grade);
	int updateByExampleSelective(Grade record,GradeExample example);
	int deleteByExample(GradeExample example) ;
}
