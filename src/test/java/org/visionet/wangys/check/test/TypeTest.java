package org.visionet.wangys.check.test;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.visionet.wangys.check.domain.Product;
import org.visionet.wangys.check.domain.Type;
import org.visionet.wangys.check.service.ProductService;
import org.visionet.wangys.check.service.TypeService;

public class TypeTest {
	@Resource
	ApplicationContext ctx;
	@Resource
	SqlSessionFactory sqlSessionFactory;
	@Resource
	 TypeService typeService;
	
	@Before
	public void init(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		typeService = (TypeService) ctx.getBean(TypeService.class);
	}
	
	
	@Test
	public void  listAllType(){
		
		//Product product=new Product();
		/*************************
		 * @param 查看产品类别信息
		 */
		//System.err.println(productService.listProductAll().toString());
		List<Type> list=typeService.listAllType();
		for(Object i:list){
			System.err.println(i.toString());
		}
		System.err.println("-----------------查询成功----------------------");
		
	}
	/*************************
	 * @param 增加产品类别
	 */
	Type type=new Type();
	@Test
	public void  addType(){
		type.setTypeid(3);
		type.setTypename("零食");
		typeService.addType(type);
		System.err.println("-------------添加成功------------");
		
	}
	//修改
	@Test
	public void  updateType(){
		type.setTypeid(3);
		type.setTypename("饮料");
		typeService.modifyType(type);
		System.err.println("-------------修改成功------------");
		
	}
	//删除
	@Test
	public void  deleteType(){
		typeService.deleteType(3);
		System.err.println("-------------删除成功------------");
		
	}
}
