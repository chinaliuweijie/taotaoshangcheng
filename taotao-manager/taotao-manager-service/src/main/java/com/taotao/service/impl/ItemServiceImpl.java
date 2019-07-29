package com.taotao.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.IDUtils;
import com.taotao.common.utils.JsonUtil;
import com.taotao.jedis.service.JedisClient;
import com.taotao.mapper.TbItemDescMapper;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;
import com.taotao.pojo.TbItemExample;
import com.taotao.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private TbItemMapper itemMapper;
	
	@Autowired
	private TbItemDescMapper itemDescMapper ;
	
	// 注入mq
	@Autowired
	private JmsTemplate jmsTemplate;
	@Resource(name="itemAddTopic")
	private Destination destination;
	
	
	@Autowired
	private JedisClient jedisClient;
	@Value("${ITEM_INFO}")
	private String ITEM_INFO;
	@Value("${ITEM_EXPIRE}")
	private Integer ITEM_EXPIRE;

	


	@Override
	public EasyUIDataGridResult gteItemList(int page, int rows) {
		// 设置分页信息
		PageHelper.startPage(page, rows);
		// 执行查询
		TbItemExample example = new TbItemExample();
		List<TbItem> list = itemMapper.selectByExample(example);
		// 获取查询结果
		PageInfo<TbItem> pageInfo = new PageInfo<>(list);
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setRows(list);
		result.setTotal(pageInfo.getTotal());
		// 返回结果	
		return result;
	}
	
	
	

	@Override
	public TaotaoResult createItem(TbItem tbItem, String desc) throws RuntimeException {
		// 生成商品id
		long itemId = IDUtils.genItemId();
		//补全item的属性
		tbItem.setId(itemId);
		//商品状态，1-正常，2-下架，3-删除
		tbItem.setStatus(((byte) 1));
		tbItem.setCreated(new Date());
		tbItem.setUpdated(new Date());
		itemMapper.insert(tbItem);
		//添加商品描述
		insertItemDesc(itemId, desc);
		// 发送activemq 消息 同步索引库
		jmsTemplate.send(destination, new MessageCreator() {
			
			@Override
			public Message createMessage(Session session) throws JMSException {
				TextMessage message = session.createTextMessage(itemId+"");
				return message;
			}
		});
		
		
		return TaotaoResult.ok();
	}
	
	
	private void insertItemDesc(long itemId,String desc) {
		//创建一个商品描述表对应的pojo
		TbItemDesc itemDesc = new TbItemDesc();
		//补全pojo的属性
		itemDesc.setItemId(itemId);
		itemDesc.setItemDesc(desc);
		itemDesc.setCreated(new Date());
		itemDesc.setUpdated(new Date());
		//向商品描述表插入数据
		itemDescMapper.insert(itemDesc);
	}

	@Override
	public TbItemDesc getItemDescById(long itemId) {
		//查询数据库之前先查询缓存
		try {
			String json = jedisClient.get(ITEM_INFO+":"+itemId+":DESC");
			if(!StringUtils.isBlank(json)){
				//把json转换成对象
				return  JsonUtil.jsonToObject(json, TbItemDesc.class);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		TbItemDesc itemDesc = itemDescMapper.selectByPrimaryKey(itemId);
		//把查询结果添加到缓存
		try {
			//把查询结果添加到缓存
			jedisClient.set(ITEM_INFO+":"+itemId+":DESC",JsonUtil.objectToJson(itemDesc));
			//设置过期时间，提高缓存的利用率
			jedisClient.expire(ITEM_INFO+":"+itemId+":DESC", ITEM_EXPIRE);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return itemDesc;
	}
	
	@Override
	public TbItem getItemById(long itemId) {
		//查询数据库之前先查询缓存
		try {
			String json = jedisClient.get(ITEM_INFO+":"+itemId+":BASE");
			if(!StringUtils.isBlank(json)){
				//把json转换成对象
				return JsonUtil.jsonToObject(json, TbItem.class);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		TbItem tbItem = itemMapper.selectByPrimaryKey(itemId);
		
		//把查询结果添加到缓存
		try {
			//把查询结果添加到缓存
			jedisClient.set(ITEM_INFO+":"+itemId+":BASE",JsonUtil.objectToJson(tbItem));
			//设置过期时间，提高缓存的利用率
			jedisClient.expire(ITEM_INFO+":"+itemId+":BASE", ITEM_EXPIRE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tbItem;
	}

}
