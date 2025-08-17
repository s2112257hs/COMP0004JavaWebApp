<!-- viewNotes -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="uk.ac.ucl.model.Note" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Your Notes</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<h1>Your Notes</h1>

<!-- Search form -->
<form method="get" action="viewNotes" class="search-form">
    <input type="text" name="searchQuery" placeholder="Search notes..." value="${param.searchQuery}" />
    <button type="submit" class="button primary">Search</button>
</form>


<!-- Sorting buttons -->
<form method="get" action="viewNotes">
    <div class="button-row">
        <button type="submit" name="sortBy" value="titleAsc" class="button secondary">Title ↑</button>
        <button type="submit" name="sortBy" value="titleDesc" class="button secondary">Title ↓</button>
        <button type="submit" name="sortBy" value="sizeAsc" class="button secondary">Size ↑</button>
        <button type="submit" name="sortBy" value="sizeDesc" class="button secondary">Size ↓</button>
        <a href="addNote.jsp" class="button primary">Add New Note</a>
    </div>
</form>

<!-- Notes list -->
<%
    List<Note> notes = (List<Note>) request.getAttribute("notes");
    if (notes == null || notes.isEmpty()) {
%>
<p>No notes available. Please add a new Note.</p>
<%
} else {
%>
<div class="notes-container">
    <%
        for (Note note : notes) {
    %>
    <div class="note-card">
        <h2>
            <a href="viewSingleNote?id=<%= note.getId() %>">
                <%= note.getTitle() %>
            </a>
        </h2>
        <p><%= note.getContents().length() > 100
                ? note.getContents().substring(0, 100) + "..."
                : note.getContents() %></p>
    </div>
    <%
        }
    %>
</div>
<%
    }
%>

<br/>

</body>
</html>
