package manager;

import java.util.HashMap;


public class tablePost {
	
	
	String Title="";
	
	public static String subTable(String log,String name,String title,String mail,String tel,String cel,String desc,String language){
	//	ReCaptcha c = ReCaptchaFactory.newReCaptcha("6Lcy_QYTAAAAAMcsDa6AJ7APtZ5kgYm8XHJqfCUF", "6Lcy_QYTAAAAADGriAqvDoK197hdApsuaYUN8g2F", false);
		
		
		String answer="";
//		String[] titles= myBoard.judge.judgeString.titles(language); 
//		String[] bugs= myBoard.judge.judgeString.bugs(language);
//		String[] subTitles= myBoard.judge.judgeString.subTitles(language);
//		answer+="<h1 id='textTitle'>" +
//				myBoard.tools.fileEditor.readExcel("menu", language, "page6_1")+
//				"</h1>	<form id=\"myform\" name=\"myform\" action=\"postIt\" method=\"post\" >	"
//				+"	<!-- target=\"_hiddenframe\">	"
//				+"	 -->	"
//				+"	  	"
//				+"	<dl class=\"memberFormContact\">	"
//				+(log.equals("")?"":"<dd>"+log+"</dd>")
//				+"<dd><h2 id='textSubTitle'>" +
//				myBoard.judge.judgeString.tablePost(language) +
//				"</h2></dd>	    <dd>	"				
//				+"	        <label class=\"labelName\">" +
//				myBoard.judge.judgeString.tablePost_1(language) +
//				"</label>	"
//				+"	        <div>" +
//				"<input id='radio01' type=\"radio\" name=\"title\" value=\"" +
//				titles[0] +
//				"\" />" +
//				"<label for=\"radio01\">" +
//				titles[0] +
//				"&nbsp;&nbsp;</label>" +
//				"<input id='radio02'  type=\"radio\" name=\"title\" value=\"" +
//				titles[1] +
//				"\"/>" +
//				"<label for=\"radio02\">" +
//				titles[1] +
//				"&nbsp;&nbsp;</label>" +
//				"<input id='radio03'  type=\"radio\" name=\"title\" value=\"" +
//				titles[2]+
//				"\"/>"  +
//				"<label for=\"radio03\">" +
//				titles[2]+
//				"&nbsp;&nbsp;</label>" +
//				"<input id='radio04'  type=\"radio\" name=\"title\" value=\"" +
//				titles[3] +
//				"\"/>" +
//				"<label for=\"radio04\">" +
//				titles[3] +
//				"&nbsp;</label><label id='textSubTitle'>*</label>" +
//				"<span id=\"bug0\" style=\"color:Red;color:Red;visibility:hidden;\">" +
//				bugs[0] +
//				"</span>"+
//				"</div>	"
//				+"	    </dd>	"
//				+"	    	"
//				+"	    <dd>	"
//				+"	        <label class=\"labelName\">" +
//				subTitles[0] +
//				"</label>	"
//				+"	        <div><input type=\"text\" name=\"name\" id=\"name\" value=\"" 
//				+(name.length()<3?name:name.substring(0,name.length()-3))
//				+"\"/><select id='sex' name='sex'><option value='mr'>" +
//				subTitles[1]  +
//				"</option><option value='miss'>" +
//				subTitles[2]  +
//				"</option></select>&nbsp;&nbsp;<label id='textSubTitle'>*</label>" +
//				"<span id=\"bug1\" style=\"color:Red;color:Red;visibility:hidden;\">" +
//				bugs[1] +
//				"</span>"+
//				"</div>	"
//				+"	    </dd>	"
//				+"	    	"
//				+"	    <dd>	"
//				+"	        <label class=\"labelName\">" +
//				subTitles[3]  +
//				"</label>	"
//				+"	        <div><input type=\"text\" name=\"tel\" id=\"tel\" onkeyup=\"value=value.replace(/[^0-9-#]/g,&#39;&#39;);\" value=\"" 
//				+tel
//				+"\"/>&nbsp;&nbsp;<label id='textSubTitle'>*</label>" 
//				+
//				"</div>	"
//				+"	    </dd>	"
//				+"	    	"
//				+"	    <dd>	"
//				+"	        <label class=\"labelName\">" +
//				subTitles[4]  +
//				"</label>	"
//				+"	        <div><input type=\"text\" name=\"cell\" id=\"cell\" onkeyup=\"value=value.replace(/[^0-9-#]/g,&#39;&#39;);\" value=\"" 
//				+cel
//				+"\"/>&nbsp;&nbsp;<label id='textSubTitle'>*</label>" 
//				+"<span id=\"bug4\" style=\"color:Red;color:Red;visibility:hidden;\">" +
//				bugs[2] +
//				"</span>"
//				+"</div>	"
//				+"	    </dd>	"
//				+"	    	"
//				+"	    	"
//				+"	    <dd>	"
//				+"	        <label class=\"labelName\">E-mail:</label>	"
//				+"	        <div><input type=\"text\" name=\"mail\" id=\"mail\" value=\"" 
//				+mail
//				+"\"/>&nbsp;&nbsp;<label id='textSubTitle'>*</label>" +
//				"<span id=\"bug2\" style=\"color:Red;color:Red;visibility:hidden;\">" +
//				bugs[3] +
//				"</span>"+
//				"</div>	"
//				+"	    </dd>	"
//				+"	    	"
//				+"	    <dd>	"
//				+"	    <label class=\"labelName\">" +
//				subTitles[5]  +
//				"</label>"
//				+"<span id=\"bug3\" style=\"color:Red;color:Red;visibility:hidden;\">" +
//				bugs[4] +
//				"</span>"
//				+"	        <div colspan=\"2\"><textarea cols=\"28\" rows=\"10\" name=\"desc\" id=\"desc\" >" 
//				+desc
//				+"</textarea>&nbsp;&nbsp;<label id='textSubTitle'>*</label></div>	"
//				+"	    </dd>	"
//				+"		"
//				+"	    	"
//				+"	    	"
//				+"	    <dd>  <table id='capTable'><tr><td ><label class=\"labelName\">" +
//				subTitles[6]  +
//				"</label></td><td ><div id='recap' >"
//				
//				+c.createRecaptchaHtml(null, null)
//				+"</div><div id='recap2' ><img id='copyRecap'></div></td></tr><tr><td></td><td><button class='button' type=\"button\" onclick='refresh();' >" +
//				subTitles[7] +
//				"</button><button class='button' type=\"button\" onclick='larger();' >" +
//				subTitles[8]  +
//				"</button></td></tr></table> 	"
//				+"	    </dd><dd>      <label class=\"labelName\">" +
//				subTitles[9]  +
//				"</label>	<input type=\"text\" name=\"cap\" id=\"cap\" value=\"\"/>&nbsp;&nbsp;<label id='textSubTitle'>*</label><span id=\"bug5\" style=\"color:Red;color:Red;visibility:hidden;\">" +
//				bugs[5] +
//				"</span></dd>	"
//				+"	    <dd><label class=\"labelName\" colspan=\"2\" align=\"right\">	"
//				+"	    <input type=\"submit\" value=\"" +
//				subTitles[10]  +
//				"\" />"
//				+"<input type=\"text\" id='language' name='language' style='visibility:hidden;' value=\""
//				+language
//				+"\" />"
//				+"	        </label><label class=\"loading\" align=\"right\"></label>	"
//				+"	    </dd>	"
//				+"	</dl>	"
//				+"	</form>	";


		 
		return answer;
	}
	public static String mainTable(String language,String title,HashMap<String,HashMap<Integer,String>> pages) {
		// TODO Auto-generated method stub
		
		String answer="";
		answer+=subTable("","","","","","","",language);
		
		return answer;
	}
	public static String mainTable(String log,String name,String title,String mail,String tel,String cel,String desc,String language) {
		// TODO Auto-generated method stub
		
		String answer="";
		answer+=subTable(log,name, title, mail, tel, cel, desc,language);
		
		
		return answer;
	}
}
