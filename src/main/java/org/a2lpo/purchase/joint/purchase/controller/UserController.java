package org.a2lpo.purchase.joint.purchase.controller;

import org.a2lpo.purchase.joint.purchase.domain.user.User;
import org.a2lpo.purchase.joint.purchase.repos.*;
import org.a2lpo.purchase.joint.purchase.service.FileService;
import org.a2lpo.purchase.joint.purchase.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;

@Controller
@RequestMapping(value = "users")
public class UserController {

    private final UserRepo userRepo;
    private final UserService userService;
    private final FileService fileService;
    private final NotificationSettingsRepo notifSettingRepo;

    @Value("${upload.path}")
    private String uploadPath;

    @Autowired
    public UserController(UserRepo userRepo,
                          ArticleRepo articleRepo,
                          UploadFileRepo uploadFileRepo,
                          UserService userService,
                          FileService fileService,
                          NotificationSettingsRepo notifSettingRepo,
                          UserNotificationRepo userNotificationRepo) {
        this.userRepo = userRepo;
        this.userService = userService;
        this.fileService = fileService;
        this.notifSettingRepo = notifSettingRepo;
    }

    /**
     * Список пользователей доступен только для администраторов
     * @param model
     * @return
     */
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping(value = "userlist")
    public String userList(Model model) {
        model.addAttribute("users", userRepo.findAll());
        return "userlist";
    }

    /**
     * Загрузка профиля
     *
     * @param user  - авторизированный пользователь
     * @param model - модель странницы
     * @return - возвращаем profile.ftl
     */
    @GetMapping(value = "/profile")
    public String profile(@AuthenticationPrincipal User user,
                          Model model) {
        model.addAttribute("user", user);
        model.addAttribute("enablenotification",notifSettingRepo.findById(1l).get());
        model.addAttribute("usernotification",userService.verifyNotify(user));
        return "profile";
    }

    /**
     * Обновление профиля с первой ТАБ вкладки
     *
     * @param form               - Map данных с формы
     * @param user               - авторизированный пользователь
     * @param redirectAttributes - редиректовая модель
     * @return - возвращает редирект profile.ftl
     */
    @PostMapping(value = "/saveprofile")
    public String updateProfile(@RequestParam Map<String, String> form,
                                @AuthenticationPrincipal User user,
                                RedirectAttributes redirectAttributes) {
        if (userService.updateUser(user, form)) {
            redirectAttributes.addFlashAttribute("message", "Профиль обновлен.");
        } else {
            redirectAttributes.addFlashAttribute("alert", "Ошибка обновления профиля.");
        }
        return "redirect:/users/profile";
    }

    /**
     * Обновление дополнительных сведений пользователя
     * @param user - авторизированный пользователь
     * @param file - принимаемый файл
     * @param redirectAttributes - модель
     * @return - возвращает редирект на страницу профиля
     */
    @PostMapping(value = "/secondaryinfo")
    public String updateAvatar(@AuthenticationPrincipal User user,
                               @RequestParam("file") MultipartFile file,
                               RedirectAttributes redirectAttributes) {
        if (file != null && !file.getOriginalFilename().isEmpty()) {
            user.setAvatar(fileService.uploadFile(file));
            userRepo.save(user);
            redirectAttributes.addFlashAttribute("message", "Новое изображение загруженно");
        } else {
            redirectAttributes.addFlashAttribute("alert","Изображение не выбранно");
        }
        String password = user.getPassword();
        return "redirect:/users/profile";
    }

    /**
     * Контроллер смены пароля пользователя
     * @param user - авторизированный пользователь
     * @param oldpass - старый пароль
     * @param newpass - новый пароль
     * @param confirmpass - подтверждение пароля
     * @param redirectAttributes - модель
     * @return
     */
    @PostMapping(value = "/changepassword")
    public String changePassword(@AuthenticationPrincipal User user,
                                 @RequestParam String oldpass,
                                 @RequestParam String newpass,
                                 @RequestParam String confirmpass,
                                 RedirectAttributes redirectAttributes
    ) {
        return "redirect:/users/profile";
    }

    @PostMapping(value = "/notification")
    public void setNotification(@AuthenticationPrincipal User user,
                                  @RequestParam Map<String, String> form,
                                  Model model) {
        userService.setNotification(user,form);
        System.out.println(form);
    }
}
