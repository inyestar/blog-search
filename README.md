# 블로그 검색 서비스
## 설명
- 실행 명령어 : java -jar search-blog-0.0.1-SNAPSHOT.jar
- 포트 : 8888
- [jar 다운로드 링크](https://drive.google.com/file/d/1SQz1vcWH_tN4vq_rTXa6hS718L8Rc4ww/view?usp=sharing)
## API 명세
- 블로그 검색 API
  - GET /api/v1/search/blog??keyword={keyword}&size={size}&page={page}&sort={sort}
  - Content-Type: application/json
  - Request Parameter
    - keyword : String / 검색어
    - size : Integer / 목록 사이즈
    - page : String / 목록 페이지 번호
    - sort : String / 정렬 방식 (ACCURACY: 정확도, RECENCY: 최신순, DATE: 날짜) 
  - Response
    - keyword : String / 검색어
    - sortType : String / 정렬 방식
    - size : Integer / 목록 사이즈
    - page : String / 목록 페이지 번호
    - totalCount : Long / 검색어 전체 갯수
    - list : List / 검색어 결과
      - postTitle : String / 볼로그 포스트 제목
      - postContents : String / 블로그 포스트 요약본
      - postUrl : String / 블로그 포스트 URL
      - blogName : String / 블로그 이름
      - thumbnailUrl : String / 블로그 포스트 썸네일 URL
      - postedAt : Date / 블로그 포스트 게시날짜
  - Sample
    ```json
    GET http://127.0.0.1:8888/api/v1/search/blog?keyword=맛집&size=2&page=1&sort=ACCURACY
    { 
      "keyword": "맛집",
      "sortType": "ACCURACY",
      "size": 2,
      "page": 1,
      "totalCount": 44655770,
      "list": [
        {
          "postTitle": "서귀포 <b>맛집</b> BEST",
          "postContents": "서귀포 <b>맛집</b> BEST 색달식당 방문기 안녕하세요 크로노입니다. 이번에 거의 몇년만에 가족들과 제주도 여행에 다녀왔습니다. 둘째날 주변 지인들에게 소개받은 서귀포 <b>맛집</b> 색달식당엘 다녀왔어요. 방송에도 출연할 만큼 갈치 요리가 일품인 곳으로 세트 요리를 주문하면 같이 차려지는 기본 반찬들까지 맛깔났던 곳...",
          "postUrl": "http://croboda.tistory.com/45",
          "blogName": "크로노",
          "thumbnailUrl": "https://search4.kakaocdn.net/argon/130x130_85_c/B5EoggjDI3j",
          "postedAt": "2023-03-08T13:44:19"
       },
       ...
      ]
    }
  ```
  
- 키워드 랭킹 API
  - GET /api/v1/keyword/top-10
  - Content-Type: application/json
  - Request
    - None
  - Response
    - no : Integer / 순위
    - keyword : String / 검색어
    - count : Long / 검색 횟수
  - Example
  ```json
  GET http://127.0.0.1:8888/api/v1/keyword/top-10
  [
    {
      "no": 1,
      "keyword": "챗 지피티는 무엇인가요",
      "count": 6
    },
    {
      "no": 2,
      "keyword": "국내여행 추천",
      "count": 5
    },
    ...
  ]
  ```