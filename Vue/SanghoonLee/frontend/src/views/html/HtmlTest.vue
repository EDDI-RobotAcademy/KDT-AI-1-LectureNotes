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
        <!-- strong은 강조 표현, b도 강조 표현으로 BOLD체에 해당함-->
        <p><strong>TypeScript</strong>, <b>Javascript</b>, Python</p>
        <!-- em과 i는 모두 이탤릭체를 표현함 -->
        <p><em>Rust</em>, <i>C</i>, Verilog</p>
        <!-- mark로 형광팬 효과를 낼 수 있음 -->
        <h2>Python <mark>TensorFlow</mark></h2>
        <!-- span은 줄바꿈이 없습니다 - 특정 스타일을 적용할 때 많이 사용하는 편 -->
        <p>Deep Learning <span style="color: green;">Keras</span></p>
        <!--
            ul은 Unordered List의 약자로 순서가 필요하지 않은 경우 사용
            li는 느낌 그대로 list에 해당함
        -->
        <ul style="text-align: left;">
            <li>EDDI</li>
            <li>Electric Car</li>
            <li>MSA</li>
            <li>Deep Learning</li>
            <li>Distribution Server</li>
        </ul>

        <ul style="text-align: left;">
            <li>Vue
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
        <!--
            table은 표를 만들 때 사용
            가장 기본 패턴으로 table > tr > td 형식을 사용함
            tr은 table-row에 해당하며 td는 table-data로 cell 혹은 column이라 봐도 무방
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
        <table style="width: 600px">
            <!-- caption을 통해서 table(표)에 제목 비스무리한 느낌을 줄 수 있음 -->
            <caption>
                <strong>Junior who pursue modern development with agile process</strong>
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
        <!-- -->
        <h2>Image</h2>
        <img src="@/assets/donwloadImg/mario_run.png">
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