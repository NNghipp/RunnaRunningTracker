# Member 1 Handoff - Auth + Profile

## Scope hien tai
Member 1 dang phu trach 3 nhom chinh:
- Firebase Authentication
- User Profile voi Cloud Firestore
- Flow UI lien quan den login, register, personal information, profile

## Flow da hoan thanh

### 1. Register
Flow hien tai:
- User mo man `Register`
- Nhap `name`, `email`, `password`, `confirm password`
- App goi Firebase Auth de tao tai khoan
- Neu tao thanh cong, app chuyen sang man `Personal Information`
- User nhap them `age`, `gender`, `height`, `weight`
- App tao document `users/{uid}` trong Firestore
- Sau do vao app chinh

### 2. Login
Flow hien tai:
- User nhap `email` + `password`
- App dang nhap bang Firebase Auth
- Neu thanh cong, app load profile tu Firestore
- Sau do vao app chinh

### 3. Forgot Password
Flow hien tai:
- User bam `Forgot password?`
- Nhap email
- App goi `sendPasswordResetEmail()`

### 4. Edit Profile
Flow hien tai:
- User vao `Profile`
- Bam `Edit Profile`
- Sua thong tin
- App cap nhat lai document `users/{uid}` bang Firestore

## Firebase structure hien tai

### Authentication
- Provider dang dung: `Email/Password`

### Firestore
Collection:
- `users`

Document:
- `users/{uid}`

Fields dang dung:
- `name`
- `email`
- `age`
- `gender`
- `height`
- `weight`

## File quan trong

### Activity + UI
- `D:/RunnaRunningTracker/app/src/main/java/com/example/runna_runningtracker/MainActivity.kt`
- `D:/RunnaRunningTracker/app/src/main/res/layout/activity_main.xml`
- `D:/RunnaRunningTracker/app/src/main/res/values/strings.xml`

### Model + Repository
- `D:/RunnaRunningTracker/app/src/main/java/com/example/runna_runningtracker/data/model/User.kt`
- `D:/RunnaRunningTracker/app/src/main/java/com/example/runna_runningtracker/data/repository/AuthRepository.kt`
- `D:/RunnaRunningTracker/app/src/main/java/com/example/runna_runningtracker/data/repository/UserRepository.kt`

## Architecture hien tai
Project van dang o muc prototype, nhung phan Auth/Profile da duoc tach bot logic ra:
- `AuthRepository`: login, register, forgot password, sign out
- `UserRepository`: create/load/update profile trong Firestore
- `User`: model du lieu user

`MainActivity` hien van dang dieu khien UI prototype, nhung khong con ghi truc tiep Firebase logic o nhieu noi nhu truoc.

## Luu y cho Member 2, 3, 4, 5

### Member 2 - User Data + UI
- Co the dung `User` model hien tai de bind thong tin len Home/Profile
- Khong nen doi schema Firestore neu chua thong nhat
- Layout hien tai dang theo yeu cau `LinearLayout + ScrollView`

### Member 3 - Run Session + Timer
- Khong nen sua flow login/register/profile
- Co the dua session model moi vao module rieng

### Member 4 - GPS + Map Tracking
- Chua co map/GPS that
- Nen tach phan tracking thanh man/module rieng, khong don them vao Auth flow

### Member 5 - History + Statistics
- Chua co collection `runs`
- Nen thong nhat schema `RunSession` truoc khi save Firestore

## Viec Member 1 nen lam tiep
- Them validation manh hon cho login/register/personal info
- Them loading state khi Firebase dang xu ly
- Tach Auth/Profile khoi `MainActivity` them nua neu co thoi gian
- Tao `UserConstants` hoac `FirestorePaths` neu team muon dung constant dong bo

## Known notes
- Layout `activity_main.xml` da duoc chuyen ve huong chi dung `LinearLayout` va `ScrollView`
- Text UI da duoc dua mot phan lon vao `strings.xml`
- Popup `Reset Password` va `Edit Profile` da bo nut phu de tranh thanh cam du
