

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.apache.jasper.tagplugins.jstl.core.Out;

/**
 * Servlet implementation class GetData
 */
	public class GetData extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public static String resultof = "";   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetData() {
        super();
        // TODO Auto-generated constructor stub
    }
    public static String of(String ID,String ENAME){

    	try {
			Class.forName("com.ibm.db2.jcc.DB2Driver");
			Connection con=DriverManager.getConnection("jdbc:db2://localhost:50000/db2","sivasai","Tinku@123");
		String sql=	"select id,name,salary from sal where id = '"+ID+"'";
		PreparedStatement ps=con.prepareStatement(sql);   
		ResultSet rs = ps.executeQuery();
		
		while(rs.next())
		{String result = rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3);
		resultof=result;
		//response.getWriter().write(result+ENAME);
		}
    	}
		//check for user name and name togather.
		 catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//response.getWriter().write(e.toString());
		}
		// TODO Auto-generated method stub
 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


    	return resultof;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ID =request.getParameter("ID");
		String ENAME=request.getParameter("name");
		//String SALARY =request.getParameter("SALARY");
		try {
			Class.forName("com.ibm.db2.jcc.DB2Driver");
			Connection con=DriverManager.getConnection("jdbc:db2://localhost:50000/db2","sivasai","Tinku@123");
		String sql=	"select id,name,salary from sal where id = '"  + ID +  "'";
		PreparedStatement ps=con.prepareStatement(sql);   
		ResultSet rs = ps.executeQuery();
		
		while(rs.next())
		{String result = rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3);
		
		//check for user name and name togather.
		if(ID.equals(rs.getString(1))&&ENAME.equals(rs.getString(2))){
			response.getWriter().write("\nYou are logged in,Your details are,\n"+result);
			
			//response.sendRedirect("ShowData.html");
		}
		else
			response.getWriter().write("please fill the details correctly");
			
		}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.getWriter().write(e.toString());
		}
		// TODO Auto-generated method stub
 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}
