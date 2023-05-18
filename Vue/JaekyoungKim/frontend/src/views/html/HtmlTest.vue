<template>
    <!--vuein 누를면 자동 완성 포맷으로 만들어짐-->
    <div>
        <h3>실제 코드 형태로 입력해 보기</h3>
        <h6>원래는 코드 형태 출력이 아닌 실제 코드가 동작해야 합니다.</h6>
        <h4>chatgpt 같은 것을 만든다면 필요할지도 모르겠네요.</h4>
        <!--강제 스타일 먹이기는 아래와 같이 style="css속성"
        여기서 css 속성은 text-align으로 글자를 정렬할 때 사용하며
        디폴트로 center 정렬이였으나 아래 function saveLocal 에 대해서는 left 정렬을 적용하느 작업입니다.
        이거 왜 깃에 안올라가냐 -->
        <pre style="text-align:left;">
            function saveLocalData(){
                let second =document.getElementById("second")
                let value =second.value
                localStorage.setITem(1,value)
                getLocalData()
            }
        </pre>
        <!--strong은 강조 표현, b도 강조 표현으로  BOLD체에 해당함-->
        <p><strong>TypeScript</strong>,<b>Javascript</b>,Python</p>
        <!--드rhk i는 모두 이탤릭체를 표현함-->
        <p><em>Rust</em>,<i>C</i>,Verilog</p>
        <!-- mark로 형광팬 효과를 낼 수 있음-->
        <h2>Python <mark> TensorFlow</mark></h2>
        <!--span은 줄바꿈이 없습니다.- 특정 스타일을 적용할때 많이 사요하는 편-->
        <p>Depp Learning <span style="color:green;">Keras</span></p>
        <!--
            ul은 Unordered List의 약자로 순서가 필요하지 않은 경우 사용
            li는 느낌 그대로 List에 해당
        -->
        <ul style="text-align:left;">
            <li>EDDI</li>
            <li>Electrinc Car</li>
            <li>MSA</li>
            <li>Deep LEARNING</li>
            <li>Distribution Server</li>
        </ul>
        <ul style="text-align:left;">
            <li>vue
                <ol type="a" start="3">
                    <li>Vue Init</li>
                    <li>Vue Router</li>
                    <li>Vue Template</li>
                    <li>Vue Script</li>
                    <li>Vue props</li>
                    <li>Vue v-model</li>
                    <li>Vue axios</li>
                    <li>Vue Local Component</li>
                    <li>Vue Global Component</li>
                    <li>Vuetify</li>
                    <li>Image Gallery</li>
                    <li>File Upload</li>
                    <li>Login/Logout</li>
                    <li>V-Dialog</li>
                    <li>Carousel</li>
                    <li>Card</li>
                    <li>Grid</li>
                </ol>
            </li>
            <li>DDD
                <ol type="a">
                    <li>Domain Driven Development</li>
                    <li>How to write Backlog</li>
                    <li>Behavioral Domain</li>
                    <li>Value Object</li>
                    <li>Domain Service</li>
                    <li>Repository</li>
                </ol>
            </li>
            <li>Hexagonal Architecture
                <ol>
                    <li>Hexagonal Architecture</li>
                    <li>Domain Hexagon</li>
                </ol>
            </li>
        </ul>
        <!--table은 표를 만들 때 사용 
        가장 기본 패턴으로 table- th-td형식을 사용함
    tr은 table row에 해당하며 td는 table data 로 cell  혹은 column이라 봐도 무방
    th는 table head로 제목이나 메인 정보 같은 것을 배치하는 편
 -->
        <table>
            <tr>
                <th>1 row 1 column</th>
                <th>1 row 2 column</th>
                <th>1 row 3 column</th>
            </tr>
            <tr>
                <td>내용이</td>
                <td>없어서</td>
                <td>그랬나</td>
            </tr>
        </table><br>
        <!-- colspan을 통해 합칠 열의 개수를 지정할 수 있음-->
        <table style="width:600px">
            <!--caption을 통해서 table에 제목 비스무리한 느낌을 줄 수 있음-->
            <caption>
                <strong>Junior who pursue Modern Development with agile process</strong>
                <p>Pursue agile process based development </p>
            </caption>
            <tr>
                <th>Name</th>
                <td>이름</td>
                <th>Contact</th>
                <td>010-0000-0000</td>
            </tr>
            <tr>
                <th>Adress</th>
                <td colspan="3">주소</td>
            </tr>
        </table>
        <!--
            Image를 추가 하고 싶을 때는 아래와 같이 이미지가 위치하는 경로를 지정해주면 됩니다"
            부가적으로 download로 확보 했는지 아니면 실질적으로 서비스 차원에서 
            사용자가 등록한 이미지인지 같은 것을 디렉토리 이름으로 구별하면 좋습니다.
        -->
        <h2>Image</h2>
        <img src="@/assets/downloadImg/cat.jpg">
        <!-- 
            figure로 image를 감싸고 figacaption 을 달면 image에 대한 설명을 붙일 수 있습니다.
        -->
        <figure><img src="@/assets/downloadImg/cat.jpg">
        <figcaption style="font-size: 32px;">작은 고양이</figcaption>
    </figure>
    <h1>Text Link 생성</h1>
    <a href="https://golang.org">Golang Homepage</a>
    <h2>이미지 링크 생성</h2>
    <a href="https://www.naver.com/">
        <img src="@/assets/downloadImg/cat.jpg">
    </a>
    <!--
        form 태그는 말 그대로 format 양식을 지정해서 데이터를 전송합니다.
        method에 post를 지정할 수 있고 default 값은 get입니다<div class=""></div>

        input type에는 text, number, submit 등등이 올 수 있습니다.
        text는 말 그대로 문자열, number는 숫자, submit은 등록 개념이라고 보면 됩니다.
        속성값은 value를 통해 표기되는 형태를 지정할 수있브니다.
        추후 이 부분의 subimt 을 prevent 하여 vue가 axios 하도록 구성하게 됩니다.
    -->
    <form action="/">
        <input type="text" value="찾을 값">
        <input type="submit" value="찾기">
    </form>
    <!--
        다중 선택 (checkbox)
        input type 으로 checkbox를 사용하여 value 값에 선택한 값을 볼 수 있습니다.
        javascript 에서 어떤 값을 선택했는지 처리할 수 있고
        이를 토대로 vue 쪽에 axios하는 데이터를 처리할 수 있습니다.
    -->
    <h3>다중 선택</h3>
    <form action="/" style="text-align: left;">
        <li><input type="checkbox" value="grammar">Grammar</li>
        <li><input type="checkbox" value="writing">Writing</li>
        <li><input type="checkbox" value="reading">Reading</li>
    </form>
    <!--
        단일 선택(radio)
        input type 으로 radio를 사용하여 value 값에 선택한 값을 볼 수 있습니다.
        단일 선택이 되도록 명확하게 지정하려면 
        name값을 모두 같은 것으로 지정하여 중복 선택이 불가능하게 만듭니다.
        마찬가지로 javascript 에서 어떤 값을 선택했는지 처리할 수 있고
        이를 토대로 vue 쪽에 axios하는 데이터를 처리할 수 있습니다.
    -->
    <h4>단일 선택</h4>
    <form action="/" style="text-align: left;">
        <li>
            <label><input type="radio" name="subject" value="rust">Rust</label>
        </li>
        <li>
            <label><input type="radio" name="subject" value="typescript">Typescript</label>
        </li>
        <li>
            <label><input type="radio" name="subject" value="kotlin">Kotlin</label>
        </li>
    </form>
    <!-- 
        email및 password를 입렵이 필요한 상황-->
    <form style="text-align: left;">
        <fieldset>
            <legend>로그인</legend>
            <ul>
                <li>
                    <label for="email">email: </label>
                    <input type="text" id="email">
            </li>
            <li>
                <label for="pwd">비밀번호: </label>
                <input type="password" id="pwd">
            </li>
        </ul>
        </fieldset>
    </form>    
    <!--범주 테스트-->
    <form style="text-align: left;">
        <fieldset>
            <legend>범주 테스트</legend>
                <ul>
                    <li>
                        <label for="member"></label>
                        <!-- 
                            input type="number"를 통해 숫자를 인식
                            value에 초기값 ,min은 최소값, max는 최댓값,
                            화살표 UI제공되는데 누를 때마다 수샂의 크기는 step
                        -->
                        <input type="number" id="member" value="1" min="1" max="10" step="1">
                    </li>
                    <li>
                        <label for="satisfy"></label>
                        <!--
                            range를 사용하면 막대 바가 생성됨
                            최솟값, 최대값, 초기값, step 설정은 위의 number와 완벽하게 동일함
                        -->
                        <input type="range" id="satisfy" value="1" min="1" max="5" step="1">
                    </li>
                </ul>
        </fieldset>
    </form>
    <!-- email 및 password 기반 회원 가입-->
    <form style="text-align: left;">
        <fieldset>
            <legend>회원 가입</legend>
            <ul>
                <li>
                    <label for="email">email: </label>
                    <input type="text" id="email">
            </li>
            <li>
                <label for="pwd">비밀번호: </label>
                <input type="password" id="pwd">
            </li>
        </ul>
        </fieldset>
        <input type="submit" value="회원 가입">
        <!-- 입력을 잘못 했을때 초기화 합니다.-->
        <input type="reset" value="초기화">
    </form>   
    <!--checkbox나 radio로 표현하기에 너무 많은 경우--> 
    <form style="text-align: left;">
        <fieldset>
            <legend>과목 선택</legend>
            <ul>
                <li>
                    <label for="subject" >과목: </label>
                    <!--select의 경우 드롭다운 형태의 목록을 만들 수 있습니다.
                    multiple을 선택하여 여러 옵션들을 복수 선택 할 수 있습니다.
                    size는 눈에 보이는 리스트의 개수입니다.-->
                    <select size="5" id="subject"  >
                        <option value="archi">소프트웨어 아키텍처</option>
                        <option value="ddd">DDD 설계</option>
                        <option value="clean">Clean 아키텍처</option>
                        <option value="hexagonal">Hexahonaml 아키텍처</option>
                        <option value="msa">MSA 설계</option>
                        <option value="rxjava">Reactive Java Programming</option>
                        <option value="r2bc">R2DBC Reactiv DB System</option>
                        <option value="jpa">Reactive에서 사용할 스 없는 jpa</option>
                        <option value="mfe">Micro Frontend Service</option>
                        <option value="edm">Event Driven MSA</option>
                        <option value="kafka">Kafka 기반 메시지 브로커 시스템</option>
                    </select>
            </li>
        </ul>
        </fieldset>
        <input type="submit" value="회원 가입">
        <!-- 입력을 잘못 했을때 초기화 합니다.-->
        <input type="reset" value="초기화">
    </form>   
    </div>
</template>
<script>
export default {
    
}
</script>
<style scoped>
    table, th, td{
        border:1px solid #ccc;
    }
    th{
        padding:15px;/*셀 테두리와 내용 사이의 간경(패딩)*/
    }
    td{
        padding: 7px;
    }
</style>