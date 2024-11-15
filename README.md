
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
</details>

### ️⚙️ ERD
<details>
<summary>ERD</summary>

![일정 관리 앱 ERD](https://github.com/user-attachments/assets/1633fc9c-2c52-4cb0-92c7-86ba94ef46f7)
</details>

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
