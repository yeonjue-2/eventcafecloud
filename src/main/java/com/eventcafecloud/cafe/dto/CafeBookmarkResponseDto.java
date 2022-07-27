package com.eventcafecloud.cafe.dto;

import com.eventcafecloud.cafe.domain.CafeBookmark;
import lombok.Data;

@Data
public class CafeBookmarkResponseDto {

    private Long id;
    private Long cafeId;
    private String cafeName;
    private String cafeInfo;
    private String cafeImgUrl;
    private int cafeWeekdayPrice;
    private String cafeReviewCount;
    private String cafeBookmarkCount;

    public CafeBookmarkResponseDto(CafeBookmark bookmark) {
        id = bookmark.getId();
        cafeId = bookmark.getCafe().getId();
        cafeName = bookmark.getCafe().getCafeName();
        cafeInfo = bookmark.getCafe().getCafeInfo();
        cafeImgUrl = bookmark.getCafe().getCafeImages().get(0).getCafeImageUrl();
        cafeWeekdayPrice = bookmark.getCafe().getCafeWeekdayPrice();
        cafeReviewCount = String.valueOf(bookmark.getCafe().getCafeReviews().size());
        cafeBookmarkCount = String.valueOf(bookmark.getCafe().getCafeBookmarks().size());
    }
}
