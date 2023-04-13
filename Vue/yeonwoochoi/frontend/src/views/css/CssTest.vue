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
            <p class="ns-font">한글 폰트 test - orange</p>
        </div>
    </div>
</template>

<script>

export default {
    
}
</script>
<!-- scoped 이 페이지에서만 적용 (분리 작업 가능)-->
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
    
  @import url('https://fonts.googleapis.com/css2?family=Rubik+Pixels&display=swap');

    .ns-font {
        font-family: 'Rubik Pixels', cursive;
        font-size: 30px;
    }
</style>