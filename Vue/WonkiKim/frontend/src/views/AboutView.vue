<template>
  <!-- html 파트는 전부 이 template에서 관리함.-->
  <div class="about">
    <!-- h1은 글ㅏ 크 제일 큰  것-->
    <h1>This is an about page</h1>
    <!-- p는 paragraph로 문단 만드는 html tag-->
    <!--아래와 같이 {{ 자바스크립트 데이터 }}로 쉽게 html내부에 데이터를 추가할 수 있습니다.-->
    <p>{{ msg }}</p>
  </div>
</template>

<script>
//script 파트는 실제 프론트 내에서 데이터를 다룰 때 사용합니다.
// 사실상 javascript 파일이 배치됩니다.
// javascript를 잘 몰라도 사용이 매우 편리하다는이점이 vue의 최대 장점입니다.

export default {
  //데이터는 말 그대로 *.vue 파일이 갖고 있는 데이터를 의미합니다.
  data() {
    // 리턴이 들어가 있어서 뭐가 싶지만 data를 표기할 때 사용하는 문법입니다.
    return {
      // msg 변수에 문자열 "안녕, Vue.js"가 배치되어 있는 상태입니다.
      msg: "hello Vue.js!"
    }
  }  
}

</script>