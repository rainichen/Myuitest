package com.lcui.service.impl;
import java.util.List;																				
import org.springframework.beans.factory.annotation.Autowired;										
import com.lcui.po.*;
import com.lcui.mapper.TableheadMapper;
import com.lcui.service.TableheadService;
public class TableheadServiceImpl implements TableheadService{
	@Autowired
	private TableheadMapper TableheadMapper;
	@Override
	public List<Tablehead> selectList(TableheadExample TableheadExample) {
		List<Tablehead> list=TableheadMapper.selectByExample(TableheadExample);
		return list;
	}
	@Override
	public Tablehead selectByPrimaryKey(Integer id) {
		Tablehead Tablehead=TableheadMapper.selectByPrimaryKey(id);
		return Tablehead;
	}
	@Override
	public int count(){
		int count=TableheadMapper.countByExample(null);
		return count;
	}
	@Override
	public int insertSelective(Tablehead Tablehead){
		return TableheadMapper.insertSelective(Tablehead);
	}
	@Override
	public int updateByExampleSelective(Tablehead Tablehead, TableheadExample example) {
		int i=TableheadMapper.updateByExampleSelective(Tablehead, example);
		return i;
	}
	@Override
	public int deleteByExample(TableheadExample example) {
		int i=TableheadMapper.deleteByExample(example);
		return i;
	}
}
