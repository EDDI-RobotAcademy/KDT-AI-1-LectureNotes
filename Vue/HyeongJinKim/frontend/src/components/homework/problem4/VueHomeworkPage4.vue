<template>
  <div style="text-align: left; padding: 20px">
    <h1>Q</h1>
    <h3>UI 상에서 캐릭터 생성이라는 버튼을 누르면</h3>
    <h3>email과 password를 입력하도록 구성합니다.</h3>
    <h3>완료를 누르면 Backend에서 캐릭터 계정을 생성해줍니다.</h3>
    <h3>또한 캐릭터 스테이터스를 만들어줍니다.</h3>
    <h3>UI 파트에서 플레이 버튼을 누르면</h3>
    <h3>캐릭터 스테이터스를 가져와서 화면에 뿌려줍니다.</h3>

    <hr />

    <h1>A</h1>
    <v-btn color="primary" @click="newChar">새 캐릭터 생성</v-btn>
    <v-btn color="primary" @click="startGame">플레이</v-btn>
    <div v-if="generateCharState">
      ID: <input type="text" v-model="newId" /><br />
      PW: <input type="text" v-model="newPw" /><br />
      <v-btn color="primary" @click="generateChar">완료</v-btn>
    </div>

    <div>
      <h2>캐릭터 정보</h2>
      <p>완력: {{ strength }}</p>
      <p>민첩: {{ dexterity }}</p>
      <p>지능: {{ intelligence }}</p>
      <p>넌 누구니: {{ whoAmI }}</p>
    </div>
  </div>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
      newId: "",
      newPw: "",
      generateCharState: false,

      strength: 0,
      intelligence: 0,
      dexterity: 0,
      whoAmI: 0,
    };
  },
  methods: {
    newChar() {
      this.generateCharState
        ? (this.generateCharState = false)
        : (this.generateCharState = true);
    },

    generateChar() {
      const { newId, newPw } = this;
      axios.post("http://localhost:7777/new-character/create-character-info", {
        idInfo: newId,
        pwInfo: newPw,
      });
      alert("캐릭터 생성 완료!");
      this.generateCharState = false;
    },

    startGame() {
      axios.get("http://localhost:7777/new-character/get-character-info").then((res) => {
        this.strength = res.data.strength;
        this.intelligence = res.data.intelligence;
        this.dexterity = res.data.dexterity;
        this.whoAmI = res.data.whosAccountId;
      });
    },
  },
};
</script>

<style></style>
