<#assign s=JspTaglibs["/META-INF/spring.tld"] />
<#assign form=JspTaglibs["/META-INF/spring-form.tld"]>

<html>
<head>
    <title>Регистрация</title>
</head>
<body onload="checkGeneratePassword()">
<h2>Регистрация</h2>

<@form.form commandName="signup_form" id="signup" action="/admin/signup" acceptCharset="UTF-8"  method="post">
<div>
    <@form.input  id="email" type="email" name="email" path="email" class="form-control" placeholder="Email"/>
    <p><@form.errors path="email" cssStyle="color: #ab2020;" /></p>
</div>
<div>
    <@form.input  id="firstName" name="firstName" path="firstName"  class="form-control" placeholder="Имя"/>
    <p><@form.errors path="firstName" cssStyle="color: #ab2020;" /></p>
</div>
<div>
    <@form.input  id="lastName" name="lastName" path="lastName"  class="form-control" placeholder="Фамилия"/>
    <p><@form.errors path="lastName" cssStyle="color: #ab2020;" /></p>
</div>
<div><p><label>
    <@form.checkbox onchange="checkGeneratePassword()" path="isPasswordGenerate" id="generate-password"/>
</label> Сгенерировать пароль</p></div>
<div id="passwords">
    <div>
        <@form.input type="password" name="password" path="password" class="form-control" placeholder="Пароль"/>
        <p><@form.errors path="password" cssStyle="color: #ab2020;" /></p>
    </div>
    <div>
        <@form.input type="password" name="confirmPassword" path="confirmPassword" class="form-control" placeholder="Повторный ввод пароля"/>
    </div>
    <div>
        <p><@form.errors path="confirmPassword" cssStyle="color: #ab2020;"/></p>
    </div>
</div>
<div>
<p><@form.select path="role" id="role"></p>
    <option value="ROLE_DESIGNER">Дизайнер</option>
    <option value="ROLE_ADMIN">Администратор</option>
    <option value="ROLE_WRITER">Печатник</option>
    <option value="ROLE_MANAGER">Менеджер</option>
    <option value="ROLE_ACCOUNTANT">Бухгалтер</option>
</@form.select>
</div>
<button type="submit">Регистрация</button>
</@form.form>
</div>

</body>
</html>

<script src="/js/javascript.js"></script>
