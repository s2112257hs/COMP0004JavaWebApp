package uk.ac.ucl.model;

import java.util.ArrayList;
import java.util.List;

public class NoteFilter {

public static List<Note> filterNotesBySearchQuery(List<Note> notes, String searchQuery) {
    List<Note> filteredNotes = new ArrayList<>();
    String queryLower = searchQuery.toLowerCase();

    for (Note note : notes) {
        if (note.getTitle().toLowerCase().contains(queryLower) || note.getContents().toLowerCase().contains(queryLower)) {
            filteredNotes.add(note);
        }
    }
    return filteredNotes;
}
}
