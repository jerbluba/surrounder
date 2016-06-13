package manager;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

import javax.swing.JOptionPane;

import org.apache.log4j.Logger;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.jdbc2.optional.*;

public class DataSource {
    private static MysqlDataSource ds = null;
    private static java.util.Properties p = null;
    private Logger logger = Logger.getLogger(this.getClass());

    public static javax.sql.DataSource getPool(HashMap<String,String> menu) {
        if (ds == null){
            ds = new MysqlDataSource();
            ds.setServerName(menu.get("server"));
            ds.setPortNumber(Integer.parseInt(menu.get("port")));
            ds.setDatabaseName(menu.get("db"));
            ds.setUser(menu.get("user"));
            ds.setPassword(menu.get("password"));
            ds.setCharacterEncoding("utf-8");
        }
 
        return ds;
    }
 
    public static java.sql.Connection getConnection(HashMap<String,String> menu)
            throws java.sql.SQLException {
        return getPool(menu).getConnection();
    }
 
    public static void main(String args[]){
    	  p = new java.util.Properties();
    	  p.setProperty("menu", "1230");
    	System.out.println(p.getProperty("menu"));
    	try {
			java.sql.Connection con = manager.DataSource.getConnection(manager.fileEditor.getMenus());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
 
}
