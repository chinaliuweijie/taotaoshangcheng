package com.taotao.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
 
import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.content.service.ContentService;

 
@Controller
public class ContentController {
	
	@Autowired
	private ContentService contentSerive;
	
	@RequestMapping("/content/query/list")
	@ResponseBody
	public EasyUIDataGridResult getContentList(Long categoryId,Integer page,Integer rows){
		EasyUIDataGridResult result = contentSerive.getContentList(categoryId, page, rows);
		return result;
	}
}
