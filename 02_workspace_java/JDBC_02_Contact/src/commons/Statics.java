package commons;

import java.math.BigInteger;
import java.security.MessageDigest;

import org.apache.commons.dbcp2.BasicDataSource;

public class Statics {
	public static BasicDataSource bds = new BasicDataSource(); 
	static {
		bds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		bds.setUsername("contact");
		bds.setPassword("contact");
		bds.setInitialSize(20);
	}
	
}
