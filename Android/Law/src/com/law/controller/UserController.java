package com.law.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.law.dto.Result;
import com.law.pojo.User;
import com.law.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	
	@RequestMapping(value = "/getById",method = RequestMethod.GET)
	@ResponseBody
	public Result<User> getById(long id) {
		User user = userService.getUserById(id);
		List<User> users = new ArrayList<>();
		users.add(user);
		if(user != null) {
			return new Result<>(true,users);
		}else {
			return new Result<>(false, "不存在该用户");
		}
	}
	
	@RequestMapping(value = "/getByName",method = RequestMethod.GET)
	@ResponseBody
	public Result<User> getByName(String name) {
		User user = userService.getUserByName(name);
		List<User> users = new ArrayList<>();
		users.add(user);
		if(user != null) {
			return new Result<>(true,users);
		}else {
			return new Result<>(false, "不存在该用户");
		}
	}
	
	@RequestMapping(value = "/getByPhone",method = RequestMethod.GET)
	@ResponseBody
	public Result<User> getByPhone(String phone) {
		User user = userService.getUserByPhone(phone);
		List<User> users = new ArrayList<>();
		users.add(user);
		return new Result<>(true,users);
	}
	
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	@ResponseBody
	public Result<Boolean> update(@RequestBody User user) {
		System.out.println(user);
		boolean result = userService.updateUser(user);
		String data = "" +result;
		return new Result<>(result,data);
	}
	
	@RequestMapping(value = "/insert",method = RequestMethod.POST)
	@ResponseBody
	public Result<String> insert(@RequestBody User user){
		System.out.println(user.toString());
	/*	user = "{" + user + "}";
		User mUser = JSONObject.parseObject(user, User.class);*/
		boolean result = userService.insertUser(user);
		/*System.out.println(mUser.toString());*/
		String data = "" +result;
		return new Result<>(result,data);
	}
	@RequestMapping(value = "/uploadHeadImg",method = RequestMethod.POST)
	@ResponseBody
	public Result<String> uploadHeadImg(MultipartFile file,HttpServletRequest request) throws IOException{
		String path = request.getSession().getServletContext().getRealPath("/images");  
		String fileName = file.getOriginalFilename(); 
		File dir = new File(path, fileName);
		if(!dir.exists()){  
            dir.mkdirs();  
        }
		System.out.println(path+fileName);
		//MultipartFile自带的解析方法  
	    file.transferTo(dir); 
	    List<String> result = new ArrayList<>();
	    result.add(path+"\\"+fileName);
		return new Result<>(true,result);
	}
	
	@RequestMapping(value = "/getUserHeadimg")
	public void getUserHeadimg(HttpServletResponse response,@RequestParam long userId) throws IOException{
		User user = userService.getUserById(userId);
		File file = new File(user.getUserHeadimg());
		if(!file.exists()){  
            return;
        }
		 //获取输入流  
        InputStream bis = new BufferedInputStream(new FileInputStream(file));  
        //假如以中文名下载的话  
        String filename = file.getName();  
        //转码，免得文件名中文乱码  
        filename = URLEncoder.encode(filename,"UTF-8");  
        //设置文件下载头  
        response.addHeader("Content-Disposition", "attachment;filename=" + filename);    
        //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型    
        response.setContentType("multipart/form-data");   
        BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());  
        int len = 0;  
        while((len = bis.read()) != -1){  
            out.write(len);  
            out.flush();  
        }  
        out.close();  
	}
	@RequestMapping(value = "/getUserHeadimgByPhone")
	public void getUserHeadimgByPhone(HttpServletResponse response,@RequestParam String userPhone) throws IOException{
		User user = userService.getUserByPhone(userPhone);
		File file = new File(user.getUserHeadimg());
		if(!file.exists()){  
            return;
        }
		 //获取输入流  
        InputStream bis = new BufferedInputStream(new FileInputStream(file));  
        //假如以中文名下载的话  
        String filename = file.getName();  
        //转码，免得文件名中文乱码  
        filename = URLEncoder.encode(filename,"UTF-8");  
        //设置文件下载头  
        response.addHeader("Content-Disposition", "attachment;filename=" + filename);    
        //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型    
        response.setContentType("multipart/form-data");   
        BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());  
        int len = 0;  
        while((len = bis.read()) != -1){  
            out.write(len);  
            out.flush();  
        }  
        out.close();  
  
	}
}
