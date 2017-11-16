package com.lcui.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lcui.po.Course;
import com.lcui.po.CourseExample;
import com.lcui.service.CourseService;


@Controller
@RequestMapping("/course")
public class CourseController {
	@Autowired
	private CourseService CourseService;

	@RequestMapping("selectList")
	public @ResponseBody Map selectList(CourseExample CourseExample,Course Course)throws Exception{
		System.out.println("page,rows:"+CourseExample.getPage()+" "+CourseExample.getRows());
		System.out.println("CourseControllerUI_selectList_Course:"+Course);
		if(CourseExample.getPage()!=null&&CourseExample.getRows()!=null){
			CourseExample.setPage((CourseExample.getPage()-1)*CourseExample.getRows());
		}
		CourseExample.Criteria criteria=CourseExample.createCriteria();
		if(Course.getId()!=null){
			criteria.andIdEqualTo(Course.getId());
		}
//		if(Course.getUnitname()!=null&&Course.getUnitname()!=""){
//			criteria.andUnitnameLike("%"+Course.getUnitname()+"%");
//		}
		List<Course> list=CourseService.selectList(CourseExample);
		System.out.println("CourseControllerUI_selectList:"+list);
//		for (Course Course : list) {
//			Date date=Course.getIssuetime();
//			String dateString=CustomDateConverter.formatDate(date, "yyyy-MM-dd hh:mm:ss");
//			Course.setIssuetimestr(dateString);
//		}
		int total=CourseService.count();
		Map map=new HashMap();
		map.put("list", list);
		map.put("total", total);
		return map;
	}

	@RequestMapping("save")
	public @ResponseBody Map save(Course Course,HttpServletRequest request){
		CourseExample CourseExample=new CourseExample();
		CourseExample.Criteria criteria=CourseExample.createCriteria();
		
		Integer saveNums=0;
		System.out.println("CourseControllerUI_save:"+Course);
		if(Course.getId()!=null){
			criteria.andIdEqualTo(Course.getId());
			saveNums=CourseService.updateByExampleSelective(Course, CourseExample);
		}else{
			 saveNums=CourseService.insertSelective(Course);
		}
		Map map=new HashMap();
		return map;
	}
	@RequestMapping("delete")
	public @ResponseBody Map deleteByPrimaryKey(String delIds){
		System.out.println("delete:"+delIds);
		CourseExample CourseExample=new CourseExample();
		CourseExample.Criteria criteria=CourseExample.createCriteria();
		List list=new ArrayList();
		String[] ids=delIds.split(",");
		for (String string : ids) {
			list.add(string);
		}
		criteria.andIdIn(list);
		int delNums=CourseService.deleteByExample(CourseExample);
		
		Map map=new HashMap();
		if(delNums>0){
			map.put("success", "true");
			map.put("delNums", delNums);
		}else{
			map.put("errorMsg", "删除出错");
		}
		return map;
	}
}
