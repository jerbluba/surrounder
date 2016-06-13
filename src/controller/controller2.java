package controller;
import java.sql.*; //完成環境設置，導入java.sql包
import java.util.HashMap;







public class controller2 {

	
	/* package whatever; // don't place package name! */



	/* Name of the class has to be "Main" only if the class is public. */
	
	
	public controller2() 
{
}
//declare variable
private Connection conn = null;
private ResultSet rs = null;
private String server = "127.0.0.1"; // Can't use localhost , you must use IP or CNAME 
private String port = "3306"; //change to your port 
private String db = "publish"; //change to your db name
private String user = "root"; //change to your username
private String pass = "root"; //change to your password
private String drivername="org.gjt.mm.mysql.Driver"; //mysql driver
private String URL="jdbc:mysql://"+server+":"+port+"/"+db+"?useUnicode=true&characterEncoding=GBK&user="+user+"&password="+pass;

public Connection getConn(){ //get database connection
 HashMap<String,String> menus=manager.fileEditor.getMenus();
 server =	menus.get("server");
 port =	menus.get("port");
 db =	menus.get("db");
 user =	menus.get("user");
 pass =	menus.get("password");
 drivername=	menus.get("drivername");
 

 try{
	 Class.forName(drivername).newInstance(); //載入驅動器
	 conn = DriverManager.getConnection(URL); //連接到數據庫
 }
 catch(Exception e){
 e.printStackTrace();
 }
 return conn ;
}
public ResultSet executeSQL(String str) {
 try{
 Statement stmt = conn.createStatement(); //語句接口
 rs = stmt.executeQuery(str); //獲得結果集
 }
 catch(Exception e){
 e.printStackTrace();
 }
 return rs;
} 
}

