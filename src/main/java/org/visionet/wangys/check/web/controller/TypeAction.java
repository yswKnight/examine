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
 * @author ����ʥ
 * @param  ��Ʒ���ҵ�������
 */
@Controller
@RequestMapping("type")
public class TypeAction {

	@Resource
	private TypeService typeService;
	
	private Logger logger=Logger.getLogger(TypeAction.class);
	
	//��ѯ���
	@RequestMapping("/listTypeInfo")
	@ResponseBody
	public List<Type> listTypeInfo(ModelMap map,Type type){
		logger.info("=====typeAction=====");
		List<Type> list= this.typeService.listAllType();
		
		return list;
	}
}
