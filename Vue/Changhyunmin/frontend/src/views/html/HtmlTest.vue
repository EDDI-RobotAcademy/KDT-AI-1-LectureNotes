<template lang="">
    <!-- vuein 입력하면 자동으로 완성  포맷으로 만들어짐 -->
    <div>
        <h3>실제 코드 형태로 입력해 보기</h3>
        <h6>원래는 코드 형태 출력이 아닌 실제 코드가 동작해야 합니다.</h6>
        <h4>chatgpt 같은 것을 만든다면 필요할지도 모르겠네요</h4>
        <!--
            강제 스타일 먹이기는 아래와 같이 style ="css속성"
            여기서 css 속석은 text=align 으로 
            글자를 정렬할 때 사용하며 디폴트로 center정렬이 있으나 
            아래 function saveLocalDate ... dp eogotjsms left정렬을 적용하는 작업입니다.

        -->
        <pre style="test-align: left;">
            function saveLocalDate (){
                let second = document.getElementById("second")
                let value = second.value
                localStorage.setItem(1, value)
                getLocalDate()
            }
        </pre>
        <!-- strong은 강조 표현 , b도 강조 표현으로 BOLD제에해당함-->
        <p><string>TypeScropt</string>, <b>javaScript</b>,Python</p>
         <!-- em과 i는 모두 이테릭체를 표현함-->
         <p><em>Rust</em>,<i>C</i>, Varilog </p>
         <!-- mark로 현광편 효과를 낼 수 있음-->
         <h2>Python<mark> TensorFlow</mark></h2>
         <!-- span은 줄바꿈이 없습니다 - 특정 스타일을 적용할 때 많이 사용하는 편-->
         <p>Deep Learning <span style = "color: green;">Keras</span></p>
         <!--
            ul 은 Unordered List의 약자로 순서가 필요하지 않은경우 사용
            li는 느낌 그대로 list에 해당
         -->
         <ul style = "test-align: left">
            <li>EDDI</li>
            <li>Electric Car</li>
            <li>MSA</li>
            <li>Deep Learning</li>
            <li>Disrtibution Server</li>

         </ul>

         <ul style = "test-align: left">
            <li>Vue
                <ol type = "a" start ="3">
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
                    <li>Login/Logout </li>
                    <li>V-Dialog</li>
                    <li>Carousel</li>
                    <li>Card</li>
                    <li>Grid</li>
                </ol>
            </li>
            <li DDD>
                <ol type="a">
                    <li>Domain Driben Debelopment</li>
                    <li>How to write Backlog</li>
                    <li>Dahaviral Domain</li>
                    <li>Value Object</li>
                    <li>Domain Service</li>
                    <li>Repository</li>
                </ol>
            </li>
            <li>Hexagonal Archutecture
                <ol>
                    <li>Hexagonal Architecture</li>
                    <li>Domain Hexagon</li>
                </ol>
            </li>
         </ul>
         <!--
            table은 표를 만들 때 사용
            가장 기본 패턴으로 table > th > td 형식으로 사용함
            tr은 table-row에 해당하며 td는 table-date로 cell혹은 column이라 봐도 무방
            th는 table-heat로 재목이나 메인 정보 같은 것을 배치하는 편
         -->
         
         <table>
            <tr>
                <th>1 row 1 column</th>
                <td>1 row 2 column</td>
                <td>1 row 3 column</td>
            </tr>
            <tr>
                <th>내용이</th>
                <td>없어서</td>
                <td>안만들었니?</td>
            </tr>
            
         </table><br>
        <!-- colspen을 통해 합칠 열의 갯수를 지정할 수 있음-->
         <table style = "width: 600px">
            <caption>
                <string>Junior who pursue Modern Development with agile process</string>
                <p>Agile Process Based</p>
            </caption>
            <tr>
                <th>Name</th>
                <td>이름</td>
                <td>Conract</td>
                <td>010-1111-2222</td>
            </tr>
            <tr>
                <th>address</th>
                <td colspen="3">주소</td>
            </tr>
            
         </table>
         <!-- 
            img를 추가하고 싶을 때는 아래와 같이 이미지가 위치하는 경로를 지정해주면 됩니다.
            부가적으로 download로 확보했는지 아니면 
            실직적으로 서비스 차원에서 사용자가 등록한 이미지인지 같은것은 디렉토리 이름으로 구별하면 좋습니다.
         -->
         <h2>Image</h2>
         <img src="@/assets/logo.png">
         <!-- figure image를 감싸고 figcaption을 달면 image에 대한 설명을 붙일 수 있습니다.-->
        <figure>
            <img src="@/assets/logo.png">
            <figcaption style = "font-size: 32px;">마리오가 달리다!</figcaption>
        </figure>
        <h1>Text Link</h1>
        <a href ="https://www.nintendo.co.kr/character/mario/">Golang Homepage</a>
        <h1>이미지 링크 생성</h1>
        <a href ="https://www.nintendo.co.kr/character/mario/">
            <img src="@/assets/logo.png">
        </a>
        <!-- 
            form 태그는 말 그대로 format(양식)을 저장해서 데이터를 전송합니다.
            method에 post 지정할 수 있고 default 값은 get입니다.

            input tupe에는 text, number, submit 등등이 올 수 있습니다.
            text는 말 그대로 문자열, number는 숫자, submit은 등록 개념이라 보면 됩니다.
            추후 이 부분의 submit을 prevent 하여 vue가 axios하도록 구성하게 됩니다.
    -->
        <form action="/">
            <input type="text" value="찾을 값">
            <input type="submit" value="찾기">
        </form>
        <!--
            다중선택 "checkbox"
            input type으로 checkbox를 사용하여 value 값에 선택한 값을 볼 수 있습니다.
            javascript에서 어떤 값을 선택 했는지 처리할 수 있고
            이를토대로 vue쪽에 axios 하는 데이터를 처리할 수 있습니다.
        -->

        <form action="/" style="text-align: left">
            <li><input type="checkbox" value="grammar">Grammar</li>
            <li><input type="checkbox" value="writng">Writng</li>
            <li><input type="checkbox" value="reading">Reading</li>
        </form>
        <!--
            단일선택(radio)
            input type으로 radio 사용하여 value 값에 선택한 값을 볼 수 있습니다.
            단일 선택이 되도록 명확하게 지정하려면
            name값을 모두 같은것으로 지정하여 중복선택이 불가하게 만듭니다
            마찬가지로 javascript에서 어떤 값을 선택 했는지 처리할 수 있고
            이를 토대로 vue쪽에 axios 하는 데이터를 처리할 수 있습니다.
        -->
        <h4>단일 선택</h4>
            <form action="/" style="text-align: left">
            <li>
                <label><input type="radio" Name="subject" value="rust">Rust</label>
            </li>
            <li>
            <label><input type="radio" Name="subject" value="TypeScropt">TypeScropt</label>
            </li>
            <li>
            <label><input type="radio" Name="subject" value="Kotlin">Kotlin</label>
            </li>
        </form>
        <!-- email 및 password 입력이 필요한 상황-->
        <form>
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
    </div>
</template>
<script>
export default {
    
}
</script>
<style scoped>
    table,th,td{
        border: 1px solid #ccc; /**셀 태두리를 만듬 */
    }    
    th{
        padding: 15px;/* 셀 테두리와 내용 사이의 간격(패딩) */
    }
    td{
        padding: 7px;
    }
</style>