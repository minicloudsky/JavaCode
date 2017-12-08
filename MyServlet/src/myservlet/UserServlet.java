package myservlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//Servlet 实现UserServlet
public class UserServlet extends HttpServlet
{
    private static final  long serialVersionUID = 1L;
    public UserServlet(){
        super();
    }
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
    {
        //设置输出内容的格式
        response.setContentType("text/html;charet = GB2312");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("GB2312");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        out.println("<html>");
        out.println("<body>");
        out.println("用户名: "+username+"<br>");
        out.println("密码: "+password+"<br>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
