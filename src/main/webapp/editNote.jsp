<!-- editNote -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="uk.ac.ucl.model.Note" %>
<html>
<head>
  <title>Edit Note</title>
  <link rel="stylesheet" href="css/style.css">
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

  <label for="title">Title:</label><br>
  <input type="text" id="title" name="title" value="<%= note.getTitle() %>" required /><br><br>

  <label for="content">Content:</label><br>
  <textarea id="content" name="content" rows="5" cols="50" required><%= note.getContents() %></textarea><br><br>
  <input type="hidden" id="id" name="id" value="<%= note.getId()%>">
  <div class="button-row">
    <button type="submit" class="button primary">Save Changes</button>
  </div>
</form>
<%
  }
%>
<br/>
<a href="viewNotes" class="button">Back to Notes</a>
</body>
</html>
