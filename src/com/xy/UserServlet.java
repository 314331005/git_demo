package com.xy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		if(type != null){
			String jsonStr = readJSONString(request);
			System.out.println(jsonStr);
			return;
		}
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		String jsonStr = "{\"success\": true,\"users\": [{\"id\": 1, \"name\": 'Ed',    \"email\": \"ed@sencha.com\"},{\"id\": 2, \"name\": 'Tommy', \"email\": \"tommy@sencha.com\"}]}";
		PrintWriter out = null;
		try {
		    out = response.getWriter();
		    out.write(jsonStr);
		} catch (IOException e) {
		    e.printStackTrace();
		} finally {
		    if (out != null) {
		        out.close();
		    }
		}
	}
	public String readJSONString(HttpServletRequest request){   
		   StringBuffer json = new StringBuffer();   
		   String line = null;   
		   try {   
		   BufferedReader reader = request.getReader();   
		   while((line = reader.readLine()) != null) {   
		   json.append(line);   
		   }   
		   }   
		   catch(Exception e) {   
		   System.out.println(e.toString());   
		   }   
		   return json.toString();   
		   }  
}