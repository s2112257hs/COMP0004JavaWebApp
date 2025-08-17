<!-- viewSingleNote -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="uk.ac.ucl.model.Note" %>
<html>
<head>
  <title>View Note</title>
  <link rel="stylesheet" href="css/style.css">
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
<div class="button-row">
  <form action="editNote" method="get">
    <input type="hidden" name="id" value="<%= note.getId() %>" />
    <button  type="submit" class="button primary">Edit</button>
  </form>

  <!-- Delete Note Button: Sends a GET request to the DeleteNoteServlet with the note title -->
  <form action="deleteNote" method="get">
    <input type="hidden" name="id" value="<%= note.getId() %>" />
    <button type="submit" class="button danger">Delete</button>
  </form>
</div>
<%
  }
%>
<br/><br/>
<a href="viewNotes" class="button">Back to Notes</a>
</body>
</html>
