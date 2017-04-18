package org.visionet.wangys.check.test;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.visionet.wangys.check.domain.Product;
import org.visionet.wangys.check.domain.Type;
import org.visionet.wangys.check.persistence.ProductMapper;
import org.visionet.wangys.check.service.ProductService;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**************************
 * 
 * @author 王永圣
 *测试
 */
public class ProductTest {
	@Resource
	ApplicationContext ctx;
	@Resource
	SqlSessionFactory sqlSessionFactory;
	@Resource
	 ProductService productService;
	@Resource
	ProductMapper productMapper;
	
	private Logger logger=Logger.getLogger(ProductTest.class);
	@Before
	public void init(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("mybatisConfig.xml","applicationContext.xml");
		productService = (ProductService) ctx.getBean(ProductService.class);
	}
/*	
	 @Test
		public void testPageList(){
			PageHelper.startPage(1,5);// 头上分页
			List<User> list=userService.queryAllList();
			System.out.println(list.size());
		}
*/


		@Test
		public void testPageList(){
			//PageHelper.startPage(1,5);// 头上分页
			//List<Product> list=productService.listProductAll();
			//System.out.println(list.size());
			Page<Product> page = PageHelper.startPage(1, 3);
	        //selectAll查询出的List即为上面定义的page
			//productMapper.findProductAll(page);
	        //注意：
	        //使用PageHelper.startPage只是针对接下来的一条查询语句，
	        //如果又查询了一次数据，则还需要使用一次PageHelper.startPage
	        logger.info("获取所有Doctor信息，获得记录数：{}"+ page.size());
	        logger.info("获取所有Doctor信息，获得记录：{}"+page);
	        System.err.println("获取所有Doctor信息，获得记录数：{}"+page.size());
	        System.err.println("获取所有Doctor信息，获得记录：{}"+page);
	        //使用PageInfo封装
	        PageInfo<Product> info = new PageInfo<Product>(page);
	        logger.info("info.getPages:{}"+info.getPages());
	        System.err.println("info.getPages:{}"+info.getPages());
		}

	@Test
	public void  listAllProducts(){
		
		//Product product=new Product();
		/*************************
		 * @param 查看产品信息
		 */
		//System.err.println(productService.listProductAll().toString());
		//List<Product> list=productService.listProductAll();
		/*for(Object i:list){
			System.err.println(i.toString());
		}
		System.err.println("-----------------连接成功----------------------");*/
		
	}
	/*************************
	 * @param 根据ID查看产品信息
	 */
	@Test
	public void  listAllProductsbyid(){
		
		//Product product=new Product();
	
		System.err.println(productService.listProductById(33322));
		System.err.println("-----------------连接成功----------------------");
		
	}
	/*************************
	 * @param 增加产品信息
	 */
	Product product=new Product();
	Type type=new Type();
	@Test
	public void  addProducts(){
		product.setProid(1003);
		product.setProname("iPhone7");
		product.setProremark("系统好");
		type.setTypeid(1);
		product.setProtype(type);
		productService.addProduct(product);
		System.err.println("-------------添加成功------------");
		
	}
	//修改
	@Test
	public void  updateProducts(){
		product.setProid(1003);
		product.setProname("iPhone8");
		product.setProremark("系统好a");
		type.setTypeid(1);
		product.setProtype(type);
		productService.modifyProduct(product);
		System.err.println("-------------修改成功------------");
		
	}
	//删除
	@Test
	public void  deleteProducts(){
		productService.deleteProduct(345);
		System.err.println("-------------删除成功------------");
		
	}
	
	


}
