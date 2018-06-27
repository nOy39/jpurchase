package org.a2lpo.purchase.joint.purchase.service;

import org.a2lpo.purchase.joint.purchase.domain.user.User;
import org.a2lpo.purchase.joint.purchase.domain.user.UserNotification;
import org.a2lpo.purchase.joint.purchase.repos.NotificationSettingsRepo;
import org.a2lpo.purchase.joint.purchase.repos.UserNotificationRepo;
import org.a2lpo.purchase.joint.purchase.repos.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService implements UserDetailsService {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final UserNotificationRepo userNotificationRepo;

    public UserService(UserRepo userRepo,
                       PasswordEncoder passwordEncoder,
                       UserNotificationRepo userNotificationRepo) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
        this.userNotificationRepo = userNotificationRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }

    /**
     * Обновление профиля пользователя
     *
     * @param user - пользователь которого обновляем
     * @param form - Мапа из формы
     * @return - возвращаем true или false
     */
    public boolean updateUser(User user, Map<String, String> form) {

        boolean isUpdate;

        for (Map.Entry<String, String> entries : form.entrySet()) {
            switch (entries.getKey()) {
                case "firstname":
                    user.setFirstname(entries.getValue());
                    break;
                case "lastname":
                    user.setLastname(entries.getValue());
                    break;
                case "email":
                    user.setEmail(entries.getValue());
                    break;
                case "phone":
                    try {
                        user.setPhone(extractPhone(entries.getValue()));
                    } catch (NumberFormatException ex) {
                        return false;
                    }
                    break;
                case "city":
                    user.setCity(entries.getValue());
                    break;
                case "district":
                    user.setDistrict(entries.getValue());
                    break;
                case "street":
                    user.setStreet(entries.getValue());
                    break;
                case "home":
                    user.setHome(entries.getValue());
                    break;
                case "flat":
                    user.setFlat(entries.getValue());
                    break;
                default:
                    break;
            }
        }

        try {
            userRepo.save(user);
            isUpdate = true;
        } catch (Exception ex) {
            isUpdate = false;
        }
        return isUpdate;
    }

    private long extractPhone(String value) {
        long phone = 0l;
        if (value.length()>10) {
            value = value.substring(value.length()-10);
        }
        return phone = Long.parseLong(value);
    }

    /**
     * Проверка пользователя на наличие его в таблице оповещений.
     * если его там нет, то он создается со всеми значения false
     * @param byUser - пользователь
     * @return
     */
    public UserNotification verifyNotify(User byUser) {
        UserNotification uNotification = new UserNotification();

        if (userNotificationRepo.findByUser(byUser) == null) {
            uNotification.setUser(byUser);
            userNotificationRepo.save(uNotification);
        } else {
            uNotification=userNotificationRepo.findByUser(byUser);
        }
        return uNotification;
    }

    public void setNotification(User user, Map<String,String> form) {
        UserNotification userNotification = userNotificationRepo.findByUser(user);
        for (Map.Entry<String, String> entries : form.entrySet()) {

        switch (entries.getKey()) {
            case "telegram":
                userNotification.setTelegram(true);
                break;
            case "email":
                userNotification.setEmail(true);
                break;
            case "viber":
                userNotification.setViber(true);
                break;
            case "selectall":
                userNotification.setTelegram(true);
                userNotification.setEmail(true);
                userNotification.setViber(true);
                break;
        }
        userNotificationRepo.save(userNotification);
    }
    }
}
