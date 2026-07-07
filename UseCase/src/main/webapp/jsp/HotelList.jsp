<%@page import="java.util.*"%>
<%@page import="com.rays.bean.HotelBean"%>

<html>

<body>

<h2 align="center">Hotel List</h2>

<form action="<%=request.getContextPath()%>/ctl/HotelListCtl">

Search Hotel

<input type="text" name="hotelName">

<input type="submit" value="Search">

<a href="<%=request.getContextPath()%>/ctl/HotelCtl">

Add Hotel

</a>

</form>

<br>

<table border="1" width="100%">

<tr>

<th>ID</th>

<th>Name</th>

<th>Location</th>

<th>Rating</th>

<th>Contact</th>

<th>Edit</th>

<th>Delete</th>

</tr>

<%

List<HotelBean> list=
(List<HotelBean>)request.getAttribute("list");

for(HotelBean bean:list){

%>

<tr>

<td><%=bean.getHotelId()%></td>

<td><%=bean.getHotelName()%></td>

<td><%=bean.getLocation()%></td>

<td><%=bean.getRating()%></td>

<td><%=bean.getContactNo()%></td>

<td>

<a href="HotelCtl?id=<%=bean.getHotelId()%>">

Edit

</a>

</td>

<td>

<form action="HotelListCtl" method="post">

<input type="hidden"
name="id"
value="<%=bean.getHotelId()%>">

<input type="submit"
name="operation"
value="Delete">

</form>

</td>

</tr>

<%

}

%>

</table>

</body>

</html>