
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
 
@WebServlet("/admincontrol")
public class AdminControlServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        request.setAttribute("ArrDeQue", ArrDeQue.ADQ);
        request.setAttribute("DBaftercalc", App.getArrFromDB());
        getServletContext().getRequestDispatcher("/admincontrol.jsp").forward(request, response);
    }
}