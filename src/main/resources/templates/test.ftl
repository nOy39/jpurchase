<#import "parts/common.ftl" as c>
<#include "parts/security.ftl">
<@c.page>
<h3>
    Hello this is the test
</h3>
    <#if know>
        <ul>
        <#if isUser>
            <li>
                ТЕСТ для ЮЗЕРА
            </li>
        </#if>
        <#if isOrganizer>
            <li>
                Тест для организатора
            </li>
        </#if>
        <#if isSuperUser>
            <li>
                <a href="/test/article/details">group_details_</a>
            </li>
        </#if>
        </ul>
    <#else>
    Привет гость
    </#if>

</@c.page>