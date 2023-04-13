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
        </div>

        <h2 class="accent">Accent Test</h2>
            <p>안녕! <span class="browntext">밤색이닷!</span></p>

            <p class="ns-font">dongle dongle kawai 아 영어는 안돼?</p>
            <p class="ns-font">아니 잘 되는구나 ㅋ</p>
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
</style>