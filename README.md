# Event-Cafe-Cloud
> 카페 대여 중개 플랫폼<p> http://eventcafecloud.com/<p>
팀 Github : https://github.com/teawan-Noh/eventcafecloud

</br>

## 1. 제작 기간 & 참여 인원
- 2022.06.24 - 2022.07.29
- 4인 - 노태완, 강현규, 김예지, 박연주

</br>

## 2. 사용 기술
**`Backend`**
- Java11 / Spring Boot 2.6.9 / Gradle 
- Spring Data JPA / MySQL / Spring Security 

**`Frontend`**
- HTML5 / CSS / JavaScript / jQuery / Thymeleaf

**`Cloud`**
- AWS S3 Docker, EC2, RDS, ECR, Route53
</br>

## 3. ERD 설계
![image](https://user-images.githubusercontent.com/101540771/181507544-f1b7b3da-571f-4d77-83f5-226248c9f08c.jpg)

[자세히보기](https://www.erdcloud.com/d/Lz8Xb2MtTkP9b3xxD)

</br>

## 4. 아키텍쳐
![image](https://user-images.githubusercontent.com/101540771/184637009-ec771d06-f587-4486-bb5a-7b926aa2718a.png)

</br>

## 5. 핵심 기능 & 맡은 역할 
**핵심 기능**
- 회원의 회원가입 및 로그인 (관리자, 사업자, 일반회원)
- 사업자 회원의 카페 등록
- 일반 회원의 이벤트 등록
- 모든 회원의 게시글 등록 

</br>

**맡은 역할**
- 프로젝트 기획 및 DB설계
- 이벤트 도메인 개발
- 이벤트 페이지 CRUD(이벤트 이름, 내용 수정 등) 
- 예약관리와 페이징, 필터, 검색 기능 
- 이벤트 댓글 CRD 및 페이징, 북마크 기능 추가
- 실 고객 피드백 수집 후 피드백 반영 

</br>

## 6. 트러블 슈팅과 그 외
[전체 issue](https://github.com/teawan-Noh/eventcafecloud/issues?q=is%3Aissue+is%3Aclosed)
</br>

**i) [EventImage가 DB에 저장이 되지 않는 문제 - Github issue #39](https://github.com/teawan-Noh/eventcafecloud/issues/39)**
- S3에서 받아온 URL로 객체 생성은 되지만 EventImage가 DB에 저장이 되지 않는 문제가 발생
- eventImage를 event의 하위 엔티티로 처리하는 cascade 을 달아주지 않아서 DB에 들어가지 않음
- cascade = CascadeType.ALL 를 달아주면 연관관계대로 DB에 저장됨. 
- [정리 블로그](https://velog.io/@ilov-/%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8-%EB%8B%A4%EC%A4%91-%ED%8C%8C%EC%9D%BC-%EC%B2%98%EB%A6%AC)
```
<처리 예시>
# Event.java

@OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
private List eventImages = new ArrayList<>();

```

</br>

**ii) 페이징**

</br>

**[🔗 프로젝트의 효율적인 기획 및 설계](https://velog.io/@ilov-/프로젝트)**

</br>

**[🔗 Dto의 반환 위치 : controller 와 service]()**

</br>

**[🔗 글로벌 예외 처리]()**

</br>

## 7. 고객 피드백 반영
<details>
<summary>여기를 눌러주세요</summary>
<div markdown="1">       

😎숨겨진 내용😎

</div>
</details>


</br>

## 8. 프로젝트 시연
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












