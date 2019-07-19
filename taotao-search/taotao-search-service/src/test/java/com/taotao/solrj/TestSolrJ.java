package com.taotao.solrj;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;


public class TestSolrJ {

	
	@Test
	public void testAddDocument() throws Exception{
		//创建一个SolrServer对象，创建一个HttpSolrServer对象，需要指定solr服务的url
		//如果有多个collection则需要指定要操作哪个collection，如果只有一个，可以不指定
		String solrUrl = "http://192.168.121.132:8080/solr/new_core" ;
		 HttpSolrClient solrClient = new HttpSolrClient.Builder(solrUrl)
	                .withConnectionTimeout(10000)
	                .withSocketTimeout(60000)
	                .build();
		//创建一个文档对象SolrInputDocument
		SolrInputDocument document = new SolrInputDocument();
		//向文档中添加域，必须有id域，域的名称必须在schema.xml中定义
		document.addField("id", 125);
		document.addField("item_title", "海尔空调冰箱大礼包");
		document.addField("item_sell_point", "送电暖宝一个哦");
		document.addField("item_price", 10000);
		document.addField("item_image", "http://www.12345678.jpg");
		document.addField("item_category_name", "电器");
		document.addField("item_desc", "这是一款最新的空调，质量好，值得信赖！！");
		//将document添加到索引库
		solrClient.add(document);
		//提交
		solrClient.commit();
	}

	
	

     @Test
	public void testDeleteDocument() throws Exception{
		//创建一个SolrServer对象，创建一个HttpSolrServer对象，需要指定solr服务的url
    	 String solrUrl = "http://192.168.121.132:8080/solr/new_core" ;
   		 HttpSolrClient solrClient = new HttpSolrClient.Builder(solrUrl)
   	                .withConnectionTimeout(10000)
   	                .withSocketTimeout(60000)
   	                .build();
		//通过id来删除文档
   		solrClient.deleteById("1111");
		//提交
   		solrClient.commit();
	}
     
     
     
     
     @Test
 	public void deleteDocumentByQuery() throws Exception{
 		//创建一个SolrServer对象，创建一个HttpSolrServer对象，需要指定solr服务的url
    	 String solrUrl = "http://192.168.121.132:8080/solr/new_core" ;
   		 HttpSolrClient solrClient = new HttpSolrClient.Builder(solrUrl)
   	                .withConnectionTimeout(10000)
   	                .withSocketTimeout(60000)
   	                .build();
 		//通过价格来删除文档
   		solrClient.deleteByQuery("last_name:爷");
 		//提交
   		solrClient.commit();
 	}


     
     
     @Test
 	public void queryDocument() throws Exception{
 		//创建一个SolrServer对象，创建一个HttpSolrServer对象，需要指定solr服务的url
    	 String solrUrl = "http://192.168.121.132:8080/solr/new_core" ;
   		 HttpSolrClient solrClient = new HttpSolrClient.Builder(solrUrl)
   	                .withConnectionTimeout(10000)
   	                .withSocketTimeout(60000)
   	                .build();
 		//通过id来删除文档
 		SolrQuery query = new SolrQuery();
 		query.setQuery("id:3333");
 		QueryResponse response = solrClient.query(query);
 		SolrDocumentList list = response.getResults();
 		for(SolrDocument document : list){
 			String id = document.getFieldValue("id").toString();
 			String title = document.getFieldValue("item_title").toString();
 			System.out.println(id);
 			System.out.println(title);
 		}
 	}

	
}
