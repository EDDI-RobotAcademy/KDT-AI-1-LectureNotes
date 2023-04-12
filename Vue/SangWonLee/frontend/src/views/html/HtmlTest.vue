<template lang="">

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

        <!-- strong 은 강조 표현, b도 강조 표현으로 BOLD체에 해당 -->
        <p><strong>TypeScript</strong>, <b>Javascipt</b>, Python</p>
        <!-- em과 i는 모두 이탤릭체를 표현함 -->
        <p><em>Rust</em>, <i>C</i>, Verilog</p>
        <!-- mark로 형광팬 효과를 낼 수 있당 -->
        <h2> Python <mark>TensorFlow</mark></h2>
        <!-- span 은 줄바꿈이 없다. - 특정 스타일을 적용할 때 많이 사용-->
        <p>Deep Learning <span style="color: green;">Keras</span></p>
<!-- 
    ul은 Unordered List의 약자로 순서가 필요하지 않은 경우 사용
    li 는 list임
-->
        <ul style = "text-align: left;">
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
        </table>
        <br>
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
        <img src="@/assets/good.jpg" width="400" height="400">
        <!-- figure로 image를 감싸고 figcaption을 달면 image에 대한 설명을 붙일 수 있습니다. -->

        <figure>
            <img src="@/assets/good.jpg" width="400" height="400">
            <figcaption style="font-size: 24px">르세라핌 짱!</figcaption>
        </figure>

        <h1>Text Link 생성 </h1>
        <a href = "http://golang.org">Golang Homepage</a>

        <h1> 이미지 링크 생성</h1>
        <a href="http://mario.nintendo.com/">
            <img src = "@/assets/good.jpg" width="400" height="400">
        </a>

        <!-- 
            form 태그는 말 그대로 format(양식)을 지정해서 데이터를 전송합니다.
            method에 post를 지정할 수 있고 default 값은 get입니다.
            input type에는 text, number, submit 등등이 올 수 있습니다.
            text는 말 그대로 문자열, number는 숫자, submit은 등록 개념이라 보면 됩니다.
            추후 이 부분의 sumbit은 prevent 하여 vue가 axios 하도록 구성하게 된다.
        -->

        <form action="/">
            <input type="text" value="찾을 값">
            <input type="submit" value="찾기">
        </form>

        <h3>다중 선택</h3>
        <form action="/" sytle="text-align: left;">
            <li><input type="checkbox" value="grammar">Grammar</li>
            <li><input type="checkbox" value="writing">Writing</li>
            <li><input type="checkbox" value="reading">Reading</li>
        </form>
        <!--
            단일 선택(radio)
            input type으로 radio를 사용하여 value 값에 선택한 값을 볼 수 있습니다.
            단일 선택이 되도록 명확하게 지정하려면
            name값을 모두 같은 것으로 지정하여 중복 선택이 불가하게 만듭니다.
            마찬가지로 javascript에서 어떤 값을 선택 했는지 처리할 수 있고
            이를 토대로 vue쪽에 axios 하는 데이터를 처리할 수 있다.
        -->


        <h4>단일 선택</h4>
        <form action="/"  sytle="text-align: left;">
            <li>
                <label for="">
                    <input type="radio" name="subject" value="rust">Rust
                </label>
            </li>
       
            <li>  
                <label for="">
                <input type="radio" name="subject" value="typescript">Typescript
            </label>
            </li>
       
          
            <li>
                <label for="">
                <input type="radio" name="subject" value="Kotlin">Kotlin
            </label>
            </li>

        </form>

        <!-- 이메일 비번 입력하기 -->

        <form action="" style="text-align: left;">
            <fieldset>
                <legend>로그인</legend>
                <ul>
                    <li>
                        <label for="email">email : </label>
                        <input type="text" id="email">
                    </li>
                    <li>
                        <label for="pwd">비밀번호 : </label>
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
table,
th,
td {
    border: 1px solid #ccc;
}

th {
    padding: 15px;
    /* 셀 테두리와 내용 사이의 간격(패딩) */
}

td {
    padding: 7px;
}
</style>