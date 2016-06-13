package manager;

import viewer.basic;

public class script {
	public static String script(String version,String scriptType){
		String[] list={
				"js/jquery.min.js"+"?v="+version,
				"js/jposter.js"+"?v="+version,
				"js/vendor/jquery.ui.widget.js"+"?v="+version,
				"js/jquery.iframe-transport.js"+"?v="+version,
				"js/jquery.fileupload.js"+"?v="+version,
				
				"js/"+scriptType+".js"+"?v="+version,
				
		};
		
		String[] content={
				

				
		};
		String answer="";
		
		for(String s:list){
			answer+=basic.script("",s);			
		}		
		for(String s:content){
			answer+=basic.script(s,"");			
		}
		
		return answer;
	}
	
	
	
	
	
}
