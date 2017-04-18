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
 * @author ����ʥ
 *����
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
			PageHelper.startPage(1,5);// ͷ�Ϸ�ҳ
			List<User> list=userService.queryAllList();
			System.out.println(list.size());
		}
*/


		@Test
		public void testPageList(){
			//PageHelper.startPage(1,5);// ͷ�Ϸ�ҳ
			//List<Product> list=productService.listProductAll();
			//System.out.println(list.size());
			Page<Product> page = PageHelper.startPage(1, 3);
	        //selectAll��ѯ����List��Ϊ���涨���page
			//productMapper.findProductAll(page);
	        //ע�⣺
	        //ʹ��PageHelper.startPageֻ����Խ�������һ����ѯ��䣬
	        //����ֲ�ѯ��һ�����ݣ�����Ҫʹ��һ��PageHelper.startPage
	        logger.info("��ȡ����Doctor��Ϣ����ü�¼����{}"+ page.size());
	        logger.info("��ȡ����Doctor��Ϣ����ü�¼��{}"+page);
	        System.err.println("��ȡ����Doctor��Ϣ����ü�¼����{}"+page.size());
	        System.err.println("��ȡ����Doctor��Ϣ����ü�¼��{}"+page);
	        //ʹ��PageInfo��װ
	        PageInfo<Product> info = new PageInfo<Product>(page);
	        logger.info("info.getPages:{}"+info.getPages());
	        System.err.println("info.getPages:{}"+info.getPages());
		}

	@Test
	public void  listAllProducts(){
		
		//Product product=new Product();
		/*************************
		 * @param �鿴��Ʒ��Ϣ
		 */
		//System.err.println(productService.listProductAll().toString());
		//List<Product> list=productService.listProductAll();
		/*for(Object i:list){
			System.err.println(i.toString());
		}
		System.err.println("-----------------���ӳɹ�----------------------");*/
		
	}
	/*************************
	 * @param ����ID�鿴��Ʒ��Ϣ
	 */
	@Test
	public void  listAllProductsbyid(){
		
		//Product product=new Product();
	
		System.err.println(productService.listProductById(33322));
		System.err.println("-----------------���ӳɹ�----------------------");
		
	}
	/*************************
	 * @param ���Ӳ�Ʒ��Ϣ
	 */
	Product product=new Product();
	Type type=new Type();
	@Test
	public void  addProducts(){
		product.setProid(1003);
		product.setProname("iPhone7");
		product.setProremark("ϵͳ��");
		type.setTypeid(1);
		product.setProtype(type);
		productService.addProduct(product);
		System.err.println("-------------��ӳɹ�------------");
		
	}
	//�޸�
	@Test
	public void  updateProducts(){
		product.setProid(1003);
		product.setProname("iPhone8");
		product.setProremark("ϵͳ��a");
		type.setTypeid(1);
		product.setProtype(type);
		productService.modifyProduct(product);
		System.err.println("-------------�޸ĳɹ�------------");
		
	}
	//ɾ��
	@Test
	public void  deleteProducts(){
		productService.deleteProduct(345);
		System.err.println("-------------ɾ���ɹ�------------");
		
	}
	
	


}
