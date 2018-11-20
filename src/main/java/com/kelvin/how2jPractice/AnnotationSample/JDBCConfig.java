package com.kelvin.how2jPractice.AnnotationSample;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static java.lang.annotation.RetentionPolicy.CLASS;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
 
@Target({METHOD,TYPE})
@Retention(CLASS)
@Inherited
@Documented
public @interface JDBCConfig {
     String ip();
     int port() default 3306;
     String database();
     String encoding();
     String loginName();
     String password();
}


//@Target 表示这个注解能放在什么位置上，是只能放在类上？还是即可以放在方法上，又可以放在属性上。自定义注解@JDBCConfig 这个注解上的@Target是：@Target({METHOD,TYPE})，表示他可以用在方法和类型上（类和接口），但是不能放在属性等其他位置。 可以选择的位置列表如下：
	//ElementType.TYPE：能修饰类、接口或枚举类型
	//ElementType.FIELD：能修饰成员变量
	//ElementType.METHOD：能修饰方法
	//ElementType.PARAMETER：能修饰参数
	//ElementType.CONSTRUCTOR：能修饰构造器
	//ElementType.LOCAL_VARIABLE：能修饰局部变量
	//ElementType.ANNOTATION_TYPE：能修饰注解
	//ElementType.PACKAGE：能修饰包

//@Retention 表示生命周期，自定义注解@JDBCConfig 上的值是 RetentionPolicy.RUNTIME, 表示可以在运行的时候依然可以使用。 @Retention可选的值有3个：
	//
	//RetentionPolicy.SOURCE： 注解只在源代码中存在，编译成class之后，就没了。@Override 就是这种注解。
	//RetentionPolicy.CLASS： 注解在java文件编程成.class文件后，依然存在，但是运行起来后就没了。@Retention的默认值，即当没有显式指定@Retention的时候，就会是这种类型。
	//RetentionPolicy.RUNTIME： 注解在运行起来之后依然存在，程序可以通过反射获取这些信息，自定义注解@JDBCConfig 就是这样。
	//大家可以试试把自定义注解@JDBCConfig的@Retention改成其他两种，并且运行起来，看看有什么不同

//@Inherited 表示该注解具有继承性。如例，设计一个DBUtil的子类，其getConnection2方法，可以获取到父类DBUtil上的注解信息。

//@Documented 是为了生成注解说明

//当没有@Repeatable修饰的时候，注解在同一个位置，只能出现一次，如例所示：
//@JDBCConfig(ip = "127.0.0.1", database = "test", encoding = "UTF-8", loginName = "root", password = "admin")
//@JDBCConfig(ip = "127.0.0.1", database = "test", encoding = "UTF-8", loginName = "root", password = "admin")
//重复做两次就会报错了。 
//使用@Repeatable之后，再配合一些其他动作，就可以在同一个地方使用多次了。