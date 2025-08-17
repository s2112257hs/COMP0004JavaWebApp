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

    @WebServlet("/viewSingleNote")
    public class ViewSingleNoteServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve the note title from the request parameter
        String id = request.getParameter("id");
        System.out.println(id);
        // Get the Model instance
        Model model = ModelFactory.getModel();
        List<Note> notes = model.getNotes();
        Note selectedNote = null;

        // Find the note with the matching title (case-sensitive or use equalsIgnoreCase if desired)
        for (Note note : notes) {
            if (note.getId().equals(id)) {
                selectedNote = note;
                break;
            }
        }

        // If no matching note is found, send a 404 error
        if (selectedNote == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Note not found. Is this the error");
            return;
        }

        // Set the note as a request attribute and forward to the JSP for display
        request.setAttribute("note", selectedNote);
        RequestDispatcher dispatcher = request.getRequestDispatcher("viewSingleNote.jsp");
        dispatcher.forward(request, response);
    }
    }
