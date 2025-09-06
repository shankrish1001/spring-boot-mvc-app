<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><!DOCTYPE html><html><head><meta charset="UTF-8">
    <title>Add User Model 33</title>
</head>
<body>
    <h1>Add User Model 33</h1>
    <% String actUrl = "/add_user_obj_act_3"; %>
    <form action="<%=actUrl%>" method="post" >
	
        <br/><br/><label for="uid">Enter uid:</label>
        <input type="text" name="uid" id="uid" required>
		
        <br/><br/><label for="uname">Enter uname:</label>
        <input type="text" name="uname" id="uname" required>
		
        <br/><br/><input type="submit" value="Submit">
    </form>

</body>
</html>
