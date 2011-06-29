<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <input type="button" value="json input test 1" onclick="doTestJson('json1')"/>
        <input type="button" value="json input test 2" onclick="doTestJson('json2')"/>
        <input type="button" value="json out test 3" onclick="doTestJson('json3.json')"/>
        <br/>
        <input type="button" value="json valid test 1" onclick="doTestJson('validJson1',getValidData('winzip','winzip','138188888'))"/>
        <input type="button" value="json valid test 2" onclick="doTestJson('validJson2',getValidData('winzip','winzip','13888888'))"/>
        <script type="text/javascript" src="js/json2.js"></script>
        <script type="text/javascript" src="js/jquery-1.6.1.js"></script>
        <script type="text/javascript" src="js/helloworld.js"></script>
    </body>
</html>
