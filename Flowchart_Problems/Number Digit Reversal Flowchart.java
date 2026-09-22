START
  ↓
Input N
  ↓
reverse = 0
  ↓
N > 0 ?
 ├── NO → Print reverse → END
 │
 └── YES
       ↓
   digit = N % 10
       ↓
   reverse = reverse * 10 + digit
       ↓
   N = N / 10
       ↓
   Back to N > 0 ?