package viewer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Locale;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.fileEditor;



/**
 * Servlet implementation class page1_1
 */
@WebServlet(name="Viewer0", urlPatterns={"/Viewer0"},loadOnStartup=1)
public class pageToogle extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
		resp.setLocale(Locale.TAIWAN);
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		
		out.println(
				viewer.basic.combineContent(
						"環景圖註解", 
						manager.toogle.mainTable(), 
						"screen",
						new String[]{"viewer0","viewer1","viewer2"},
						fileEditor.getMenus()
						));
		out.close();
	}

	
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pageToogle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#getServletConfig()
	 */
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

}
