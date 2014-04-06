package com.redhat
import org.apache.log4j.BasicConfigurator;
import org.junit.Before
import org.junit.Test

class HiveConnectionTest {

	@Before void beforeTest() {
        
	}

	@Test void shouldDoSomethingGroovy() {
        BasicConfigurator.configure();
        String host = "localhost";
        //String host = "ec2-54-213-193-118.us-west-2.compute.amazonaws.com";
        String port = 10000;
        HiveUtil hive = new HiveUtil(host,port);
        hive.selectPrint("firewall");
    }

}
