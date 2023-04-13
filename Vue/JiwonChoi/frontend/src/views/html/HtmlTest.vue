<template>
    <!-- vuein 입력하면 자동 완성 포맷으로 만들어짐 -->
    <div>
        <!-- h 태그 1 ~ 6까지 존재함 -->
        <h3>실제 코드 형태로 입력해보기</h3>
        <h6>원래는 코드 형태 출력이 아닌 실제 코드가 동작해야 합니다.</h6>
        <h4>chatgpt 같은 것을 만든다면 필요할지도 모르겠네요.</h4>

        <!-- 
            강제 스타일 먹이기는 아래와 같이 style="css속성"
            여기서 css 속성은 text-align으로
            글자를 정렬할 때 사용하며 디폴트로 center 정렬이였으나
            아래 function saveLocal .... 에 대해서는 left 정렬을 적용하는 작업입니다.
        -->
        <pre style="text-align: left;">
            function saveLocalData () {
                let second = document.getElementById("second")
                let value = second.value
                localStorage.setItem(1, value)
                getLocalData()
            }
        </pre>
        
        <!--strong은 강조 표현, b도 강조 표현으로 BOLD체에 해당함-->
        <p>
            <strong>TypeScript</strong>,
            <b>javascript</b>,
            Python
        </p>
        
        <!--em과 i는 모두 이탤릭체를 표현함-->
        <p>
            <em>Rust</em>, <i>C</i>, Verilog
        </p>

        <!--mark로 형광펜 효과를 낼 수 있음-->
        <h2>Python<mark>TensorFlow</mark></h2>

        <!--span은 줄바꿈이 없습니다. 특정 스타일을 적용할 때 많이 사용하는 편-->
        <p>Depp Learning<span style="color: green;">Keras</span></p>

        <!--
            u1은 Unordered List의 약자로 순서가 필요하지 않은 경우 사용
            li는 느낌 그대로 List에 해당함
        -->
        <u1 style="text-align: left;">
            <li>EDDI</li>
            <li>Electric Car</li>
            <li>MSA</li>
            <li>Deep Learning</li>
            <li>Distribution Server</li>
        </u1>

        <ul style="text-align: left;">
            <li>Vue
                <ol type="a" start="3">
                    <li>Vue Init</li>
                    <li>Vue Router</li>
                    <li>Vue template</li>
                    <li>Vue Script</li>
                    <li>Vue props</li>
                    <li>Vue v-model</li>
                    <li>Vue axios</li>
                    <li>Vue Local Component</li>
                    <li>Vue Glbal Component</li>
                    <li>Vuetify</li>
                    <li>Imagr Gallery</li>
                </ol>
            </li>

            <li>DDD
                <ol type="a">
                    <li>Domain Driven Development</li>
                    <li>How to write Backlog</li>
                    <li>Behavioral Domain</li>
                    <li>Value Object</li>
                </ol>
            </li>

            <li>Hexagonal Architecture
                <ol>
                    <li>Hexagonal Architecture</li>
                    <li>Domain Hexagon</li>
                </ol>
            </li>
        </ul>

        <!--
            table은 표를 만들 때 사용
            가장 기본 패턴으로 table > tr > td의 형식을 사용함
            tr은 table-row에 해당하며 td는 table-data로 cell 혹은 column이라 봐도 무방
            th는 table-head로 제목이나 메인 정보 같은 것을 배치하는 편이다.
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
                <td>안만들었니?</td>
            </tr>
        </table><br>

        <!--colspan을 통해 합칠 열의 개수를 지정할 수 있음-->
        <table style="width: 600px;">
            <!--caption을 통해서 table(표)에 제목 비스무리한 느낌을 줄 수 있음-->
            <caption>
                <strong>Junior how pursue modern development with aglie process</strong>
            </caption>
            <tr>
                <th>Name</th>
                <td>이름</td>
                <th>Contact</th>
                <td>010-1111-2222</td>
            </tr>
            <tr>
                <th>Address</th>
                <td colspan="3">주소</td>
            </tr>
        </table>
        
        <!--Image를 추가하고 싶으 ㄹ때는 아래와같이 이미지가 위치하는 경로를 지정해주면 됩니다.
        부가적으로 download로 확보 했는지 아니면
        실질적으로 서비스 차원에서 사용자가 등록한 이미지인지 같은 것을 디렉토리 이름으로 구별하면 좋습니다.-->
        <h2>Image</h2>
        <img src="@/assets/donwloadImg/asdf123.png">
         <!--figure로 image를 감싸고 figcaption을 달면 image에 대한 설명을 붙일 수 있습니다.-->
        <figure>
            <img src="@/assets/donwloadImg/asdf123.png">
            <figcaption style="font-size: 25px;">
                <mark style="background-color: #e1c5f6;"> <span style="color: #ffffff;"><b>산리오</b>가 구경한다!</span></mark>
            </figcaption>
        </figure>

        <h1>Text Link 생성</h1>
        <a href= "http://golang.org">Golang Homepagr</a>
        <br>

        <h1>이미지 Link 생성</h1>
        <a href= "http://sanriokorea.co.kr">
            <img src="@/assets/donwloadImg/asdf123.png">
        </a>


        <!--from 태그는 말 그대로 format(양식)을 지정해서 데이터를 전송합니다.
        method에 post를 지정할 수 있고 default 값은 get입니다.
        input type에 있는 text, number, submit 등등이 올 수 있습니다.
        text는 말 그대로 문자열, number는 숫자, submit은 등록 개념이라 보면 됩니다. 
        속성값 value를 통해 표기되는 형태를 지정할 수 있습니다.
        추후 이 부분의 submit을 prevent하여 vue가 axios 하도록 구성하게 됩니다.-->
        <form action="/">
            <input type="text" value="찾을 값">
            <input type="submit" value="찾기"> <!--찾기버튼 누르면 홈으로 돌아감-->
        </form>


        <!--다중 선택 (checkbox)
        input type으로 cheackbox를 사용하여 value 값에 선택한 값을 볼 수 있습니다.
        javascript에서 어떤 값을 선택 했는지 처리할 수 있고
        이를 토대로 vue쪽에 axios 하는 데이터를 처리할 수 있습니다.-->
        <h3>다중 선택</h3>
        <form action="/" style="text-align: left;">
            <li><input type="checkbox" value="grammer">Grammar</li>
            <li><input type="checkbox" value="writing">Writing</li>
            <li><input type="checkbox" value="reading">Reading</li>
        </form>

        <!--단일 선택 (radio)
        input type으로 radio를 사용하여 value 값에 선택한 값을 볼 수 있습니다.
        단일 선택이 되도록 명확하게 지정하려면
        name값을 모두 같은 것으로 지정하여 중복 선택이 불가하게 만듭니다.
        마찬가지로 javascript에서 어떤 값을 선택 했는지 처리할 수 있고
        이를 토대로 vue쪽에 axios 하는 데이터를 처리할 수 있습니다.-->
        <h4>단일 선택</h4>
        <form action="/" style="text-align: left;">
            <label><li><input type="radio" name="subject" value="rust">rust</li></label>
            <label><li><input type="radio" name="subject" value="typedcript">typedcript</li></label>
            <label><li><input type="radio" name="subject" value="kotlin">kotlin</li></label>
        </form>

        <!--email 및 password 입력이 필요한 상황-->
        <form style="text-align: left;">
            <fieldset>
                <legend>로그인</legend>
                <ul>
                    <li>
                        <label for="email">이메일: </label>
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
        <form>
            <fieldset>
                <legend>범주 테스트</legend>
                    <ul>
                        <li>
                            <label for="member"></label>
                            <!--
                                input type="number"를 통해 숫자를 인식
                                value에 초기값, min은 최소값, max는 최대값,
                                화살표가 UI가 제공되는데 누를 때마다 이동하는 숫자의 크기는 step
                            -->
                            <input type="number" id="member" value="1" min="1" max="10" step="1">
                        </li>

                        <li>
                            <label for="satisfy"></label>
                            <!--
                                range를 사용하면 막대 바가 생성됨
                                최소값, 최대값, 초기값, step 설정은 위의 number와 완벽하게 동일함
                            -->
                            <input type="range" id="satisfy" value="1" min="1" max="5" step="1">
                        </li>
                    </ul>
            </fieldset>
        </form>

        <!--email 및 password 기반 회원 가입-->
        <form style="text-align: left;">
            <fieldset>
                <legend>회원 가입</legend>
                <ul>
                    <li>
                        <label for="email">이메일: </label>
                        <input type="text" id="email">
                    </li>
                    <li>
                        <label for="pwd">비밀번호: </label>
                        <input type="password" id="pwd">
                    </li>
                </ul>
            </fieldset>
            <input type="submit" value="회원 가입">

            <!--입력을 잘못 했을 경우 정보를 초기화 합니다.-->
            <input type="reset" value="초기화">

        </form>
        <!--checkbox, radio로 표현하기에 너무 많은 경우-->
        <form style="text-align: left;">
            <fieldset>
                <legend>과목 선택</legend>
                <ul>
                    <li>
                        <label for="subject">과목: </label>
                        <!--select의 경우엔 드롭 다운 형태의 목록을 만들 수 있습니다.
                        multiple을 선택하여 여러 옵션들을 복수 선택할 수 있습니다.
                        size는 눈에 보이는 리스트의 개수입니다.
                        -->
                        <select size="5" id="subject" multiple>
                            <!--option에는 실제 배치하고 싶은 옵션 리스트를 작성합니다.-->
                            <option value="archi">소프트웨어 아키텍처</option>
                            <option value="ddd">DDD 설계</option>
                            <option value="clean">Clean 아키텍처</option>
                            <option value="hexagon1">Hexagon1 아키텍처</option>
                            <option value="msa">MSA 설계</option>
                            <option value="r j p">Reactive J P</option>
                        </select>
                    </li>
                </ul>
            </fieldset>
        </form>
        <!--progress bar 만들기-->
        <ul>
            <li>
                <label>10초 남았음</label>
                <progress value="50" max="60"></progress>
            </li>
            <li>
                <label>30% 채웠음</label>
                <progress value="30" max="100"></progress>
            </li>
        </ul>

        <!--meter 만들기 : 값의 크기를 표시-->
        <ul>
            <li>
                <label>투명도 0.8</label>
                <meter value="0.8"></meter>
            </li>
            <li>
                <label>사용률 64%</label>
                <meter min="0" max="100" value="64"></meter>
            </li>
            <li>
                <label>트래픽 초과까지</label>
                <meter min="1024" max="16384" value="9277"></meter>
            </li>
        </ul>

    </div>
</template>


<script>
export default {
    
}
</script>

<style scoped>
    table, th, td {
        border: 1px solid #c8a8d6;
    }
    th{
        padding: 15px; /* 셀 테두리와 내용 사이의 간격 (패딩) */
    }
    td{
        padding: 7px; 
    }
    img{
        border: 2px dashed #c8a8d6;
        padding: 5px; 
    }
    ul li{
        list-style: none;
        margin: 15px 0;
        font-size: 16px;
    }
</style>