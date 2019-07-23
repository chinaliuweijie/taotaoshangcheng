package com.taotao.search.mapper;

import java.util.List;

import com.taotao.common.pojo.SearchItem;

public interface SearchItemMapper {
	// 查询所有的商品
	List<SearchItem> getSearchItemList();
	// 根据商品id 查询商品	
	SearchItem getItemById(long itemId);
	
}
