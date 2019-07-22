package com.taotao.searchsolr;

import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.junit.Test;

public class SolrTest {

	
	@Test
	public void queryDocument() throws Exception{
		//创建一个SolrServer对象，创建一个HttpSolrServer对象，需要指定solr服务的url
		String solrUrl = "http://192.168.31.133:8080/solr/new_core" ;
		HttpSolrClient solrClient = new HttpSolrClient.Builder(solrUrl)
	                .withConnectionTimeout(10000)
	                .withSocketTimeout(60000)
	                .build();
		//创建一个SolrQuery对象
		SolrQuery query = new SolrQuery();
		//设置查询条件、过滤条件、分页条件、排序条件、高亮
		//query.set("q", "*:*");
		query.setQuery("手机");
		//分页条件
		query.setStart(0);
		query.setRows(3);
		//设置默认搜索域
		query.set("df", "item_keywords");
		//设置高亮
		query.setHighlight(true);
		//高亮显示的域
		query.addHighlightField("item_title");
		query.setHighlightSimplePre("<em>");
		query.setHighlightSimplePost("</em>");
		//执行查询，得到一个Response对象
		QueryResponse response = solrClient.query(query);
		//取查询结果
		SolrDocumentList solrDocumentList = response.getResults();
		//取查询结果总记录数
		System.out.println("查询结果总记录数："+solrDocumentList.getNumFound());
		for(SolrDocument document : solrDocumentList){
			System.out.println(document.getFieldValue("id"));
			//取高亮显示
			Map<String,Map<String,List<String>>> highlighting = response.getHighlighting();
			List<String> list = highlighting.get(document.getFieldValue("id")).get("item_title");
			String itemTitle = "";
			if(list != null && list.size() > 0){
				itemTitle = list.get(0);
			}else {
				itemTitle = (String)document.get("item_title");
			}
			System.out.println(itemTitle);
			System.out.println(document.get("item_sell_point"));
			System.out.println(document.get("item_price"));
			System.out.println(document.get("item_image"));
			System.out.println(document.get("item_category_name"));
			System.out.println("===============================================");
		}
	}
	
}
