package map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {

public static void main(String[] args) {
	ApplicationContext ctx = new ClassPathXmlApplicationContext("appCon.xml");
	Mapping m = ctx.getBean("Mapping" , Mapping.class);
	m.show();
}

}
