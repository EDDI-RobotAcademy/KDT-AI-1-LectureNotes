<template>    
<div>  
  <main>
  <div>
    <h3>오류가 발생할까?</h3>
  </div>
  </main>
    <div class="spinner-div" v-if="isLoading">
        <q-spinner-cube
        color="primary"
        size="5em"
        />
    </div>
    <p :style="{ height, width: computedWidth }"
            class="SkeletonBox"/>   
<table>
    <div>
     어지럽다
    </div>
    <div id="app">
		<div
			v-for="(item, index) in list"
			:key="item.name"
			:class="item.value ? 'checked' : ''"
		>
			<input type="checkbox" @change="changeCheck(index)" />
			{{ item.name }}
		</div>
		<button @click="add">add</button>
	</div>
    <tr>
        <td>
        <div>
            <v-btn icon >
                <v-icon >mdi-heart</v-icon>
            </v-btn>
            <input class="bar" type="search" placeholder="답변해드립니다.">
            <v-btn icon>
          <v-icon >mdi-dots-vertical</v-icon>
        </v-btn>  
        <div>
          <div class="static" title="기본적으로 볼수 있는 형태">position: static;</div>
          <div class="relative" title="균등한 값을 주는 레이어같다">position: relative;</div>
          <div class="absolute" title="쌓이는 레이어라고 생각하면 편하다">position: absolute;</div>
          <div class="fixed" title="움직이는 광고">
            position: fixed
              <li><a href="http://localhost:8080/animetion">11</a></li>
              <li><a href="http://localhost:8080/test-page1">testpage</a></li>
          </div>
        </div>  
        <div>
          <form action="">
            <h3>input</h3>
            <input type="button" value="클릭 | "><br>
          <input type="checkbox"><br>
          <input type="color"><br>
          <input type="date"><br>
          <input type="datetime-local"><br>
          수신인: <input type="email"><br>
          <input type="file"><br>
          아이디: <input type="text"><br>
          비밀번호: <input type="password"><br>
          <input type="hidden" id="gameToken" name="game_token" value="xm234jq"><br>
          <input type="submit"><br>
          <input type="image" src="@/views/testpage/이미지.png" alt="제출버튼"><br>
          <input type="month"><br>
          <input type="number" min="2" max="20" step="2"><br>
          <input type="radio">10대<br>
          <input type="range" min="10" max="60" step="10"><br>
          <input type="reset"><br>
          <input type="search"><br>
          전화번호: <input type="tel"><br>
          <input type="time"><br>
          블로그주소<input type="url"><br>
          <input type="week"><br>
          </form>          
        </div>
        <div>
          <div class="test-path test-path-polygon" title="삼각형css">
          <div class="testpath testpathpolygon">
            <div class="path path-polygon"></div>
          </div>              
        </div>
            <p class="long" >장문</p>
            <button v-on:click="alertDialogBox">alert 대화 상자</button>    
            <a href="#" class="Top">a</a>       
        </div>  
        <button class="box1" padder="center">box</button>  
        </div> 
        </td>
    </tr>
</table>
<form>
  <fieldset class="box2">
    <legend>개인 정보 입력</legend>
    이름 : <input type="text" name="name" required/><br/>
    주민번호 : <input type="text" name="security_number" pattern="\d{6}\-\d{7}"
     title="123456-1234567 형식으로 입력해주세요"/><br/>
      ID : <input type="text" name="id"><br/>
     Password : <input type="password" name="password"/><br/>
     성별 : 남 <input type="radio" name="gender">
     여 <input type="radio" name="gender"><br/>
     관심사 : 연예 <input type="checkbox" name="checkbox1">
              스포츠 <input type="checkbox" name="checkbox2">
              IT <input type="checkbox" name="checkbox3"><br/>
  </fieldset>
  <fieldset class="box3" >
  <legend>개인 정보 입력</legend>
  <h3>지역선택</h3>
  <select name="city2" size="4" multiple>
    <option>성남시</option>
    <option>수원시</option>
    <option>용인시</option>
    <option>안양시</option>
    <option>과천시</option>
    <option>하남시</option>
  </select><br><br>
  <h3>지역선택</h3>
  <select name="city1">
    <optgroup label="서울">
      <option>송파구</option>
      <option>강남구</option>
      <option>서초구</option>
      <option>중구</option>
    </optgroup>

    <optgroup label="경기도">
      <option>성남시</option>
      <option>수원시</option>
      <option>용인시</option>
      <option>안양시</option>
    </optgroup>
  </select>
</fieldset>
<fieldset class="box4">
  <legend>개인 정보 입력</legend>
  가입 인사<br>
  <textarea name="comment" cols="30" rows="7" placeholder="안녕하세요."></textarea>
</fieldset>
<fieldset>
  <legend> < number ></legend>
  number : <input type="number" min="0" max="100" step="10" name="number">
</fieldset>
  <br><br>
<fieldset>
  <legend>< range ></legend>
  range : <input type="range" min="0" max="100" step="10" name="range">
</fieldset>
</form>
<div>
  <span>web</span>
<span class="test">Is</span>
<span class="test">Free</span>
<span class="test">Com</span><br>
<span class="test2">특수기호</span>
</div>
<footer>
  <div>
    <p>2023-5-12구현</p>
    
  </div>
</footer>
</div>
</template>

  
  <script>
  export default {
    data() { 
       
		return {
      
			list: [],
            isLoading: true, 
		};
    
	},
  
	methods: {
		add() {
			this.list.push({
				name: Math.floor(Math.random() * 10000 + 1),
				value: false
			});
		},
		changeCheck(index) {
			this.list[index].value = !this.list[index].value;
		},
        handleScroll(){
            this.btnShow = window.scrollY > 400;
        },
        alertDialogBox() {
        alert("확인을 누를 때 까지 다른 작업을 할 수 없어요!")
      },  
    
    beforeMount() {
        window.addEventListener("scroll",this.handleScroll);
    },
    beforeDestroy() {
        window.removeEventListener("scroll", this.handleScroll);
    },

    name: `SkeletonBox`,

    props: {
      maxWidth: {
        default: 100,
        type: Number
      },
      minWidth: {
        default: 80,
        type: Number
      },
      height: {
        default: `1em`,
        type: String
      },
      width: {
        default: null,
        type: String
      }
    },
    
    computed: {
      computedWidth () {
        return this.width || `${Math.floor((0.9 * (this.maxWidth - this.minWidth)) + this.minWidth)}%`
      }
    }  
  }
}
  </script>
  
  <style lang="scss">
  .SkeletonBox {
    padding: 1rem 50rem;
    display: inline-block;
    position: relative;
    vertical-align: middle;
    overflow: hidden;
    background-color: #DDDBDD;
    &::after {
      position: absolute;
      top: 0;
      right: 0;
      bottom: 0;
      left: 0;
      transform: translateX(-100%);
      background-image: linear-gradient(
        90deg,
        rgba(#fff, 0) 0,
        rgba(#fff, 0.2) 20%,
        rgba(#fff, 0.5) 60%,
        rgba(#fff, 0)
      );
      animation: shimmer 5s infinite;
      content: '';
    }
    @keyframes shimmer {
      100% {
        transform: translateX(100%);
      }
    }
  }
.bar{
width: auto;
border: 1px solid#f1f1f1;
border-radius: 5px 5px 5px 5px;
box-shadow: 2.5px 2.5px 5px #979797;
background:linear-gradient(to right, #eeedee , #eeedee 80%) ;    
} 
.checked{
    color: red;
}
.long{
    width: 100px;
    padding: 400px 300px;
    bottom: 20px;
    box-shadow: 2.5px 2.5px 5px #979797;

}   
.static{
  position: static;
  width: 200px;
  border:  1px solid #cfcfcf;
  text-align: center;
  line-height: 100px;
  background: #e4e4e4;
  margin-bottom: 10px;
}
.relative{
  position: relative;
  width: 200px;
  border:  1px solid #cfcfcf;
  text-align: center;
  line-height: 100px;
  background: #e4e4e4;
  margin-bottom: 10px;
}
.absolute{
  position: absolute;
  width: 200px;
  border:  1px solid #cfcfcf ;
  text-align: center;
  line-height: 100px;
  background: #e4e4e4;
  right: 0;
  margin-right: 10px;
}
.fixed{
  right: 12rem;
  position: fixed;
  width: 150px;
  border:  1px solid #cfcfcf ;
  text-align: center;
  line-height: 75px;
  background: #e4e4e4;
  text-shadow: 3px 3px 4px #000000;

}
input{
  left: auto;
}
li {
  height: 3rem;
  text-align: left;
  line-height: 1rem;
}
.Top{
  width: 40px;
  height: 40px;
  background-image: url('@/assets/logo.png');
  position: fixed;
  right: 30px;
  bottom: 30px;
  display: none;
}
.box1{
  display: inline-block;
    position: relative;
    vertical-align: middle;
    overflow: hidden;
    background-color: #DDDBDD;
    padding: 2rem 30rem;
    &::after {
      position: absolute;
      top: 0;
      right: 0;
      bottom: 0;
      left: 0;
      transform: translateX(-100%);
      background-image: linear-gradient(
        90deg,
        rgba(#707070, 0) 0,
        rgba(#7e7c7c, 0.2) 20%,
        rgba(#707070, 0.5) 60%,
        rgba(#fff, 0)
      );
      
      animation: shimmer 5s infinite;

      content: '';
    }
    @keyframes shimmer {
      100% {
        transform: translateX(100%);
      }
    }
}
.test::before {
  content: '-';
}
.test2::after {
    content: '&nbsp;';
}
.test-path{
  width: 300px;
  height: 300px;
  text-align: center;
  line-height: 300px;
  font-weight: bold;
  background: #5f868a;
  position: absolute;

}
.test-path-polygon{
  clip-path: polygon(100px 0px, 200px 200px, 0 200px);
}
.testpath{
  width: 300px;
  height: 300px;
  text-align: center;
  line-height: 300px;
  font-weight: bold;
  background: #74a7a8;
  // opacity: 90%;
  position: absolute; top: 30px;left: 25px;
}
.testpathpolygon{
  clip-path: polygon(75px 0px, 150px 150px, 0 150px);
}
.path{
  width: 300px;
  height: 300px;
  text-align: center;
  line-height: 300px;
  font-weight: bold;
  background: #5fd4af;
  position: absolute; top: 30px; left: 22.5px;

}
.path-polygon{
  clip-path: polygon(50px 0px, 100px 100px, 0 100px);
}
legend{
  width:8em;
}
fieldset{
  width: 18rem;
}
.box2{
  float: left;
  border-right: 0%;
}
.box3{
  float: left;
  display: inline-block;
  margin: 1rem;
}
.box4{
  float: left;
  display: inline-block;
}
h3{
  margin: 0%;
  padding: 0;
}
  </style>