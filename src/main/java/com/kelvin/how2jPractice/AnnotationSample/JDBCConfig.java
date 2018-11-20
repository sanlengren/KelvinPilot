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


//@Target ��ʾ���ע���ܷ���ʲôλ���ϣ���ֻ�ܷ������ϣ����Ǽ����Է��ڷ����ϣ��ֿ��Է��������ϡ��Զ���ע��@JDBCConfig ���ע���ϵ�@Target�ǣ�@Target({METHOD,TYPE})����ʾ���������ڷ����������ϣ���ͽӿڣ������ǲ��ܷ������Ե�����λ�á� ����ѡ���λ���б����£�
	//ElementType.TYPE���������ࡢ�ӿڻ�ö������
	//ElementType.FIELD�������γ�Ա����
	//ElementType.METHOD�������η���
	//ElementType.PARAMETER�������β���
	//ElementType.CONSTRUCTOR�������ι�����
	//ElementType.LOCAL_VARIABLE�������ξֲ�����
	//ElementType.ANNOTATION_TYPE��������ע��
	//ElementType.PACKAGE�������ΰ�

//@Retention ��ʾ�������ڣ��Զ���ע��@JDBCConfig �ϵ�ֵ�� RetentionPolicy.RUNTIME, ��ʾ���������е�ʱ����Ȼ����ʹ�á� @Retention��ѡ��ֵ��3����
	//
	//RetentionPolicy.SOURCE�� ע��ֻ��Դ�����д��ڣ������class֮�󣬾�û�ˡ�@Override ��������ע�⡣
	//RetentionPolicy.CLASS�� ע����java�ļ���̳�.class�ļ�����Ȼ���ڣ����������������û�ˡ�@Retention��Ĭ��ֵ������û����ʽָ��@Retention��ʱ�򣬾ͻ����������͡�
	//RetentionPolicy.RUNTIME�� ע������������֮����Ȼ���ڣ��������ͨ�������ȡ��Щ��Ϣ���Զ���ע��@JDBCConfig ����������
	//��ҿ������԰��Զ���ע��@JDBCConfig��@Retention�ĳ��������֣���������������������ʲô��ͬ

//@Inherited ��ʾ��ע����м̳��ԡ����������һ��DBUtil�����࣬��getConnection2���������Ի�ȡ������DBUtil�ϵ�ע����Ϣ��

//@Documented ��Ϊ������ע��˵��

//��û��@Repeatable���ε�ʱ��ע����ͬһ��λ�ã�ֻ�ܳ���һ�Σ�������ʾ��
//@JDBCConfig(ip = "127.0.0.1", database = "test", encoding = "UTF-8", loginName = "root", password = "admin")
//@JDBCConfig(ip = "127.0.0.1", database = "test", encoding = "UTF-8", loginName = "root", password = "admin")
//�ظ������ξͻᱨ���ˡ� 
//ʹ��@Repeatable֮�������һЩ�����������Ϳ�����ͬһ���ط�ʹ�ö���ˡ�