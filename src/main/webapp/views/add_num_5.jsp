<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><!DOCTYPE html><html><head><meta charset="UTF-8">
    <title>JSP 5</title>
</head>
<body>
    <h1>Welcome to test JSP 5</h1>

    <form action="/add_num_5_act" method="post" >
	
        <br/><br/><label for="num1">Enter your num1:</label>
        <input type="text" name="num1" id="num1" required>
		
        <br/><br/><label for="num2">Enter your num2:</label>
        <input type="text" name="num2" id="num2" required>
		
        <br/><br/><input type="submit" value="Submit">
    </form>

</body>
</html>
