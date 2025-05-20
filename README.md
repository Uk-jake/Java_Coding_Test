# Java Coding Test Practice

코딩 테스트 문제를 꾸준히 풀고 기록하는 저장소입니다.
플랫폼은 프로그래머스와 백준을 사용합니다.

---

## 📁 디렉토리 구조

```

java-coding-test/
├── src/                    # 문제 풀이 코드 저장소 (월별)
│   ├── 2025-05/            # 월별 폴더 (예: 2025년 5월)
│   │   ├── BOJ_1000_Addition_20250520.java
│   │   └── PG_L1_AddDigits_20250520.java
│   └── template/           # 문제 풀이 템플릿
│       └── MainTemplate.java
├── test/                   # 실행 확인용 파일만 저장
│   └── RunSolution.java
├── README.md               
└── .gitignore              

```

---

## 🗂️ 파일 네이밍 규칙

### 백준 (BOJ)

```

BOJ_문제번호_문제이름_YYYYMMDD.java
예: BOJ_1000_Addition_20250520.java

```

### 프로그래머스 (PG)

```

PG_L레벨_문제이름_YYYYMMDD.java
예: PG_L1_AddDigits_20250520.java

```

---

## 🛠️ 사용 방법

1. `src/template/MainTemplate.java`를 복사하여 `src/YYYY-MM/` 하위에 새 파일로 붙여넣기  
2. 파일명을 네이밍 규칙에 따라 작성  
3. 문제 실행이 필요하면 `test/RunSolution.java`에 복사하여 테스트 실행

---

## ⚙️ 개발 환경

- 언어: Java 17
- IDE: IntelliJ IDEA
- 실행 방식: `RunSolution.java`를 통한 개별 실행

---

