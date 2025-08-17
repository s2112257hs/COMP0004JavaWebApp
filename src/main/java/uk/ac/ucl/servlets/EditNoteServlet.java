package uk.ac.ucl.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import uk.ac.ucl.model.Model;
import uk.ac.ucl.model.ModelFactory;
import uk.ac.ucl.model.Note;

import java.io.IOException;
import java.util.List;

@WebServlet("/editNote")
public class EditNoteServlet extends HttpServlet {

// GET: Load the note data and display the edit form
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String id = request.getParameter("id");
    Model model = ModelFactory.getModel();
    List<Note> notes = model.getNotes();
    Note selectedNote = null;
    for (Note note : notes) {
        if (note.getId().equals(id)) {
            selectedNote = note;
            break;
        }
    }
    if (selectedNote == null) {
        response.sendError(HttpServletResponse.SC_NOT_FOUND, "Note not found.");
        return;
    }
    request.setAttribute("note", selectedNote);
    RequestDispatcher dispatcher = request.getRequestDispatcher("/editNote.jsp");
    dispatcher.forward(request, response);
}

// POST: Process the updated note data and save changes
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String id = request.getParameter("id");
    String newTitle = request.getParameter("title");
    String newContent = request.getParameter("content");

    if (id == null || newTitle == null || newContent == null) {
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing parameters.");
    }

    Model model = ModelFactory.getModel();
    boolean updated = model.updateNote(id, newTitle, newContent);

    if (updated) {
        response.sendRedirect("viewNotes");  // ✅ Redirect to viewNotes after saving
    } else {
        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to update the note.");
    }
}


}
