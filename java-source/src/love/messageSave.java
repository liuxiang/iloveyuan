package love;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.ws.util.StringUtils;

//servlet 3.0 @WebServlet(name = "messageSave", urlPatterns = { "/messageSave.do" })
public class messageSave extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String name_index = "";
		String message_index = "";

		String name = "";
		String content2 = "";
		String content = "";

		if (req.getParameter("name") != null && !req.getParameter("name").equals(""))
		{
			name_index = reEncoding(req.getParameter("name"),"ISO8859-1", "UTF-8");// 姓名
			message_index = reEncoding(req.getParameter("message"),"ISO8859-1", "UTF-8");// 留言
		} else if(req.getParameter("site_comment[name]") != null && !req.getParameter("site_comment[name]").equals(""))
		{
			// super.doPost(req, resp);
			name = reEncoding(req.getParameter("site_comment[name]"),"ISO8859-1", "UTF-8");// 姓名
			content2 = reEncoding(req.getParameter("site_comment[content2]"),"ISO8859-1", "UTF-8");// 席座
			content = reEncoding(req.getParameter("site_comment[content]"),"ISO8859-1", "UTF-8");// 留言
		}else
		{
			resp.sendRedirect("message.jsp");
			return;
		}

		MessageDao message = new MessageDao();
		message.save(name.equals("") ? name_index : name, content2, content.equals("") ? message_index : content);
		resp.sendRedirect("message.jsp");
	}

	/** 对字符串重新编码
	 *
	 * @param text 字符串
	 * @param resEncoding 源编码
	 * @param newEncoding 新编码
	 * @return 重新编码后的字符串 */
	public static String reEncoding(String text, String newEncoding)
	{
		String rs = null;
		try
		{
			rs = new String(text.getBytes(), newEncoding);
		} catch (UnsupportedEncodingException e)
		{
			throw new RuntimeException(e);
		}
		return rs;
	}

	/** 对字符串重新编码
	 *
	 * @param text 字符串
	 * @param resEncoding 源编码
	 * @param newEncoding 新编码
	 * @return 重新编码后的字符串 */
	public static String reEncoding(String text, String resEncoding, String newEncoding)
	{
		String rs = null;
		try
		{
			rs = new String(text.getBytes(resEncoding), newEncoding);
		} catch (UnsupportedEncodingException e)
		{
			throw new RuntimeException(e);
		}
		return rs;
	}
}
