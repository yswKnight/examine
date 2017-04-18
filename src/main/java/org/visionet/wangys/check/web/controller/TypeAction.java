package org.visionet.wangys.check.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.visionet.wangys.check.domain.Type;
import org.visionet.wangys.check.service.TypeService;

/**************************************
 * 
 * @author 王永圣
 * @param  产品类别业务控制类
 */
@Controller
@RequestMapping("type")
public class TypeAction {

	@Resource
	private TypeService typeService;
	
	private Logger logger=Logger.getLogger(TypeAction.class);
	
	//查询类别
	@RequestMapping("/listTypeInfo")
	@ResponseBody
	public List<Type> listTypeInfo(ModelMap map,Type type){
		logger.info("=====typeAction=====");
		List<Type> list= this.typeService.listAllType();
		
		return list;
	}
}
