# aos
## Convention
### Branch
도메인 단위로 브랜치를 구성합니다.

main
- feature/home `소현`
- feature/page `대환`
- feature/profile `재원`
- feature/reviews `재원`

#### PR
- 5/21 까지 할 작업물들을 1차 마일스톤으로 세우고, **이슈에 작성해주세요.**
  - PR 단위는 정해진 마일스톤입니다.
    - 1차 마일스톤 : ~5/21
    - 2차 마일스톤 : ~5/25
- Review 는 PR 이 올라오고 24h 안에 이루어져야합니다.
- 각 feature/{도메인} 의 base branch 는 main 입니다.
  - approve 가 모두 이루어져야 main 으로 merge 가 가능합니다.
  
### Commit
이번 합세를 통해 본인들이 생각하는 커밋의 단위(기준) 을 고민해고, **이슈로 공유해주세요.**

앞서 합세 안드 회의에서도 이야기했듯이, 팀에서는 팀의 컨벤션을 지키지만, 합세에서 우리는 본인만의 기준을 찾아보는거로 해요.

Ex
- 한 뷰와 모든 기능을 한 커밋의 단위라고 생각합니다.
- ui (xml) 과 binding 작업, api 작업들은 각각 분리되어야하고, 각 구현들이 하나의 단위라고 생각합니다.
- 한 뷰내 각 컴포넌트들이 구현의 단위라고 생각합니다.
  - 이름 입력받기
  - 목록 구현하기
  - 등..

#### Commit Message
- [{tag}] #{issue}-{content}
  - tag
    - 커밋의 단위를 표현해주세요.
  - issue
    - 어떤 이슈로부터 파생된 구현 내용인지 알려주세요.
  - content
    - 해당 커밋에 담긴 구현 내용을 공유해주세요
      - 여러 책임들이 한 커밋에 있지 않도록 주의해주세요.
- 구현을 하고 commit 을 쪼개지 말고, 작업을 하면서 수시로 commit 을 남겨주세요.

#### Tag

- [FEAT] : 새로운 기능 구현  
- [ADD] : 부수적인 코드 추가 및 라이브러리 추가, 새로운 파일 생성
- [CHORE] : 버전 코드 수정, 패키지 구조 변경, 타입 및 변수명 변경 등의 작은 작업
- [UI] : UI 작업
- [FIX] : 버그 및 오류 해결

### Resource
<img width="781" alt="스크린샷 2023-05-16 오전 12 36 17" src="https://github.com/SOPT-TEAM9-Carrot/Carrot-aos/assets/88091704/f1478a29-70d1-403f-bd89-59d5d45743a7">
<img width="755" alt="스크린샷 2023-05-16 오전 12 37 08" src="https://github.com/SOPT-TEAM9-Carrot/Carrot-aos/assets/88091704/06db44fc-6f6a-4a34-aade-a6b18600d1c1">
