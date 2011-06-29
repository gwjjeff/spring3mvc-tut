var cfg = {
	type : 'POST',
	data : JSON.stringify({
		userName : 'winzip',
		password : 'password',
		mobileNO : '13818881888'
	}),
	dataType : 'json',
	contentType : 'application/json;charset=UTF-8',
	success : function(result) {
		alert(result.success);
	}
};

function doTestJson(actionName, data) {
	cfg.url = actionName;
	if (data) {
		cfg.data = JSON.stringify(data);
	}
	$.ajax(cfg);
}

function getValidData(userName, email, mobileNO) {
	var ret = {};
	ret.userName = userName;
	ret.email = email;
	ret.mobileNO = mobileNO;
	return ret;
}