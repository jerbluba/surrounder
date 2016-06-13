<%@ page contentType="text/html; charset=UTF-8"%>

<%--STEP 1、引入提供檔案上傳功能的套件--%>
<%@ page import="com.jspsmart.upload.*,java.io.File,java.util.Map,java.io.*" %>

<%--STEP 2、以Bean物件的方式引用com.jspsmart.upload.SmartUpload類別
, 並設定名稱為myUpload --%>
<jsp:useBean id="myUpload" scope="page"
	     class="com.jspsmart.upload.SmartUpload" />
<HTML>
<HEAD>
<TITLE>檔案上傳</TITLE>
<link rel="stylesheet" type="text/css" href="css/viewer0.css">
<script src='https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js'></script>
<script src='js/jposter.js'></script>

<script type="text/javascript">

$( document ).ready(function() {
	//	alert($('#select').val());
	
		$.redirect( 
			"Viewer3?v=123", 
			{
			'picName':$('#pic').val(),
			'name':$('#name').val(),
			'type':'0',
			'comment':$('#comment').val(),
			'x':$('#x').val(),
			'y':$('#y').val(),
			'z':$('#z').val(),
			'cla':$('#cla').val(),
			});
	

	
//	$('#send').submit();
	
});

</script>
</HEAD>
<BODY>

<HR>
<%

String savePath = "c:/xampp/htdocs/img/"; //設定儲存路徑
int maxPostSize = 25 * 1024 *1204; //限制上傳檔案的總大小為25 MB
int fcount = 0; //計算上傳檔案個數

myUpload.initialize(pageContext); //STEP 3、起始myUpload物件
myUpload.setTotalMaxFileSize(maxPostSize);

//設定所有上傳檔案的總大小，單位為bytes，若未設定，則不限制

myUpload.upload(); //STEP 4、取得上傳檔案

com.jspsmart.upload.File myFile = myUpload.getFiles().getFile(0);


String x=myUpload.getRequest().getParameter("x");
String y=myUpload.getRequest().getParameter("y");
String z=myUpload.getRequest().getParameter("z");


String fileDirectory=x+"plus"+y+"plus"+z;

File baseDir = new File(savePath+fileDirectory);

if(!baseDir.isDirectory()){
	baseDir.mkdir();
}

String fileName="";

StringBuffer fileList = new StringBuffer();
try{
	java.io.File folder = new java.io.File(savePath+fileDirectory);
    String[] list = folder.list();           
    fileName=list.length+"."+myFile.getFileExt();
}catch(Exception e){
     
} 



	

try{
	if(myFile.getTypeMIME().equals("image")){
		myFile.saveAs(savePath+fileDirectory+"/"+fileName);
		//STEP 5、將上傳的檔案儲存至Web應用程式目錄下的upload子目錄，
		//取傳回成功上傳的檔案個數	
		
		
		out.println("檔案存檔成功！");
		//out.println("<FORM action=Viewer3 method=post enctype=multipart/form-data name=FileName id='send'>");
		out.println("<input type='hidden' id='pic' name='pic' value='"+fileName+"'>");
		out.println("<input type='hidden' id='name' name='name' value='"+myUpload.getRequest().getParameter("name")+"'>");
		out.println("<input type='hidden' id='comment' name='comment' value='"+myUpload.getRequest().getParameter("comment")+"'>");
		
		
		out.println("<input type='hidden' id='x' name='x' value='"+x+"'>");
		out.println("<input type='hidden' id='y' name='y' value='"+y+"'>");
		out.println("<input type='hidden' id='z' name='z' value='"+z+"'>");
		out.println("<input type='hidden' id='cla' name='cla' value='"+myUpload.getRequest().getParameter("cla")+"'>");
		//out.println("</FORM>");
		
		
	}else{
		out.println("請上傳圖檔！");
		out.println("<input type='hidden' id='pic' name='pic' value='wrong'>");
		out.println("<input type='hidden' id='name' name='name' value='wrong'>");
		out.println("<input type='hidden' id='comment' name='comment' value='wrong'>");
		
		
		out.println("<input type='hidden' id='x' name='x' value='wrong'>");
		out.println("<input type='hidden' id='y' name='y' value='wrong'>");
		out.println("<input type='hidden' id='z' name='z' value='wrong'>");
		
	}
	
	
	
}
catch (Exception ex){
	out.println("上傳檔案時發生錯誤<BR>錯誤訊息為 [");
	out.println(ex.toString());
	out.println("] <BR>");
}
%>


</BODY>
</HTML>


