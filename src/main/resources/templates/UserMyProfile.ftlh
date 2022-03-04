<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>My Profile</title>
</head>
<body>
<form action="/user/myProfile" method="get" enctype="multipart/form-data">
    <table border="1" width="100%">
        <thead>
        <tr>
            <th>Name</th>
            <th>Surname</th>
            <th>Current Route</th>
            <th>Current Checkpoint</th>
            <th>Start of quest</th>
        </tr>
        </thead>

        <tbody>
        <tr>
            <td>${user.name}</td>
            <td>${user.surname}</td>
            <td>${currentRoute.route.name}</td>
            <td>${currentRoute.checkpoint.name}</td>
            <td>${currentRoute.localDateTime.toString()}</td>
        </tr>
        </tbody>
    </table>
    <br>
    <br>
    <#list userCompletedRoutes as userCompletedRoute>
        <label>${userCompletedRoute.route.name}</label>
    </#list>
    <br>
    <br>
    <a href="/user/mainMenu"> Back to Menu!</a>
</form>
</body>
</html>