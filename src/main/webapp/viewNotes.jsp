<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="uk.ac.ucl.model.Note" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Your Notes</title>
    <style>
        body { font-family: Arial, sans-serif; padding: 20px; }
        .button { padding: 8px 16px; margin: 5px; background-color: #007bff; color: white; border: none; border-radius: 4px; cursor: pointer; }
        .button:hover { background-color: #0056b3; }
        input[type="text"] { padding: 5px; margin-right: 10px; }
    </style>
</head>
<body>
<h1>Your Notes</h1>

<!-- Search form -->
<form method="get" action="viewNotes">
    <input type="text" name="searchQuery" placeholder="Search notes..." value="${param.searchQuery}" />
    <button type="submit">Search</button>
</form>

<!-- Sorting buttons -->
<form method="get" action="viewNotes">
    <button type="submit" name="sortBy" value="titleAsc">Sort by Title (Ascending)</button>
    <button type="submit" name="sortBy" value="titleDesc">Sort by Title (Descending)</button>
    <button type="submit" name="sortBy" value="sizeAsc">Sort by Size (Shortest to Longest)</button>
    <button type="submit" name="sortBy" value="sizeDesc">Sort by Size (Longest to Shortest)</button>
</form>

<!-- Notes list -->
<ul>
    <%
        // Get the notes from the request attribute
        List<Note> notes = (List<Note>) request.getAttribute("notes");
        if (notes == null || notes.isEmpty()) {
    %>
    <p>No notes available. Please add a new Note.</p>
    <%
    } else {
        for (Note note : notes) {
    %>
    <li>
        <a href="viewSingleNote?title=<%= note.getTitle() %>">
            <%= note.getTitle() %>
        </a>
    </li>
    <%
            }
        }
    %>
</ul>

<br/>
<a href="addNote.jsp" class="button">Add New Note</a>
</body>
</html>
