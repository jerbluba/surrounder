package viewer;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;






import manager.Close;
import manager.fileEditor;
import manager.toogle;

/**
 * Servlet implementation class hotPoint
 */
@WebServlet(name="Viewer3", urlPatterns={"/Viewer3"},loadOnStartup=1)
public class hotPoint extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public hotPoint() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setLocale(Locale.TAIWAN);
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		
		String x=request.getParameter("x");
		String y=request.getParameter("y");
		String z=request.getParameter("z");

		out.println(
				viewer.basic.combineContent(
					"加註或瀏覽", 
					"<FORM action=getFile.jsp method=post enctype=multipart/form-data name=FileName id='send' accept-charset='UTF-8'>"
					+manager.toogle.hotTable(x,y,z,"")+"</FORM>", 
						"uploader",
						new String[]{"viewer3"},
						fileEditor.getMenus()
						));
		out.close();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
//		JOptionPane.showMessageDialog(null, "開始POST", "訊息", JOptionPane.INFORMATION_MESSAGE);
		
		response.setLocale(Locale.TAIWAN);
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		HashMap<String,String> menu=manager.fileEditor.getMenus();
		
		String picName=request.getParameter("picName");
		String name=request.getParameter("name");
		String type=request.getParameter("type");
		String comment=request.getParameter("comment");
		String x=request.getParameter("x");
		String y=request.getParameter("y");
		String z=request.getParameter("z");
		String cla=request.getParameter("cla");
		
		String log="";
			        
		if(x.equals("wrong")){
			log+=menu.get("wrong");
			
		}else{
			java.sql.Connection con = null;
			java.sql.PreparedStatement ps = null;
	          try {
	          	String sql = "insert into henry(picName,type,name,comment,x,y,z,cla) values(?,?,?,?,?,?,?,?)";
	              con = manager.DataSource.getConnection(menu);
	              ps = con.prepareStatement(sql);
	              int idx = 0;
	              ps.setString(++idx, manager.StringTool.reFormat(picName));
	              ps.setString(++idx, manager.StringTool.reFormat(type));
	              ps.setString(++idx, manager.StringTool.reFormat(name));	              
	              ps.setString(++idx, manager.StringTool.reFormat(comment));
	              ps.setString(++idx, manager.StringTool.reFormat(x));                    
	              ps.setString(++idx, manager.StringTool.reFormat(y));
	              ps.setString(++idx, manager.StringTool.reFormat(z));
	              ps.setString(++idx, manager.StringTool.reFormat(cla));
	              ps.executeUpdate();
	              
	
	              
	              log+=menu.get("success");    
	     
	          } catch (java.sql.SQLException e) {
	             
	              e.printStackTrace();
	              log+=menu.get("fail");
	                 
	          }catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				Close.Single(ps);
				Close.Single(con);
			}
			              
		}
		
 
			
			out.println(viewer.basic.combineContent(
					log, 
					"<FORM action=getFile.jsp method=post enctype=multipart/form-data name=FileName id='send' accept-charset='UTF-8'>"+
					manager.toogle.hotTable(x,y,z,log)+"</FORM>", 
					"uploader",
					new String[]{"viewer3"},
					fileEditor.getMenus()
					)
					);
		out.close();
	}
}
