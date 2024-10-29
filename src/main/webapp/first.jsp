<%@ page import="java.io.PrintWriter ,java.io.IOException" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Wish Content</title>
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="firework.css">
    <link rel="stylesheet" href="fire_shot.css">
    <link rel="stylesheet" href="fire_shot1.css">
    <link rel="stylesheet" href="center_fire.css">

    <style>
        .paragraph{

            position: relative;
            letter-spacing: 1px;
            padding-top: 70px;

            color: azure;
            text-align: center;
            font-size: 20px;
            font-family: "Lucida Fax", serif;

        }

        .para2{

            position: relative;
            letter-spacing: 1px;
            padding-top: 10px;

            color: azure;
            text-align: center;
            font-size: 20px;
            font-family: "Lucida Fax", serif;

        }
    </style>


</head>
<body style="background-color: black;text-align: center">

<%

    response.setContentType("text/html");
    PrintWriter out1 = response.getWriter();

    HttpSession session1 =request.getSession();
    String username = (String)session1.getAttribute("name");
    out1.println("<h1 class=\"content\">HAPPY DIWALI</h1>");
    out1.println("<h1 class=\"name\">"+username.toUpperCase()+"</h1>");
    out1.println("<p class=\"paragraph\">Wishing you a Diwali filled with joy, prosperity, and the warmth of loved ones.</p>");
    out1.println("<p class=\"para2\"> May the festival of lights illuminate your life with happiness and peace!</p>");

    out1.println("<div class=\"firework\"></div>");
    out1.println("<div class=\"fire_part\"></div>");
    out1.println("<div class=\"fire_shot\"></div>");
    out1.println("<div class=\"fire_shot1\"></div>");
    out1.println("<div class=\"center_fire\"></div>");
  %>


</body>
</html>