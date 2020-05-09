
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
 
@WebServlet("/DeQueindex")
public class DeQueServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        ArrayDeque<String> QQ=ArrDeQue.ADQ;
        request.setAttribute("dfg", QQ);
        getServletContext().getRequestDispatcher("/DeQueindex.jsp").forward(request, response);
    }
}