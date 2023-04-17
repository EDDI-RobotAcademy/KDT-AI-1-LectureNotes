<template>
    <div id="app">
        <b>뺼셈계산기</b>
        <p></p>
        <div><span>a= </span><input type="text" v-model="a"></div>
        <div><span>b= </span><input type="text" v-model="b"></div>
        <p></p>
        <button @click="onClickSubtract">뺄셈</button>
      <pre>{{ result }}</pre>
      <p></p>
      <b>2배계산기</b>
        <p></p>
      <div><span>c= </span><input type="text" v-model="c"></div>
      <p></p>
        <button @click="onClickX2">2배로 만들기</button>
        <pre>{{ result2 }}</pre>
        <b>계산기</b>
        <p></p>
        <div><span>num1= </span><input type="text" v-model="num1"></div>
        <div><span>num2= </span><input type="text" v-model="num2"></div>

        <p></p>
        
        <button @click="onClickPlus">덧셈</button>
        <button @click="onClickSubtract2">뺄셈</button>
        <button @click="onClickMultiply">곱셈</button>
        <button @click="onClickDivide">나눗셈</button>
        <pre>{{ result3 }}</pre>

    </div>
   


  </template>
  
  <script>
  export default {
    data () {
        return {
            result: '0',
            result2: '0',
            result3: '0'
        }
    },
    methods: {
      //02.뺄셈계산기
     onClickSubtract(){
      this.result= parseInt(this.a) - parseInt(this.b)     
      },
     //03.곱셈 계산기
      onClickX2(){
        this.result2= parseInt(this.c *2)
      },


     //04.계산기
      onClickPlus(){
        this.result3= parseInt(this.num1) + parseInt(this.num2)     
      },
     
      onClickMultiply(){
        this.result3= parseInt(this.num1) * parseInt(this.num2)     
      },
     
      onClickDivide(){
        this.result3= parseInt(this.num1) / parseInt(this.num2)     
        },
     
      onClickSubtract2(){
        this.result3= parseInt(this.num1) - parseInt(this.num2)
      }
      //05.checkbox
  }
}
  </script>
  
  <style>
    
  </style>