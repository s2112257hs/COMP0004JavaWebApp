package uk.ac.ucl.model;

import java.io.IOException;

public class ModelFactory {

private static Model model;

public static Model getModel() throws IOException {
  if (model == null) {
    // Initialize the model if it is not already initialized
    model = new Model("data/notes.json");  // Make sure to provide the correct file path here
  }
  return model;
}
}
