package org.a2lpo.purchase.joint.purchase.controller;

import org.a2lpo.purchase.joint.purchase.domain.*;
import org.a2lpo.purchase.joint.purchase.domain.eav.Article;
import org.a2lpo.purchase.joint.purchase.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @Value("${upload.path}")
    private String uploadPath;

    @Autowired
    public TestController(UserRepo userRepo, ArticleRepo articleRepo, UploadFileRepo uploadFileRepo) {
        this.userRepo = userRepo;
        this.articleRepo = articleRepo;
        this.uploadFileRepo = uploadFileRepo;
    }

    @GetMapping
    public String testPage(Model model) {
        return "test";
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
     *
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
                    file.transferTo(new File(uploadPath+"/"+resultFilename));
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
}
