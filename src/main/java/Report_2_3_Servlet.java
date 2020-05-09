
import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.example.*;

 
 
@WebServlet("/report_2_3")
public class Report_2_3_Servlet extends HttpServlet {
     
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	response.setCharacterEncoding("UTF-8");
    	response.setContentType ("text/html; charset=UTF-8");

    	if(App.insert_Data_To_DB_int==0) {
    		try {
				App.ForEnter();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		App.insert_Data_To_DB_int=1;}
    	
    	
    	
    	if (App.Calc==false) {
    		CalculateForDeQue.main();
    		//App.create_Request_int=5;
    	App.Calc=true;}
    	

    	
    	try {
    		App.J2_jsp(App.appMapSearchFile, App.appMap_J1_J2);
			PrintWriter out = response.getWriter();
	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        out.print(App.JSON_22);
	        out.flush();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
          
        //getServletContext().getRequestDispatcher("/report_2_1.jsp").forward(request, response);
    }
}