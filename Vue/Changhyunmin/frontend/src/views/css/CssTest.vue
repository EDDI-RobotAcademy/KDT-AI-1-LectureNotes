<template>
    <div>
        <h1>Css Test</h1>
        <h2>Web Doc</h2>
        <p>Content: HTML, Design: CSS, Data Handle: JavaScript(TypeScript)</p>
        <section>
            <h2>Who am I?</h2>
            <p>Interest at MSA</p>
        </section>
        <div id="contatiner">
            <h1>Test id</h1> 
            <h2 class="accent">Accent Test</h2>  
            <p>안녕 <span class="browntext">밤색이다!</span></p>        
            <p class="ns-font">Sans Noto Serif - 와 센즈!!</p>
        </div>
        <p><a href="https://threejs.org/"><b>Three.js</b></a></p>
        <h1 class="shadow-option1">shadow</h1>
        <h1 class="shadow-option2">shadow</h1>
        <h1 class="shadow-option3">shadow</h1>
        <h1 class="shadow-option4">shadow</h1>
        <p class="align-right">오른쪽 정렬</p>
        <p class="align-left">왼쪽 정렬</p>
        <p class="align-center">가운대 정렬 이 가운대 정렬로 말하자면 3세기전의 그리스의 철학가인...</p>
        <p class="align-justify">양쪽 정렬  이 양쪽 정렬로 말하자면 4세기전의 그리스의 철학가인...</p>
        <div class="box1"></div>
        <div class="box2"></div>
        <div class="box3">box-sizeing = :"content-box"</div>
        <div class="box4">box-size = "border-box"</div>
        <div class="box5"></div>
        <div class="box6"></div>
        <div class="box7"></div>
        <div class="box8"></div>
        <section id = "container">
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
        width: 900px; 
        /* %로 지정할수도 있음 */
        padding: 15px;
        border: 5px solid gray;
    }
    /* id 설정의 경우 */
    #contatiner{
        width: 97.05%;
        padding: 15px;
        border: 1px dotted rgb(64, 74, 119);
    }
    /*class의 경우엔 아래와 같이(JAVA Class와 다름) . */
    h2.accent{
        background-color: slategray;
        color: black;
        padding: 3px;
    }
    .browntext{
        color: brown;
    }
  /* 폰트 적용
       https://fonts.google.com/noto/specimen/Noto+Sans+KR */
       @import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@900&display=swap');
    .ns-font {
        font-family: 'Noto Sans KR', sans-serif;
    }
    a {
        text-decoration: none;
    }
    .shadow-option1{
        color: #b35151;
        text-shadow: 1px 1px;
    }
    .shadow-option2{
        text-shadow: 5px 5px 3px black;
    }
    .shadow-option3{
        color: #ff6666;
        text-shadow: 5px -5px 5px rgb(158, 158, 158);
    }
    .shadow-option4{
        background-color: #000000;
        color: #000000;
        text-shadow: 0 0 4px #ccc,
        0 -5px 4px rgb(51, 255, 238),
        2px -10px 6px rgb(51, 190, 255),
        -2px -15px 11px rgb(0, 89, 255),
        6px -20px 18px rgb(73, 20, 220)
    }
    .align-right{
        text-align: right;
    }
    .align-left{
        text-align: left;
    }
    .align-center{
        text-align: center;
    }
    .align-justify{
        text-align: justify;
    }
    div {
        margin: 5px;   
    }
    .box1{
        width: 400px;
        height: 100px;
        background-color: aqua;

    }
    .box2{
        width: 500px;
        height: 150px;
        background-color: royalblue;
    }
    .box3{
       box-sizing: content-box;
       width: 300px;
       height: 150px;
       margin: 10px;
       padding: 30px;
       border: 2px solid red;
    }
    .box4{
        width: 300px;
       height: 150px;
       margin: 10px;
       padding: 30px;
       border: 2px solid red;
    }
    .box5{
        margin-right: 10px;
       padding: 20px;
       background: #0094ff;
       float: left;
    }
    .box6{
        margin-right: 10px;
       padding: 20px;
       background: cadetblue;
       float: left;
    }
    .box7{
        margin-right: 10px;
       padding: 20px;
       background: darkorchid;
       float: left;
    }
    .box8{
        padding: 20px;
        background: green;
       float: right;
       border: 1px solid black;
    }
    #container ul{
        border: 1px dotted rgb(136, 21, 69);
    }

    #container2 > ul{
        border: 1px dotted green;
    }

</style>