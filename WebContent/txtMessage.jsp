<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="love.*"%>
<%@page import="java.util.*"%>
<%@page import="java.lang.*"%>
<%
	MessageDao messageDao = new MessageDao();
	List<String> list = messageDao.init();
	for (int i = 0; i < list.size(); i++)
	{
		String message = list.get(i);//ISO-8859-1
		//message = new String(message.getBytes("ISO-8859-1"), "UTF-8");
		out.print(message.replace("<br>", "&lt;br>")+"<br>");
	}
%>