<template>
    <div>
        <h1>CSS</h1>
        <div>            
            <a href="" name="l">1.HTML</a>
            <a href="" name="l">2.CSS</a>
            <a href="" name="l">3.JS</a>
        </div>
        <div>
            <input v-model="test"/>
            <p>testname: {{ test }}</p>
            <p>카운터: {{ number }}</p>
            <button v-no:click="increment">증가</button>
            <button v-on:click="decrement">감소</button>
        </div>
    </div>
</template>
<script>
export default {
    data() {
        return {
            test: "",
            number: 0
        }
    },
    methods: {
        increment: +1,
        decrement: -1
    },
}
</script>
<style>
h1{
    font-size: 200%;
    padding-right: 100em;
    grid-template-columns: 150px 1fr;
}

[name=l]{
    color: #c02c2c;
    padding: 0px 10px 3px  10px;
}
</style>