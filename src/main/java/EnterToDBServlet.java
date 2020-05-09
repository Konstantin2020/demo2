
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.ArrayList;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.example.*;

@WebServlet("/enterToDB")
public class EnterToDBServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
try { 
	App.ForEnter();
	
	
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

App.insert_Data_To_DB_int=1;
request.setAttribute("fileSourceName_int", App.fileSourceName_int);
request.setAttribute("insert_Data_To_DB_int", App.insert_Data_To_DB_int);

        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
}