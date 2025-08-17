package uk.ac.ucl.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;

public class Note {
private String id;
private String title;
private String contents;

// Default constructor needed for Jackson
public Note() {
}

// Constructor with parameters
@JsonCreator
public Note(@JsonProperty("title") String title, @JsonProperty("contents") String contents, @JsonProperty("id") String id) {
    this.id = id;
    this.title = title;
    this.contents = contents;
}

// Getter for ID
public String getId() {
    return id;
}


// Getter and setter for title
public String getTitle() {
    return title;
}

public void setTitle(String title) {
    this.title = title;
}

// Getter and setter for contents
public String getContents() {
    return contents;
}

public void setContents(String contents) {
    this.contents = contents;
}

@Override
public String toString() {
    return "Note{" +
            "id='" + id + '\'' +
            ", title='" + title + '\'' +
            ", contents='" + contents + '\'' +
            '}';
}
}
