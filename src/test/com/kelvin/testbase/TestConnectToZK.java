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
	//kelvin - 在这个代码中，我链接到了本地起来的ZK，然后在内部设置了属性，访问成功，可以log打印出节点地址
		
	ZookeeperClientUtil zkclient = new ZookeeperClientUtil();
	zkclient.setServers("127.0.0.1:2181");
	zkclient.setMainPath("/PilotProject");
	List<String> testList = zkclient.getChildren();
	logger.info(testList.toString());

	
	//	ZooKeeper zk = zkclient.getAliveZk();
//	string test = zk.get
	}
}
