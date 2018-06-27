<#assign
    know = Session.SPRING_SECURITY_CONTEXT??
>
<#if know>
    <#assign
        author = Session.SPRING_SECURITY_CONTEXT.authentication.principal
        name = author.getUsername()
        isAdmin = author.isAdmin()
        isSuperUser = author.isSuperUser()
        isOrganizer = author.isOrganizer()
        isUser = author.isUser()
    >
    <#else>
    <#assign
        name = "unknow"
        isAdmin = false
    >
</#if>

