<template lang="">
  <div>
    <p>로그인 중인 계정: {{ myEmail }}</p>
    <p>Account ID: {{ myAccountId }}</p>
    <div v-if="myCharId.length > 0">
      <form action="/">
        <table v-for="(character, index) in this.myCharId" :key="index">
          <li>
            <label>
              <input type="radio" name="character" />
              {{ index + 1 }} 번 캐릭터 - Character ID: {{ character }}
            </label>
            <!-- radio는 label로 묶은 범위가 클릭 선택 범위 -->
          </li>
        </table>
      </form>
    </div>
    <div v-else>
      <p>등록된 캐릭터가 없습니다.</p>
    </div>

    <div>
      <v-btn color="primary" @click="charDetails">캐릭터 생성</v-btn>
      <v-btn color="primary" @click="getCharList">캐릭터 선택</v-btn>
      <v-btn class="pink white--text" @click="startGame">플레이</v-btn>
    </div>
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
      <!-- Aysnchronous(비동기) 문제가 발생하였음 -->
      <!-- <v-btn color="primary" @click="createChar(), getCharList()">완료</v-btn> -->
      <v-btn color="primary" @click="createCharAndGetCharList()">완료</v-btn>
    </div>

    <div v-if="showCharInfo">
      <h2>캐릭터 정보</h2>
      <p>성별: {{ characterGender }}</p>
      <p>완력: {{ strength }}</p>
      <p>민첩: {{ dexterity }}</p>
      <p>지능: {{ intelligence }}</p>
      <p>넌 누구니: {{ characterId }}</p>
    </div>
  </div>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
      createCharState: false,
      showCharInfo: false,

      characterGender: "",
      selectedGender: "male",

      strength: 0,
      intelligence: 0,
      dexterity: 0,
      characterId: 0,
      myAccountId: 0,

      myCharId: [],
    };
  },
  methods: {
    async createCharAndGetCharList() {
      await this.createChar();
      await this.getCharList();
    },

    createChar() {
      const { selectedGender } = this;
      axios.post("http://localhost:7777/new-character/create-character", {
        selectedGender,
      });
      alert("캐릭터 생성 완료!");
      this.createCharState = false;
    },

    getCharList() {
      const { myAccountId } = this;
      axios
        .post("http://localhost:7777/new-character/get-character-id", {
          myAccountId,
        })
        .then((res) => {
          this.myCharId = res.data;
        });
    },
    startGame() {
      axios
        .get("http://localhost:7777/new-character/get-character-info")
        .then((res) => {
          this.strength = res.data.strength;
          this.intelligence = res.data.intelligence;
          this.dexterity = res.data.dexterity;
          this.characterId = res.data.characterId;
          this.showCharInfo = true;
          this.characterGender = res.data.selectedGender;
        })
        .catch((res) => {
          alert("캐릭터가 없습니다! 먼저 캐릭터를 생성해주세요!");
        });
    },
  },
};
</script>

<style lang=""></style>
