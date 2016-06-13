var width=40;
	var height=40;
	$( document ).ready(function() {
		
		$('#list td').each(function(index){					
			if($(this).html()=='close'){
				$(this).css({
					'background':'no-repeat',
					'background-size':width+'px '+height+'px',
					'background-image':'url(img/'+$(this).html()+'.png)',
					'width':width,
					'height':height,		
					'cursor':'pointer',	
				}).attr(
					'id',$(this).html()
				).html(
					''
				).click(
					function(){
						parent.deleteWindow();
					});
			}



		
			if($(this).attr('id')!=''&&$(this).attr('id')!=undefined){
				$(this).click(function(){
					if($(this).css('background-position-x')=='-300px'){
						var link=window.location.href.slice(window.location.href.indexOf('?') + 1).split(':8080')[0]+"/img/"+$('#list').attr('class')+"/"+$(this).attr('id');
						parent.resizeWindow($('#main-wrap').css('width'));
						$('#imagefield').css({
							'width':parent.width*3,
							'height':parent.height*2.4,
							'background':'url('+link+')',
							'background-size':parent.width*3+'px '+ parent.height*2.4+'px',
						});
						$('.buttom').css({
							'background-position':'-300px -350px',	
						});
						
						$(this).css({
							'background-position':'-260px -350px',	
						});
						parent.document.getElementById('chaos').width=$("#list").width()+$("#imagefield").width();
						 parent.document.getElementById('chaos').height=Math.max($("#list").height(),$("#imagefield").height());
						
						
						
					}else if($(this).css('background-position-x')=='-260px'){
						var f=$('#list').attr('class').replace('plus','')[1];
						var l=$('#list').attr('class').replace('plus','')[0];
						parent.reArrangeWindow(f,l);
						$('#imagefield').css({
							'width':0,
							'height':0,
						});
						$('.buttom').css({
							'background-position':'-300px -350px',	
						});
						parent.document.getElementById('chaos').width=$("#list").width();
						 parent.document.getElementById('chaos').height=$("#list").height();
						
					}
					
					
				});
				
			}
			
			
		}).css({
			'cursor':'pointer',
		
		});
	});
	
	 $(window).load(function(){
		 parent.document.getElementById('chaos').width=$("#list").width();
		 parent.document.getElementById('chaos').height=$("#list").height();
   
 });