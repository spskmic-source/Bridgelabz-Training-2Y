START
  ↓
Input N
  ↓
N <= 1 ?
 ├── YES → Print "Not Prime" → END
 │
 └── NO
       ↓
     i = 2
       ↓
   i * i <= N ?
    ├── NO → Print "Prime" → END
    │
    └── YES
          ↓
       N % i == 0 ?
        ├── YES → Print "Not Prime" → END
        │
        └── NO
              ↓
            i = i + 1
              ↓
        Back to i * i <= N ?