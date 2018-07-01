package add_pro;

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
 * Servlet implementation class Add_pro
 */
@WebServlet("/Add_pro")
public class Add_pro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add_pro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
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
        	
        	String pro_name = request.getParameter("pro_name").trim();
        	String pro_content = request.getParameter("pro_content").trim();
        	String pro_picture1 = request.getParameter("pro_picture1").trim();
        	String pro_shop = request.getParameter("pro_shop").trim();
        	String pro_kind = request.getParameter("pro_kind").trim();
        	
            User u=new User();    
            String p="0";
            try {
            	 HttpSession session=request.getSession(true);
 	            String role=(String)session.getAttribute("role");
 	            if(role=="2")
 	            {
 	            	p=u.add_pro(pro_name,pro_content,pro_shop,pro_kind);
 	            }
 	         
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
          
          
        	response.getWriter().append(p.toString()); 
          
        }
	}

}
