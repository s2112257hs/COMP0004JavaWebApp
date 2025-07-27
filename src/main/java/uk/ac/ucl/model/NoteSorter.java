package uk.ac.ucl.model;

import java.util.Comparator;
import java.util.List;

public class NoteSorter {

public static List<Note> sortNotes(List<Note> notes, String sortBy) {
    switch (sortBy) {
        case "titleAsc":
            notes.sort(Comparator.comparing(Note::getTitle, String.CASE_INSENSITIVE_ORDER));
            break;
        case "titleDesc":
            notes.sort(Comparator.comparing(Note::getTitle, String.CASE_INSENSITIVE_ORDER).reversed());
            break;
        case "sizeAsc":
            notes.sort(Comparator.comparingInt(note -> note.getContents() != null ? note.getContents().length() : 0));
            break;
        case "sizeDesc":
            notes.sort(Comparator.comparingInt((Note note) -> note.getContents() != null ? note.getContents().length() : 0).reversed());
            break;
    }
    return notes;
}
}
