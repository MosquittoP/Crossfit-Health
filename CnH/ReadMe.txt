주요 기능 : 로그인 및 회원가입, 운동 정보, 스트레칭, 타이머, 식단 관리, 게시판

개발도구 : Java eclipse, MySQL

MySQL code : CnH\database
Java code : CnH\SECnH\src\test

※ 프로그램 사용가이드

각 화면 좌측 상단위의  C&H 버튼은 홈버튼으로 클릭 시 메인화면으로 돌아갑니다.
본 프로젝트의 main 메소드는 JPanelTest에 존재합니다.
JPanelTest는 change메소드를 통해 페이지를 전환하며 'Page7'로 이동하는 부분에는 영상시청을 위한 코드가 추가되어 있습니다.
Page8, Page9, Page11은 별도의 기능없이 페이지연결을 위한 클래스입니다. 해당 페이지에서 필요로하는 기능은 JFrame을 통해 새로운 창에서 실행됩니다.

해당 프로그램은 로그인 후 이용가능하며 계정이 없을 경우 회원가입을 통해 먼저 계정을 생성해야합니다.
회원가입은 ID, 비밀번호, 이름, 성별, 나이, 키, 체중으로 구성되어 있으며 ID중복여부를 체크하지 않거나 빈칸이 있는 경우 가입이 되지 않습니다.

로그인 후 프로그램의 메인화면이 등장하며 해당 화면에서 프로그램의 주요기능을 실행하기 위한 화면으로 넘어갈 수 있습니다.
프로그램의 주요기능은 운동하기, 스트레칭하기, 식단 관리하기, 게시판, MyPage로 이루어져 있습니다.

운동하기버튼을 클릭하면 사람의 신체사진이 나타나며 상체, 코어, 하체로 나누어진 부위를 선택하여 추천운동에 대한 리스트를 얻을 수 있습니다.
추천운동은 3가지씩 나타나며 추천버튼을 클릭하면 새로운 추천루틴을 볼 수 있습니다. 하단에는 각 루틴의 총합 칼로리가 나타납니다.
확인완료 버튼을 누르면 운동 전 준비영상이 실행되며 시청종료 후 창을 닫으면 타이머세팅을 위한 버튼이 나타납니다.

타이머는 운동 전 준비시간, 운동시간, 휴식시간, 세트, 사이클로 구성되어 있습니다. 세트수는 추천운동이 3가지이므로 3세트로 고정되어 있어 타이머세팅 창에는 표시되지 않습니다.
setting over버튼을 누르면 타이머가 실행되며 종료버튼을 누르면 타이머가 종료되고 메인화면으로 돌아갈 수 있는 버튼이 나타납니다.
스트레칭하기버튼을 통한 기능구현은 운동하기 기능과 기본적으로 동일하며 세부운동 루틴의 차이만 존재합니다.

식단 관리하기버튼을 누르면 검색을 통해 자신이 먹은 메뉴를 검색할 수 있습니다. 해당 메뉴를 검색한 후 추가하기 버튼을 누르면 메뉴만큼의 칼로리가 총합 칼로리에 추가됩니다.
추가된 칼로리는 각 계정의 DB에 저장됩니다.

MyPage는 사용자가 자신의 개인정보를 확인할 수 있는 페이지입니다.
개인정보 확인하기 버튼을 누르면 회원가입 때 입력한 이름, 나이, 신장, 체중, BMI지수와 함께 소모칼로리와 이에 대응한 레벨이 표시되며 체중은 수정가능합니다.

게시판은 프로그램을 사용하는 유저들이 등록한 글을 모아놓은 페이지입니다. 각 유저는 글을 등록하거나 다른 유저의 글을 확인할 수 있고 자신이 등록한 글을 삭제할 수 있습니다.
관리자계정은 모든 유저의 글을 삭제할 수 있습니다.

※ DB관련 사용가이드
mysql에 seproject 데이터베이스를 생성한 후 database폴더를 import합니다.
ip는 localhost 기준이며 root 아이디에 비밀번호 00000000 인 계정으로 설정하셔야 프로그램을 실행시킬 수 있습니다.
