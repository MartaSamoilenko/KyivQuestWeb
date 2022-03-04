<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>AdminAddCheckpoint</title>
</head>
<body>
<form name="admin/addCheckpoint" method="post" enctype="multipart/form-data">
    <label class="label" id="nameLabel" for="nameInput">Name</label>
    <br>
    <input class="input" id="nameInput" type="text" name="name" value="">
    <br>
    <input type="submit" name="Add">
</form>
<br>

<table border="1" width="50%">
    <thead>
    <tr>
        <th>Checkpoint Id</th>
        <th>Name</th>
        <th></th>
    </tr>
    </thead>

    <tbody>

    <#list checkpoints as checkpoint>
        <tr>
            <td>${checkpoint.id}</td>
            <td>${checkpoint.name}</td>
            <td><form action="/admin/deleteCheckpoint/${checkpoint.id}" method="get"><a class="btn" role="button" href="/admin/deleteCheckpoint/${checkpoint.id}">Delete</a></form>
            </td>
        </tr>
    </#list>

    </tbody>
</table>
<br>
<a href="/admin/mainPage">Back to AdminMenu</a>
</body>
</html>