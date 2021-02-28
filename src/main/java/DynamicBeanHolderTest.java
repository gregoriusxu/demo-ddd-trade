
import java.util.HashMap;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

import com.demo2.support.utils.DynamicBeanHolder;

@SpringBootApplication
@ComponentScan(basePackages = { "com.demo2" })
@ImportResource(locations = { "classpath*:applicationContext-*.xml" })
@MapperScan("com.demo2.support.dao")
public class DynamicBeanHolderTest {

	private static DynamicBeanHolder dynamicBeanHolder;

	public DynamicBeanHolder getDynamicBeanHolder() {
		return dynamicBeanHolder;
	}

	@Autowired
	public void setDynamicBeanHolder(DynamicBeanHolder dynamicBeanHolder) {
		DynamicBeanHolderTest.dynamicBeanHolder = dynamicBeanHolder;
	}

	public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException {
		SpringApplication.run(DynamicBeanHolderTest.class, args);

		// 设置属性们，默认16
		HashMap propertyMap = new HashMap(16);
		propertyMap.put("name", String.class);
		propertyMap.put("age", Integer.class);
		propertyMap.put("height", Double.class);
		Object generateObject = dynamicBeanHolder.generateObject("person", propertyMap);
		// 生成动态 Entity
		// DynamicBeanHold bean = new DynamicBeanEntity(propertyMap);
		// 设置属性值
		dynamicBeanHolder.setValue(generateObject, "name", "zx");
		dynamicBeanHolder.setValue(generateObject, "age", 22);
		dynamicBeanHolder.setValue(generateObject, "height", 175.0);
		// 获取属性值
		Object nameObject = dynamicBeanHolder.getValue(generateObject, "name");
		// 获取可执行的方法
		// MultiValueMap methods = bean.getMethods();
		// 执行某个方法
		// dynamicBeanHolder.executeMethod("setAge", 23);
		System.out.println("动态bean的name属性：" + nameObject.toString());
	}
}