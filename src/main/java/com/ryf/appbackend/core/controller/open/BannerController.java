package com.ryf.appbackend.core.controller.open;


import com.ryf.appbackend.core.services.BannerService;
import com.ryf.appbackend.models.dto.Banner;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class BannerController {

    private final BannerService bannerService;

    public BannerController(BannerService bannerService) {
        this.bannerService = bannerService;
    }

    @GetMapping("/v1/public/banner")
    public Banner getOneBanner(@RequestParam("id") Long id) {

        return bannerService.getBannerOnid(id);
    }

    @GetMapping("/v1/public/banners")
    public List<Banner> getBannersonPageAndSize(@RequestParam(value = "page", required = true, defaultValue = "0") int page,
                                                @RequestParam(value = "size", required = true, defaultValue = "8") int size) {

        return bannerService.getArticlesOnPaging(page, size);
    }


}
