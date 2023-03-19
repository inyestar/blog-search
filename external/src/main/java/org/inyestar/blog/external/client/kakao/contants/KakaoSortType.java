package org.inyestar.blog.external.client.kakao.contants;

import lombok.Getter;
import org.inyestar.blog.domain.constants.SortType;

import java.util.Arrays;
import java.util.Objects;

@Getter
public enum KakaoSortType {
    ACCURACY("accuracy", SortType.ACCURACY),
    RECENCY("recency", SortType.RECENCY)
    ;

    private final String kakaoType;
    private final SortType sortType;

    KakaoSortType(String kakaoType, SortType sortType) {
        this.kakaoType = kakaoType;
        this.sortType = sortType;
    }

    public static String getType(SortType sortType) {
        return Arrays.stream(values())
            .filter(kakaoSortType -> Objects.equals(kakaoSortType.getSortType(), sortType))
            .findFirst()
            .map(KakaoSortType::getKakaoType)
            .orElse(null);
    }
}
