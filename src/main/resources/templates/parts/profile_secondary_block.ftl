<div class="form-row">
    <div class="col-md-6 mb-3">
        <div class="card my-3" style="width: 9rem;">
            <div class="thumbnail">
                <a href="/static/img/noava.png" target="_blank">
                    <img src="/img/${user.avatar?ifExists}" alt="rounded" style="width:100%">
                </a>
            </div>
            <label class="btn btn-dark-otline" for="my-file-selector">
                <input id="my-file-selector" type="file" style="display:none" name="file"
                       onchange="$('#upload-file-info').html(this.files[0].name)">
                Загрузить<br> изображение
            </label>
            <span class='label label-info' id="upload-file-info"></span>
            <#--<img class="card-img-top" src="/static/img/noava.png" alt="Card image cap">-->
        </div>
    </div>
</div>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <button class="btn btn-primary" type="submit">Сохранить</button>