<#assign s=JspTaglibs["/META-INF/spring.tld"] />
<#assign form=JspTaglibs["/META-INF/spring-form.tld"]>

<html>
<head><title>смена пароля</title>
<body>
<h2>Смена пароля</h2>
<div>
<@form.form commandName="change_password_form" id="change_password" action="/user/change/password"
acceptCharset="UTF-8"  method="post">
    <div>
        <@form.input  id="oldPassword" type="password" name="oldPassword" path="oldPassword" class="form-control"
        placeholder="old password"/>
        <p><@form.errors path="oldPassword" cssStyle="color: #ab2020;" /></p>
    </div>
    <div>
        <@form.input type="password" name="newPassword" path="newPassword" class="form-control"
        placeholder="новый пароль"/>
        <p><@form.errors path="newPassword" cssStyle="color: #ab2020;" /></p>
    </div>
    <div>
        <@form.input type="password" name="confirmPassword" path="confirmPassword" class="form-control"
        placeholder="Повторный ввод пароля"/>
        <p><@form.errors path="confirmPassword" cssStyle="color: #ab2020;"/></p>
        <p><@form.errors path="passwordsEquals" cssStyle="color: #ab2020;"/></p>
    </div>
    <button type="submit">сменить пароль</button>
</@form.form>
</div>
</body>
</html>