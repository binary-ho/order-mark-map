# order-mark-map
배달 음식을 주문하고 지도에서 모아 보는 웹 프로젝트입니다. 
느린 배달 프로젝트를 지원하기 위한 스프링 공부의 내용들을 직접 적용해보고, 다양한 API를 이용해 보기 위하여 만들어 보았ㅅ브니다.

<메인 화면>
아직 html을 다루는 법을 따로 배우지 않아 처참한 화면 상태입니다.
기능 구현에만 집중했습니다.
![메인 화면22](https://user-images.githubusercontent.com/71186266/158461661-79e7f29a-5df2-4d78-9f76-c0cd0365bd56.png)


<주문 화면>
다음 주소 검색 API를 이용해 주소를 검색합니다.
정확한 주소 문자열을 이용해 카카오 지도 API의 getAddress() 함수를 이용하여 주소의 정확한 좌표를 파악합니다.
![깃허브용](https://user-images.githubusercontent.com/71186266/158461679-2189eefd-d55b-4387-8697-f91039fcee08.png)
![깃허브용2](https://user-images.githubusercontent.com/71186266/158461680-950ce496-8c72-409e-9580-e4a85d825fc9.png)


<데이터 베이스>
주문한 내용들은 db에 저장됩니다.
![깃허브용 db](https://user-images.githubusercontent.com/71186266/158461666-534c9c64-3aff-4f66-9bb3-c7fb7f2e122d.png)


<지도에서 모아보기>
db에 저장된 내용들을 가져와서 화면에 보여줍니다.
controller에서 model에 객체들을 넣어 보내줍니다.
이 객체들을 꺼내서 화면단의 javascript에 주문 내용과 좌표들을 보내줍니다.
그 다음 카카오 지도 API의 여러 마커에 정보 표시 기능을 이용하여 주문 정보를 모두 표시해줍니다.

![깃허브용 성공](https://user-images.githubusercontent.com/71186266/158461673-7d562373-6496-4c71-ae85-7ab6c86c96f6.png)

다음과 같이 마우스를 올리면 해당 주문의 정보가 나오게 됩니다.

정말 간단한 프로젝트지만 controller에서 html파일에 객체 Array를 보내고 그걸 html파일의 javascript에서 접근하여 사용하는 방식을 알아내느라 너무 고생했습니다.
정말 정말 정말 다양한 방법을 시도해봤으나 모두 실패했고, 허무하게도 가장 처음에 시도했던 Thymeleaf를 이용하니 해결되었습니다. 
스프링을 공부한 내용을 직접 적용해보고, 다양한 API를 이용해볼 수 있어서 재미있었습니다.