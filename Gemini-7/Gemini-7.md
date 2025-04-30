# How to RUN Gemini-7 Project
---

## ✅ Requirements

ก่อนเริ่มต้น โปรดติดตั้งเครื่องมือดังต่อไปนี้:

- ✅ [Java JDK 17+](https://adoptium.net/)
- ✅ [Gradle 7+](https://gradle.org/install/) (ใช้ผ่าน `./gradlew` ก็ได้)
- ✅ [IntelliJ IDEA](https://www.jetbrains.com/idea/) หรือ IDE ที่รองรับ Spring Boot
- ✅ Git

---
1. **Clone Repository**:
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

# Design pattern
---

## ✅ Requirements
1. **Builder Design Pattern**:
   - **จุดที่ใช้ :** ใน class SciencePlanBuilder สำหรับการสร้าง object SciencePlan
   - **เหตุผลที่เลือกใช้ :** Builder Pattern เหมาะกับ object ที่มีหลายฟิลด์ โดยเฉพาะเมื่อบางฟิลด์เป็น optional หรืออาจมีค่า default ช่วยให้โค้ดการสร้างอ็อบเจกต์อ่านง่าย เป็นระเบียบ และลดข้อผิดพลาดจาก constructor ที่มีหลายพารามิเตอร์

2. **Facade Design Pattern**:
   - **จุดที่ใช้ :** ใน class SciencePlanFacade เพื่อเป็นตัวกลางระหว่าง controller กับระบบ logic/backend อื่น ๆ
   - **เหตุผลที่เลือกใช้ :** Facade Pattern ช่วยซ่อนความซับซ้อนของหลายคลาสด้านหลัง interface ที่เรียบง่าย ช่วยให้ Controller เรียกใช้งานได้ง่ายขึ้นโดยไม่ต้องรู้รายละเอียดเบื้องหลัง ลดการ coupling ระหว่าง layers
3. **Adapter Design Pattern**:
   - **จุดที่ใช้ :** ใน class SciencePlanMapper เชื่อมต่อกับระบบ OCS หรือระบบภายนอก ที่ใช้ object/model structure ที่ต่างจากของเรา
   - **เหตุผลที่เลือกใช้ :** Adapter Pattern ทำหน้าที่เป็นตัวแปลงข้อมูลระหว่างระบบหรือ class ที่มี interface ต่างกัน ทำให้สามารถใช้งานร่วมกันได้โดยไม่แก้โค้ดเดิมมากเกินไป

---
