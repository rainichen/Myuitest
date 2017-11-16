package com.lcui.service;
import java.util.List;																				
import com.lcui.po.*;
public interface TableheadService{
public List<Tablehead> selectList(TableheadExample TableheadExample);
	Tablehead selectByPrimaryKey(Integer id);
	int count();
	int insertSelective(Tablehead Tablehead);
	int updateByExampleSelective(Tablehead record,TableheadExample example);
	int deleteByExample(TableheadExample example) ;
}
