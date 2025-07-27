package uk.ac.ucl.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uk.ac.ucl.model.Model;
import uk.ac.ucl.model.ModelFactory;

import java.io.IOException;

@WebServlet("/deleteNote")
public class DeleteNoteServlet extends HttpServlet {

// GET: Delete the note by title
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String title = request.getParameter("title");
    Model model = ModelFactory.getModel();

    boolean deleted = model.deleteNoteByTitle(title);
    if (deleted) {
        // Redirect to the notes list page after deletion
        response.sendRedirect("viewNotes");
    } else {
        response.sendError(HttpServletResponse.SC_NOT_FOUND, "Note not found.");
    }
}
}
