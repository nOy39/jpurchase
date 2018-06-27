
        <div class="form-row">
            <div class="col-md-4 mb-3">
                <label for="validationCustom01">Имя</label>
                <input type="text" class="form-control" id="validationCustom01" placeholder="Имя" name="firstname" value="${user.firstname?ifExists}" required>
                <div class="valid-feedback">
                    Looks good!
                </div>
            </div>
            <div class="col-md-4 mb-3">
                <label for="validationCustom02">Фамилия</label>
                <input type="text" class="form-control" id="validationCustom02" placeholder="Фамилия" name="lastname" value="${user.lastname?ifExists}" required>
                <div class="valid-feedback">
                    Looks good!
                </div>
            </div>
            <div class="col-md-4 mb-3">
                <label for="validationCustomUsername">Юзернейм</label>
                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroupPrepend">@</span>
                    </div>
                    <input type="text" class="form-control" id="validationCustomUsername" placeholder="Username" name="username" value="${user.username}" aria-describedby="inputGroupPrepend" required disabled>
                    <div class="invalid-feedback">
                        Please choose a username.
                    </div>
                </div>
            </div>
        </div>
        <div class="form-row">
            <div class="col-md-6 mb-3">
                <label for="validationCustom01">Почта</label>
                <input type="email" class="form-control" id="validationCustom01" placeholder="e-mail" name="email" value="${user.email?ifExists}" required>
                <div class="valid-feedback">
                    Looks good!
                </div>
            </div>
            <div class="col-md-6 mb-3">
                <label for="validationCustom02">Телефон</label>
                <input type="text" class="form-control" id="validationCustom02" placeholder="Моб.телефон" name="phone" value="+7 ${user.phone?ifExists}" required>
                <div class="valid-feedback">
                    Looks good!
                </div>
            </div>
        </div>
        <div class="form-row">
            <div class="col-md-3 mb-3">
                <label for="validationCustom03">Город</label>
                <input type="text" class="form-control" id="validationCustom03" placeholder="Город" name="city"value="${user.city?ifExists}" required>
                <div class="invalid-feedback">
                    Please provide a valid city.
                </div>
            </div>
            <div class="col-md-3 mb-3">
                <label for="validationCustom04">Район</label>
                <input type="text" class="form-control" id="validationCustom04" placeholder="Район" name="district" value="${user.district?ifExists}">
                <div class="invalid-feedback">
                    Please provide a valid state.
                </div>
            </div>
            <div class="col-md-3 mb-3">
                <label for="validationCustom05">Улица</label>
                <input type="text" class="form-control" id="validationCustom05" placeholder="Улица" name="street" value="${user.street?ifExists}">
                <div class="invalid-feedback">
                    Please provide a valid zip.
                </div>
            </div>
            <div class="col-md-1 mb-3">
                <label for="validationCustom05">Дом</label>
                <input type="text" class="form-control" id="validationCustom05" placeholder="Дом" name="home" value="${user.home?ifExists}">
                <div class="invalid-feedback">
                    Please provide a valid zip.
                </div>
            </div>
            <div class="col-md-1 mb-3">
                <label for="validationCustom05">Квартира</label>
                <input type="text" class="form-control" id="validationCustom05" placeholder="Кв." name="flat" value="${user.flat?ifExists}">
                <div class="invalid-feedback">
                    Please provide a valid zip.
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="form-check">
                <input class="form-check-input" type="checkbox" value="" id="invalidCheck" required>
                <label class="form-check-label" for="invalidCheck">
                    Подтвердить изменения.
                </label>
                <div class="invalid-feedback">
                    Вы должны подтвердить изменения.
                </div>
            </div>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <button class="btn btn-primary" type="submit">Сохранить</button>

