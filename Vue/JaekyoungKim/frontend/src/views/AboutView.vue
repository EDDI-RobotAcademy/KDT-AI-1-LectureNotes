<template>
  <!--html 파트는 전 부 이 템플릿에서 관리한다.-->
  <div class="about">
    <!-- h1은 글자 크기가 제일 큰것-->
    <h1>This is an about page</h1>
  
    <!-- p는 paragraph로 문단 만드는 html tag-->
    <p> {{ msg }}</p>
  </div>

</template>
<script>

//script 파트는 실제  front 내에서 데이터를 다룰때 사용합니다.
  //사실상 javascript 파일이 배치됩니다. javascript를 잘 몰라도 사용이 매우 편리하다는 이점이  vue의 최대 장점입니다.
  export default{
    // 데이터는 말 그대로 *.vue 파일이 가지고 있는 데이터를 의미합니다.
    data() {
      // retunr이 들어가 있어서 뭔가 십짐ㄴ data를 표기할 때 사용하는 문법입니다.
      return {
        //msg  변수에 문자열 "안녕, vue.js"가 배치되어 있는 상태입니다.
        msg: "안녕, vue.js!",
      }
    }
  }
</script>
