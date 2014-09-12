package com.redhat
import org.apache.log4j.BasicConfigurator;
import org.junit.Before
import org.junit.Test

/**
*  An example of a sample groovy test. 
*  This is not necessary for pure java projects, 
*  but its nice to keep around in case you might
*  want to make your project polyglot at some point.
*/
class HiveConnectionTest {

	@Before void beforeTest() {
        
	}

	@Test 
	public void shouldDoSomethingGroovy() {
        BasicConfigurator.configure();
        String host = "localhost";
        //String host = "ec2-54-213-193-118.us-west-2.compute.amazonaws.com";
        String port = 10000;
        HiveUtil hive = new HiveUtil(host,port);
        hive.selectPrint("firewall");
    }

}
