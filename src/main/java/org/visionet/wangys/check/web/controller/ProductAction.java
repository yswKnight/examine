package org.visionet.wangys.check.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.visionet.wangys.check.domain.Page;
import org.visionet.wangys.check.domain.Product;
import org.visionet.wangys.check.service.ProductService;
import org.visionet.wangys.check.service.TypeService;


/**************************************
 * 
 * @author 王永圣
 * @param  产品业务控制类
 */
@Controller
@RequestMapping("product")
public class ProductAction {
	@Resource
	private ProductService productService;
	@Resource
	private TypeService typeService;
	
	private Logger logger=Logger.getLogger(ProductAction.class);
	/*******************************************************************************************
	 * @return 跳转页面
	 * 
	 */
	@RequestMapping("/tomyproduct")
	public String tomyproduct(){
		
		return "listProduct";
	}
	
	/***************************************************************************************************
	 * @return 查看产品信息
	 */
	@RequestMapping("/listProductInfo")
	@ResponseBody
	public List<Product> listProductInfo(ModelMap map, HttpServletRequest request,Page page) throws Exception {
		//总页数
		int total=0;
		//总记录条数
		int zongshu = productService.getProductTotal();
		//当前页数
		int pageNo=1;
		
		if(zongshu%5==0){
			total = zongshu/5;
		}else{
			total = zongshu/5+1;
		}
		
		if(page.getStartRow()==0&&page.getPageNo()==0){
			page.setStartRow(0);
			page.setEndRow(5);
			page.setPageNo(1);
			//request.getSession().setAttribute("page", page);
		}else{
			if(page.getPageNo()>total){
				page.setPageNo(total);
			}
			if(page.getPageNo()==0){
				page.setPageNo(1);
			}
			page.setStartRow((page.getPageNo()-1)*5);
			page.setEndRow(100);
		}
		
		List<Product> list  = productService.listProductAll(page);
		System.err.println(list.toString());
		map.addAttribute("page", page);
		Product pro = (Product)list.get(0);
		return list;
	}
	
/*	public List<Product> listProductInfo(){
		logger.info("===ajax===");
		List<Product> list=this.productService.listProductAll();
		return list;
	}*/
	/***************************************************************************************************
	 * @return 增加产品信息
	 */
	@RequestMapping("/saveProductInfo")
	@ResponseBody
	public String saveProductInfo(Product product){
		String result="";
		try {
			//若取到的proid不为空时添加产品
			if(product.getProid()!=null){
				this.productService.addProduct(product);
				result="success";
			}else{
				System.out.println("取不到id值");
				result="error";
			}
		} catch (Exception e) {
			e.printStackTrace();
			result="error";
		}
		
		return result;
	}
	/***************************************************************************************************
	 * @return 修改产品信息
	 */
	//先到修改页面加载相关信息出来
	@RequestMapping("/toUpdate")
	@ResponseBody
	public String  toUpdate(HttpServletRequest request,Product product,ModelMap map){
		try {
				Integer pid=Integer.parseInt(request.getParameter("pid"));
				product=this.productService.listProductById(pid);
				map.addAttribute("pro",product);
				//map.put("pro",product);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	@RequestMapping("/updateProductInfo")
	@ResponseBody
	public String updateProductInfo(Product product){
		String result="";
		try {
				this.productService.modifyProduct(product);
				result="success";
		} catch (Exception e) {
			e.printStackTrace();
			result="error";
		}
		
		return result;
	}
	/***************************************************************************************************
	 * @return 删除产品信息
	 */
	@RequestMapping("/deleteProductInfo")
	@ResponseBody
	public String deleteProductInfo(HttpServletRequest request,Integer pid){
		String result="";
		try {
			pid=Integer.parseInt(request.getParameter("id"));
			this.productService.deleteProduct(pid);
			result="success";
		} catch (Exception e) {
			e.printStackTrace();
			result="error";
		}
		return result;
	}
	
	private Map<String , Object> map=new HashMap<String , Object>();

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

}
