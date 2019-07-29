package com.taotao.sso.service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbUser;

public interface UserService {
	//减产用户数据的合法性 data是参数  type是类型
	TaotaoResult checkUserData(String data,int type);

	//注册
	TaotaoResult register(TbUser tbUser);
	

	//登录
	TaotaoResult login(String username,String password);
	
	//通过token获取用户信息
	TaotaoResult getUserByToken(String token);
	//安全退出
	TaotaoResult logout(String token);
}
