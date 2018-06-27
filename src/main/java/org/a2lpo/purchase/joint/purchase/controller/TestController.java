package org.a2lpo.purchase.joint.purchase.controller;

import org.a2lpo.purchase.joint.purchase.domain.UploadFile;
import org.a2lpo.purchase.joint.purchase.domain.user.User;
import org.a2lpo.purchase.joint.purchase.domain.eav.Article;
import org.a2lpo.purchase.joint.purchase.repos.*;
import org.a2lpo.purchase.joint.purchase.service.FileService;
import org.a2lpo.purchase.joint.purchase.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping(value = "test")
public class TestController {

    private final UserRepo userRepo;
    private final ArticleRepo articleRepo;
    private final UploadFileRepo uploadFileRepo;
    private final UserService userService;
    private final FileService fileService;
    private final NotificationSettingsRepo notifSettingRepo;
    private final UserNotificationRepo userNotificationRepo;

    @Value("${upload.path}")
    private String uploadPath;

    @Autowired
    public TestController(UserRepo userRepo,
                          ArticleRepo articleRepo,
                          UploadFileRepo uploadFileRepo,
                          UserService userService,
                          FileService fileService,
                          NotificationSettingsRepo notifSettingRepo,
                          UserNotificationRepo userNotificationRepo) {
        this.userRepo = userRepo;
        this.articleRepo = articleRepo;
        this.uploadFileRepo = uploadFileRepo;
        this.userService = userService;
        this.fileService = fileService;
        this.notifSettingRepo = notifSettingRepo;
        this.userNotificationRepo = userNotificationRepo;
    }

    @GetMapping
    public String testPage(Model model) {
        return "test";
    }

    /**
     * @param user
     * @param brand
     * @param title
     * @param description
     * @param price
     * @param model
     * @return
     */
    @PreAuthorize("hasAuthority('ORGANIZER')")
    @PostMapping(value = "/article/add")
    public String addArticle(@AuthenticationPrincipal User user,
                             @RequestParam String brand,
                             @RequestParam String title,
                             @RequestParam String description,
                             @RequestParam String price,
                             @RequestParam("file") MultipartFile file,
                             Map<String, Object> model) {

        Article article = new Article();
        boolean fieldIsEmpty = (StringUtils.isEmpty(brand) ||
                StringUtils.isEmpty(title) ||
                StringUtils.isEmpty(description) ||
                StringUtils.isEmpty(price));

        if (!fieldIsEmpty) {
            article.setOrganizer(user);
            article.setBrand(brand);
            article.setDescription(description);
            article.setName(title);
            article.setPrice(BigDecimal.valueOf(Long.parseLong(price)));
            articleRepo.save(article);
            if (file != null && !file.getOriginalFilename().isEmpty()) {
                File uploadDir = new File(uploadPath);

                if (uploadDir.exists()) {
                    uploadDir.mkdirs();
                }
                String uuid = UUID.randomUUID().toString();
                String resultFilename = uuid + "." + file.getOriginalFilename();

                try {
                    file.transferTo(new File(uploadPath + "/" + resultFilename));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                UploadFile uploadFile = new UploadFile();
                uploadFile.setArticle(article);
                articleRepo.save(article);
                uploadFileRepo.save(uploadFile);


            }
        }
        return "article";
    }

    /**
     * AlertTest Complete.
     *
     * @param redirectAttributes
     * @return
     */
    @GetMapping(value = "alerttest")
    public String alertTest(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("alert", "Alert Test successfully!");
        return "redirect:/";
    }

    @GetMapping(value = "/article/details")
    public String createGroupDetails(RedirectAttributes redirectAttributes) {
        return "groupdetails";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping(value = "useredit/{user}")
    public String userEdit(@PathVariable User user,
                           Model model) {
        model.addAttribute("user", user);
        return "useredit";
    }
}
