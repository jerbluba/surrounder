package viewer;

public class css {
	public static String css(String version,String[] list){

		String answer="";
		
		for(String s:list){
			answer+=basic.css("css/"+s+".css?v="+version);			
		}		
		
		return answer;
	}
}
