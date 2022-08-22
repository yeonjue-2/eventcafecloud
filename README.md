# Event-Cafe-Cloud
![image](https://user-images.githubusercontent.com/101540771/185291808-336ef6f0-009d-427c-9c72-e8d3316dd033.png)

</br>

## 1. 프로젝트 개요
> 카페 대여 중개 플랫폼 - http://eventcafecloud.com/<p>

- 개발기간 : 2022.06.24 - 2022.07.29
- 참여 인원 : 4명 - [팀 Github](https://github.com/teawan-Noh/eventcafecloud)


</br>
</br>

## 2. 사용 기술
**`Backend`**
- Java 11 / Spring Boot 2.6.9 / Gradle 7.4.1
- Spring Data JPA / MySQL 8.0.29 / Spring Security 

**`Frontend`**
- HTML5 / CSS / JavaScript / jQuery / Thymeleaf

**`Cloud`**
- AWS S3 Docker, EC2, RDS, ECR, Route53

</br>
</br>

## 3. ERD 설계
![image](https://user-images.githubusercontent.com/101540771/181507544-f1b7b3da-571f-4d77-83f5-226248c9f08c.jpg)

[자세히보기](https://www.erdcloud.com/d/Lz8Xb2MtTkP9b3xxD)

</br>
</br>

## 4. 아키텍쳐
![image](https://user-images.githubusercontent.com/101540771/184637009-ec771d06-f587-4486-bb5a-7b926aa2718a.png)

</br>
</br>

## 5. 프로젝트 시연
<details>
<summary>페이지 gif</summary>
<div markdown="1">  
</br>
</br>

| **📋 메인 페이지** | **📋 로그인 페이지** |
|----------|-----------|
|![메인페이지](https://user-images.githubusercontent.com/101540771/181512329-3a2b70c9-d40a-462f-8777-aa8b27b30c92.gif)|![로그인페이지](https://user-images.githubusercontent.com/101540771/181514074-2ee0ca3a-3e37-45ee-9ccf-826a9f3172a1.gif)|

| **📋 프로필 페이지** | **📋 카페 페이지** |
|----------|-----------|
|![프로필페이지](https://user-images.githubusercontent.com/101540771/181514180-0ddaac1f-3cb2-4894-87e4-95e6b9233f6d.gif)|![카페페이지](https://user-images.githubusercontent.com/101540771/181514369-254337b8-24ca-4433-baeb-e304e3cadf05.gif)|

| **📋 어드민 페이지** | **📋 이벤트 페이지** |
|----------|-----------|
|![어드민](https://user-images.githubusercontent.com/101540771/181514270-8c67163f-5f9d-4d80-9e6a-98b8a96bdb8e.gif)|![이벤트](https://user-images.githubusercontent.com/101540771/181514441-43e20c35-e1fe-46b0-a5bb-a9dcf573b35f.gif)|


| **📋 게시판 페이지** | **📋 에러 페이지** |
|----------|-----------|
|![게시판페이지](https://user-images.githubusercontent.com/101540771/181516164-706bcecf-bff6-419a-9f55-012565ed0ada.gif)|![에러페이지](https://user-images.githubusercontent.com/101540771/181516268-784e1231-3dc4-4391-a6ec-4652dcfc7129.gif)|

</br>
</br>

</div>
</details>

</br>
</br>

## 6. 핵심 기능 & 맡은 역할 
**핵심 기능**
- 회원의 회원가입 및 로그인 (관리자, 사업자, 일반회원)
- 사업자 회원의 카페 등록
- 일반 회원의 이벤트 등록
- 모든 회원의 게시글 등록 

</br>

**맡은 역할**
- 프로젝트 기획 및 DB설계
- 이벤트 페이지 CRUD(이벤트 이름, 내용 수정 등)
- S3 버킷을 이용한 이미지 저장 & url 관리
- 예약관리와 페이징, 필터, 검색 기능 
- 이벤트 댓글 CRD 및 페이징
- 북마크 기능 추가
- 실 고객 피드백 수집 후 피드백 반영 

<details>
<summary>코드 보기</summary>
<div markdown="1"> 
</br>

[🔗 EventController](https://github.com/yeonjue-2/eventcafecloud/blob/develop/src/main/java/com/eventcafecloud/event/controller/EventController.java)

[🔗 EventApiController](https://github.com/yeonjue-2/eventcafecloud/blob/develop/src/main/java/com/eventcafecloud/event/controller/EventApiController.java)

</br>

</div>
</details>

</br>
</br>

## 7. 트러블 슈팅과 그 외
[전체 issue](https://github.com/teawan-Noh/eventcafecloud/issues?q=is%3Aissue+is%3Aclosed)
</br>

### i ) EventImage가 DB에 저장이 되지 않는 문제 - [Github issue #39](https://github.com/teawan-Noh/eventcafecloud/issues/39)

- 문제
  - S3에서 받아온 URL로 객체 생성은 되지만 EventImage가 기본 이미지로만 보여지는 문제 발생
  - DB 확인으로 DB에 저장이 되지 않는 다는 사실을 인지

- 해결
  - eventImage를 event의 하위 엔티티로 처리하는 `cascade` 을 달아주지 않아서 DB에 들어가지 않음
  - `cascade = CascadeType.ALL` 를 달아주면 연관관계대로 DB에 저장됨. 
  - [기술 블로그 1](https://velog.io/@ilov-/%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8-%EB%8B%A4%EC%A4%91-%ED%8C%8C%EC%9D%BC-%EC%B2%98%EB%A6%AC) , 
  [기술 블로그 2](https://velog.io/@ilov-/Spring-Data-JPA-cascade)

<details>
<summary>처리 예시</summary>
<div markdown="1"> 

```java
<처리 예시>
# Event.java

@OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
private List<EventImage> eventImages = new ArrayList<>();

```
</div>
</details>

</br>
</br>

### ii ) Entity를 Dto로 반환하여 페이징
- 이벤트 목록을 페이징하기 위해 Spring Data JPA의 Pageable을 사용하여 Entity인 Event를 반환
- 엔티티를 UI계층에 노출시키지 않고 화면에 필요한 정보들만 선별하기 위해 Dto로 변환하는 과정 필요
- 빌더를 사용하여 필요한 정보들을 하나씩 Dto로 담아 toDtoList 메소드를 통해 반환하여 페이징
- 람다식을 활용한 Dto 반환을 알게되어 빌더패턴을 사용하지 않고 반환하여 페이징
- [기술 블로그](https://velog.io/@ilov-/TIL-0714)

<details>
<summary>Builder와 Lambda를 활용한 Dto 반환</summary>
<div markdown="1"> 

```java
1. Builder
 Page<EventListResponseDto> eventListResponseDtos = events.map(e ->
                EventListResponseDto.builder()
                        .eventNumber(e.getId())
                        .eventName(e.getEventName())
                        .eventCategory(e.getEventCategory())
                        .eventStartDate(e.getEventStartDate())
                        .eventEndDate(e.getEventEndDate())
                        .eventImageUrls(e.getEventImages().stream()
                                .map(i -> i.getEventImageUrl())
                                .collect(Collectors.toList()))
                        .build());

2. Lambda
Page<EventListResponseDto> reponseDto = events.map(EventListResponseDto :: new);

```

</div>
</details>

</br>
</br>

**[🔗 프로젝트의 효율적인 기획 및 설계](https://velog.io/@ilov-/프로젝트)**

</br>

**[🔗 Dto의 반환 위치 : controller 와 service]()**

</br>

**[🔗 AOP를 활용한 글로벌 예외 처리](https://velog.io/@ilov-/global)**

</br>
</br>

## 8. 고객 피드백 반영
![IMG_0229](https://user-images.githubusercontent.com/101540771/185299901-bc45b8a6-8319-44f7-8626-816463938c88.jpeg)

</br>


- 피드백 기간 : 2022.07.21 - 2022.07.23 
- 참여 인원 : 52명
- 5주간의 개발 기간 중 4주차 주말에 고객피드백을 받고 다음 1주동안 피드백을 반영하고 개선하는 것에 초점을 맞췄습니다.

</br>

<details>
<summary>주요 피드백 사항</summary>
<div markdown="1">       

</br>
  
- 프로필 변경 시, 닉네임 또는 사진을 선택적으로 변경
- 카페 캘린더에서 이벤트 클릭 시, 이벤트 상세페이지 이동 로직 추가
- 이벤트 상세 페이지에서 댓글 기능 추가 요청
- 게시글에서 다른 유저의 데이터 수정이 불가능하도록 API 접근 제한 요청
  
  -> 대부분의 사항들을 반영하여 최종 프로젝트를 마무리 &nbsp;[Event-Cafe-Cloud 고객 피드백](https://majestic-dollar-d76.notion.site/Event-Cafe-Cloud-16e201b95f91429394261d157cfa8238)

</br>

</div>
</details>


</br>
</br>

## 9. KPT 회고
> 프로젝트 개발 KPT 회고 : https://velog.io/@ilov-/WIL-KPT

</br>
</br>
</br>












