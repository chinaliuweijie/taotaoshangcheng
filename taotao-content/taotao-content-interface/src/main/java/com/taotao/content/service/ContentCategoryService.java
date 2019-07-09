package com.taotao.content.service;


import java.util.List;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.common.pojo.TaotaoResult;

public interface ContentCategoryService {
	// 获取内容分类
	public List<EasyUITreeNode> getContentCategoryList(long parentId);
	// 添加内容分类
	public TaotaoResult addContentCategory(long parentId,String name);
	// 重命名
	public TaotaoResult updateContentCategory(long id,String name);
	// 删除分类
	public TaotaoResult deleteContentCategory(long id);
	
	
}
