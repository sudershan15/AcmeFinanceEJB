package com.foo.Client;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
/**
 * Servlet implementation class MyController
 */
public class MyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   
        // TODO Auto-generated constructor stub
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String tickersymbol=request.getParameter("ticker");
		System.out.println(tickersymbol);
		String frm1=request.getParameter("radioB");
		System.out.println(frm1);
		String typ1=request.getParameter("radio1");
		System.out.println(typ1);
		String data1="historical";
		String data2="snapshot";
		//String data3="realtime";
		String data3="analyzed";
		String url="Result.jsp";
		StockProviderClient t=new StockProviderClient();
	   if(typ1.equalsIgnoreCase("historical"))
	   {
			 t.gethistoricaldata(tickersymbol,frm1);
			 response.sendRedirect(url);
	   }
	   else if(typ1.equalsIgnoreCase("snapshot"))
	   {
		   String sdate=request.getParameter("text");
		   String edate=request.getParameter("text1");
		   t.getsnapshotdata(tickersymbol, frm1, sdate, edate);
	   }
	   else if(typ1.equalsIgnoreCase("analyzed"))
	   {
		   t.getanalyzedata("20080522", frm1);
		   response.sendRedirect(url);
		 
		}
	   
	}
}
