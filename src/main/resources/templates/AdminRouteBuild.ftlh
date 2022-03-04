<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>AdminBuildRoute</title>
</head>
<script>
    function addToRoute() {
        var select = document.getElementById("checkpoints");
        let checkpoints = document.getElementById("checkpointsInRoute");
        checkpoints.innerHTML += select.options[select.selectedIndex].text + " ";
    }
</script>
<body>
<form name="/admin/routeBuild" method="post" enctype="multipart/form-data">
    <label class="label" id="nameLabel" for="nameInput">Name of Route</label>
    <br>
    <input class="input" id="nameInput" type="text" name="routeName" value=""> <label class="label"
                                                                                      id="checkpointsInRoute"
                                                                                      type="text" value=""></label>
    <br>
    <label class="label" id="checkpointLabel">Checkpoints</label>
    <br>
    <div>
        <#list checkpoints as checkpoint>
            <input type="checkbox" id="checkpoint${checkpoint.id}" name="checkpoints" value="${checkpoint.name}"/>
            <label for="checkpoint${checkpoint.id}" name="checkpointName">${checkpoint.name}</label>
            <br>
        </#list>
    </div>
    <input type="submit" name="BuildRoute" id="buildRoute" value="Build Route">
</form>
<br>
<a href="/admin/mainPage">Back to AdminMenu</a>
</body>
</html>