package com.taotao.content.service;

import com.taotao.common.pojo.EasyUIDataGridResult;

public interface ContentService {

	public EasyUIDataGridResult getContentList(long categoryId,int page,int rows);
	
	
}
