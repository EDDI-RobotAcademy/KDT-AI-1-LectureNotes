<template>
  <!-- html(출력)파트는 전부 이 tamplate에서 관리함 -->
  <!-- 화면에 어떻게 뿌려질지 관리하는 곳 -->
  <div class="about">
    <!-- h1은 글자 크기 제일 큰 것-->
    <h1>This is an about page</h1>
    <!-- p는 paragraph로 문단 만드는 html tag
         아래와 같이 {{ 자바스크립트 데이터 }} 로 쉽게 html 내부에 데이터를 추가할 수 있습니다. -->
    <p>{{ msg }}</p>
  </div>
</template>

<script>
// 어떤 효과를 입힐 것인지 여기서 신경써야함
// detail한 부분을 말하는거같음

// script 파트는 실제 front 내에서 데이터를 다룰 때 사용합니다.
// 사실상 javascript 파일이 배치됩니다.
// javascript를 잘 몰라도 사용이 매우 편리하다는 이점이 vue의 최대 장점입니다.
// 리액트와 뷰의 장점을 가진 솔리드라는 프로그램이 있음

export default {
  // 데이터는 말 그대로 *.vue 파일이 가지고 있는 데이터를 의미합니다.
  data () {
    // return이 들어가 있어서 뭔가 싶지만 data를 표기할 때 사용하는 문법입니다.
    return {
      // msg 변수에 문자열 "안녕, Vue.js"가 배치되어 있는 상태입니다.
      msg: "안녕, Vue.js!",
    }
  }  
}

</script>