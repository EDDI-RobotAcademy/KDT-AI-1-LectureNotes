<template lang="">
  <div>
    <v-btn color="primary" @click="charDetails">캐릭터 생성</v-btn>
    <div v-if="createCharState">
      <h4>캐릭터 성별 선택</h4>
      <form action="/" style="text-align: center">
        <li>
          <label>
            <input type="radio" v-model="selectedGender" value="male" />남성
          </label>
        </li>
        <li>
          <label>
            <input type="radio" v-model="selectedGender" value="female" />여성
          </label>
        </li>
      </form>
      <v-btn color="primary" @click="createChar">완료</v-btn>
    </div>
  </div>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
      selectedGender: "male",
      createCharState: false,
    };
  },
  methods: {
    charDetails() {
      this.createCharState
        ? (this.createCharState = false)
        : (this.createCharState = true);
    },

    createChar() {
      const { selectedGender } = this;
      axios.post("http://localhost:7777/new-character/create-character", {
        selectedGender,
      });
      alert("캐릭터 생성 완료!");
      this.createCharState = false;
    },
  },
};
</script>

<style lang=""></style>
