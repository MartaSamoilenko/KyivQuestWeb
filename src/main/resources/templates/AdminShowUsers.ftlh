<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Show Users</title>
</head>
<body>
<form action="/admin/showUsers" method="get" enctype="multipart/form-data">
    <table border="1" width="100%">
        <thead>
        <tr>
            <th>Name</th>
            <th>Surname</th>
            <th>Email</th>
            <th>Role</th>
        </tr>
        </thead>

        <tbody>
        <#list users as user>
        <tr>
            <td>${user.name}</td>
            <td>${user.surname}</td>
            <td>${user.email}</td>
            <td>${user.role.getRolename()}</td>
        </tr>
        </#list>
        </tbody>
    </table>
    <br>
    <a href="/admin/mainPage">Back to AdminMenu</a>
</form>
</body>
</html>