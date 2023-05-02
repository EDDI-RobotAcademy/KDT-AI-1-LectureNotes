<template>
  <div style="text-align: left; padding: 20px">
    <h1>Q</h1>
    <h3>
      오늘 풀어봤던 문제 은행 [ 4 ]는 계정을 생성하고 캐릭터 스테이터스를 보내줍니다.
    </h3>
    <h3>이제 계정 여러가지가 생성될 것이고 캐릭터도 여러개 만들텐데</h3>
    <h3>어떤 계정의 어떤 캐릭터인지 알 수 없습니다.</h3>
    <h3>그러므로 로그인 기능을 만들어서 로그인 했을 때 이메일 주소를 보여줍시다.</h3>
    <h3>그리고 계정 선택을 할 수 있게 만들어봅시다.</h3>

    <!-- 
      TODO
        - 계정과 캐릭터List의 연결
        - 캐릭터List의 0번 인덱스만 가져오게 되어있다
          -> 캐릭터 선택 창
    -->

    <hr />
    <div style="text-align: center">
      <div v-if="setAccountPhase">
        <div>
          <v-btn color="primary" @click="chooseSignIn">로그인</v-btn>
          <v-btn color="primary" @click="chooseSignUp">회원가입</v-btn>
        </div>
        <div v-if="signInState">
          <fieldset>
            <input type="text" v-model="userEmail" placeholder="이메일" /><br />
            <input type="password" v-model="userPw" placeholder="비밀번호" /><br /><br />
            <v-btn color="primary" @click="signIn">로그인</v-btn>
          </fieldset>
        </div>
        <div v-if="signUpState">
          <fieldset>
            <input type="text" v-model="newEmail" placeholder="이메일" /><br />
            <input type="password" v-model="newPw" placeholder="비밀번호" /><br />
            <input type="password" v-model="verifyPw" placeholder="비밀번호 확인" /><br />
            <v-btn
              v-if="newPw === verifyPw && newPw != false"
              color="primary"
              @click="signUp"
              >회원가입</v-btn
            >
            <v-btn v-else aria-disabled="true">비밀번호를 확인해주세요.</v-btn>
          </fieldset>
        </div>
      </div>

      <div v-else>
        <p>로그인 중인 계정: {{ myEmail }}</p>
        <br />
        <p>Account ID: {{ myAccountId }}</p>
        <br />
        <div v-if="myCharId.length == 0">
          <p>등록된 캐릭터가 없습니다.</p>
        </div>
        <div v-else>
          <p>Character ID: {{ myCharId }}</p>
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
          <v-btn color="primary" @click="createChar">완료</v-btn>
        </div>
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
  </div>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
      setAccountPhase: true,
      signInState: false,
      signUpState: false,
      createCharState: false,
      showCharInfo: false,

      userEmail: "",
      userPw: "",
      newEmail: "",
      newPw: "",
      verifyPw: "",
      myEmail: "",
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
    chooseSignIn() {
      this.signInState ? (this.signInState = false) : (this.signInState = true);
      this.signUpState = false;
    },

    chooseSignUp() {
      this.signUpState ? (this.signUpState = false) : (this.signUpState = true);
      this.signInState = false;
    },

    chooseSignOut() {},

    charDetails() {
      this.createCharState
        ? (this.createCharState = false)
        : (this.createCharState = true);
    },

    signIn() {
      const { userEmail, userPw } = this;
      axios
        .post("http://localhost:7777/new-character/sign-in", { userEmail, userPw })
        .then((res) => {
          if (res.data.isCurrentInfo) {
            this.setAccountPhase = false;
            this.myEmail = res.data.userEmailInfo;
            this.myAccountId = res.data.userIdInfo;
            localStorage.setItem("signInUserInfo", res.data.userIdInfo);
          } else if (!res.data.isCurrentInfo) {
            alert("이메일 또는 비밀번호를 확인해주세요.");
          }
        });
      // ,mounted() {
      //   this.myAccountId = localStorage.getItem("")
      // };
    },

    signUp() {
      const { newEmail, newPw } = this;
      axios
        .post("http://localhost:7777/new-character/sign-up", { newEmail, newPw })
        .then((res) => {
          if (res.data == false) {
            alert("이미 가입된 이메일입니다!");
          } else {
            alert("회원가입 완료!");
            this.signUpState = false;
            this.signInState = true;
          }
        })
        .catch((res) => {
          alert("이메일/비밀번호를 확인해주세요!");
        });
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

<style></style>
