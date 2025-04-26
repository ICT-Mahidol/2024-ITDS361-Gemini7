# Gemini Project Analysis of 3 selected use cases
---
# Class Diagram
![Class Diagram](https://github.com/ICT-Mahidol/2024-ITDS361-Gemini7/blob/master/Gemini-7/designs/design%20diagrams/classDiagram.png)
---
# 1. Create a science plan 

## Use Case Description

#### 
| **Use Case Name** | Create a science plan  |
|---|---|
| **ID** | 1 |
| **Importance Level** | High |
| **Primary Actor** | Astronomer  |
| **Use Case Type** | Detail, Essential |

### Stakeholders and Interests
| Stakeholder | Interest                                               |
|---|--------------------------------------------------------|
| **Astronomer** | ต้องการสร้าง science plan ใหม่                         |


### Brief Description
Astronomer ต้องการสร้าง Science Plan สําหรับการศึกษาดวงดาวและดาวเคราะห์
### Precondition
Astronomer จะต้อง Login เข้าระบบเรียบร้อยแล้วก่อนจะทํา use case นี้

### Trigger
| Type | User-Initiated |
|---|---|
| **Trigger** | Astronomer ต้องการสร้าง Science Plan |

### Relationships
| Type | Entities |
|---|---|
| **Association** |  Astronomer |
| **Include** | - |
| **Extend** | - |
| **Generalization** | - |

### Normal Flow of Events
| Step | Description                                                                                                    |
|------|----------------------------------------------------------------------------------------------------------------|
| 1    | Astronomer เลือกเมนู “Create Science Plan”                                                                      |
| 2    | ระบบแสดงหน้าสร้างแผนวิทยาศาสตร                                                                                 |
| 3    | Astronomer เลือกปุ่ม Create Science Plan และระบบจะแสดงแบบฟอร์มสร้างแผนวิทยาศาสตร์ซึ่งประกอบด้วยข้อมูลต่อไปนี้: |
| 3.1  | Plan ID – ระบบสร้างให้โดยอัตโนมัติ                                                                             |                                                                                                                              |                                                                                                                              |
| 3.2  | Plan Name – อยู่ในรูปแบบข้อความสั้นๆ                                                                           |                                                                                                                              |                                                                                                                              |
| 3.3  | Creator – ระบบกรอกให้โดยอัตโนมัติจากข้อมูล Login ของ Astronomer                                                |                                                                                                                              |                                                                                                                              |
| 3.4  | Funding – ค่าตัวเลขเป็นดอลลาร์และทศนิยม                                                                        |                                                                                                                              |                                                                                                                              |
| 3.5  | Objective – อยู่ในรูปแบบข้อความขนาดยาว                                                                         |                                                                                                                              |                                                                                                                              |
| 3.6  | Start and End dates – Astronomer ทําการเลือกจากปฏิทิน                                                          |                                                                                                                              |                                                                                                                              |
| 3.7  | Telescope assigned – Astronomer ทําการเลือกจากรายการกล้องโทรทรรศน์2 แห่ง: ฮาวาย(Hawaii) และชิลี(Chile)         |                                                                                                                              |                                                                                                                              |
| 3.8  | Target – เลือกเป้าหมายจากรายการแคตตาล็อกดาว                                                                    |                                                                                                                              |                                                                                                                              |
| 4    | Astronomer กรอกข้อมูลทั้งหมดดังกล่าวข้างต้น                                                                    |
| 5    | Astronomer เลือกข้อกําหนดการประมวลผลข้อมูล (Data processing requirements) ซึ่งได้แก้ข้อมูลดังต่อไปนี้:         |
| 5.1  | FileType – ตัวเลือก: PNG, JPEG, RAW                                                                            |
| 5.2  | FileQuality – ตัวเลือก: Low, Fine                                                                              |
| 5.3  | ColorType – ตัวเลือก: โหมดสี (Color mode) และ โหมดขาวดํา (B&W mode)                                            |
| 5.4  | Contrast – ค่าทศนิยม (สําหรับทั้งโหมดสีและขาวดํา)                                                              |
| 5.5  | Brightness – ค่าทศนิยม (เฉพาะโหมดสี)                                                                           |
| 5.6  | Saturation – ค่าทศนิยม (เฉพาะโหมดสี)                                                                           |
| 5.7  | Highlights – ค่าทศนิยม (เฉพาะโหมดขาวดํา)                                                                       |
| 5.8  | Exposure – ค่าทศนิยม (สําหรับทั้งโหมดสีและขาวดํา)                                                              |
| 5.9  | Shadows – ค่าทศนิยม (เฉพาะโหมดขาวดํา)                                                                          |
| 5.10 | Whites – ค่าทศนิยม (เฉพาะโหมดขาวดํา)                                                                           |
| 5.11 | Blacks – ค่าทศนิยม (เฉพาะโหมดขาวดํา)                                                                           |
| 5.12 | Luminance – ค่าทศนิยม (เฉพาะโหมดสี)                                                                            |
| 5.13 | Hue – ค่าทศนิยม (เฉพาะโหมดสี)                                                                                  |
| 6    | นักดาราศาสตร์สร้างแผนวิทยาศาสตร์โดยคลิกปุ่ม “Save Science Plan”                                                |

### Alternate/Exceptional Flow
| Step   | Condition                                                                                          |
|--------|----------------------------------------------------------------------------------------------------|
| **5a** | หากกําหนดวันเริ่มต้นหลังจากวันสิ้นสุด ระบบจะแจ้งเตือนว่า “Start date cannot be after the end date” |
| **5a** | หากข้อมูลที่ป้อนเข้ากันไม่ได้กับระบบ OCS รุ่นเก่า (เช่น รูปแบบไฟล์ไม่ถูกต้อง ค่าที่ไม่รองรับ หรือข้อมูลที่จําเป็นขาดหายไป) ระบบจะแสดงข้อความข้อผิดพลาดว่า: “Input data is not compatible with the legacy OCS system.”                                                   |

## Activity Diagram
![Create a science plan  Activity Diagram](https://github.com/ICT-Mahidol/2024-ITDS361-Gemini7/blob/master/Gemini-7/designs/design%20diagrams/activityDiagramsCreateSciencePlan.png)

## Sequence Diagram
![Create a science plan  Sequence Diagram](https://github.com/ICT-Mahidol/2024-ITDS361-Gemini7/blob/master/Gemini-7/designs/design%20diagrams/sequenceDiagramsCreateSciencePlan.png)


---
# 2. Test a science plan

## Use Case Description

#### 
| **Use Case Name** | Test a science plan |
|---|---|
| **ID** | 2 |
| **Importance Level** | High |
| **Primary Actor** | Astronomer |
| **Use Case Type** | Detail, Essential |

### Stakeholders and Interests
| Stakeholder | Interest |
|---|---|
| **Astronomer** | ต้องการทดสอบ science plan ก่อนส่งเข้าสู่ระบบเพื่อให้มั่นใจว่าสามารถดําเนินการได้จริงและถูกต้อง |

### Brief Description
Use case นี้อธิบายขั้นตอนที่ Astronomer ใช้ในการทดสอบ science plan โดยใช้virtual telescope ก่อนส่งเข้าระบบ โดยระบบจะตรวจสอบแผนกับ test case ต่าง ๆ เพื่อให้มั่นใจว่า science plan ตรงตามเงื่อนไขที่กําหนด
### Precondition
Astronomer ต้องเข้าสู่ระบบก่อน
### Trigger
| Type | User-Initiated |
|---|---|
| **Trigger** | The astronomer initiates the testing process for a science plan. |

### Relationships
| Type | Entities                                              |
|---|-------------------------------------------------------|
| **Association** | Astronomer                                            |
| **Include** | Operate the interactive observing (virtual telescope) |
| **Extend** | -                                                     |
| **Generalization** | -                                                     |

### Normal Flow of Events
| Step | Description                                                                                                                                               |
|------|-----------------------------------------------------------------------------------------------------------------------------------------------------------|
| 1    | Astronomer เลือกปุ่ม “Test Science Plan”                                                                                                                  |
| 2    | ระบบแสดงรายการ science plan ทั้งหมดที่สามารถทดสอบได้                                                                                                      |
| 3    | Astronomer เลือก science plan ที่ต้องการทดสอบ                                                                                                             |
| 4    | ระบบโหลด science plan ที่เลือกและเตรียมข้อมูลสําหรับการทดสอบ                                                                                              |
| 5    | ระบบดําเนินการ test case ต่อไปนี้เพื่อ validate science plan:                                                                                             |
| 5.1  | Star System Selection Test: ตรวจสอบว่าได้เลือก star system ที่เหมาะสม                                                                                     |
| 5.2  | Image Processing Configuration Test: ตรวจสอบการตั้งค่าการประมวลผลภาพ เช่น ประเภทของไฟล์คุณภาพ และการปรับค่าต่าง ๆ ได้แก่ contrast, brightness, saturation |
| 5.3  | Telescope Location Test: ตรวจสอบตําแหน่งของกล้องโทรทรรศน์ว่าเหมาะสมกับความต้องการในการสังเกตการณ์                                                         |
| 5.4  | Observation Duration Test: ตรวจสอบระยะเวลาการสังเกตการณ์ให้อยู่ในช่วงที่ยอมรับได้                                                                         |
| 6    | ระบบประเมินผลการทดสอบ                                                                                                                                     |
| 7    | หากทุก test case ผ่าน ระบบจะอัปเดตสถานะของ science plan เป็น “TESTED” และแสดงข้อความยืนยันพร้อมผลการทดสอบ                                                 |
| 8    | หากมี test case ใดล้มเหลว ระบบจะแสดงข้อความแสดงความผิดพลาด พร้อมระบุ test case ที่ไม่ผ่าน และข้อเสนอแนะในการแก้ไข                                         |
| 9    | Astronomer ตรวจสอบผลการทดสอบ และปรับแก้ตามความจําเป็น                                                                                                     |
| 10   | Astronomer อัปเดตสถานะของ science plan ที่ผ่านการทดสอบ                                                                                                    |
| 11   | Astronomer กดปุ่ม “Finish” เพื่อสิ้นสุดกระบวนการ                                                                                                          |
| 12   | ระบบบันทึกการเสร็จสิ้นของการทดสอบและอัปเดตข้อมูลในระบบ                                                                                                    |

### Alternate/Exceptional Flow
| Step   | Condition                                                                                                          |
|--------|--------------------------------------------------------------------------------------------------------------------|
| **2a** | หากไม่พบ science plan ที่สามารถทดสอบได้ระบบจะแสดงข้อความ: "No available science plans for testing."                 |
| **3a** | หาก Astronomer เลือก science plan ที่ไม่มีอยู่จริง ระบบจะแสดงข้อความ: "Your selected science plan does not exist." |
| **5a** | หากมี test case ใดล้มเหลว ระบบจะแสดงชื่อของ test case ที่ไม่ผ่าน                                                   |

## Activity Diagram
![Test a science plan Activity Diagram](https://github.com/ICT-Mahidol/2024-ITDS361-Gemini7/blob/master/Gemini-7/designs/design%20diagrams/activityDiagramsTestSciencePlan.png)

## Sequence Diagram
![Test a science plan Sequence Diagram](https://github.com/ICT-Mahidol/2024-ITDS361-Gemini7/blob/master/Gemini-7/designs/design%20diagrams/sequenceDiagramsTestSciencePlan.png)


---
# 3. Submit a science plan

## Use Case Description

#### 
| **Use Case Name** | Submit a Science Plan |
|---|---|
| **ID** | 3 |
| **Importance Level** | High |
| **Primary Actor** | Astronomer |
| **Use Case Type** | Detail, Essential |

### Stakeholders and Interests
| Stakeholder | Interest                                                                      |
|---|-------------------------------------------------------------------------------|
| **Astronomer** | ต้องการส่ง Science Plan ที่สร้างขึ้นเข้าสู่ระบบ                               |
### Brief Description
Astronomer ต้องการส่ง science Plan ที่สร้างขึ้นเข้าสู่ระบบเพื่อรับการตรวจสอบและดําเนินการ
### Precondition
Astronomer จะต้อง Login เข้าระบบเรียบร้อยแล้วก่อนจะทํา use case นี้

### Trigger
| Type | User-Initiated |
|---|---|
| **Trigger** | Astronomer ต้องการส่ง Science Plan เข้าสู่ระบบ |

### Relationships
| Type | Entities |
|---|---|
| **Association** | Astronomer |
| **Include** | - |
| **Extend** | - |
| **Generalization** | - |

### Normal Flow of Events
| Step | Description                                                                                          |
|------|------------------------------------------------------------------------------------------------------|
| 1    | Astronomer เลือกเมนู “Science Plans”                                                                  |
| 2    | ระบบแสดงหน้า science Plans ซึ่งแสดง science Plan ทั้งหมดที่สร้างโดย Astronomer ในระบบ                |
| 2.1  | Astronomer สามารถกรอง science Plan ตามสถานะ (Created, Tested, Submitted, Validated, Executed)        |
| 3    | Astronomer เลือก science Plan ที่ต้องการส่ง                                                          |
| 4    | ระบบให้Astronomer ทําการยืนยันการส่ง science Plan                                                    |
| 4.1  | หาก Astronomer เลือก “Confirm” ระบบจะทําการส่ง science Plan ที่เลือกเข้าสู่ระบบ                      |
| 4.2  | หาก Astronomer เลือก “Cancel” ระบบจะกลับไปที่หน้ารายการ science Plan ทั้งหมด (กลับไปที่ขั้นตอนที่ 2) |

### Alternate/Exceptional Flow
| Step   | Condition                                                                                                                               |
|--------|-----------------------------------------------------------------------------------------------------------------------------------------|
| **2a** | หาก Astronomer ไม่มี science Plan ที่สร้างไว้ระบบจะแสดงหน้าว่างพร้อมปุ่มให้สร้าง science Plan ใหม่ (ไปที่ Use Case: Create science Plan) |
| **3a** | Astronomer สามารถส่ง science Plan ที่มีสถานะ "TESTED" เท่านั้น                                                                          |
| **3b** | หาก science Plan อยู่ในสถานะ CREATED แต่ยังไม่ได้ทดสอบ ระบบจะแจ้งให้ Astronomer ทําการทดสอบแผนก่อน (ไปที่ Use Case: Test a science Plan) |

### Note
|    |    Science Plan สามารถมีสถานะดังต่อไปนี้                                                                                                                      |
|--------|-----------------------------------------------------------------------------------------------------------------------------------|
| **CREATED** | แผนถูกสร้างและบันทึกในระบบ แต่ยังไม่ได้ทดสอบหรือส่ง |
| **TESTED** | แผนผ่านการทดสอบเรียบร้อยแล้ว|
| **SUBMITTED** | แผนถูกส่งไปยัง Observatory Control System (OCS) และรอการตรวจสอบจากผู้สังเกตการณ์ทางวิทยาศาสตร์|
| **VALIDATED** | แผนได้รับการตรวจสอบและยืนยันโดยผู้สังเกตการณ์ทางวิทยาศาสตร์|
| **RUNNING** | แผนกําลังถูกดําเนินการใน OCS|
| **INVALIDATED** | แผนถูกปฏิเสธเนื่องจากข้อผิดพลาดหรือความไม่สอดคล้องกัน|
| **COMPLETE** | แผนดําเนินการเสร็จสมบูรณ์|
| **CANCELLED** | แผนถูกยกเลิก|
## Activity Diagram
![Submit a science plan Activity Diagram](https://github.com/ICT-Mahidol/2024-ITDS361-Gemini7/blob/master/Gemini-7/designs/design%20diagrams/activityDiagramsSubmitSciencePlan.png)

## Sequence Diagram
![Submit a science plan Sequence Diagram](https://github.com/ICT-Mahidol/2024-ITDS361-Gemini7/blob/master/Gemini-7/designs/design%20diagrams/sequenceDiagramsSubmitSciencePlan.png)
---
