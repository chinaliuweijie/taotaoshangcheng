package com.taotao.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.pojo.TbItemCatExample.Criteria;
import com.taotao.service.ItemCatService;


@Service
public class ItemCatServiceImpl implements ItemCatService {
	
	@Autowired
	private TbItemCatMapper  itemCatMapper;
	
	
	@Override
	public List<EasyUITreeNode> getItemCatList(long parentId) {
		
		// 根据parentid 查询到所有节点信息
		TbItemCatExample example = new TbItemCatExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		// 执行查询
		List<TbItemCat> itemCats = itemCatMapper.selectByExample(example);
		// 将集合数据转换成EasyUITreeNode
		List<EasyUITreeNode> list = new ArrayList<>();
		for (TbItemCat itemCat : itemCats) {
			EasyUITreeNode node = new EasyUITreeNode();
			node.setId(itemCat.getId());
			node.setState(itemCat.getIsParent()?"closed":"open");
			node.setText(itemCat.getName());
			list.add(node);
		}
		return list;
	}

}
