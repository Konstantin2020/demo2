
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

@WebServlet("/report_1_1")
public class Report_1_1_Servlet extends HttpServlet {
	String [] report_1_1_Arr;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	response.setCharacterEncoding("UTF-8");
    	response.setContentType ("text/html; charset=UTF-8");
ArrayList<Product> products = ProductDB.select();
    	report_1_1_Arr=new String[4];
    	report_1_1_Arr[0]=("Состояние обработчика: " + CalculateForDeQue.Processor);
    	report_1_1_Arr[1]=("Заявок всего: "+(products.size()+ArrDeQue.ADQ.size()));
    	report_1_1_Arr[2]=("Заявок обработано: "+products.size());
    	report_1_1_Arr[3]=("Последняя заявка: "+ArrDeQue.ADQ.peekLast());
        JSONArray prodJsonString = new JSONArray(report_1_1_Arr);
				PrintWriter out = response.getWriter();
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				out.print(prodJsonString);
				out.flush();
		}
}

