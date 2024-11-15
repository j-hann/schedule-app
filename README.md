
# 💻 프로젝트 소개
#### 📅 **일정 관리 앱** 📅

## 🚀 개발 기간
> 2024.11.13 - 2024.11.15


## 🌱 개발 환경
- `IDE : IntelliJ`
- `Java Development Kit : openjdk version '17.0.2'`
- `Framework : springframework.boot version '3.3.5', Spring Data JPA`
- `Database : MySQL version '8.0.40'`

## 🪧 커밋 컨벤션
🎉 begin: 프로젝트 시작 <br>
✨ feat : 새로운 기능 추가, 구현<br>
📝 docs : 문서 파일 추가 및 수정<br>
🔧 add :  파일 추가 & 코드 수정<br>
✏️ typos : 단순 오타 수정<br>
🐛 fix : 버그 수정<br>
🚚 rename : 파일, 경로, route를 옮기거나 이름 변경<br>
♻️ refactor : 코드 리팩토링<br>
🎨 : 코드의 구조, 형태 개선<br>
💡 : comment : 주석 추가, 변경<br>
🔥 remove : 파일, 코드 삭제<br>

## 📑 API 명세서 & ERD
### 📄 API 명세서
<details>
<summary>API 명세서</summary>
<br/>

#### 🗓️Schedule
|    기능    | method |URL|
|:--------:|:------:|:---:|
|  일정 생성   | POST  |/schedules|
| 일정 목록 조회 | GET  |/schedules|
| 일정 상세 조회 | GET  |/schedules/{Id}|
|  일정 수정   | PUT  |/schedules/{Id}|
|  일정 삭제   | DELETE  |/schedules/{Id}|

<details>
<summary>✅ 일정 생성</summary>

|  기능  | method |URL|
|:----:|:------:|:---:|
| 일정 생성 | POST  |/schedules|

#### Request Eelements
|    파라미터    |   타입    | 필수 여부 |           설명           |
|:----------:|:-------:|:-----:|:----------------------:|
|     id     | Integer |   Y   |         일정 ID          |
|  user_id   | String  |   Y   |         사용자 ID         |
|   title    | String  |   Y   |         일정 제목          |
|  contents  | String  |   Y   |         일정 내용          |
| created_at | String |   Y   |   일정 작성 일자(datetime)   |
| updated_at |  String   |   Y   | 일정 최종 수정 일자 (datetime) |

#### Respons Eelements
| 파라미터  |   타입    | 필수 여부 |     설명 |
|:-----:|:-------:|:-----:|:------:|
| id | Integer |   Y   |         일정 ID          |

#### 요청 예시

```json
  {
      "title" : "제목입니다.",
      "contents" : "내용입니다.",
      "username" : "유저이름"
  }
```
#### 응답 예시
- Statue Code 201 Created [생성 성공]
```json
  {
      "id": 1,
      "title": "제목입니다.",
      "contents": "내용입니다."
  }
```
- Statue Code 400 Bad Request [잘못된 요청]
```json
  {
    "error": "일정 생성에 실패했습니다."
  }
```
- Statue Code 401 Unauthorized [권한 없음]
```json
  {
    "error": "일정 생성 권한이 없습니다."
  }
```
</details>





</details>

### ️⚙️ ERD
<details>
<summary>ERD</summary>

![일정 관리 앱 ERD](https://github.com/user-attachments/assets/1633fc9c-2c52-4cb0-92c7-86ba94ef46f7)
</details>

### ️⌨️ SQL
- [SQL query](https://github.com/j-hann/schedule-app/blob/main/schedule.sql)

## 🪐 주요 기능
<details>
<summary>주요 기능</summary>

#### **✨ Lv1 : 일정 CRUD**
* 일정을 저장, 조회, 수정, 삭제할 수 있다. []

#### **✨ Lv2 : 유저 CRUD**
* 유저를 저장, 조회, 삭제할 수 있다. []

#### **✨ Lv3 : 회원가입**
* 유저는 유저명과 비밀번호, 이메일을 입력해 회원가입을 할 수 있다. []

#### **✨ Lv4 : 로그인(인증)**
* 유저는 이메일과 비밀번호를 입력해 로그인을 할 수 있다. []
* Cookie/Session을 활용해 로그인 기능을 구현 []
* 필터를 활용해 인증 처리를 할 수 있다. []
* 회원가입, 로그인 요청은 인증 처리에서 제외 []
* 로그인 시 이메일과 비밀번호가 일치하지 않을 경우 401을 반환한다. []

#### **✨ Lv5 : 예외 처리**
* Validation을 활용해 다양한 예외처리를 적용 []
* @Pattern을 사용해서 회원 가입 Email 데이터 검증 []

#### **✨ Lv6 : 비밀번호 암호화**
* 비밀번호 필드에 들어가는 비밀번호를 암호화 할 수 있다. []

#### **✨ Lv7 : 댓글 CRUD**
* 생성한 일정에 댓글을 남길 수 있다. []
* 댓글을 저장, 조회, 수정, 삭제할 수 있다. []

#### **✨ Lv8 : 영속성 전이를 활용한 삭제**
* 유저를 삭제할 때 해당 유저가 생성한 일정과 댓글도 삭제된다. []

#### **✨ Lv9 : 일정 페이징 조회**
* 일정을 Spring Data JPA의 Pageable과 Page 인터페이스를 활용하여 페이지네이션을 구현한다. []
* 일정 제목, 일정 내용, 댓글 개수, 일정 작성일, 일정 수정일, 일정 작성 유저명 필드를 조회 할 수 있다. []
* 디폴트 페이지 크기는 10으로 적용한다. []
* 일정의 수정일을 기준으로 내림차순 정렬이 가능하다. []

</details>

## 🌟 실행 화면
<details>
<summary> 📌 일정 생성</summary>

* postman 응답

![postman 응답](https://github.com/user-attachments/assets/2909bda1-b372-41c8-875a-f4ab2c614b53)
* 터미널 log

![터미널 log](https://github.com/user-attachments/assets/dfd8f25f-d386-4c4a-86a1-ac961b06c803)
* MySQL 쿼리 조회

![mysql 쿼리 조회](https://github.com/user-attachments/assets/c030cc74-e680-4c7d-938d-1bca015f1620)
</details>

<details>
<summary> 📌 일정 전체 조회</summary>

* postman 응답

 ![postman 응답](https://github.com/user-attachments/assets/1d46e8e5-0492-4ce0-985a-620c5634f912)<br>
* 터미널 log

![터미널 로그](https://github.com/user-attachments/assets/2c1862fc-baa4-44f5-a62b-126c11e11e7a)

* MySQL 쿼리 조회

![MySQL 쿼리 조회](https://github.com/user-attachments/assets/c2fc751b-1eb4-4c45-969b-79c23a372f99)
</details>

<details>
<summary> 📌 특정 일정 조회</summary>

* postman 응답

![postman 응답](https://github.com/user-attachments/assets/7c26484a-73d6-4901-ae80-ffbdcabf61c8)<br>
* 터미널 log

![터미널 로그](https://github.com/user-attachments/assets/6ac5ecc3-2893-484d-86c1-22fd46e02a0b)

* MySQL 쿼리 조회

![MySQL 쿼리 조회](https://github.com/user-attachments/assets/43499219-6f7f-45e3-8d6e-5f0a8fb22e7b)
</details>

<details>
<summary> 📌 특정 일정 수정</summary>

#### postman 응답
- 전체 일정 목록 조회
![전체 일정 목록](https://github.com/user-attachments/assets/5b43a557-2efa-45b6-9896-20c4e98d1b23)<br>
- 일정 1번 id 제목, 내용 수정
![일정 1번 id 제목, 내용 수정](https://github.com/user-attachments/assets/2ab5d4c7-6452-4050-bd22-360d2ee00ef1)
- 수정된 일정 조회
![수정 완료](https://github.com/user-attachments/assets/264f0f08-7e73-4b01-8a70-f482143ff28b)

#### 터미널 log

![터미널 로그](https://github.com/user-attachments/assets/a98db859-29f6-4dcd-abd7-36d467d0de2f)

#### MySQL 쿼리 조회

![MySQL 쿼리 조회](https://github.com/user-attachments/assets/b2c07609-769a-4d6a-8820-5c4a3977e5d2)
</details>

<details>
<summary> 📌 특정 일정 삭제</summary>

#### postman 응답
- 삭제 전 일정 조회
![삭제 전 일정 조회](https://github.com/user-attachments/assets/4d793b5d-7f73-4f82-afc8-45dc7bc8006f)<br>
- id 1번 일정 삭제 완료
![삭제 완료 200 ok](https://github.com/user-attachments/assets/01de187b-8eb3-44b4-be34-80b85fafd71b)
- 수정 후 일정 조회
![삭제 후 조회 (1번 일정 사라짐)](https://github.com/user-attachments/assets/bbf27514-19a4-4fa5-8d65-38b589eb3ef7)

#### 터미널 log

![터미널 로그](https://github.com/user-attachments/assets/160146f5-48b1-4409-bd1b-a3ac8137795a)

#### MySQL 쿼리 조회

![MySQL 쿼리 조회](https://github.com/user-attachments/assets/a390fc35-5d6c-46c6-b077-e620c63000ce)
</details>

<details>
<summary> 📌 회원가입</summary>

</details>

<details>
<summary> 📌 로그인</summary>

</details>

<details>
<summary> 📌 사용자 조회</summary>

</details>
