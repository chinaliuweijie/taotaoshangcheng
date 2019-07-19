package com.taotao.search.service;

import com.taotao.common.pojo.TaotaoResult;

public interface SearchItemService {
 
	// 导入数据库中文件到索引库
	public TaotaoResult importItemIndex();
	
	
}
