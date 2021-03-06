package com.taotao.content.service;

import java.util.List;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbContent;

public interface ContentService {
	//获取内容列表
	public EasyUIDataGridResult getContentList(long categoryId,int page,int rows);
	
	
	
	//添加内容
	public TaotaoResult addContent(TbContent content);
	//修改内容
	TaotaoResult updateContent(TbContent content);
	//删除内容
	TaotaoResult deleteContent(String ids);
	//获取单个内容信息
	public TaotaoResult getContent(long id);
	
	List<TbContent> getContentListByCid(long cid);
}
