<#assign s=JspTaglibs["/META-INF/spring.tld"] />
<#assign form=JspTaglibs["/META-INF/spring-form.tld"]>

<html>
<head>
    <title>Вход</title>
    <meta name="_csrf" content="${_csrf.token}"/>
    <!-- default header name is X-CSRF-TOKEN -->
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
</head>
<body>
<h2>Вход</h2>

<@form.form id="signin" action="/j_spring_security_check" method="post">

    <div>
        <input name="email" type="text" class="form-control" placeholder="email">
    </div>
    <div>
        <input name="password" type="password" class="form-control" placeholder="пароль">
    </div>

<#if error??>
    <p style="color: #a71f1f">
        Неправильный логин или пароль
    </p>
</#if>

    <div>
        <input type="checkbox" name="remember-me">&nbsp;&nbsp;Запомнить меня
    </div>

    <div>
        <button type="submit">Войти</button>
    </div>
</@form.form>

</body>

</html>