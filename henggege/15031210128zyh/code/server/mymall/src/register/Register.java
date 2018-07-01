package register;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dal.User;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
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
		    response.setContentType("text/html;charset=utf-8");
	        request.setCharacterEncoding("utf-8");
	        response.setCharacterEncoding("utf-8");

	        try (PrintWriter out = response.getWriter()) {

	            //��������д������û���������
	            String username = request.getParameter("username").trim();
	            String password = request.getParameter("password").trim();
	          //  String role = request.getParameter("role").trim();
	          
	            User u=new User();    //ʵ�����û���
	            String result="0";         //���ؽ��Ĭ��Ϊ0������½���ɹ�
	            int userid=0;
	            try {
	            	
					result=u.register(username, password,"1");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            out.append(result);   //"1"Ϊ��ң�"2"Ϊ����  
	            HttpSession session=request.getSession(true);
	            session.setAttribute("username", username);
	            session.setAttribute("role", result);
	            session.setAttribute("userid",userid);
	        }
	}

}
