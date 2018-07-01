package changepwd;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dal.User;
import session.Mysession;

/**
 * Servlet implementation class Changepwd
 */
@WebServlet("/Changepwd")
public class Changepwd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Changepwd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		//String username = request.getParameter("username").trim();
    	String oldpwd = request.getParameter("oldpwd").trim();
    	String newpwd = request.getParameter("newpwd").trim();
    	String sessionid=request.getHeader("cookie");
    	HttpSession session = Mysession.getSession(sessionid);
        User u=new User();    
        String p="0";
        try (PrintWriter out = response.getWriter()) {
        	
        try {
        	
        	 int userid=(int)session.getAttribute("userid");
	          
	         p=u.change_pwd(userid,oldpwd,newpwd);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
      
        out.append(p);
        }
	}

}
