package com.ryf.appbackend.core.controller.user;


import com.ryf.appbackend.core.controller.models.Opportunity;
import com.ryf.appbackend.core.controller.models.Status;
import com.ryf.appbackend.core.services.OpportunityUtil;
import com.ryf.appbackend.jpa.dao.BookmarkDao;
import com.ryf.appbackend.jpa.dao.OpportunityDao;
import com.ryf.appbackend.jpa.dao.UserDao;
import com.ryf.appbackend.jpa.entities.user.Bookmark;
import com.ryf.appbackend.jpa.entities.user.User;
import com.ryf.appbackend.jwtsecurity.model.JwtUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserDataController {

    @Autowired
    BookmarkDao bookmarkDao;

    @Autowired
    UserDao userDao;

    @Autowired
    OpportunityDao opportunityDao;

    @GetMapping(path = "/api/v1/protected/user/bookmarks")
    public List<Opportunity> getAllBookMarks(Authentication authentication,
                                             @RequestParam(value = "page", required = false, defaultValue = "0") int page,
                                             @RequestParam(value = "size", required = false, defaultValue = "10") int size) {

        JwtUserDetails details = (JwtUserDetails) authentication.getPrincipal();
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by("id"));

        return bookmarkDao
                .findAllByUserId(details.getId(), pageRequest)
                .stream()
                .map(Bookmark::getOpportunity)
                .map(new OpportunityUtil()::getOpportunityFromEntity)
                .collect(Collectors.toList());

    }


    @GetMapping(path = "/api/v1/protected/user/is_bookmarked")
    public Status isBookmarked(Authentication authentication,
                               @RequestParam("opportunity_id") long id) {

        JwtUserDetails details = (JwtUserDetails) authentication.getPrincipal();

        Boolean aBoolean = bookmarkDao.existsBookmarkByUserIdAndOpportunityId(details.getId(), id);

        return Status.builder().currentState(aBoolean).build();
    }


    @GetMapping(path = "/api/v1/protected/user/toggle_bookmarked")
    public Status toggleBookMark(Authentication authentication,
                                 @RequestParam("opportunity_id") long opportunityId) {

        JwtUserDetails details = (JwtUserDetails) authentication.getPrincipal();

        User one = userDao.getOne(details.getId());
        Boolean aBoolean = bookmarkDao.existsBookmarkByUserIdAndOpportunityId(details.getId(), opportunityId);

        if (aBoolean) {

            Bookmark bookmarkByUserIdAndOpportunityId = bookmarkDao.findBookmarkByUserIdAndOpportunityId(details.getId(), opportunityId);
            one.getBookmarks().remove(bookmarkByUserIdAndOpportunityId);


        } else {

            Bookmark bookmark = new Bookmark();
            bookmark.setOpportunity(opportunityDao.getOne(opportunityId));

            bookmarkDao.save(bookmark);

            one.getBookmarks().add(bookmark);
        }

        userDao.save(one);

        return Status.builder().newState(!aBoolean).build();
    }

}
