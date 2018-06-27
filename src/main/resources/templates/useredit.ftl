<#import "parts/common.ftl" as c>
<#include "parts/security.ftl">
<@c.page>
<div class="container">
    <p>Список всех пользователей:</p>
    <table class="table table-bordered">
        <form method="post" action="/test/saveuser">
            <div class="input-group">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="">First and last name</span>
                </div>
                <input type="text" class="form-control" value="${user.username}">
                <input type="text" class="form-control" value="${user.email}">
            </div>
</div>
</@c.page>