package com.mengyi.service;

import com.mengyi.entity.Spec;
import com.github.pagehelper.PageInfo;

/**
 * 
 * @author zhuzg
 *
 */
public interface SpecService {
	
	PageInfo<Spec> list(String name,int page);
	
	int add(Spec spec);
	
	int update(Spec spec);
	
	int delete(int id);
	
	/**
	 * 鏌ユ壘涓�涓鏍� 鐢ㄤ簬淇敼鏃跺�欑殑鍥炴樉
	 * @param id
	 * @return
	 */
	Spec findById(int id);
	
	
	/**
	 * 鎵归噺鍒犻櫎
	 * @param id
	 * @return
	 */
	int deleteBatch(int[] id);
	
	
	
	
	
	
	
}
