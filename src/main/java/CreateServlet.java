
import java.io.IOException;
import java.util.ArrayDeque;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.*;

 
@WebServlet("/create")
public class CreateServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType ("text/html; charset=UTF-8");
        getServletContext().getRequestDispatcher("/create.jsp").forward(request, response);
    }
     
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType ("text/html; charset=UTF-8");
        try {
            String name = request.getParameter("name");
 if(name.length()==0) { App.create_Request_int=4;} 
 else         
 if(App.isComparison_Name_Deque(name, ArrDeQue.ADQ)||App.isComparison_Name_DB(name, App.getArrFromDB())||name.length()==0){
	 App.create_Request_int=1;
 }else {
         ArrDeQue.addADQ(name); 
         System.out.println("Внесение заявки: "+name+" в очередь");
         if (name != null && ArrDeQue.ADQ.size()==1) App.create_Request_int=2;
         if (ArrDeQue.ADQ.size()>1) App.create_Request_int=3;
        }
App.Calc=false;
 request.setAttribute("create_Request_int", App.create_Request_int);
 response.sendRedirect(request.getContextPath()+"/index");}
        catch(Exception ex) {
 getServletContext().getRequestDispatcher("/create.jsp").forward(request, response); 
        }
    }
}