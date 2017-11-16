package com.lcui.controller;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lcui.po.Tablehead;
import com.lcui.po.TableheadExample;
import com.lcui.po.Tablehead;
import com.lcui.po.TableheadExample;
import com.lcui.service.TableheadService;


@Controller
@RequestMapping("/tablehead")
public class TableheadController {
	@Autowired
	private TableheadService TableheadService;

	@RequestMapping("selectList")
	public @ResponseBody Map selectList(TableheadExample TableheadExample,Tablehead Tablehead)throws Exception{
		System.out.println("page,rows:"+TableheadExample.getPage()+" "+TableheadExample.getRows());
		System.out.println("TableheadControllerUI_selectList_Tablehead:"+Tablehead);
		if(TableheadExample.getPage()!=null&&TableheadExample.getRows()!=null){
			TableheadExample.setPage((TableheadExample.getPage()-1)*TableheadExample.getRows());
		}
		TableheadExample.Criteria criteria=TableheadExample.createCriteria();
		if(Tablehead.getId()!=null){
			criteria.andIdEqualTo(Tablehead.getId());
		}
		if(Tablehead.getTablename()!=null&&Tablehead.getTablename()!=""){
			criteria.andTablenameLike("%"+Tablehead.getTablename()+"%");
		}
		List<Tablehead> list=TableheadService.selectList(TableheadExample);
		System.out.println("TableheadControllerUI_selectList:"+list);
//		for (Tablehead Tablehead : list) {
//			Date date=Tablehead.getIssuetime();
//			String dateString=CustomDateConverter.formatDate(date, "yyyy-MM-dd hh:mm:ss");
//			Tablehead.setIssuetimestr(dateString);
//		}
		int total=TableheadService.count();
		Map map=new HashMap();
		map.put("list", list);
		map.put("total", total);
		return map;
	}
	@RequestMapping("save")
	public @ResponseBody Map save(Tablehead Tablehead,HttpServletRequest request){
		TableheadExample TableheadExample=new TableheadExample();
		TableheadExample.Criteria criteria=TableheadExample.createCriteria();
		
		Integer saveNums=0;
		System.out.println("TableheadControllerUI_save:"+Tablehead);
		if(Tablehead.getId()!=null){
			criteria.andIdEqualTo(Tablehead.getId());
			saveNums=TableheadService.updateByExampleSelective(Tablehead, TableheadExample);
		}else{
			 saveNums=TableheadService.insertSelective(Tablehead);
		}
		Map map=new HashMap();
		return map;
	}
}
