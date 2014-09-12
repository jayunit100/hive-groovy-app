package javatests;
import junit.framework.Assert;

import org.apache.log4j.BasicConfigurator;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import com.redhat.HiveUtil;

public class JavaTest {
  
	@Test 
	public void testJavaClassNameExample() {
	        assertEquals("com.redhat.HiveUtil",com.redhat.HiveUtil.class.getName());
	}

}
