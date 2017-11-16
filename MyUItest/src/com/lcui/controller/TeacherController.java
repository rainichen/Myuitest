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

import com.lcui.po.Teacher;
import com.lcui.po.TeacherExample;
import com.lcui.po.Teacher;
import com.lcui.po.TeacherExample;
import com.lcui.service.TeacherService;


@Controller
@RequestMapping("/teacher")
public class TeacherController {
	@Autowired
	private TeacherService TeacherService;

	@RequestMapping("selectList")
	public @ResponseBody Map selectList(TeacherExample TeacherExample,Teacher Teacher)throws Exception{
		System.out.println("page,rows:"+TeacherExample.getPage()+" "+TeacherExample.getRows());
		System.out.println("TeacherControllerUI_selectList_Teacher:"+Teacher);
		if(TeacherExample.getPage()!=null&&TeacherExample.getRows()!=null){
			TeacherExample.setPage((TeacherExample.getPage()-1)*TeacherExample.getRows());
		}
		TeacherExample.Criteria criteria=TeacherExample.createCriteria();
		if(Teacher.getId()!=null){
			criteria.andIdEqualTo(Teacher.getId());
		}
//		if(Teacher.getUnitname()!=null&&Teacher.getUnitname()!=""){
//			criteria.andUnitnameLike("%"+Teacher.getUnitname()+"%");
//		}
		List<Teacher> list=TeacherService.selectList(TeacherExample);
		System.out.println("TeacherControllerUI_selectList:"+list);
//		for (Teacher Teacher : list) {
//			Date date=Teacher.getIssuetime();
//			String dateString=CustomDateConverter.formatDate(date, "yyyy-MM-dd hh:mm:ss");
//			Teacher.setIssuetimestr(dateString);
//		}
		int total=TeacherService.count();
		Map map=new HashMap();
		map.put("list", list);
		map.put("total", total);
		return map;
	}
	@RequestMapping("save")
	public @ResponseBody Map save(Teacher Teacher,HttpServletRequest request){
		TeacherExample TeacherExample=new TeacherExample();
		TeacherExample.Criteria criteria=TeacherExample.createCriteria();
		
		Integer saveNums=0;
		System.out.println("TeacherControllerUI_save:"+Teacher);
		if(Teacher.getId()!=null){
			criteria.andIdEqualTo(Teacher.getId());
			saveNums=TeacherService.updateByExampleSelective(Teacher, TeacherExample);
		}else{
			 saveNums=TeacherService.insertSelective(Teacher);
		}
		Map map=new HashMap();
		return map;
	}
}
