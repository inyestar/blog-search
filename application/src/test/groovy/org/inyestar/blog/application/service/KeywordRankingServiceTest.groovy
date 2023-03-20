package org.inyestar.blog.application.service


import org.inyestar.blog.domain.entity.Keyword
import org.inyestar.blog.domain.entity.KeywordRanking
import org.inyestar.blog.domain.port.jpa.KeywordRankingPersistence
import spock.lang.Specification

class KeywordRankingServiceTest extends Specification {
    KeywordRankingPersistence persistence = Mock()
    def service = new KeywordRankingService(
            persistence
    )

    def "키워드 랭킹 추가"() {
        given:
        persistence.existsByKeyword(_ as Keyword) >> false

        when:
        service.putKeywordRanking(Keyword.sample())

        then:
        0 * persistence.modifyKeywordRanking(_)
        1 * persistence.addKeywordRanking(_)
    }

    def "키워드 랭킹 수정"() {
        given:
        persistence.existsByKeyword(_ as Keyword) >> true

        when:
        service.putKeywordRanking(Keyword.sample())

        then:
        1 * persistence.modifyKeywordRanking(_)
        0 * persistence.addKeywordRanking(_)
    }

    def "키워드 탑텐 정보 없음"() {
        given:
        persistence.findTop10Keyword() >> []

        when:
        def result = service.findTop10()

        then:
        result.isEmpty()
    }

    def "키워드 탑텐 정보 있음"() {
        given:
        persistence.findTop10Keyword() >> [
                KeywordRanking.sample(),
                KeywordRanking.sample(),
                KeywordRanking.sample()
        ]

        when:
        def result = service.findTop10()

        then:
        !result.isEmpty()
    }
}
