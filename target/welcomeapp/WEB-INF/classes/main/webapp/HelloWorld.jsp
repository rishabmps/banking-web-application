<%@page import="com.ideas.database.Account"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script language="javascript">
	function detail(value) {

		var http;

		if (window.XMLHttpRequest) {
			http = new XMLHttpRequest();

		}
		http.onreadystatechange = function() {

			if (http.readyState == 4 && http.status == 200) {
				var account = JSON.parse(http.responseText);

				document.getElementById("name").value = account.name2;
				document.getElementById("birthdate").value = account.birtDate2;
				document.getElementById("account_type").value = account.type2;
				document.getElementById("pan_no").value = account.pan_no2;
				document.getElementById("mobile_no").value = account.mobile2;

				document.getElementById("detail").style.visibility = 'visible';
			}
		};

		http.open("POST", "./welcome1?value=" + value, true);
		http.send();
	}
	
	
	function Edit(){
	
		document.getElementById("name").removeAttribute("readonly");
		document.getElementById("birthdate").removeAttribute("readonly");
		document.getElementById("account_type").removeAttribute("disabled");
		
		document.getElementById("mobile_no").removeAttribute("readonly");
	}
	function update(){
		document.getElementById("operation").value="update";
		document.forms[0].submit();
	
	}
</script>

<style >
a:link {
    color: #F296A7;
}
</style>
</head>
<body background="html-color-codes-color-tutorials-903ea3cb.jpg">
	<table border="2" width="50%" cellpadding="2" color="white"  style="
    border: burlywood;
    color: white;
    background: #C70039;
    margin-left: 24%;
    margin-top: 3%;
">
		<tr style="
    background: #910A0A;
">
			<th>Account_Name</th>
			<th>BirthDate</th>
			<th>Account_Type</th>
			<th>mobile</th>
			<th>Pan_no</th>
		</tr>

		<%!int i;%>

		<%
			ArrayList<Account> accountlist = (ArrayList<Account>) request.getAttribute("list");
			i = 1;
			for (Account account : accountlist) {
		%>
		<tr>
			<td><a href="javascript:detail('<%=i%>');" name="value">
					<%
						out.println(account.getName2() + "\n");
					%>
			</a><br></td>
			<td>
				<%
					out.println(account.getBirtDate2() + "\n");
				%>
			</td>
			<td>
				<%
					out.println(account.getType2() + "\n");
				%>
			</td>
			<td>
				<%
					out.println(account.getMobile2() + "\n");
				%>
			</td>
			<td>
				<%
					out.println(account.getPan_no2() + "\n");
				%>
			</td>

		</tr>

		<%
			i++;
			}
		%>
	</table>
<br>
	<div id="detail" style="float: left; visibility:hidden;margin-left: 40%; ">
		<form action="./welcome1" method="post">
			<table border="2" width="50%" cellpadding="2"
			color="white"  style="
    border: burlywood;
    color: white;
    background: #C70039;
    margin-top: 3%;"
			>
				<tr>
					<td>Account Name:</td>
					
					<td>
					<input type="text" id="name" value="Account_Name" name="name" readonly></td>
				</tr>
				<tr>
					<td>BirthDate:</td>
					
					<td>
					<input type="text" id="birthdate" name="birthdate"
				value="birthdate" readonly></td>
				</tr>
				<tr>
					<td>Account Type:</td>
					 
					<td >
					<select id="account_type" name="type" disabled  >
			<option value="saving"  >Saving</option>
			<option value="current" >Current</option>
			

		</select>
					</td>
				</tr>
				<tr>
					<td>	Pan No:</td>
					 
					<td>
				 <input type="text" id="pan_no"  value="Pan_no" name="Pan_no"   readonly></td>
				</tr>
				<tr>
					<td>	Mobile no: </td>
					 
					<td>
				<input type="text" id="mobile_no" value="mobile_no" name="Mobile_no" pattern="^\d{10}" readonly/>
				</td>
				</tr>
			</table>
			<br>
			
			<input type="button" value="Edit" onclick="Edit()" style="
    margin-left: 25%;"  />
	
		<input type="hidden" name="operation"  id="operation"
			value="SAVE" >
		<input type="button" value="Update" onclick="update()"/>
		
			
		</form>
	</div>
</body>
</html>