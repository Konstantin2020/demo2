
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.example.*;

@WebServlet("/report_1_2")
public class Report_1_2_Servlet extends HttpServlet {
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	response.setCharacterEncoding("UTF-8");
    	response.setContentType ("text/html; charset=UTF-8");

String [] prod_name_from_DB2=App.sort(App.getArrFromDB());

if (prod_name_from_DB2.length>10) {
	String [] endArrIfMore10=new String [10];
for(int y=0;y<10;y++) {
	endArrIfMore10[y]=prod_name_from_DB2[y];
}
JSONArray prodJsonString = new JSONArray(endArrIfMore10);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.print(prodJsonString);
		out.flush();
		} 
	else 
		{
		JSONArray prodJsonString = new JSONArray(prod_name_from_DB2);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.print(prodJsonString);
		out.flush();
		}
    }
}
