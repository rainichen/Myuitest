package com.lcui.controller;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lcui.po.*;
import com.lcui.service.UserService;


@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService UserService;

	@RequestMapping("selectList")
	public @ResponseBody Map selectList(UserExample UserExample,User User)throws Exception{
		System.out.println("page,rows:"+UserExample.getPage()+" "+UserExample.getRows());
		System.out.println("UserControllerUI_selectList_User:"+User);
		if(UserExample.getPage()!=null&&UserExample.getRows()!=null){
			UserExample.setPage((UserExample.getPage()-1)*UserExample.getRows());
		}
		UserExample.Criteria criteria=UserExample.createCriteria();
		if(User.getId()!=null){
			criteria.andIdEqualTo(User.getId());
		}
//		if(User.getUnitname()!=null&&User.getUnitname()!=""){
//			criteria.andUnitnameLike("%"+User.getUnitname()+"%");
//		}
		List<User> list=UserService.selectList(UserExample);
		System.out.println("UserControllerUI_selectList:"+list);
//		for (User User : list) {
//			Date date=User.getIssuetime();
//			String dateString=CustomDateConverter.formatDate(date, "yyyy-MM-dd hh:mm:ss");
//			User.setIssuetimestr(dateString);
//		}
		int total=UserService.count();
		Map map=new HashMap();
		map.put("list", list);
		map.put("total", total);
		return map;
	}
	@RequestMapping("save")
	public @ResponseBody Map save(User User,HttpServletRequest request){
		UserExample UserExample=new UserExample();
		UserExample.Criteria criteria=UserExample.createCriteria();
		
		Integer saveNums=0;
		System.out.println("UserControllerUI_save:"+User);
		if(User.getId()!=null){
			criteria.andIdEqualTo(User.getId());
			saveNums=UserService.updateByExampleSelective(User, UserExample);
		}else{
			 saveNums=UserService.insertSelective(User);
		}
		Map map=new HashMap();
		return map;
	}
	@RequestMapping("delete")
	public @ResponseBody Map deleteByPrimaryKey(String delIds){
		System.out.println("delete:"+delIds);
		UserExample UserExample=new UserExample();
		UserExample.Criteria criteria=UserExample.createCriteria();
		List list=new ArrayList();
		String[] ids=delIds.split(",");
		for (String string : ids) {
			list.add(string);
		}
		criteria.andIdIn(list);
		int delNums=UserService.deleteByExample(UserExample);
		
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
