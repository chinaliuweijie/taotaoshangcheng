package com.taotao.search.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.SearchItem;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.search.mapper.SearchItemMapper;
import com.taotao.search.service.SearchItemService;

@Service
public class SearchItemServiceImpl implements SearchItemService {
	
	@Autowired
	private SearchItemMapper searchItemMapper;

    @Resource
    private SolrClient solr;
	
	@Override
	public TaotaoResult importItemIndex() {
		//1、先查询所有商品数据
				try {
					List<SearchItem> itemList= searchItemMapper.getSearchItemList();
					//2、遍历商品数据添加到索引库
					for(SearchItem searchItem : itemList){
						//创建文档对象
						SolrInputDocument document = new SolrInputDocument();
						document.addField("id", searchItem.getId());
						document.addField("item_title", searchItem.getTitle());
						document.addField("item_sell_point", searchItem.getSell_point());
						document.addField("item_price", searchItem.getPrice());
						document.addField("item_image", searchItem.getImage());
						document.addField("item_category_name", searchItem.getItem_category_name());
						document.addField("item_desc", searchItem.getItem_desc());
						solr.add(document);
					}
					solr.commit();
					
					

					
					
					
//					SolrInputDocument document = new SolrInputDocument();
//					//向文档中添加域，必须有id域，域的名称必须在schema.xml中定义
//					document.addField("id", 3333);
//					document.addField("item_title", "海尔空调冰箱大礼包");
//					document.addField("item_sell_point", "送电暖宝一个哦");
//					document.addField("item_price", 10000);
//					document.addField("item_image", "http://www.12345678.jpg");
//					document.addField("item_category_name", "电器");
//					document.addField("item_desc", "这是一款最新的空调，质量好，值得信赖！！");
//					//将document添加到索引库
//					solr.add(document);
//					//提交
//					solr.commit();
					
					
					return TaotaoResult.ok();
				}  catch (Exception e) {
					e.printStackTrace();
					return TaotaoResult.build(500, "导入数据失败！");
				}

	}

}
