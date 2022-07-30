# board_practice
Youtube-한코딩, 게시판 만들기
2022.07.26 ~ 2022.07.31

- Java 11, Spring Boot
- Maria DB
- 글 조회, 작성, 수정, 삭제
- 안내 메세지
- 페이징, 검색

** 주요 Issue
> 타임리프 문법 : th:lnline 사용시, 텍스트렌더링에서 발생한 문제.
> > 원인: 인라인 스크립트 안에서 변수를 선언시, 문자로 지정해줘야 함.   
> > 해결: 서버에서 넘겨받은 값을 문자로 변경하여 변수에 저장.   
> > 참고 레퍼런스 : https://blogshine.tistory.com/185
