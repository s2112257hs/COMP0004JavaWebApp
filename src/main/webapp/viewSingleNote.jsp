<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="uk.ac.ucl.model.Note" %>
<html>
<head>
  <title>View Note</title>
  <style>
    body { font-family: Arial, sans-serif; padding: 20px; }
    .button { padding: 8px 16px; margin: 5px; background-color: #007bff; color: white; border: none; border-radius: 4px; cursor: pointer; }
    .button:hover { background-color: #0056b3; }
  </style>
</head>
<body>
<%
  // Retrieve the note from the request attribute
  Note note = (Note) request.getAttribute("note");
  if(note == null) {
%>
<p>Note not found.</p>
<%
} else {
%>
<h1><%= note.getTitle() %></h1>
<p><%= note.getContents() %></p>

<!-- Edit Note Button: Sends a GET request to the EditNoteServlet with the note title -->
<form action="editNote" method="get" style="display:inline;">
  <input type="hidden" name="title" value="<%= note.getTitle() %>" />
  <button type="submit" class="button">Edit</button>
</form>

<!-- Delete Note Button: Sends a GET request to the DeleteNoteServlet with the note title -->
<form action="deleteNote" method="get" style="display:inline;">
  <input type="hidden" name="title" value="<%= note.getTitle() %>" />
  <button type="submit" class="button" style="background-color: #dc3545;">Delete</button>
</form>
<%
  }
%>
<br/><br/>
<a href="viewNotes" class="button">Back to Notes</a>
</body>
</html>
