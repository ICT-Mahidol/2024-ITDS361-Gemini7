# How to RUN Gemini-7 Project
---

## ✅ Requirements

ก่อนเริ่มต้น โปรดติดตั้งเครื่องมือดังต่อไปนี้:

- ✅ [Java JDK 17+](https://adoptium.net/)
- ✅ [Gradle 7+](https://gradle.org/install/) (ใช้ผ่าน `./gradlew` ก็ได้)
- ✅ [IntelliJ IDEA](https://www.jetbrains.com/idea/) หรือ IDE ที่รองรับ Spring Boot
- ✅ Git

---
1. **Clone RepositoryA**:
    - เปิด Terminal หรือ Command Prompt 
    - พิมพ์ git clone https://github.com/ICT-Mahidol/2024-ITDS361-Gemini7.git

2. **Open Project in IntelliJ IDEA**:
    - เปิด IntelliJ IDEA แล้วเลือก Open → เลือกโฟลเดอร์ implementations
    - รอให้ IntelliJ โหลด Gradle dependencies ให้เสร็จ
3. **Configure Database**:
    - เปิดไฟล์ implementations/src/main/resources/application.properties
    - แก้ไขบรรทัด: spring.datasource.url=jdbc:h2:file:/[path]/geminiDB
4. **Run the Project**:
    - เปิดคลาส Gemini7Application.java
    - กดปุ่มสามเหลี่ยมสีเขียว เพื่อรัน
5. **Access the Web App**:
    - เปิดหน้า web browser ไปที่ http://localhost:8080/
