<template lang="">
    <div>
        <h1>Css Test</h1>
        <h2>Web Doc</h2>
        <p>Content : HTML, Design : CSS, Data Handle : JavaScript(TypeScript)</p>
        <section>
            <h2>Who am I ?</h2>
            <p>Interest at MSA</p>
        </section>

        <div id="container">
            <h1>Test id</h1>

        <h2 class="accent">Accent Test</h2>
            <p>안녕! <span class="browntext">밤색이닷!</span></p>

            <p class="ns-font">dongle dongle kawai 아 영어는 안돼?</p>
            <p class="ns-font">아니 잘 되는구나 ㅋ</p>
        </div>

        <p><a href="https://threejs.org/"><b>Three.js</b></a></p>

         <h1 class="shadow-option1">Micro-Frontend</h1>
        <h1 class="shadow-option2">Micro-Frontend</h1>
        <h1 class="shadow-option3">Micro-Frontend</h1>
        <h1 class="shadow-option4">Micro-Frontend</h1>
        <p class="align-right">오른쪽 정렬</p>
        <p class="align-left">오른쪽 정렬</p>
        <p class="align-center">가운데 정렬: 으아나ㅓㄹ아너 인오링ㅁ홈ㅇㄹ허밍림ㄴ 얾닝럼ㄴㅇ리멍 린ㅁㅇ러ㅣㅁ어밇 ㅁ얼힌ㅇㄹ 혼이ㅏㅓ ㄹ화ㅣㅇㄴㅀㄴ 일힌ㅇㄹ혼 잃노일혼 이랗ㄴ 힌ㅇㄹ회</p>
        <p class="align-justify">양쪽 정렬: 으아나ㅓㄹ아너 인오링ㅁ홈ㅇㄹ허밍림ㄴ 얾닝럼ㄴㅇ리멍 린ㅁㅇ러ㅣㅁ어밇 ㅁ얼힌ㅇㄹ 혼이ㅏㅓ ㄹ화ㅣㅇㄴㅀㄴ 일힌ㅇㄹ혼 잃노일혼 이랗ㄴ 힌ㅇㄹ회</p>

    </div>
   


</template>

<script>
export default {

}
</script>
<style scoped>
h2 {
    font-size: 20px;
    color: lightblue;
}

p {
    color: lightskyblue;
}

section {
    width: 96%;
    padding: 15px;
    border: 5px solid mediumslateblue;
}

/* id 설정의 경우 # */
#container {
    width: 600px;
    padding: 15px;
    border: 1px dotted dodgerblue;
}

/* class의 경우엔 아래와 같이 ' . ' */
h2.accent {
    background-color: aquamarine;
    color: red;
    padding: 5px;
}

.browntext {
    color: brown;
}

@import url('https://fonts.googleapis.com/css2?family=Dongle&display=swap');

p.ns-font {
    font-family: 'Dongle', sans-serif;
    font-size: 50px;
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
    background-color: #000;
    color: #000;
    text-shadow: 0 0 4px #ccc,
        0 -5px 4px #ff3,
        2px -10px 6px #fd3,
        -2px -15px 11px #f80,
        2px -19px 18px #f20;
}

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
}</style>