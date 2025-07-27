package uk.ac.ucl.servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/addNote")
public class AddNoteServlet extends HttpServlet {

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    // Show the Add Note form
    response.sendRedirect("addNote.jsp");
}
}
