<#if !isRegisterForm?ifExists>
<div class="form-group col-md-6 mb-3">
    <label for="exampleInputPassword1">Текущий пароль:</label>
    <input type="password" class="form-control" name="oldpass" placeholder="Текущий пароль" disabled>
</div>
</#if>
<div class="form-group col-md-6 mb-3">
    <label for="exampleInputPassword1">Новый пароль:</label>
    <input type="password" class="form-control" name="newpass" placeholder="Новый пароль" disabled>
</div>
<div class="form-group col-md-6 mb-3">
    <label for="exampleInputPassword1">Подтверждение пароля:</label>
    <input type="password" class="form-control" name="confirmpass" placeholder="Подтверждение пароля:" disabled>

</div>
<div class="form-group col-md-6 mb-3">
    <button type="submit" class="btn btn-primary" disabled>Сохранить</button>
</div>