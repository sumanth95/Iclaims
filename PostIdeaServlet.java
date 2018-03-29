

import java.awt.TextArea;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PostIdeaServlet
 */
public class PostIdeaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostIdeaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String title =request.getParameter("title");
		String desc =request.getParameter("desc");
		TextArea ta = new TextArea();
				//String sal = request.getParameter("salary");
		
		//GetData.of(ID, ENAME);
		
		try {
			Class.forName("com.ibm.db2.jcc.DB2Driver");
			Connection con=DriverManager.getConnection("jdbc:db2://localhost:50000/db2","sivasai","Tinku@123");
		String sql=	"insert into ideas values('"+title+"','"+desc+"',0) ";
		
		PreparedStatement ps=con.prepareStatement(sql);   
		ps.executeUpdate();
		ps.addBatch();
		response.getWriter().write("Successfully updated to the Database!!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

		
	}

}
