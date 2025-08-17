package uk.ac.ucl.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Model {

private static Model instance; // Singleton instance

private List<Note> notes;
private final String notesDataFilePath;
private final ObjectMapper objectMapper;

// Private constructor for singleton
Model(String notesDataFilePath) {
  this.notesDataFilePath = notesDataFilePath;
  this.objectMapper = new ObjectMapper();
  this.notes = new ArrayList<>();
  loadNotesFromFile();
}

// Static method to retrieve the singleton instance
public static Model getInstance() {
  if (instance == null) {
    // Use the correct path to your JSON file
    instance = new Model("data/notes.json");
  }
  return instance;
}

// Load notes from the JSON file
private void loadNotesFromFile() {
  try {
    File file = new File(notesDataFilePath);
    if (file.exists()) {
      this.notes = new ArrayList<>(Arrays.asList(objectMapper.readValue(file, Note[].class)));
    } else {
      this.notes = new ArrayList<>();
    }
  } catch (IOException e) {
    e.printStackTrace();
  }
}

// Add a new note to the list and update the JSON file
public void addNewNote(Note newNote) {
  this.notes.add(newNote);
  saveNotesToFile(); // Save changes to the file
  loadNotesFromFile(); // Reload the notes list from the JSON file
}

// Save the notes list back to the JSON file
private void saveNotesToFile() {
  try {
    objectMapper.writeValue(new File(notesDataFilePath), this.notes);
  } catch (IOException e) {
    e.printStackTrace();
    throw new RuntimeException("Failed to save notes to file.");
  }
}

public List<Note> getNotes() {
  loadNotesFromFile();  // ✅ Always reload from file before returning
  return notes;
}



public boolean updateNote(String id, String newTitle, String newContent) {
  for (Note note : notes) {
    if (id.equals(note.getId())) {
      note.setTitle(newTitle);
      note.setContents(newContent);
      saveNotesToFile();  // ✅ Save changes to JSON file
      return true;
    }
  }
  return false;
}

public boolean deleteNoteById(String id) {
  boolean removed = notes.removeIf(note -> note.getId().equals(id));
  if (removed) {
    saveNotesToFile();
  }
  return removed;
}
}