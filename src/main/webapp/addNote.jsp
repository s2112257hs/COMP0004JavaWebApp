<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add New Note</title>
</head>
<body>

<h1>Add New Note</h1>

<!-- Check for any errors passed as query parameter -->
<% if (request.getParameter("error") != null) { %>
<p style="color: red;">Please fill in both the title and contents.</p>
<% } %>

<!-- Form to submit a new note -->
<form action="saveNote" method="post">
    <label for="title">Title:</label><br>
    <input type="text" id="title" name="title" required><br><br>

    <label for="content">Content:</label><br>
    <textarea id="content" name="content" rows="5" cols="50" required></textarea><br><br>

    <button type="submit" class="button">Save Note</button>
    <button type="button" class="button" onclick="window.location.href='viewNotes'">Cancel</button>
</form>
</body>
</html>
