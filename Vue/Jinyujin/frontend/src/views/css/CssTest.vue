<template>
    <div>
        <h1>Css Test</h1>
        <h2>Web Doc</h2>
        <p>Content: HTML, Desigh: CSS, Data Handle: JavaScript(TypeScipt)</p>
        <section>
            <h2>Who am I?</h2>
            <p>Interest at MSA</p>
        </section>
        <div id="container">
            <h1>Test id</h1>
            <h2 class="accent">Accent Test</h2>
            <p>안녕! <span class="browntext">밤색이닷!</span></p>
            <p class="ns-font">한글 폰트 테스트 - 밤색이닷!</p>
        </div>
        <p><a href="https://threejs.org"><b>Three.js</b></a></p>
        <!-- 자바스크립트로 3d를 표현하는 사이트(게임 만들 때 활용하나봄) -->
        <h1 class="shadow-option1">Micro-Frontend</h1>
        <h1 class="shadow-option2">Micro-Frontend</h1>
        <h1 class="shadow-option3">Micro-Frontend</h1>
        <h1 class="shadow-option4">Micro-Frontend</h1>
        <p class="align-right">오른쪽 정렬</p>
        <p class="align-left">왼쪽 정렬</p>
        <p class="align-center">가운데 정렬: 로모허리넘럼ㄹ;ㅓ  머ㅓㅓ멀ㄴ모로  모놀놈ㄹ;ㅣㅘ롬;노람노   ;롬ㄴㄹㄴ모로모나ㅓ오노  론몬마ㅗ라오ㅓㅏㄻㅇ뇌  뫼ㅏ오나ㅓㅗ머</p>
        <p class="align-justify">양쪽 정렬: 로모허리넘럼ㄹ;ㅓ  머ㅓㅓ멀ㄴ모로  모놀놈ㄹ;ㅣㅘ롬;노람노   ;롬ㄴㄹㄴ모로모나ㅓ오노  론몬마ㅗ라오ㅓㅏㄻㅇ뇌  뫼ㅏ오나ㅓㅗ머</p>
        <!-- 양쪽과 가운데 정렬의 차이를 보려면 이런 긴 문자가 필요 -->
        <div class="box1"></div>
        <div class="box2"></div>
        <div class="box3">box-sizing = "content-box"</div>
        <div class="box4">box-sizing = "border-box"</div>
        <div class="box5"></div>
        <div class="box6"></div>
        <div class="box7"></div>
        <div class="box8"></div>
        <section id="container">
            <p>How much is it?</p>
            <ul>
                <li>Card</li>
                <li>Money</li>
                <li>Bank</li>
            </ul>
        </section>
        <!-- style scoped에서 그냥 컨테이너는 dotted gray, 
            그 컨테이너의 ul을 또 dotted blue로 특정 범주를 지정해줌 -->
        <section id="container2">
            <ul>
                <li>A
                    <ul>
                        <li>B</li>
                        <li>C</li>
                        <li>D</li>
                    </ul>
                </li>
                <li>E
                    <ul>
                        <li>F</li>
                        <li>G</li>
                        <li>H</li>
                    </ul>
                </li>
            </ul>
        </section>
    </div>
</template>

<script>
export default {
   
}
</script>

<style scoped>
    h2 {
        font-size: 20px;
        color: orange;
    }
    p {
        color: blue;
    }
    section {
        width: 96%;
        padding: 15px;
        border: 5px solid gray;
    }
    /* id 설정의 경우 */
    #container {
        width: 600px;
        padding: 15px;
        border: 1px dotted gray;
    }
    /* h2에 직접 accent 집어넣을 때 */
    /* 위에서 h2를 원래 오렌지 색으로 설정했는데 직접적으로 이거만 바꾸고 싶을 때는 이렇게 하면 된다 */
    /* class의 경우엔 아래와 같이(당연히 자바 class 아님) */
    h2.accent {
        background-color: aquamarine;
        color: black;
        padding: 5px;
    }
    /* 이런 케이스에서는 밤색을 입히고 싶어 할 때 */
    .browntext {
        color: brown;
    }
    /* 글꼴 가져오기 */
    @import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@900&display=swap');    
    p.ns-font {
        font-family: 'Noto Sans KR', sans-serif;
        font-size: 30px;
    }
    a {
        text-decoration: none;
    }
    .shadow-option1 {
        color: orange;
        text-shadow: 1px 1px;
    }
    .shadow-option2 {
        text-shadow: 5px 5px 3px #000;
    }
    .shadow-option3 {
        color: blue;
        text-shadow: 7px -7px 5px #000;
    }
    .shadow-option4 {
        margin-top: 30px;
        background-color: #000;
        color: #000;
        text-shadow: 0 0 4px white, 
        0 -5px 4px #ff3, 
        2px -10px 6px #fd3, 
        -2px -15px 11px #f80,
        2px -19px 18px #f20;
    }
    /* 그림자 옵션은 다중으로 가능 */
    .align-right {
        text-align: right;
    }
    .align-left {
        text-align: left;
    }
    .align-center {
        text-align: center;
    }
    .align-justify {
        text-align: justify;
    }
    .box1 {
        width: 400px;
        height: 100px;
        background-color: aqua;
    }
    .box2 {
        width: 500px;
        height: 100px;
        background-color: royalblue;
    }
    /* 박스 사이에 간격 주고 싶은 경우 */
    div {
        margin: 10px;
    }
    .box3 {
        box-sizing: content-box;
        width: 300px;
        height: 150px;
        margin: 10px;
        padding: 30px;
        border: 2px solid red;
    }
    .box4 {
        box-sizing: border-box;
        width: 300px;
        height: 150px;
        margin: 10px;
        padding: 30px;
        border: 2px solid red;
    }
    .box5 {
        margin-right: 10px;
        padding: 20px;
        background: #0094ff;
        float: left;
    }
    .box6 {
        margin-right: 10px;
        padding: 20px;
        background: cadetblue;
        float: left;
    }
    .box7 {
        margin-right: 10px;
        padding: 20px;
        background: darkorchid;
        float: left;
    }
    .box8 {
        padding: 20px;
        background: green;
        float: right;
        border: 1px solid black;
    }
    /* container 내의 모든 ul */
    #container ul {
        border: 1px dotted blue;
    }
    /* container 바로 하위의 ul만 적용 */
    #container2 > ul { 
        border: 1px dotted darkcyan;
    }
    /* 이걸 container로 바꾸면 생성된 ul 각각 dotted blue가 적용됨 */
    /* > 이게 있기 때문에 바로 하위 그니까 ul 내부의 ul들까지 싸그리 dotted darkcyan이 적용되는 것 */
</style>