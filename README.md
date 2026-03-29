# Runna - Running Tracker App

`Runna` la app Android theo doi chay bo, duoc xay dung bang `Kotlin` trong `Android Studio`, su dung `Firebase` de quan ly tai khoan va du lieu nguoi dung.

Project hien tai dang o giai doan:
- da co bo UI prototype chinh
- da co `Auth + Profile` that voi Firebase
- chua hoan thanh phan `Run Session`, `GPS Tracking`, `Map`, `History`, `Statistics`

---

## 1. Cach doc va su dung project

### Thu muc va file quan trong

#### UI + flow chinh
- [MainActivity.kt](D:/RunnaRunningTracker/app/src/main/java/com/example/runna_runningtracker/MainActivity.kt)
- [activity_main.xml](D:/RunnaRunningTracker/app/src/main/res/layout/activity_main.xml)
- [strings.xml](D:/RunnaRunningTracker/app/src/main/res/values/strings.xml)

#### Model va repository
- [User.kt](D:/RunnaRunningTracker/app/src/main/java/com/example/runna_runningtracker/data/model/User.kt)
- [AuthRepository.kt](D:/RunnaRunningTracker/app/src/main/java/com/example/runna_runningtracker/data/repository/AuthRepository.kt)
- [UserRepository.kt](D:/RunnaRunningTracker/app/src/main/java/com/example/runna_runningtracker/data/repository/UserRepository.kt)

#### Tai lieu handoff rieng cho Member 1
- [MEMBER1_HANDOFF.md](D:/RunnaRunningTracker/MEMBER1_HANDOFF.md)

### Thu tu nen doc project

Neu la nguoi moi vao project, nen doc theo thu tu nay:

1. [README.md](D:/RunnaRunningTracker/README.md)
2. [MEMBER1_HANDOFF.md](D:/RunnaRunningTracker/MEMBER1_HANDOFF.md)
3. [MainActivity.kt](D:/RunnaRunningTracker/app/src/main/java/com/example/runna_runningtracker/MainActivity.kt)
4. [activity_main.xml](D:/RunnaRunningTracker/app/src/main/res/layout/activity_main.xml)
5. [User.kt](D:/RunnaRunningTracker/app/src/main/java/com/example/runna_runningtracker/data/model/User.kt)
6. [AuthRepository.kt](D:/RunnaRunningTracker/app/src/main/java/com/example/runna_runningtracker/data/repository/AuthRepository.kt)
7. [UserRepository.kt](D:/RunnaRunningTracker/app/src/main/java/com/example/runna_runningtracker/data/repository/UserRepository.kt)

### Cach chay project

1. Mo project bang Android Studio
2. Cho Gradle sync xong
3. Dam bao da co file `google-services.json` trong:
   - `app/google-services.json`
4. Trong Firebase Console, can da bat:
   - `Authentication > Email/Password`
   - `Cloud Firestore`
5. Chay app bang emulator hoac thiet bi that

### Luu y layout
- Theo yeu cau hien tai, file layout chinh dang duoc giu theo huong `LinearLayout + ScrollView`
- Khong nen tu y doi sang `ConstraintLayout`, `FrameLayout`, `RelativeLayout` neu chua thong nhat

---

## 2. Project hien tai da di toi dau

Project da co:
- bo giao dien chinh cua app
- man `Login`
- man `Register`
- man `Personal Information`
- man `Home`
- man `Start Running`
- man `History` prototype
- man `Profile`
- man `Tracking` prototype
- man `Run Summary` prototype
- popup `Forgot Password`
- popup `Edit Profile`
- popup `App Information`

Project da ket noi Firebase cho:
- `Login`
- `Register`
- `Forgot Password`
- `Logout`
- tao profile nguoi dung tren Firestore
- load profile tu Firestore
- update profile len Firestore

Project hien chua co:
- `RunSession` model that
- GPS tracking that
- Google Map that
- distance calculation that
- run history that
- statistics that
- tach man hinh thanh `Fragment` rieng

Noi ngan gon:
- UI da co nen
- Auth + Profile da chay that
- Tracking/Map/History/Statistics van con la prototype

---

## 3. Cong viec da hoan thanh cua Member 1

Member 1 phu trach: `Auth + Profile`

### Da hoan thanh
- ket noi Firebase vao project Android
- bat `Firebase Authentication`
- bat `Cloud Firestore`
- hoan thanh `Register` bang Firebase Auth
- hoan thanh `Login` bang Firebase Auth
- hoan thanh `Forgot Password`
- hoan thanh `Logout`
- tao man `Personal Information` sau khi register
- tao luong:
  - `register -> personal information -> save firestore -> vao app`
- load profile tu Firestore sau khi login
- update profile len Firestore khi edit
- tao `User model`
- tach logic auth ra `AuthRepository`
- tach logic profile ra `UserRepository`
- giam bot firebase logic trong `MainActivity`
- dua nhieu text hardcode sang `strings.xml`
- them comment/ghi chu de nguoi khac de doc code
- giu file layout chinh theo huong `LinearLayout + ScrollView`

### Ket qua hien tai cua Member 1
- phan `Auth + Profile` da xong o muc de team co the tiep tuc lam tiep
- phan viec con lai cua Member 1 chu yeu la chinh UI dep hon neu can

---

## 4. Cong viec can lam cua Member 2

Member 2 phu trach: `User Data + UI (Front-end)`

### Muc tieu
- hoan thien giao dien cho dong bo, dep va de dung hon
- bind du lieu user len cac man hien co

### Cong viec can lam
- chinh lai giao dien `Home` theo dung style Figma
- chinh lai giao dien `Start Running`
- chinh lai giao dien `History`
- chinh lai giao dien `Profile`
- chinh spacing, text size, card, button cho dong bo
- bind thong tin user that len:
  - `Home`
  - `Profile`
  - `Edit Profile`
- ra soat tat ca text / margin / mau sac cho thong nhat
- tiep tuc them note trong XML neu can

### Luu y
- khong nen sua schema Firestore cua `users` neu chua thong nhat
- nen tai su dung `User model` da co
- nen giu style theo `Runna`: clean, minimal, cam la mau nhan

---

## 5. Cong viec can lam cua Member 3

Member 3 phu trach: `Run Session + Timer`

### Muc tieu
- bien phan tracking hien tai tu demo thanh logic that

### Cong viec can lam
- tao `RunSession` model
- tao state cho buoi chay:
  - `idle`
  - `running`
  - `paused`
  - `finished`
- xu ly:
  - `Start`
  - `Pause`
  - `Resume`
  - `Finish`
- tach logic timer hien tai thanh module rieng
- dam bao timer tinh dung khi pause/resume
- luu run type dang chon vao session

### Luu y
- khong nen sua flow `Auth/Profile`
- co the dung man tracking hien tai lam UI nen, nhung logic nen tach khoi `MainActivity`

---

## 6. Cong viec can lam cua Member 4

Member 4 phu trach: `GPS + Map Tracking`

### Muc tieu
- them tracking vi tri that theo thoi gian thuc
- hien thi duong chay that tren map

### Can dung cong nghe nao

Khong dung `Firebase` de lay GPS.

GPS tracking trong Android nen dung:
- `FusedLocationProviderClient` cua Google Play Services de lay vi tri
- `Google Maps SDK for Android` de hien thi ban do

Noi ngan gon:
- `Firebase` dung de luu du lieu
- `Google Location + Google Maps` dung de lay va hien thi GPS

### Cong viec can lam
- them permission location:
  - `ACCESS_FINE_LOCATION`
  - `ACCESS_COARSE_LOCATION`
- neu can tracking background, xem them:
  - `ACCESS_BACKGROUND_LOCATION`
- tao module lay vi tri hien tai
- cap nhat location theo chu ky
- tich hop Google Maps
- ve `polyline` duong chay
- tinh quang duong tu danh sach diem GPS
- tra du lieu route ve cho Member 3 / Member 5 dung tiep

### Luu y ky thuat
- nen dung `FusedLocationProviderClient`, khong dung Firebase cho GPS
- nen tao model `RoutePoint(lat, lng, timestamp)`
- nen loc bot diem nhay sai de tranh cong sai km

---

## 7. Firestore structure hien tai

### Collection: `users`
Document:
- `users/{uid}`

Fields hien dang dung:
- `name`
- `email`
- `age`
- `gender`
- `height`
- `weight`

### Collection chua lam
Du kien sau nay se can:
- `runs`

Member 3, 4, 5 can thong nhat schema nay truoc khi code sau.

---

## 8. Tinh trang tong ket ngan

### Da xong
- UI nen cua app
- Auth Firebase
- User profile Firestore
- Handoff co ban cho team

### Dang o muc prototype
- Tracking screen
- History
- Summary

### Chua lam
- GPS
- Google Map
- Run Session that
- History that
- Statistics that

---

## 9. Ghi chu cho team

- Neu sua code phan Auth/Profile, doc ky:
  - [MainActivity.kt](D:/RunnaRunningTracker/app/src/main/java/com/example/runna_runningtracker/MainActivity.kt)
  - [AuthRepository.kt](D:/RunnaRunningTracker/app/src/main/java/com/example/runna_runningtracker/data/repository/AuthRepository.kt)
  - [UserRepository.kt](D:/RunnaRunningTracker/app/src/main/java/com/example/runna_runningtracker/data/repository/UserRepository.kt)
- Neu sua giao dien, doc ky:
  - [activity_main.xml](D:/RunnaRunningTracker/app/src/main/res/layout/activity_main.xml)
  - [strings.xml](D:/RunnaRunningTracker/app/src/main/res/values/strings.xml)
- Khong nen doi lung tung naming va schema neu chua thong nhat ca nhom

