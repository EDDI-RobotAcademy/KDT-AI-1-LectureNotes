<template>
    <div>
        <h1>Css Test</h1>
        <h2>Web Doc</h2>
        <p>Content: HTML, Design: CSS, Data Handle: JavaScript(TypeScript)</p>
        <section>
            <h2>Who am I ?</h2>
            <p>Interest at MSA</p>
        </section>
        <div id="container">
            <h1>Test id</h1>
            <h2 class="accent">Accent Test</h2>
            <p>안녕! <span class="browntext">밤색이닷!</span></p>
            <p class="ns-font">한글 폰트 테스트 - 밤색이닷!</p>
        </div>
        <p><a href="https://threejs.org">ThreeJs</a></p>
        <h1 class="shadow-option1">Micro-Frontend</h1>
        <h1 class="shadow-option2">Micro-Frontend</h1>
        <h1 class="shadow-option3">Micro-Frontend</h1>
        <h1 class="shadow-option4">Micro-Frontend</h1>
        <p class="align-rignt">오른쪽 정렬</p>
        <p class="align-left">왼쪽 정렬</p>
        <p class="align-center">가운데 정렬: ㄴㅁㄹ어ㅏㅣㅣ ㅣㅣㅣ ㅣㅣㅣㅣ ㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣ; 험ㄴ;ㅣㅏ허ㅣ남 엏;ㄴㅁ어ㅏㅎ;ㅣ</p>
        <p class="align-justify">양쪽 정렬:  ㄴㅁㄹ어ㅏㅣㅣ ㅣㅣㅣ ㅣㅣㅣㅣ ㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣ; 험ㄴ;ㅣㅏ허ㅣ남 엏;ㄴㅁ어ㅏㅎ;ㅣ</p>
        <div class="box1"></div>
        <div class="box2"></div>
        <div class="box3">box-sizing="content-box"</div>
        <div class="box4">box-sizing="border-box"</div>
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
        color: rgb(50, 211, 252);
    }
    section {
        width: 96%;
        padding: 15px;
        border: 5px solid gray;
    }
    /* id 설정의 경우 # */
    #container {
        width: 600px;
        padding: 15px;
        border: 1px dotted gray;
    }
    /* class의 경우엔 아래와 같이 . */
    h2.accent {
        background-color: aquamarine;
        color: black;
        padding: 5px;
    }
    .browntext {
        color: brown;
    }
    /* 폰트 적용
       https://fonts.google.com/noto/specimen/Noto+Sans+KR */
    @import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@900&display=swap');
    p.ns-font {
        font-family: 'Noto Sans KR', sans-serif;
        font-size: 30px;
    }
    a{
        text-decoration:none;
    }
    .shadow-option1 {
        color : orangered;
        text-shadow: 1px 1px

    }
    .shadow-option2{
    
        text-shadow: 3px 3px;
    }
    .shadow-option3{
        color: rgb(211, 7, 7);
    text-shadow: 7px -7px 2px #813059;
}
.shadow-option4{
    background-color: #4e4b4b;
    color: #4e3030;
    text-shadow: 0 0 4px #ccc,
     0 -5px 4px rgb(194, 130, 70),
     2px -10px 6px rgb(211, 165, 38),
     -2px -15px 7px #f80,
     2px -19px 18px rgb(204, 47, 22);
}
.align-left{
    text-align: left;
}
.align-right{
    text-align: right;
}
.align-center{
    text-align: center;
}
.align-justify{
    text-align: justify;
}
.box1{
    width: 400px;
    height: 100px;
    background-color: aqua;

}
.box2{
    width: 500px;
    height: 100px;
    background-color: crimson;

}
.box3{
    box-sizing: content-box;
    width: 300px;
    height: 150px;
    margin: 10px;
    padding: 30px;
    border: 2px solid #e40707;
}
.box4{
    box-sizing: border-box;
    width: 300px;
    height: 150px;
    margin: 10px;
    padding: 30px;
    border: 2px solid #e40707;

}
.box5{
    margin: 10px;
    padding: 20px;
    background: #0094ff;
    float: left;

}
.box6{
    margin: 10px;
    padding: 20px;
    background: #5fa6d8;
    float: left;
}
.box7{
    margin: 10px;
    padding: 20px;
    background: #f01acc;
    float: left;
}
.box8{
    padding: 20px;
    background: #3bdfeb;
    float: right;
    border: 1px solid black;
}

div{
    margin: 10px;
}/* container 내의 모든 ul */
#container ul{
    border: 1px dotted blue;
}/* container 바로 아래 ul */
#container2 > ul{
    border: 1px dotted rgb(28, 248, 248);

}
    </style>