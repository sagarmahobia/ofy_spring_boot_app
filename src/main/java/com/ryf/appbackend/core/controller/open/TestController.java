package com.ryf.appbackend.core.controller.open;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
/*

    @Autowired
    UserDao userDao;

    @Autowired
    OpportunityDao opportunityDao;

    @Autowired
    BookmarkDao bookmarkDao;

    @Autowired
    JwtUtil jwtUtil;

    @RequestMapping("/api/v1/public/testToken")
    public String tedsToken() {

        JwtUser jwtUser = new JwtUser(1L, "user");

        return jwtUtil.generate(jwtUser);
    }

    @RequestMapping("/api/v1/public/test")
    public String tedst() {

    */
/*

//     TODO WAY TO SAVE BOOKMARK

      User one = userDao.getOne(3L);

        Bookmark bookmark = new Bookmark();
        bookmark.setOpportunity(opportunityDao.getOne(9L));

        Bookmark bookmark2 = new Bookmark();
        bookmark2.setOpportunity(opportunityDao.getOne(10L));

        Bookmark bookmark3 = new Bookmark();
        bookmark3.setOpportunity(opportunityDao.getOne(11L));

        bookmarkDao.save(bookmark);
        bookmarkDao.save(bookmark2);
        bookmarkDao.save(bookmark3);

        one.getBookmarks().add(bookmark);
        one.getBookmarks().add(bookmark2);
        one.getBookmarks().add(bookmark3);

        userDao.save(one);
*//*


    */
/*    List<Bookmark> allByUserId = bookmarkDao.findAllByUserId(3l);

        return allByUserId.size() + "";*//*



  */
/*      Boolean existsBookmarkByUserIdAndOpportunityId = bookmarkDao.existsBookmarkByUserIdAndOpportunityId(3L, 9L);

        StringBuilder stringBuilder = new StringBuilder();

        return stringBuilder.append("Exist: ").append(existsBookmarkByUserIdAndOpportunityId).toString();
*//*


*/
/*        User one = userDao.getOne(03L);
        Set<Bookmark> bookmarks = one.getBookmarks();
        System.out.println(
                "Boookmarks size ; " + bookmarks.size()
        );*//*

        return "Success";


    }


    @RequestMapping("/api/v1/public/bookmarkTest")
    public List<Opportunity> bookmarks() {

        long id = 3L;

        PageRequest pageRequest = PageRequest.of(0, 10, Sort.by("id"));

        return bookmarkDao.findAllByUserId(id, pageRequest).stream().map(Bookmark::getOpportunity).map(new OpportunityUtil()::getOpportunityFromEntity).collect(Collectors.toList());


    }
*/


}
