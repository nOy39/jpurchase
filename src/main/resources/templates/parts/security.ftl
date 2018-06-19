<#assign
    know = Session.SPRING_SECURITY_CONTEXT??
>
<#if know>
    <#assign
        author = Session.SPRING_SECURITY_CONTEXT.authentication.principal
        name = author.getUsername()
        isAdmin = author.isAdmin()
        isUser = author.isUser()
        isOrganizer = author.isOrganizer()
        isSuperUser = author.isSuperUser()
    >
    <#else>
    <#assign
        name = "unknow"
        isAdmin = false
    >
</#if>

