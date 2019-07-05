package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;

@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/item/{itemId}")
	@ResponseBody
	public TbItem getItemById(@PathVariable Long itemId) {
		TbItem itemById = itemService.getItemById(itemId);
		return itemById;
	}
	
	@RequestMapping("/item/list")
	@ResponseBody
	public EasyUIDataGridResult gteItemList(int page,int rows) {
		EasyUIDataGridResult result = itemService.gteItemList(page, rows);
		return result;
	};
	
	@RequestMapping(value="/item/save",method=RequestMethod.POST)
	@ResponseBody
	public TaotaoResult addItem(TbItem tbItem,String desc) {
		try {
			TaotaoResult result = itemService.createItem(tbItem, desc);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return TaotaoResult.build(500, "添加商品失败");
		}
		
	}
	
	
	
}
