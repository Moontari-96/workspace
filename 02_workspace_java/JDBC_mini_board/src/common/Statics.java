package common;

import org.apache.commons.dbcp2.BasicDataSource;

public class Statics {
	public static String name = "";
	public static BasicDataSource bds1 = new BasicDataSource(); 
	static {
		bds1.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		bds1.setUsername("kedu01");
		bds1.setPassword("kedu01");
		bds1.setInitialSize(5);
	}
}
