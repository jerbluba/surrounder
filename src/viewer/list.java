package viewer;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.Close;
import manager.fileEditor;

/**
 * Servlet implementation class list
 */
@WebServlet(name="Viewer4", urlPatterns={"/Viewer4"},loadOnStartup=1)
public class list extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public list() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setLocale(Locale.TAIWAN);
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		
		String x=request.getParameter("x");
		String y=request.getParameter("y");
		String z=request.getParameter("z");
		String type=request.getParameter("type");
		
		String answer="";
		HashMap<String,String> menu=manager.fileEditor.getMenus();
		
		java.sql.Connection con = null;
        java.sql.PreparedStatement ps = null;
        ResultSet rs= null;
        try {
        	String sql = "select name, picName,comment,cla from henry where x='"+x+"' and y='"+y+"' and z='"+z+"'";
            con = manager.DataSource.getConnection(menu);
            ps = con.prepareStatement(sql);
            rs= ps.executeQuery(sql);
            
            answer+="<table id='list' class='"+x+"plus"+y+"plus"+z+"'><tr><td colspan='2' id='textTitle'>熱點清單</td><td>close</td></tr><tr><td id='firstCol'>姓名</td><td id='firstCol'>註解</td><td id='firstCol'>開關</td></tr>";
            while(rs.next()){
            	String comment=rs.getString("comment");
            	String picName=rs.getString("picName");
            	String board="<td>";
            	int rowspan=1;
            	
            	if(comment.length()<=20){
            		board+=comment+"</td><td class='buttom' id='"+picName+"' rowspan="+rowspan+"></td></tr>";
            	}else if(comment.length()>20&&comment.length()<=40){
            		board+=comment.substring(0, 20)+"</td><td class='buttom' id='"+picName+"' rowspan="+rowspan+"></td></tr>"
            				+ "<tr><td>"
            				+comment.substring(20, comment.length())
            				+ "</td></tr>";
            		rowspan=2;
            	}else if(comment.length()>40&&comment.length()<=60){
            		board+=comment.substring(0, 20)+"</td><td class='buttom' id='"+picName+"' rowspan="+rowspan+"></td></tr>"
            				+ "<tr><td>"
            				+comment.substring(20, 40)
            				+ "</td></tr>"
            				+ "<tr><td>"
            				+comment.substring(40, comment.length())
            				+ "</td></tr>";
            		rowspan=3;
            	}else if(comment.length()>60&&comment.length()<=80){
            		board+=comment.substring(0, 20)+"</td><td class='buttom' id='"+picName+"' rowspan="+rowspan+"></td></tr>"
            				+ "<tr><td>"
            				+comment.substring(20, 40)
            				+ "</td></tr>"
            				+ "<tr><td>"
            				+comment.substring(40, 60)
            				+ "</td></tr>"
            				+ "<tr><td>"
            				+comment.substring(60, comment.length())
            				+ "</td></tr>";
            		rowspan=4;
            	}else if(comment.length()>80){
            		board+=comment.substring(0, 20)+"</td><td class='buttom' id='"+picName+"' rowspan="+rowspan+"></td></tr>"
            				+ "<tr><td>"
            				+comment.substring(20, 40)
            				+ "</td></tr>"
            				+ "<tr><td>"
            				+comment.substring(40, 60)
            				+ "</td></tr>"
            				+ "<tr><td>"
            				+comment.substring(60, 80)
            				+ "</td></tr>"
            				+ "<tr><td>"
            				+comment.substring(80, comment.length())
            				+ "</td></tr>";
            		rowspan=5;
            	}
            	 answer+="<tr><td  id='firstCol' rowspan="+rowspan+">第 "+rs.getString("cla")+" 組<br>"+rs.getString("name")+"</td>"
            	 		+ board;
             	
            }
            answer+="</table>";
        } catch (java.sql.SQLException e) {
           
            e.printStackTrace();
        }finally{
        	Close.Single(rs);
			Close.Single(ps);
			Close.Single(con);
        	
        }
		
		out.println(
				viewer.basic.combineContent(
						"環景圖註解", 
						"<div id='listfield'>"
//						+manager.toogle.listTable(x, y, z, type)
						+answer
						+"</div><div id='imagefield'></div>", 
						"list",
						new String[]{"viewer4"},
						fileEditor.getMenus()
						));
		out.close();
		
		
	}

}
