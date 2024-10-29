package com.wishes.wishserv;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class DemoWish extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");

        String url="jdbc:mysql://localhost:3306/wishserv";
        String user="root";
        String password="Gowtham@*17";
        int count_no= 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,user,password);
            PreparedStatement statement = connection.prepareStatement("insert into name_list values(count_no,?)");
            statement.setString(1,request.getParameter("username"));
            statement.executeUpdate();
            ResultSet rs = statement.executeQuery("select * from name_list");


if(!username.isEmpty()) {
    while (rs.next()) {
        if (username.equals(rs.getString("username"))) {
            out.println("<p class='name'>" + rs.getString("username") + "</p>");
            HttpSession session = request.getSession();
            session.setAttribute("name", rs.getString("username"));
            RequestDispatcher rd = request.getRequestDispatcher("first.jsp");
            rd.forward(request, response);
        }
    }
}
            else{
                out.println("<b> Please Enter the Name ");
                RequestDispatcher rd = request.getRequestDispatcher("index.html");
                rd.include(request, response);
    }


            } catch (ServletException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        //  response.sendRedirect("first.jsp");


    }
}
