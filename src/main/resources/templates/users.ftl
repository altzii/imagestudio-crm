<html>
<head><title>Пользователи</title>
<body>

<h1>Пользователи</h1>
<#list users as user>
<div>${user.getFirstName()} ${user.getLastName()} с ролями:
<ul>
    <#list user.roles as role>
        <li>${role.getName()}</li>
    </#list>
</ul>
</div>
</#list>

</body>

</html>