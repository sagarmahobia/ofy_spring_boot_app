package com.ryf.appbackend.jpa.dao;

import com.ryf.appbackend.jpa.entities.user.Bookmark;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookmarkDao extends JpaRepository<Bookmark, Long> {

    Boolean existsBookmarkByUserIdAndOpportunityId(Long userId, Long opportunityId);

    Bookmark findBookmarkByUserIdAndOpportunityId(Long userId, Long opportunityId);

    List<Bookmark> findAllByUserId(Long userId, Pageable pageable);

}
