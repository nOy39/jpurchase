<#import "parts/common.ftl" as c>
<#include "parts/security.ftl">

<@c.page>
<div class="container">
    <p>Список всех пользователей:</p>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>ID</th>
            <th>USERNAME</th>
            <th>EMAIL</th>
            <th>ПРАВА</th>
            <th>УПРАВЛЕНИЕ</th>
        </tr>
        </thead>
        <tbody>
        <#list users as user>
        <tr>
            <td>${user.getId()}</td>
            <td>${user.getUsername()}</td>
            <td>${user.getEmail()}</td>
            <td>
                <#list user.roles as role>
                    ${role}
                    <#sep>,
                </#list>
            </td>
            <td><#if user.username != 'admin'>
            <a href="/test/useredit/${user.id}">Edit</a></td>
            </#if>
        </tr>
        </#list>
        </tbody>
    </table>
</div>

<a href="/">Main page</a>
</@c.page>