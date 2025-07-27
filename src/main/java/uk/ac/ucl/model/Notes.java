package uk.ac.ucl.model;

import java.io.*;
import java.util.*;

public class Notes {
private List<Note> notes;
private final String notesFilePath;

public Notes(String filePath) {
    this.notesFilePath = filePath;
    this.notes = new ArrayList<>();
    loadNotesFromFile();
}

private void loadNotesFromFile() {
    notes.clear();
    try (BufferedReader br = new BufferedReader(new FileReader(notesFilePath))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",", 2);
            if (parts.length == 2) {
                notes.add(new Note(parts[0], parts[1])); // Note(title, content)
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}

public List<Note> getAllNotes() {
    return new ArrayList<>(notes); // Return copy of notes list
}

public Note getNoteByTitle(String title) {
    for (Note note : notes) {
        if (note.getTitle().equalsIgnoreCase(title)) {
            return note;
        }
    }
    return null;
}

public void addNote(String title, String content) {
    notes.add(new Note(title, content));
    saveNotesToFile();
}

public void updateNote(String title, String newContent) {
    for (Note note : notes) {
        if (note.getTitle().equalsIgnoreCase(title)) {
            note.setContents(newContent);
            saveNotesToFile();
            return;
        }
    }
}

public void deleteNote(String title) {
    notes.removeIf(note -> note.getTitle().equalsIgnoreCase(title));
    saveNotesToFile();
}

private void saveNotesToFile() {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(notesFilePath))) {
        for (Note note : notes) {
            bw.write(note.getTitle() + "," + note.getContents());
            bw.newLine();
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}
