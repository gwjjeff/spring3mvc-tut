	var cfg = 	{
	    type: 'POST', 
	    data: JSON.stringify({userName:'测试用户',password:'password',mobileNO:'13818881888'}), 
	    dataType: 'json',
	    contentType:'application/json;charset=UTF-8',	    
	    success: function(result) { 
	        alert(result.success + ": " + result.msg); 
	    } 
	};

function doTestJson(actionName,data){
	cfg.url = actionName;
	if(data){
		cfg.data = JSON.stringify(data);
	}
	$.ajax(cfg);
}

function getValidData(userName,email,mobileNO){
	var ret = {};
	ret.userName = userName;
	ret.email = email;
	ret.mobileNO = mobileNO;
	return ret;
}

function doTestXML(actionName){
	var xmlDocument = "<?xml version=\"1.0\" encoding=\"utf-8\" ?>";
	xmlDocument += "<xmlStrA>";
	xmlDocument += "<id>1000</id>";
	xmlDocument += "<name>test</name>";
	xmlDocument += "<password>test</password>";
	xmlDocument += "</xmlStrA>";	

	var xmlcfg = 	{
			url:actionName,
		    type: 'POST', 
		    data: xmlDocument, 
		    dataType: 'xml',
		    contentType:'application/xml;charset=UTF-8',	    
		    success: function(result) {
//		    	console.dir($(result));
		        alert($(result).text());
		    } 
		};	
	
	$.ajax(xmlcfg);
}

function setCookie(key,value){
	document.cookie = [key, '=', encodeURIComponent(value)].join('');
}