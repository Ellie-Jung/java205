package firstweb;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;
import java.io.*;

@WebServlet("/now2")
public class NowServlet extends HttpServlet{

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
      System.out.println("GET 로 요청");
      
      resp.setContentType("text/html; charset=utf-8");
      
      PrintWriter writer = resp.getWriter();
      writer.println("<html>");
      writer.println("   <head><title>NowServlet</title></head>");
      writer.println("   <body>");
      writer.println("   <h1>"+new Date()+"</h1>");
      writer.println("   </body>");
      writer.println("<html>");
      
      writer.close();
   }
   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
      System.out.println("POST로 요청");
   }
}
