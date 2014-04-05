package com.redhat
import org.junit.Before
import org.junit.Test

class HiveConnectionTest {

	@Before void beforeTest() {
        
	}

	@Test void shouldDoSomethingGroovy() {
        
        String host = "localhost";
        //String host = "ec2-54-213-193-118.us-west-2.compute.amazonaws.com";
        String port = 9999;
        HiveUtil hive = new HiveUtil(host,port);
        hive.selectPrint("firewall");
    }

}
