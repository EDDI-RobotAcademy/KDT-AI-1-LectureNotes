<template lang="">
  <div>
    <div v-if="myCharIdList.length > 0">
      <form action="/">
        <table v-for="(character, index) in this.myCharIdList" :key="index">
          <tr>
            <th align="center">성별</th>
            <th align="center">완력</th>
            <th align="center">민첩</th>
            <th align="center">지능</th>
            <th align="center">ID</th>
          </tr>
          <tr v-if="!boards || (Array.isArray(boards) && boards.length === 0)">
            <td colspan="5">등록된 캐릭터가 없습니다.</td>
          </tr>
          <tr v-else v-for="board in boards" :key="board.characterId">
            <td align="center">
              {{ board.characterGender }}
            </td>
            <td align="center">
              {{ board.strength }}
            </td>
            <td align="center">
              {{ board.dexterity }}
            </td>
            <td align="center">
              {{ board.intelligence }}
            </td>
            <td align="center">
              {{ board.characterId }}
            </td>
          </tr>
        </table>
      </form>
    </div>
    <div v-else>
      <p>등록된 캐릭터가 없습니다.</p>
    </div>

    <v-btn color="primary" @click="">캐릭터 선택</v-btn>

    <div v-if="selectedChar != 0">
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
      characterGender: "male",
      strength: 0,
      intelligence: 0,
      dexterity: 0,
      characterId: 0,
      myCharIdList: [],
      selectedChar: 0,
    };
  },
  methods: {
    charChange(event) {
      this.selectedChar = event.target.value;
    },
  },

  mounted: {
    getCharList() {
      const { myAccountId } = this;
      axios
        .post("http://localhost:7777/new-character/get-character-id", {
          myAccountId,
        })
        .then((res) => {
          this.myCharIdList = res.data;
        });
    },
    selectChar() {
      const { myCharIdList } = this;
      axios
        .post("http://localhost:7777/new-character/get-character-info")
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
