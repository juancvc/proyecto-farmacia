<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
function openWin()
{
myWindow=window.open('','','width=200,height=100');
myWindow.document.write("<p>This is 'myWindow'</p>");
myWindow.focus();
print(myWindow);
}
</script>
</head>
<body>

<input type="button" value="Open window" onclick="openWin()" />

</body>
</html>
