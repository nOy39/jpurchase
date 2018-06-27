<#import "parts/common.ftl" as c>
<#include "parts/security.ftl">
<@c.page>
<h1>
    Какая-то Ошибка!!!
</h1>
<h3>
    Код ошибки: ${status}
</h3>
<h4>
    Вероятная причина: ${error}
</h4>

</@c.page>