# java-calculator-precourse

## 개요

해당 저장소는 문자열 덧셈 계산기를 구현한 저장소입니다.
사용자가 문자열을 입력하면 구분자를 기준으로 분리하여 각 숫자의 합을 반환합니다.

## 세부요구사항

### 문자열에서 숫자 추출 기능

- [x] 구분자 뽑아 오기
    - 기본 구분자(쉼표, 콜론) 인경우 `"[,:]"` 반환
    - 커스텀 구분자인 경우 //와 \n 사이에 있는 문자 추출 해서 `"[구분자]"` 로 반환
    - 잘못된 커스텀 구분자의 선언 `예) /n;//1;2;3` -> IllegalArgumentException`을 발생시킨후 종료시킨다.
- [x] 구분자 선언부 제거
- [x] 구분자를 기준으로 분리하기
    - 구분자로 구분된 값이 숫자가 아닌 경우 `예) 1,a;3` -> `IllegalArgumentException`을 발생시킨후 종료시킨다.
- [ ] 추출한 숫자가 양수만 있는지 검증
    - `예) 1,-1;2` -> `IllegalArgumentException`을 발생시킨후 종료시킨다.

### 추출한 숫자 덧셈 기능

- [ ] 추출한 숫자를 덧셈한다.

### 입력

- [x] 숫자를 추출하여 덧셈할 문자열을 입력받는다.
- 입력 예시)
  `1,2:3`

### 출력

- [ ] `덧셈할 문자열을 입력해주세요.` 출력한다.
- [ ] 덧셈 결과를 출력한다
- 출력 예시)
  `결과 : 6`