package com.mengyi.service;

import java.util.List;

import com.mengyi.entity.Brand;
import com.mengyi.entity.Category;
import com.github.pagehelper.PageInfo;

/**
 * 
 * @author zhuzg
 *  
 *  **** Dubbo 閺堝秴濮熼幒銉ュ經閸戣姤鏆熷В鏃囶洣閺堝娼猇oid 閻ㄥ嫯绻戦崶鐐诧拷锟�********
 *  
 */
public interface GoodsService {
	
	int addBrand(Brand brand);
	int updateBrand(Brand brand);
	int deleteBrand(Integer id);
	/**
	 * 
	 * @param firstChar 妫ｆ牕鐡уВ锟�
	 * @param page 妞ょ數鐖�
	 * @return
	 */
	PageInfo<Brand> listBrand( String firstChar,int page); 
	
	
	int addCategory(Category category);
	int updateCategory(Category category);
	int deleteCategory(Integer id);
	/**
	 * 
	 * @param firstChar 妫ｆ牕鐡уВ锟�
	 * @param page 妞ょ數鐖�
	 * @return
	 */
	PageInfo<Category> listCategory( String firstChar,int page); 
	/**
	 * 娴犮儲鐖查惃鍕埌瀵繑妯夌粈鍝勫灙鐞涳拷
	 * @return
	 */
	List<Category> treeCategory(); 
	
	

}
