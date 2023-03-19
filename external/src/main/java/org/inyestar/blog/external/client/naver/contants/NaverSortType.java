package org.inyestar.blog.external.client.naver.contants;

import lombok.Getter;
import org.inyestar.blog.domain.constants.SortType;

import java.util.Arrays;
import java.util.Objects;

@Getter
public enum NaverSortType {
    SIM("sim", SortType.ACCURACY),
    DATE("date", SortType.DATE)
    ;

    private final String naverType;
    private final SortType sortType;

    NaverSortType(String naverType, SortType sortType) {
        this.naverType = naverType;
        this.sortType = sortType;
    }

    public static String getType(SortType sortType) {
        return Arrays.stream(values())
            .filter(naverSortType -> Objects.equals(naverSortType.getSortType(), sortType))
            .findFirst()
            .map(NaverSortType::getNaverType)
            .orElse(null);
    }
}
