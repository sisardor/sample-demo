package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.blackice.beans.CentralDbService;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

		
		//UserInfoBean u = (UserInfoBean) context.getBean("userInfoBean");
		CentralDbService centralDbService = (CentralDbService) context.getBean("tenant");
		
		CentralDbService centralDbService1 = (CentralDbService) context.getBean("tenant");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		ConfigurableBeanFactory beanFactory=  new DefaultListableBeanFactory();
//		Scope threadScope= new SimpleThreadScope();
//		beanFactory.registerScope("thread", threadScope);
        
    }
    
    
}
