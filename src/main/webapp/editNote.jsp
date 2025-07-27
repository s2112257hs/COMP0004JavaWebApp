<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="uk.ac.ucl.model.Note" %>
<html>
<head>
  <title>Edit Note</title>
  <style>
    body { font-family: Arial, sans-serif; padding: 20px; }
    .button { padding: 8px 16px; margin: 5px; background-color: #007bff; color: white; border: none; border-radius: 4px; cursor: pointer; }
    .button:hover { background-color: #0056b3; }
  </style>
</head>
<body>
<%
  Note note = (Note) request.getAttribute("note");
  if (note == null) {
%>
<p>Note not found.</p>
<%
} else {
%>
<h1>Edit Note</h1>
<form action="editNote" method="post">
  <!-- Use originalTitle to identify which note is being updated -->
  <input type="hidden" name="originalTitle" value="<%= note.getTitle() %>" />

  <label for="title">Title:</label><br>
  <input type="text" id="title" name="title" value="<%= note.getTitle() %>" required /><br><br>

  <label for="content">Content:</label><br>
  <textarea id="content" name="content" rows="5" cols="50" required><%= note.getContents() %></textarea><br><br>

  <button type="submit" class="button">Save Changes</button>
</form>
<%
  }
%>
<br/>
<a href="viewNotes" class="button">Back to Notes</a>
</body>
</html>
