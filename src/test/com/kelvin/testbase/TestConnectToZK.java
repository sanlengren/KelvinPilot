package com.kelvin.testbase;

import java.util.List;

import org.apache.zookeeper.ZooKeeper;
import org.junit.Test;

import com.kelvin.util.ZookeeperClientUtil;
import com.sun.istack.internal.logging.Logger;

public class TestConnectToZK {
	
	private static Logger logger = Logger.getLogger(TestConnectToZK.class);
	@Test
	public void testconnection(){
	//kelvin - ����������У������ӵ��˱���������ZK��Ȼ�����ڲ����������ԣ����ʳɹ�������log��ӡ���ڵ��ַ
		
	ZookeeperClientUtil zkclient = new ZookeeperClientUtil();
	zkclient.setServers("127.0.0.1:2181");
	zkclient.setMainPath("/PilotProject");
	List<String> testList = zkclient.getChildren();
	logger.info(testList.toString());

	
	//	ZooKeeper zk = zkclient.getAliveZk();
//	string test = zk.get
	}
}
