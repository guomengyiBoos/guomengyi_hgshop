package com.mengyi.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mengyi.entity.Spec;
import com.mengyi.service.SpecService;
import com.github.pagehelper.PageInfo;


/**
 * 
 * @author zhuzg
 * 瑙勬牸鐨勭鐞�
 */
@Controller
@RequestMapping("spec")
public class SpecController {
	
	@Reference
	SpecService specService;
	
	/**
	 * 杩涘叆瑙勬牸鐨勫垪琛�
	 * @param page
	 * @return
	 */
	@RequestMapping("list")
	public String list(HttpServletRequest request,
			@RequestParam(defaultValue="1") int page,
			@RequestParam(defaultValue="") String name
	) {
		 PageInfo<Spec> pageInfo = specService.list(name, page);
		//pageInfo.getPages()
		 request.setAttribute("pageInfo", pageInfo);
		 request.setAttribute("queryName", name);
		return "spec/list";
	}
	
	/**
	 * 娣诲姞
	 * @param request
	 * @param page
	 * @param name
	 * @return
	 */
	@RequestMapping("add")
	@ResponseBody
	public String add(HttpServletRequest request,Spec spec) {
		//System.out.println("spec" + spec);
		//System.out.println();
		spec.getOptions().removeIf(x->{return x.getOptionName()==null;});
		//System.out.println("spec 澶勭悊鍚庯細" + spec);
		//璋冪敤鏈嶅姟
		int add = specService.add(spec);
		return add>0?"success":"false";
	}
	
	@RequestMapping("update")
	@ResponseBody
	public String update(HttpServletRequest request,Spec spec) {
		System.out.println("spec" + spec);
		//System.out.println();
		spec.getOptions().removeIf(x->{return x.getOptionName()==null;});
		System.out.println("spec 澶勭悊鍚庯細" + spec);
		//璋冪敤鏈嶅姟
		int result = specService.update(spec);  
		return result >0 ?"success":"false";
		//return "fail";
	}
	
	
	
	/**
	 * 鐢ㄤ簬淇敼鏁版嵁鏃跺�欑殑鍥炴樉
	 * @param request
	 * @param id 瑙勬牸id
	 * @return
	 */
	@RequestMapping("getSpec")
	@ResponseBody
	public Spec getSpec(HttpServletRequest request, int id){
		return specService.findById(id);
		
	}
	
	
	/**
	 * 鍒犻櫎瑙勬牸
	 * @param request
	 * @param id  瑙勬牸鐨刬d
	 * @return
	 */
	@RequestMapping("delSpec")
	@ResponseBody
	public String delSpec(HttpServletRequest request,int id) {
		//璋冪敤鏈嶅姟
		int delNum = specService.delete(id);
		return delNum>0?"success":"false";
	}
	
	/**
	 * 鍒犻櫎瑙勬牸
	 * @param request
	 * @param id  瑙勬牸鐨刬d
	 * @return
	 */
	@RequestMapping("delSpecBatch")
	@ResponseBody
	public String delSpecBatch(HttpServletRequest request,@RequestParam(name="ids[]") int[] ids) {
		System.out.println("瑕佸垹闄ょ殑棰濇暟鎹�");
		for (int i : ids) {
			System.out.println(" i is " + i  );
		}
		//璋冪敤鏈嶅姟
		int delNum = specService.deleteBatch(ids);
		return delNum>0?"success":"false";
	}

}
