package com.fei.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fei.springboot.dao.UserMapper;
import com.fei.springboot.domain.User;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	
	
	public void insertUser(User u){
		this.userMapper.insert(u);
	}
	
	public PageInfo<User> queryPage(String userName,int pageNum,int pageSize){
		Page<User> page = PageHelper.startPage(pageNum, pageSize);
		//PageHelper会自动拦截到下面这查询sql
		this.userMapper.query(userName);
		return page.toPageInfo();
	}
	//测试事务
	@Transactional
	public void testTransational(){
		
		//删除全部
		this.userMapper.deleteAll();
		//新增
		User u = new User();
		u.setId("123456");
		u.setUserName("张三");
		this.userMapper.insert(u);
		//制造异常
		throw new RuntimeException("事务异常测试");
	}
	
}
