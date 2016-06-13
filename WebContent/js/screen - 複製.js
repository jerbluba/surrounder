/**
 * 
 */	
 /* 
Copyright (c) 2015 Miguel Galante
Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/


;(function( $ ){
/**
 * jQuery Redirect
 * @param {string} target - Url of the redirection
 * @param {Object} values - (optional) An object with the data to send. If not present will look for values as QueryString in the target url.
 * @param {string} method - (optional) The HTTP verb can be GET or POST (defaults to POST)
 */
	$.redirect = function( target, values, method ) {  
		method = (method && method.toUpperCase() == 'GET') ? 'GET' : 'POST';
			
		if (!values)
		{
			var obj = $.parse_url(target);
			target = obj.url;
			values = obj.params;
		}
					
		var form = $('<form>').attr({
			method: method,
			action: target
		});
		
		iterateValues(values, [], form);
		$('body').append(form);
		form.submit();
	};

//Private Functions	
	$.parse_url = function(url)
	{
		if (url.indexOf('?') == -1)
			return { url: url, params: {} }
			
		var parts = url.split('?'),
			url = parts[0],
			query_string = parts[1],
			elems = query_string.split('&'),
			obj = {};
		
		for(var i in elems)
		{
			var pair = elems[i].split('=');
			obj[pair[0]] = pair[1];
		}

		return {url: url, params: obj};		
	}  	
		var getInput = function(name, value, parent) {
		var parentString;
		if( parent.length > 0 ) {
			parentString = parent[0];
			for( var i = 1; i < parent.length; ++i ) {
				parentString += "[" + parent[i] + "]";
			}
			name = parentString + "[" + name + "]";
		}

		return $("<input>").attr({
			type: "hidden",
			name: name,
			value: value
		});
	};
	
	var iterateValues = function(values, parent, form) {
		var iterateParent = [];
		for(var i in values)
		{
			if( typeof values[i] == "object" ) {
				iterateParent = parent.slice();
				iterateParent.push(i);
				iterateValues(values[i], iterateParent, form);
			} else {
				getInput(i, values[i], parent).appendTo(form);
			}
		}
	};

})( jQuery );


function deleteWindow(){
		$("#main-table td").each(function(index){
			if($(this).attr('id')==$('.3plus3').attr('id')){
				var f=$(this).attr('class').split('plus')[0];
				var l=$(this).attr('class').split('plus')[1];
				$("#"+f+'surrounder'+l).html("");
				
				$("."+f+'close'+l).css({
					
					'cursor':'auto',
					'display':'none',
				
				});
			
				
			}		
		});			
}



var width=$(window).width()*0.90/5;
var height=$(window).height()*0.90/4;
$( document ).ready(function() {
   $("#main-table0 td").each(function(index){
	$(this).css({
	'width':width/2*1.4,
	'padding-top':height/2,
	
	});
   
   
   });
   $("#main-table td").each(function(index){
		if($(this).html()=='A1'){
			var y=$(this).attr('class').split('plus')[0];
			var x=$(this).attr('class').split('plus')[1];
			$(this).html(
				"<div style='z-index:9;position:absolute;margin-top:-4%;width:"+width+"; height:"+height+";' id='"+y+'surrounder'+x+"'></div>"
				//+"<input type='image' width='40px' height='40px' src='img/close.png' id='close'  class='"+y+"close"+x+"'></input>"
				).css({
				'background':'no-repeat',
				'background-image':'url(img/1_001.jpg)',
				'background-position':'-'+(x-1)*width+'px -'+y*height+'px',
				'background-size':width*5+'px '+height*4+'px',
				'width':width,
				'height':height,			
			}).attr('id','screen1');
		}		
		if($(this).html()=='left'||$(this).html()=='right'){					
			$(this).html("<div id='"+$(this).html()+"'></div>");
		}
		if(index>29){
			var type="";
			
			switch(index){
				case 30:
					type='human';
				break;
				case 31:
					type='info';
				break;
				case 32:
					
					type='link';
				break;
			}
			var content="<div id='"+type+"' style='background:url(img/"+type+".png);background-size:40px 40px;' ></div>"+$(this).html();
			//alert(content);
			$(this).html(content);
		}
		
		//controller5
		$(this).click(function(){
			if($(this).attr('id')==$('.3plus3').attr('id')){
				
				deleteWindow();
				var f=$(this).attr('class').split('plus')[0];
				var l=$(this).attr('class').split('plus')[1];
				var z=$(this).attr('id').replace('screen','');
				$("#"+f+'surrounder'+l).html("<iframe style='border-width: 0;' src='Viewer3?y="+f+"&x="+l+"&z="+z+"'/>");
			
				$("."+f+'close'+l).css({
					'cursor':'pointer',
					'display':'block',
				
				});
			
			}
		
			
		});
		//End of controller5
   });		
   
   //controller1
   
	
	$("#right").click(function(){
		deleteWindow();
		var screen=parseInt($('.3plus3').attr('id').replace('screen',''));
    	$("#main-table td").each(function(index){
			
			if($(this).attr('id')==('screen'+screen)){
				
				var temp=(screen+1)%7;
				if(temp==0){temp=7;}
				$(this).attr('id','screen'+temp).css({
					'background-image':'url(img/1_00'+temp+'.jpg)',	
				});
			}
		});
    });
	
	$("#left").click(function(){
		deleteWindow();
		var screen=parseInt($('.3plus3').attr('id').replace('screen',''));
	   	$("#main-table td").each(function(index){
		
			if($(this).attr('id')==('screen'+screen)){
				
				var temp=(screen-1)%7;
				if(temp==0){temp=7;}
				$(this).attr('id','screen'+temp).css({
					'background-image':'url(img/1_00'+temp+'.jpg)',	
				});
			}
		});   
    });
    for(var i=0;i<7;i++){
		$("#main-table0 .0plus"+i).click(function(){
			deleteWindow();
			var screen=$('.3plus3').attr('id');
			var temp=parseInt($(this).attr('class').replace("0plus",""))+1;
	
			$("#main-table td").each(function(index){
				if($(this).attr('id')==screen){
					$(this).attr('id','screen'+temp).css({
						'background-image':'url(img/1_00'+temp+'.jpg)',	
					});
				}
			}); 
			
		}).css({
			'cursor':'pointer',
			'white-space':'nowrap',
		});
	}
	 //End of controller1
});