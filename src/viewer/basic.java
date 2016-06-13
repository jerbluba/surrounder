package viewer;

import java.io.IOException;
import java.util.HashMap;

import manager.script;

public class basic {
	public static String body(String content){
		return "<body class='no-header-page wsite-theme-light wsite-page-index'>"+content+"</body>";
	}
	public static String html(String content){
		return "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\"><html>"+content+"</html>";
	}
	
	public static String jsp(HashMap<String,String> menus){
		String answer="<%@ page ";
		String subAnswer="";
		for(String s:menus.keySet()){
			if(s.startsWith("import")){
				
				subAnswer+=menus.get(s);
				
			}
		}
		if(!subAnswer.equals("")){
			answer+="import=\"";
			answer+=subAnswer;
			answer+="\" ";
			
		}
		
		answer+="language=\"java\" contentType=\"text/html; charset=UTF-8\" pageEncoding=\"UTF-8\"%>";
	
		return answer;
		
	}
	
	
	public static String head(String content,String title ){
		return "<head><meta http-equiv='Content-Type' content='text/html; charset=utf-8'><title>"
				+title
				+"</title>"
				+content
				+"</head>";
	}
	
	public static String script(String content,String src){
		return "<script "
				+(src.equals("")?"type='text/javascript'":"src='"+src+"'")
				+">"+content+"</script>";
	}
	public static String css(String src){
		return "<link rel='stylesheet' type='text/css' href='"
				+src+"' />";
	}
	
	public static String others(HashMap<String,String> attr){
		String answer="<"+attr.get("labelName")+" ";
		for(String s:attr.keySet()){
			if(!(s.equals("content")||s.equals("labelName"))){
				answer+=(s+"=\""+attr.get(s)+"\" ");	
			}	
		}
		return answer+">"+attr.get("content")+"</"+attr.get("labelName")+">";
	}
	
	public static String div(String content,String id ,String cla,String style){
		return "<div "
				+(!id.equals("")?" id='"+id+"'":"")
				+(!cla.equals("")?" class='"+cla+"'":"")
				+(!style.equals("")?" style='"+style+"'":"")
				+">"+content+"</div>";
	}
	
	public static String combineContent(String title,String content,String scriptType,String[] cssList,HashMap<String,String> menus) throws IOException{
		String version=menus.get("version");
		
		return html(
					head(
						css.css(version,cssList)
						+script.script(version,scriptType),title)
						+body(
							div(div(content,"main-wrap","","")
							,"page-wrap","","")
					)
				);
	}
	
}
