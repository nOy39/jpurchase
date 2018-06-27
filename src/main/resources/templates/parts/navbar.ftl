<#include "security.ftl">
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <button class="navbar-toggler" type="button"
            data-toggle="collapse" data-target="#navbarToggler"
            aria-controls="navbarToggler" aria-expanded="false"
            aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <a class="navbar-brand" href="/">Joint Purchase</a>
    <div class="collapse navbar-collapse" id="navbarToggler">
        <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
        <#if know>
            <li class="nav-item active">
                <a class="nav-link" href="#">Корзина</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="#">Сообщение</a>
            </li>

<#if isOrganizer>
            <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Администрирование
            </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
    <#if isOrganizer>
                    <a class="dropdown-item" href="#">Мои закупки</a>
                    <a class="dropdown-item" href="#">Создать закупку</a>
                    <div class="dropdown-divider"></div>
    </#if>
                    <#if isSuperUser>
                    <a class="dropdown-item" href="#">Организаторы</a>
                    <a class="dropdown-item" href="#">Настройки</a>
                    <div class="dropdown-divider"></div>
                    </#if>
                    <#if isAdmin>
                    <a class="dropdown-item" href="/users/userlist">Список пользователей</a>
                    <a class="dropdown-item" href="#">Сервис</a>
                    <div class="dropdown-divider"></div>
                    </#if>
                    <a class="dropdown-item" href="/users/profile">Мой профиль</a>
                </div>
<#else >
    <li class="nav-item">
        <a class="nav-link" href="/users/profile">Мой профиль</a>
    </li>
</#if>
        </#if>
        <#if !isUser??>
            <li class="nav-item">
                <a class="nav-link" href="/login">Login</a>
            </li>
        <#else>
            <li class="nav-item">
                <a class="nav-link" href="#">Logout</a>
            </li>
        </#if>
        </ul>


    </div>
</nav>



