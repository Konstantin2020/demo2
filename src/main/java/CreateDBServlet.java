
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
 
@WebServlet("/main")
public class CreateDBServlet extends HttpServlet {
	 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
    	
try {
	ProductDB.createDB();
	App.create_DB_bool=App.isCreateDB();
	System.out.println("База создана? Ответ: "+App.create_DB_bool);
	ArrDeQue.createADQ();
	App.create_DQ_bool=true;
} catch (Exception e) {
	// TODO Auto-generated catch block
	App.create_DB_bool=false;
	App.create_DQ_bool=false;
	
	e.printStackTrace();
}

 request.setAttribute("create_DQ_bool", App.create_DQ_bool);
 request.setAttribute("create_DB_bool", App.create_DB_bool);
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
}