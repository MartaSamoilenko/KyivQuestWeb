<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>MainPageAdmin</title>
</head>
<body>
<center>
    <form action="/admin/mainPage" method="post" enctype="multipart/form-data">
        <a href="/admin/addCheckpoint">Add new checkpoint</a>
        <br>
        <a href="/admin/routeBuild">Build new route</a>
        <br>
        <a href="/admin/showUsers">Show users</a>
    </form>
    <form action="/admin/logout" method="post" enctype="multipart/form-data">
        <input type="submit" class="logout" name="delete"
               value="Вийти із системи">
    </form>
</center>
</body>
</html>