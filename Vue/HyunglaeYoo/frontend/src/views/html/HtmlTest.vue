<template lang="">
    <!-- vuin 입력하면 자동 완성 포맷으로 만들어짐-->
    <div>
        <!-- h 태그 1 ~ 6까지 존재함-->
        <h3>실제 코드 형태로 입력해보기</h3>
        <h5>원래는 코드 형태 출력이 아닌 실제 코드가 동작해야 합니다.</h5>
        <h4>chatgpt 같은 것을 만든다면 필요할지도 모르겠네요.</h4>

        <!-- 강제 스타일 먹이기는 아래와 같이 style="css속성"
            여기서 css 속성은 text-align으로 
            글자를 정렬할 때 사용하며 디폴트로 center 정렬이렸으나
            아래 function saveLocal...에 대해서는 left 정렬을 적용하는 작업입니다.
        -->
        <pre style="text-align: left;">
            function saveLocalData () {
                let second = document.getElementById("second")
                let value = second.value
                localStorage.setItem(1, value)
                getLocalData()
            }  
        </pre>       
        <!-- strong은 강조 표현, b도 강조 표현으로 BOLD채에 해당함-->
        <p><strong>TypeScript</strong>, <b>Javascript</b>, Python</p>
        <!-- em과 i는 모두 이탤릭체를 표현함 -->
        <p><em>Rust</em>, <i>C</i>, Verilog</p>
        <!-- mark로 형광팬 효과를 낼 수 있음-->
        <h2>Python <mark>TensorFlow</mark></h2>
        <!-- span은 줄바꿈이 없습니다 - 특정 스타일을 적용할 때 많이 사용하는 편 -->
        <p>Deep Learning <span style="color: green;">keras</span></p>
        <!-- 
            ul은 Unordered List의 약자로 순서가 필요하지 않은 경우 사용
            li는 느낌 그대로 list에 해당함
        -->
        <ul style="text-align: left;">
            <li>EDDI</li>
            <li>Electric car</li>
            <li>MSA</li>
            <li>Deep Learnig</li>
            <li>Distributtion Server</li>
        </ul>

        <ul style="text-align: left;">
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
                    <li>Vue Gloval Component</li>
                    <li>Vuetify</li>
                    <li>Image Gallert</li>
                    <li>file Upload</li>
                    <li>Login/Logout</li>
                    <li>V-Dialog</li>
                    <li>Carousel</li>
                    <li>Card</li>
                    <li>Grid</li>
                </ol>
            </li>
            <li> DDD
                <ol type="a">
                    <li>Domin Driven Development</li>
                    <li>How to write Backlog</li>
                    <li>Behavioral Domain</li>
                    <li>Value Object</li>
                    <li>Domain Service</li>
                    <li>Repository</li>
                </ol>
            </li>
            <li>Haxagonal Architecture
                <ol>
                    <li>Hexagonal Architecture</li>
                    <li>Domain Hexagon</li>
                </ol>
            </li>
        </ul>
        <!-- 
            table은 표를 만들 때 사용
            가장 기본 패턴으로 table > tr > td 형식을 사용함
            tr은 table-row에 해당하며 td는 table-data로 cell 혹은 coluumn이라 봐도 무방
            th는 table-head로 제목이나 메인 정보 같은 것을 배치하는편
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
                <td>안만들었니 ?</td>
            </tr>
        </table><br>
        <!-- colspan을 통해 합칠 열의 개수를 지정할 수 있음 -->
        <table style= "width: 600px">
            <caption>
                <strong>Junior who pursue modern development whit agile process</strong>
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
        <!-- 
            Image를 추가하고 싶을 때는 아래와 같이 이미지가 위치하는 경로를 지정해주면 됩니다.
            부가적으로 download로 확보 햇는지 아니면
            실직적으로 서비스 차원에서 사용자가 등록한 이미지인지 같은 것을 디렉토리 이름으로 구별하면 좋습니다.
        -->
        <h2>Image</h2>
        <img src="@/assets/downloadingimg/뜸부기.jpg">
        <figcaption style="font-size: 32px;">뜸부기</figcaption>
        <!-- figure로 Image를 감싸고 figcaption을 달면 image에 대한 설명을 볼수 있습니다.-->
        <h1>Text Link 생성</h1>
        <a href="https://namu.wiki/w/%EB%9C%B8%EB%B6%80%EA%B8%B0">뜸부기</a>
        <h1>이미지 링크 생성</h1>
        <a href="https://namu.wiki/w/%EB%9C%B8%EB%B6%80%EA%B8%B0">
            <img src="@/assets/downloadingimg/뜸부기.jpg">
        </a>
        <!--
             from 태그는 말그대로 format(양식)을 지정해서 데이터를 전송합니다
             method에 post를 지정할 수 있고 default 값은 get입니다.
             input type에는 text, number, submit은 등록 개념이라 보면 됩니다.
             속성값 value를 통해 표기되는 형태를 지정할 수 있습니다.
             추후 이 부분의 submit을 prevent 하여 vue가 axios 하도록 구성하게 됩니다.
        -->
        <form action="/">
            <input type="text" title="찾을 값">
            <input type="submit" value="찾기">
        </form>
        <!-- 
            단일선택(radio)
            input type으로 checkbox를 사용하여 value 값에 선택한 값을 볼 수 있습니다.
            javascript에서 어떤 값을 선택 했는지 처리할 수 있고
            이를 토대로 vue쪽에 axios 하는 데이터를 처리할 수 있습니다
        -->

        <h3 style="text-align: left;">다중 선택</h3>
        <form action="/" style="text-align: left;">
            <li><input type="checkbox" value="grammer">Grammer</li>
            <li><input type="checkbox" value="writing">Writing</li>
            <li><input type="checkbox" value="reading">Reading</li>
        </form>
        <!--
            단일선택(radio)
            input type으로 radio를 사용하여 value 값에 선택한 값을 볼 수 있습니다
            단일 선택이 되도록 명확하게 지정하려면
            name값을 모두 같은 것으로 지정하여 중복 선택이 불가하게 만듭니다
            마찬가지로 javascript에서 어떤 값을 선택 했는지 처리할 수 있고
            이를 토대로 vue쪽에 axios 하는 데이터를 처리할 수 있습니다
        -->
        <h4 style="text-align: left;">단일 선택</h4>
        <form action="/" style="text-align: left;">
            <li>
                <label><input type="radio" name="subject" value="rust">Rust</label>
            </li>
            <li>
                <label><input type="radio" name="subject" value="typescript">TypeScript</label>
            </li>
            <li>
                <label><input type="radio" name="subject" value="kotlin">kotlin</label>
            </li>
        </form>
        <!-- email 및 password(비밀번호) 입력이 필요한 상황-->
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
    </div>
</template>

<script>

export default {
    
}
</script>

<style scoped>
     table, th, td {
        border: 1px solid #ccc;
     }
     th {
        padding: 15px; /* 셀 테두리와 내용 사이의 간격(패딩) */    
     }
     td {
        padding: 7px;
     }

</style>