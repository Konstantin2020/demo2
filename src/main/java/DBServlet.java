
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.example.*;
 
@WebServlet("/DBindex")
public class DBServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
    	String [] ggg= App.getArrFromDB();
        request.setAttribute("DBaftercalc", ggg);
        getServletContext().getRequestDispatcher("/DBindex.jsp").forward(request, response);
    }
}