package uk.ac.ucl.servlets;

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

@WebServlet("/noteView")
public class ViewNoteServlet extends HttpServlet {

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String noteTitle = request.getParameter("title");
    Model model = ModelFactory.getModel();

    // Find the note with the given title
    List<Note> notes = model.getNotes();
    Note selectedNote = null;
    for (Note note : notes) {
        if (note.getTitle().equals(noteTitle)) {
            selectedNote = note;
            break;
        }
    }

    if (selectedNote != null) {
        request.setAttribute("note", selectedNote);
        RequestDispatcher dispatcher = request.getRequestDispatcher("noteView.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error displaying note.");
        }
    } else {
        response.sendError(HttpServletResponse.SC_NOT_FOUND, "Note not found.");
    }
}
}
