<template>
    <div>
    <h1>{{ result }}</h1>
    <!-- <form v-on:submit="onSubmitForm"> -->
    <!-- v-on:submit + e.preventDefault() -->
    <form @submit.prevent="onSubmitForm">
      <input ref="answer" type="text" minlength="4" maxlength="4" v-model="value" />
      <button type="submit">입력</button>
    </form>
    <div>시도: {{ tries.length }}</div>
    <ul>
      <li v-for="t in tries" v-bind:key="t.id">
        <div>{{ t.try }}</div>
        <div>{{ t.result }}</div>
      </li>
    </ul>
  </div>
</template>

<script>
const getNumbers = () => {
  const num = [1, 2, 3, 4, 5, 6, 7, 8, 9];
  const array = [];
  for (let i = 0; i < 4; i++) {
    const random = num.splice(Math.floor(Math.random() * (9 - i)), 1)[0];
    array.push(random);
    console.log(random);
  }
  return array;
};

export default {
    data() {
        return {
            answer: getNumbers(),
            tries: [],
            value: "",
            result: "",
            id: ""
        };
    },
    methods: {
        onSubmitForm(e){
            // e.preventDefault();
            if (this.value === this.answer.join("")) {
        this.tries.push({
          try: this.value,
          result: "홈런",
          id: this.id++
        });
        this.result = "홈런";
        alert("게임을 다시 실행합니다");
        this.answer = getNumbers(); //새 정답 배열 생성
        this.tries = []; //시도수
        this.value = ""; // 입력값
        this.$refs.answer.focus();
    } else {
        //정답 틀렷을때
        if (this.tries.length >= 9) {
          this.result = `10번 넘게 틀려서 실패!! 
          답은 ${this.answer.join(", ")}였습니다`;
          alert("게임을 다시 실행합니다");
          this.answer = getNumbers();
          this.value = "";
          this.tries = [];
          this.$refs.answer.focus();
        }
                // 같은 변수라도 화면에 보여지면 데이터에 넣고
        // 아닐경우 데이터에 넣지 않고 그냥 활용한다.
        let ball = 0;
        let strike = 0;
        const answerArray = this.value.split("").map(v => parseInt(v));
        // const rightAnswerArray = this.answer.split('').map(v => parseInt(v));

        for (let i = 0; i < 4; i++) {
          if (answerArray[i] === this.answer[i]) {
            //숫자 자리수까지 다 맞았을때
            strike++;
          } else if (this.answer.includes(answerArray[i])) {
            //숫자만 정답
            ball++;
          }
        }
                this.tries.push({
          try: this.value,
          result: `${strike} 스트라이크, ${ball} 볼입니다`,
          //``억음부호 ~를 일반으로 누름 영어로는 backtick라고 부름
          //
          id: this.id++
        });
        // console.log(strike, ball);
        this.value = "";
        this.$refs.answer.focus();
      }

      // console.log(this.id);
    }
  }
};
</script>
<style>
    
</style>