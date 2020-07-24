<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>
<div>
    <@l.logout />
</div>
<div>
    <form method="post">
        <input type="text" name="text" placeholder="Введите сообщение" />
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <input type="text" name="tag" placeholder="Тэг">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button type="submit">Добавить</button>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
    </form>
</div>
<div>Список сообщений</div>
<form method="get" action="/main">
    <input type="text" name="filter" value="${filter}">
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <button type="submit">Найти</button>
</form>
<#list messages as message>
<div>
    <b>${message.id}</b>
    <span>${message.text}</span>
    <i>${message.tag}</i>
    <strong>${message.authorName}</strong>
</div>
<#else>
No message
</#list>
</@c.page>