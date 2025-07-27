package uk.ac.ucl.servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uk.ac.ucl.model.Model;
import uk.ac.ucl.model.ModelFactory;
import uk.ac.ucl.model.Note;

import java.io.IOException;

@WebServlet("/saveNote")
public class SaveNoteServlet extends HttpServlet {

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    // Get data from the form
    String title = request.getParameter("title");
    String content = request.getParameter("content");

    // Create a new Note object using the constructor
    Note newNote = new Note(title, content);

    try {
        // Get the Model instance (this should not be null)
        Model model = ModelFactory.getModel();

        // Add the new note to the model
        model.addNewNote(newNote);

        // Redirect to the viewNotes page to display the updated list of notes
        response.sendRedirect(  "viewNotes"); // Redirect to viewNotes page after saving the note

    } catch (NullPointerException e) {
        e.printStackTrace(); // Log the exception
        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error: Model object is null.");
    } catch (IOException e) {
        e.printStackTrace(); // Log the exception
        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error: Failed to save the note.");
    } catch (Exception e) {
        e.printStackTrace(); // Log any other general exceptions
        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An unexpected error occurred.");
    }
}
}
