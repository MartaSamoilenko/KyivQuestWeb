<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>RouteChoice</title>
</head>
<body>
<form action="user/routeChoice" method="get" enctype="multipart/form-data">
    <table id="routeTable" style="border: 1px">
        <thead id="routeTableHead">
        <tr>
            <th>Name of route</th>
            <td>Image</td>
            <th>Checkpoints</th>
            <th></th>
        </tr>
        </thead>

        <tbody id="routeTableBody">
        <#list routes as key, value>
            <tr>
                <form action="/user/routeChoice/chosen" method="get">
                    <td>${key.name}</td>
                    <td>${key.image}</td>
                    <td>
                        <#list value as place>${place.name} </#list>
                    </td>
                    <input type="hidden" name="route" value="${key.id}">
                    <td>
                        <input type="submit"
                               value="Choose Route">
                </form>
                </td>
            </tr>
            </tr>
        </#list>
        </tbody>
    </table>


</form>
<a href="/user/mainMenu"> Back to menu </a>
</body>
</html>