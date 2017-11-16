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

import com.lcui.po.Grade;
import com.lcui.po.GradeExample;
import com.lcui.po.Grade;
import com.lcui.po.GradeExample;
import com.lcui.service.GradeService;


@Controller
@RequestMapping("/grade")
public class GradeController {
	@Autowired
	private GradeService GradeService;

	@RequestMapping("selectList")
	public @ResponseBody Map selectList(GradeExample GradeExample,Grade Grade)throws Exception{
		System.out.println("page,rows:"+GradeExample.getPage()+" "+GradeExample.getRows());
		System.out.println("GradeControllerUI_selectList_Grade:"+Grade);
		if(GradeExample.getPage()!=null&&GradeExample.getRows()!=null){
			GradeExample.setPage((GradeExample.getPage()-1)*GradeExample.getRows());
		}
		GradeExample.Criteria criteria=GradeExample.createCriteria();
		if(Grade.getId()!=null){
			criteria.andIdEqualTo(Grade.getId());
		}
//		if(Grade.getUnitname()!=null&&Grade.getUnitname()!=""){
//			criteria.andUnitnameLike("%"+Grade.getUnitname()+"%");
//		}
		List<Grade> list=GradeService.selectList(GradeExample);
		System.out.println("GradeControllerUI_selectList:"+list);
//		for (Grade Grade : list) {
//			Date date=Grade.getIssuetime();
//			String dateString=CustomDateConverter.formatDate(date, "yyyy-MM-dd hh:mm:ss");
//			Grade.setIssuetimestr(dateString);
//		}
		int total=GradeService.count();
		Map map=new HashMap();
		map.put("list", list);
		map.put("total", total);
		return map;
	}

	@RequestMapping("save")
	public @ResponseBody Map save(Grade Grade,HttpServletRequest request){
		GradeExample GradeExample=new GradeExample();
		GradeExample.Criteria criteria=GradeExample.createCriteria();
		
		Integer saveNums=0;
		System.out.println("GradeControllerUI_save:"+Grade);
		if(Grade.getId()!=null){
			criteria.andIdEqualTo(Grade.getId());
			saveNums=GradeService.updateByExampleSelective(Grade, GradeExample);
		}else{
			 saveNums=GradeService.insertSelective(Grade);
		}
		Map map=new HashMap();
		return map;
	}
}
