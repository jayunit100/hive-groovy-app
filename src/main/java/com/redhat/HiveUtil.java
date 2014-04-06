package com.redhat;


import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hive.ql.parse.HiveParser_IdentifiersParser.booleanValue_return;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.util.Tool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * Hive View creator is designed to read from Pigs cleaned output.
 * The basic strategy is:
 * 
 * 1) store pig output as a hive table
 * 2) use "select .. as" to select a subset 
 * 
 * Note on running locally:
 * 
 * 1) Local mode requires a hive and hadoop tarball, with HIVE_HOME and
 * HADOOP_HOME pointing to it. 2) In HADOOP_HOME, you will need to cp the
 * HIVE_HOME/lib/hive-serde*jar file into HADOOP_HOME/lib.
 * 
 * Then, the below queries will run.
 * 
 * The reason for this is that the hive SerDe stuff is used in the MapReduce
 * phase of things, so those utils need to be available to hadoop itself. That
 * is because the regex input/output is processed vthe mappers
 * 
 */
public class HiveUtil {

    static {
        try{
            //Class.forName("org.apache.hadoop.hive.ql.exec.mr.ExecDriver");
            //Class.forName("org.apache.hadoop.hive.ql.exec.mr.ExecDriver");
            //System.out.println("found exec driver !!!!!!!!!!!!!!!!");
        }
        catch(Throwable t) {
            throw new RuntimeException(t);
        }
        try{
        }
        catch(Throwable t) {
            throw new RuntimeException(t);
        }
    }

    String con; 
    public HiveUtil(String server,String port) throws Exception {
        con=(String.format(
                //jdbc:hive2://<host>:<port>/<db>?hive.server2.transport.mode=http;hive.server2.thrift.http.path=<http_endpoint>
                "jdbc:hive2://%s:%s/default",
                    server,
                    port
                    ));
        
        System.out.println("Connection url : " + con);
    }
    
    public void selectPrint(String tableName) throws Exception {
        Statement stmt = getConnection();
        ResultSet rs = stmt.executeQuery("SELECT * from "+tableName + " LIMIT 10");
        
        int row =0;
        while(rs.next()) {
            System.out.println(String.format("row %s col 1: %s",row++,rs.getObject(1)));
        }
    }

    public static final String HIVE_JDBC_DRIVER = "org.apache.hive.jdbc.HiveDriver";

    private Statement getConnection() throws Exception,
            SQLException {
        try{Class.forName(HIVE_JDBC_DRIVER);
        System.out.println("Connect:  "+ this.con.toString() +"... getting connection timeout=" + DriverManager.getLoginTimeout());
 
        Connection jdbc = DriverManager.getConnection(this.con,"hive","password");
        
        Properties p = new Properties();
        p.setProperty("host", con);
        //Connection jdbc = new HiveConnection(con,p);
        
        System.out.println("hive con = " + con.getClass().getName());
        Statement stmt = jdbc.createStatement();
        return stmt;
        }
        catch (Throwable t) {
                 t.printStackTrace();
                 System.exit(1);
        }
        return null;
    }
    
    /**
    public static void main(String[] args) throws Exception {
        new HiveViewCreator()
            .run(args);
    }
    **/
}