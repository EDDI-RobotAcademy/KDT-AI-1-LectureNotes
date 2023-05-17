<template>
    <div id="app">
        <div><span>a= </span><input type="text" v-model="a"></div>
        <div><span>b= </span><input type="text" v-model="b"></div>
        <p></p> 
        <button @click="onClickPlus">덧셈</button>
      <pre>{{ result }}</pre>
    </div>
  
  </template>
  
  <script>
  export default {
    data () {
        return {
            result: '0'
  
        }
    },
    methods: {
      onClickPlus(){
        //01.덧셈계산기
      this.result= parseInt(this.a) + parseInt(this.b)
      }
    },
  }
  </script>
  
  <style>
    
  </style>