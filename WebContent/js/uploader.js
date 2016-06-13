
	
	
function getUrlVars()
{
    var vars = [], hash;
    var hashes = window.location.href.slice(window.location.href.indexOf('?') + 1).split('&');
    for(var i = 0; i < hashes.length; i++)
    {
        hash = hashes[i].split('=');
        vars.push(hash[0]);
        vars[hash[0]] = hash[1];
    }
    return vars;
}	
	
	var width=40;
	var height=40;
	var x=getUrlVars()['x'];
	var y=getUrlVars()['y'];
	var z=getUrlVars()['z'];
	$( document ).ready(function() {
		$('#hot-table td').each(function(index){		
			if(x==undefined){
				x=$('#hot-table').attr('class').split('plus')[0];
			}
			
			if(y==undefined){
				y=$('#hot-table').attr('class').split('plus')[1];
			}
			x
			if(z==undefined){
				z=$('#hot-table').attr('class').split('plus')[2];
			}
			if(index!=0){
			
				if($(this).html()=='add'||$(this).html()=='info'||$(this).html()=='close'||$(this).html()=='refresh'){
					$(this).css({
					'background-image':'url(img/'+$(this).html()+'.png)',	
					}).attr('id',$(this).html()).html('').click(function(){
						switch($(this).attr('class')){
							case '5plus0':
								if(ValidBotBoot()&&$('#pic').val()!=undefined&&$('#name').val()!=''&&$('#content').val()!=''){
									$('#send').submit();
								}else if(!ValidBotBoot()){
									alert("請輸入正確答案!");									
								}else{
									alert("請填滿所有空格!");									
								}
								
								break;
							case '5plus2':
								$.redirect( 
								"Viewer4", 
								{
								'x':x,
								'y':y,
								'z':z,
								'type':1,
								});
								break;
							case '4plus0':
								location.reload();
								//window.close();
								//$('body').hide();
								break;
							case '5plus4':
								//location.reload();
								//window.close();
								
								$('body').hide();
								parent.deleteWindow();
								
								break;
								
						}
					
					
					});
				}else{
					$(this).css({
					'white-space':'nowrap',	
					});
				}
				if($(this).html()=='x'||$(this).html()=='y'||$(this).html()=='z'){
					switch($(this).html()){
						case 'x':
							$(this).html('<input type="hidden" name="'+$(this).html()+'" value="'+x+'"></input>');
							break;
						case 'y':
							$(this).html('<input type="hidden" name="'+$(this).html()+'" value="'+y+'"></input>');
							break;
						case 'z':
							$(this).html('<input type="hidden" name="'+$(this).html()+'" value="'+z+'"></input>');
							break;
					}
					
					
				}
			}
		});
		
		
		
		
		
		
		
		
	});
	
	//controller04

    var a = Math.ceil(Math.random() * 10);
    var b = Math.ceil(Math.random() * 10);       
    var c = a + b
    function DrawBotBoot()
    {
        document.write(a + " + " + b +"? ");
        document.write("<input id='BotBootInput' type='text' maxlength='2' size='2'/>");
    }    
    function ValidBotBoot(){
        var d = document.getElementById('BotBootInput').value;
        if (d == c) return true;        
        return false;
        
    }

    $(window).load(function(){
    	 
		 parent.document.getElementById('chaos').width=$("#hot-table").width();
		 parent.document.getElementById('chaos').height=$("#hot-table").height();
    });
	//End of controller04
	