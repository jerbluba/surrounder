package manager;

import java.util.HashMap;



public class toogle {

	public static String mainTable() {
		String answer="<table id='main-table0'>"+fileEditor.readExcel("topMenu","實驗工具")+"</table>";
		answer+="<table id='main-table'>"+fileEditor.readExcel("content","")+"</table>";
		answer+="<div id='window' style='z-index:9;position:absolute;margin-top:-4%;display:none;'></div>";
		
		return answer;
	}
	public static String hotTable(String x,String y,String z,String log) {
		
		
		HashMap<String,String> menu=manager.fileEditor.getMenus();
		String answer="<table id='hot-table' class='"+x+"plus"+y+"plus"+z+"'>"+fileEditor.readExcel("hotMenu",!log.equals("")?log:"選擇你要的動作")+"</table>";
		
		
		//answer=answer.replace("recapcha", "<div class='g-recaptcha' data-sitekey='"+menu.get("sitekey")+"'></div>");
		
	
		
		answer=answer.replace("jcap","<script type='text/javascript'>DrawBotBoot()</script>");
		
		
		
		
	
			
		
		return answer;
	}
	
	public static String listTable(String x,String y,String z,String type) {
		System.out.println(type);
		String answer="<table id='list-table' class='"+x+"plus"+y+"plus"+z+"'>"+fileEditor.readExcel("listMenu","點擊鍵頭可開關圖片")+"</table>";
		
		
		return answer;
	}
}
