<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

  <%@ page language="java" import="com.foo.Client.*" %>
 <%@ page language="java" import="java.sql.*" %>
    <%@ page language="java" import="java.lang.*" %>
    <%@ page language="java" import="java.math.*" %>

<head>
<script type="text/javascript">
function set(id)
{
	if(id=="historical" )
	{
		 form1.text1.disabled=true;
		 form1.text.disabled=true;
	}
	else if( id=="analyzed"){
		 form1.text1.disabled=true;
		 form1.text.disabled=true;
	}
}
function set2(id)
{
	if(id=="snapshot"){
		form1.text1.disabled=false;
		form1.text.disabled=false;
	 }
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>

<body bgcolor="#FFFFFF">
<div align="center">
  <table border="0" width="90%" cellspacing="0" cellpadding="0">
    <tr>
      <td width="50%"><img src="img/topleft.jpg" border="0" width="372" height="106" /></td>
      <td><img src="img/Untitled.png" width="445" height="107" /></td>
      <td width="50%"><p align="right" /></td>
   </tr>
  </table>
</div>
<div align="center">
  <!--  <table border="0" width="90%" cellspacing="0" cellpadding="0">
    <tr>
      <td width="100%"><font size="1">&nbsp;</font></td>
    </tr>
    <tr>
  
   
    </tr>
  </table>-->
</div>
<div align="center">
  <table border="0" width="90%" cellspacing="0" cellpadding="0">
    <tr>
      <td width="99%" valign="top"><br/>
    		<form name="form1" id="form1" method="post" action="MyController">
			<p>Select the data to retrieve data in </p>
			<p>	<input type="radio" name="radioB"  value="xml" />XML<br />
				<input type="radio" name="radioB"  value="csv" />CSV<br/>
				<input type="radio" name="radioB"  value="json" />JSON<br />
			</p>
 			<p> <label for="ticker">Enter Ticker Name </label>
 				<input type="text" name="ticker" id="ticker" />
  			</p>
  			<p>Select type of data you want to retrieve  </p>
  			<p>	<input type="radio" name="radio1"   id="historical" value="historical" onclick="set(this.id)"/> Historical
    			<input type="radio" name="radio1"   id="snapshot" value="snapshot" onclick="set2(this.id)"/>Snapshot
   				<input type="radio" name="radio1"   id="analyzed" value="analyzed" onclick="set(this.id)" />Analyzed(Get Top 5 Stock Trades of the company )  </p>
 			<h3>Request Bulk Data</h3>
			<p><strong>Enter date range:</strong></p>
			<p>Start Date: <input type="text" name="text" id="text" value="yyyymmdd" />
  			  To End Date: <input type="text" name="text1" id="text1" value="yyyymmdd" />
  			</p>
  			<p><input name="Submit" type="submit" value="Submit" />
  			<a href="upload.jsp">Click here to upload file</a>
  			</p>
			</form>
	</td>
    <td width="1%" valign="top">
      <p align="right">	<img src= "img/but-top.jpg" border="0" width="136" height="22"/><br/>
      					<img src= "img/button1.jpg" border="0" width="136" height="43"/><br/>
      					<img src=" img/button2.jpg" border="0" width="136" height="50"/><br/>
      					<img src=" img/button3.jpg" border="0"  width="136" height="49"/><br/>
      					<img src=" img/button4.jpg" border="0" width="136" height="52"/><br/>
      					<img src=" img/butbot.jpg" border="0" width="136" height="40"/>
      </p>
    </td>
  </tr>
  </table>
</div>
<div align="center">
   <table border="0" width="90%" cellspacing="0" cellpadding="0">
    <tr>
      <td width="100%"><font size="1">&nbsp;</font></td>
    </tr>
  </table>
</div>
</body>
</html>