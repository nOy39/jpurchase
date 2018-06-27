<table class="table table-striped">
    <thead>
    <tr class="table-success">
        <th scope="col">Тип оповещения</th>
        <th>Статус</th>
    </tr>
    </thead>
    <tbody>
                        <#if enablenotification.telegram>
                        <tr>
                            <th scope="row">Telegram message</th>
                            <td>
                                <input type="checkbox" name="telegram" ${usernotification.telegram?string("checked","")}>
                            </td>
                        </tr>
                        </#if>
                        <#if enablenotification.whatsUp>
                        <tr>
                            <th scope="row">WhatsUp message</th>
                            <td>
                                <input type="checkbox" name="whatsup" ${usernotification.whatsUp?string("checked","")}>
                            </td>
                        </tr>
                        </#if>
                        <#if enablenotification.viber>
                        <tr>

                            <th scope="row">Viber message</th>
                            <td>
                                <input type="checkbox" name="viber" ${usernotification.viber?string("checked","")}>
                            </td>
                        </tr>
                        </#if>
                        <#if enablenotification.sms>
                        <tr>
                            <th scope="row">SMS сообщение</th>
                            <td>
                                <input type="checkbox" name="sms" ${usernotification.sms?string("checked","")}>
                            </td>
                        </tr>
                        </#if>
                        <#if enablenotification.email>
                        <tr>
                            <th scope="row">Электронной почтой</th>
                            <td>
                                <input type="checkbox" name="email" ${usernotification.email?string("checked","")}>
                            </td>
                        </tr>
                        </#if>
                        <#if enablenotification.socialVk>
                        <tr>

                            <th scope="row">Через социальную сеть VK</th>
                            <td>
                                <input type="checkbox" name="vk" ${usernotification.socialVk?string("checked","")}>
                            </td>
                        </tr>
                        </#if>
                        <#if enablenotification.push>
                        <tr>
                            <th scope="row">Push уведомления</th>
                            <td>
                                <input type="checkbox" name="push" ${usernotification.push?string("checked","")}>
                            </td>
                        </tr>
                        </#if>
    <tr>
        <td class="bg-info">Всеми доступными для меня способами</td>
        <td class="bg-info">
            <input type="checkbox" name="selectall" >
        </td>
    </tr>
    </tbody>
</table>
                    <div class="form-group col-md-6 mb-3">
                        <input type="hidden" name="_csrf" value="${_csrf.token}">
                        <button type="submit" class="btn btn-primary">Сохранить</button>
                    </div>