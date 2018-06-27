<#import "parts/common.ftl" as c>
<#include "parts/security.ftl">
<@c.page>
<div class="container">
    <h4>Профиль пользователя ${user.username}.</h4>
    <ul class="nav nav-tabs" id="myTab" role="tablist">
        <li class="nav-item">
            <a class="nav-link active" id="home-tab" data-toggle="tab" href="#primary" role="tab" aria-controls="home" aria-selected="true">Основное</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" id="profile-tab" data-toggle="tab" href="#secondary" role="tab" aria-controls="profile" aria-selected="false">Дополнительно</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" id="messages-tab" data-toggle="tab" href="#settings" role="tab" aria-controls="messages" aria-selected="false">Настройки</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" id="settings-tab" data-toggle="tab" href="#secure" role="tab" aria-controls="settings" aria-selected="false">Безопастность</a>
        </li>
    </ul>

    <!-- Tab panes -->
    <div class="tab-content">
    <#--TODO: Переделать телефон-->
        <div class="tab-pane active" id="primary" role="tabpanel" aria-labelledby="home-tab">
            <div class="container">
                <form class="needs-validation" novalidate name="profile" method="post" action="/users/saveprofile/">
            <#include "parts/profile_primary_block.ftl">

                </form>
            </div>
        </div>
    <#--TODO: Сделать привязку к телеграмм боту, сделать привязку к соцсетям-->
    <#--TODO: Переделать фронт-->
        <div class="tab-pane" id="secondary" role="tabpanel" aria-labelledby="profile-tab">
            <div class="container">
                <form name="profile" method="post" action="/users/secondaryinfo" enctype="multipart/form-data">
                    <#include "parts/profile_secondary_block.ftl">
                </form>
            </div>
        </div>
        <div class="tab-pane" id="settings" role="tabpanel" aria-labelledby="messages-tab">
            <div class="container">
                <form name="notifications" method="post" action="/users/notification" name="form">
                <#include "parts/notification_setting.ftl">
                </form>
            </div>
        </div>
        <div class="tab-pane" id="secure" role="tabpanel" aria-labelledby="settings-tab">
            <div class="container">
                <form method="post" action="/users/changepassword">
                    <#include "parts/profile_secure_block.ftl">
                </form>
            </div>
        </div>
    </div>
</div>
    <script>
        $(function () {
            $('#myTab li:last-child a').tab('show')
        })
    </script>
    <script>
        (function() {
            'use strict';
            window.addEventListener('load', function() {
                // Fetch all the forms we want to apply custom Bootstrap validation styles to
                var forms = document.getElementsByClassName('needs-validation');
                // Loop over them and prevent submission
                var validation = Array.prototype.filter.call(forms, function(form) {
                    form.addEventListener('submit', function(event) {
                        if (form.checkValidity() === false) {
                            event.preventDefault();
                            event.stopPropagation();
                        }
                        form.classList.add('was-validated');
                    }, false);
                });
            }, false);
        })();
    </script>
</@c.page>
