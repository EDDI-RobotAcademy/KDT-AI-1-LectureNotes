<template>
    <div>
        <h1>Css Test</h1>

        <h2>Web Doc</h2>

        <p>Content: HTML, Design: CSS, Data Handle: JavaScript(TypeScript)</p>
        
        <section>
            <h2>Who am I?</h2>
            <p>Interest at NSA</p>
        </section>
       
        <div id="container">
            <h1>Test id</h1>
            <h2 class="accent">Accent Test</h2>
            <p>안녕!<span class="browntext">밤색이닷!</span></p>
            <p class= "ns-font">한글 폰트 테스트1- 밤색이닷!</p>
            <p class= "hm-font">한글 폰트 테스트2- 밤색이닷!</p>
        </div>

        <p><a href="https://threejs.org"><b>Three.js</b></a></p>
        <h1 class="shadow-option1">Micro - Frontend</h1>
        <h1 class="shadow-option2">Micro - Frontend</h1>
        <h1 class="shadow-option3">Micro - Frontend</h1>
        <h1 class="shadow-option4">Micro - Frontend</h1>

        <p class="align-right">오른쪽 정렬</p>
        <p class="align-left">왼쪽 정렬</p>
        <p class="align-center">가운데 정렬 : ㅣ나어라니어린ㅇㄹ 이나런이ㅏㅓ리낭 ㄴ이ㅏ러나ㅣ어 니아러니ㅏ얼  ㄴ이ㅏ러ㅣㅏㄹ히ㅏㅇ ㄴㅇ러ㅣㅏㄴ어린ㄴ이린;ㅇㄹ;ㅣㄴ 으린;ㅡㅇㄹ;ㅣㅡ니르 니을ㄴ ;을ㄴ 으리;능 ㄹ; 니이ㅡㄹ; 늬;</p>
        <p class="align-justify">양쪽 정렬 : ㅣ나어라니어린ㅇㄹ 이나런이ㅏㅓ리낭 ㄴ이ㅏ러나ㅣ어 니아러니ㅏ얼  ㄴ이ㅏ러ㅣㅏㄹ히ㅏㅇ ㄴㅇ러ㅣㅏㄴ어린ㄴ이린;ㅇㄹ;ㅣㄴ 으린;ㅡㅇㄹ;ㅣㅡ니르 니을ㄴ ;을ㄴ 으리;능 ㄹ; 니이ㅡㄹ; 늬;</p>
        <div class="box1"></div>
        <div class="box2"></div>
        <div class="box3">box-sizing - "content-box"</div>
        <div class="box4">box-sizing - "border-box"</div>
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
        <section id="container2">
            <ul>
                <li>A
                    <ul>
                        <li>a</li>
                        <li>b</li>
                        <li>c</li>
                    </ul>
                </li>
                <li>B
                    <ul>
                        <li>a</li>
                        <li>b</li>
                        <li>c</li>
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
    h1{
        color: rgb(147, 93, 168);
    }
    h2 {
        font-size: 20px;
        color: rgb(197, 135, 221);
    }
    p {
        color: rgb(224, 185, 240);
    }
    section {
        width: 96%;
        padding: 15px;
        border: 5px solid rgb(205, 198, 207);
    }

    /* id 설정의 경우 '#'을 사용함*/
    #container {
        width: 96%;
        padding: 15px;
        border: 5px dotted rgb(205, 198, 207);
    }

    /* class(java의 class와 다름)의 경우엔 아래와 같이 '.'을 사용함*/
    h2.accent {
        background-color: rgb(174, 226, 209);
        color: black;
        padding: 5px;
    }
    .browntext {
        color: brown;
    }
    /*
    폰트 적용
    폰트 url 사이트 - https://fonts.google.com/?subset=korean&noto.script=Kore
    */
    @import url('https://fonts.googleapis.com/css2?family=Hahmlet&family=Noto+Sans+KR:wght@100&display=swap');
    .ns-font {
        font-family: 'Noto Sans KR', sans-serif;
        font-size: 30px;
    }
    .hm-font {
        font-family: 'Hahmlet', serif;
        font-size: 30px;
    }

    /* 밑줄 없애기*/
    a {
        text-decoration: none;
    }
    .shadow-option1 {
        color: orange;
        text-shadow: 1px 1px;
    }
    .shadow-option2 {
        color: orange;
        text-shadow: 5px 5px 3px #000;
    }
    .shadow-option3 {
        color: #211ee7;
        text-shadow: 3px -5px 3px #000;
    }

    .shadow-option4 {
        background-color: #000;
        color: #000;
        text-shadow: 0 0 4px #ccc, 
        0 -5px 4px #ff3, 
        2px -10px 6px #fd3,
        -2px -15px 11px #f80,
        2px -19px 18px #f20;
    }

    /* 정렬하기 */
    .align-left {
        text-align: left;
    }
    .align-right {
        text-align: right;
    }
    .align-center {
        text-align: center;
    }
    .align-justify {
        text-align: justify;
    }

    /* 박스 */
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
    div {
        margin: 10px;
    }
    .box3 {
        box-sizing : content-box;
        width: 300px;
        height: 150px;
        margin: 10px;
        padding: 30px;
        border: 2px solid red;
    }
    .box4 {
        box-sizing : border-box;
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
    #container2 > ul{
        border: 1px dotted darkcyan;
    }
</style>