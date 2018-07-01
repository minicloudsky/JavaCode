package add_to_car;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dal.User;
import model.Productinfo;
import session.Mysession;

/**
 * Servlet implementation class Add_to_car
 */
@WebServlet("/Add_to_car")
public class Add_to_car extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add_to_car() {
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
        	
        	String pro_id = request.getParameter("pro_id").trim();
        	String sessionid=request.getHeader("cookie");
        	int proid=Integer.parseInt(pro_id);
            User u=new User();    
            HttpSession session = Mysession.getSession(sessionid);
           // System.out.println(sessionid);
             int userid=(int)session.getAttribute("userid");
	      
	       
            String p="0";
            try {
            	 
				p=u.add_to_car(userid,proid);
			} catch (Exception e) {
				 
				e.printStackTrace();
			}
           
            out.append(p);
            System.out.println(p+proid+userid);
          
        }
	}

}
