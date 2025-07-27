package uk.ac.ucl.servlets;

import jakarta.servlet.annotation.WebServlet;
import uk.ac.ucl.model.Note;
import uk.ac.ucl.model.Model;
import uk.ac.ucl.model.NoteFilter;
import uk.ac.ucl.model.NoteSorter;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.util.*;

@WebServlet("/viewNotes")
public class ViewNotesServlet extends HttpServlet {

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String searchQuery = request.getParameter("searchQuery");
    String sortBy = request.getParameter("sortBy");

    // Load notes from the model
    Model model = Model.getInstance();
    List<Note> notes = model.getNotes();

    // Handle search functionality
    if (searchQuery != null && !searchQuery.isEmpty()) {
        notes = NoteFilter.filterNotesBySearchQuery(notes, searchQuery);
    }

    // Sort notes
    if (sortBy != null) {
        notes = NoteSorter.sortNotes(notes, sortBy);
    }

    // Set the notes in the request attribute to be displayed in the JSP
    request.setAttribute("notes", notes);

    // Forward the request to the JSP
    RequestDispatcher dispatcher = request.getRequestDispatcher("viewNotes.jsp");
    dispatcher.forward(request, response);
}
}
