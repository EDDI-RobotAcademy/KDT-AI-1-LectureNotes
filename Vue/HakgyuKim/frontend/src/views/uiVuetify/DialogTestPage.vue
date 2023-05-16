<template lang="">
  <div>
    <p class="blue lighten-4 red--text">Test</p>
    <p class="green white--text">Test</p>
    <p class="yellow darken-3">Test</p>
    <p class="teal lighten-1 text-center">Test</p>

    <v-btn class="teal lighten-3" rounded @click="btnClick">버튼</v-btn>

    <v-layout justify-center>
      <!-- fullscreen 옵션을 넣으면 전체 화면으로 출력됨 -->
      <v-dialog v-model="isDialogOpened" fullscreen persistent max-width="400">
        <template v-slot:activator="{ on }">
          <v-btn color="primary" dark v-on="on">결제</v-btn>
        </template>
        <v-card>
          <v-card-title class="headline">
            {{ name }}
          </v-card-title>
          <v-card-text>
            <h1>지금 즉시 결제</h1>
            <h3>오늘만 할인률 50%!!! 오늘만 날입니다.</h3>
            <p>두 번 없는 초특급 찬스! 지금 당장 결제하시겠습니까 ?</p>
          </v-card-text>
          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn color="teal darken-1" text @click="btnCancel"> 취소 </v-btn>
            <v-btn color="teal darken-1" text @click="btnPay"> 결제 </v-btn>
          </v-card-actions>
        </v-card>
      </v-dialog>
    </v-layout>
  </div>
</template>
<script>
export default {
  data() {
    return {
      name: "7박 8일 풀 패키지 여행 코스!!",
      isDialogOpened: false,
    };
  },
  methods: {
    btnClick() {
      alert("클릭!");
    },
    btnCancel() {
      alert("취소!");
      this.isDialogOpened = false;
    },
    btnPay() {
      alert("1000만원이 결제되었습니다! 감사합니다 고객님!");
      this.isDialogOpened = false;
    },
  },
};
</script>
<style lang=""></style>
