package com.taotao.service;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;

public interface ItemService {
	// 查询商品的信息
 	TbItem getItemById(long itemId); 
 	// 查询商品列表
 	EasyUIDataGridResult gteItemList(int page,int rows);
 	// 添加商品  之所以要抛出异常是因为这个接口要操作两张表，而且这两张表的操作要都成功才叫成功，否则事务就回滚，因此异常要向上抛
 	TaotaoResult createItem(TbItem tbItem,String desc) throws RuntimeException;
 	
}
