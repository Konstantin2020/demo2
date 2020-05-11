
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
 
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
    	request.setAttribute("create_DQ_bool", App.create_DQ_bool);
    	request.setAttribute("create_DB_bool", App.create_DB_bool);
    	request.setAttribute("fileSourceName_int", App.fileSourceName_int);
    	request.setAttribute("create_Request_int", App.create_Request_int);
    	int lengthDeQue=ArrDeQue.ADQ.size();
        request.setAttribute("lengthDeQue", lengthDeQue);
    	//request.setAttribute("uploadFile_int", App.uploadFile_int);
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
}