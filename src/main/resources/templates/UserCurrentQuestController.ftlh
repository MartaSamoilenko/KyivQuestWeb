<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form action="/user/currentQuest" method="get">
    <label>${route.name}</label>
    <br>
    <table border="1">
        <thead>
        <tr>
            <th>Checkpoint</th>
            <th>Result</th>
        </tr>
        </thead>
        <tbody>

        <#list checkpointsOfCurrentRoute as checkpoint>
        <tr>
                <td>${checkpoint.name}</td>
        </#list>


        <#list result as res>
                <td>${res}</td>
        </tr>
        </#list>

        </tbody>
    </table>
</form>
</body>
</html>