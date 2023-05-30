<template>
    <div class="html">
        <user-id/>
        <!-- <a>는 링크를 집어넣을때 사용하며 href 속성이 있어야한다.(주소넣을때 사용)-->
        <a href="http://www.tcpschool.com">티씨피스쿨 사이트로 이동!</a>
        <p>이 문장은 일반 텍스트입니다.</p>
        <!-- <b>는 단순히 텍스트를 굵게만든다.-->
        <p><b>이 문장은 단순히 굵게 표현된 텍스트입니다.</b></p>
        <!-- <abbr>은 >"이 문장의"< 설명을 더하는데 사용한다.-->
        <p><abbr title="International Olympic Committee">IOC</abbr>
        (국제 올림픽 위원회)는 스위스 로잔에 본부를 둔 국제 스포츠 기구이다.</p>
        <!-- <footer> 요소가 포함되어 있는 문서나 
            섹션에 대한 아래와 같은 정보를 포함합니다. (솔직히 뭔말인지 모르겠다.)-->
        <footer>
            <p>Copyright © 2018 tcpschool.co.,Ltd. All rights reserved.</p>
            <!--<address> 문장의 상하 좌우로 뛰어준다.(중요한 문장이 있을떄 좋겠다.)-->
            <address>    
                <!--<br> 줄바꿈을 정의할 때 사용된다 (println같은 느낌)-->  
                서울시 강남구 역삼동<br>
                Tel: (02)123-4567 | Fax: (02)234-5678
            </address>
        </footer>
        <!--<article> 뉴스나 포스팅에 사용한다고 함(잘 사용은 안할것 같다)-->
        <article>
            <!--<h2>문자열의 크기 1~6으로 갈수록 작아진다-->
            <h2>2월 19일 날씨 정보</h2>
            <!--<h3>-->
            <h3>서울</h3>
            <!--<h3>-->
            <p>맑음</p>
            <h3>대전</h3>
            <p>흐림</p>
            <h3>부산</h3>
            <p>비</p>
        </article>

        <h2>과메기</h2>
            <p>과메기는 경상북도 포항 지역의 특산물로 청어나 꽁치를 추운 겨울 동안 얼렸다 녹였다를 반복하여 반건조시킨 음식이다.</p>
        <!--<aside> 내용의 연관성은 있으나 분리 시킬 수 있는 페이지를 정의한다.-->
        <aside>
            <h4>포항</h4>
            <p>포항시는 대한민국 경상북도 동해안에 위치하고 있으며, 포항시 중심을 관통하는 형산강이 영일만에 유입되면서 
            넓은 충적평야를 형성하고 있다.</p>
        </aside>
        <!--<ul>마커로 사용된다.-->
        <ul>
            <!--<li>ul(마커),ol(숫자 (ex: 1. @@@))에서 사용하는 마크로 사용된다.-->
            <li><bdi>홍길동</bdi> - 1등</li>
            <!--<bdi> 주위의 텍스트들과는 다른 방향으로 써지는 텍스트 영역을 정의할 때 사용합니다.(아랍어 말고는 별로 안쓸거같다.)-->
            <li><bdi>John Smith</bdi> - 2등</li>
            <li><span>John Smith</span> - 2등</li>
            <li><bdi>تیز سمی</bdi> - 3등</li>
            <li><span>تیز سمی</span> - 3등</li>
            <p>연습</p>
            <li>연습</li>
        </ul>
            <p>이 단락은 왼쪽부터 오른쪽 방향으로 써질 것입니다.</p>
            <!--<bdo>문자의 방향을 정 반대로 마든다.(dir="rtl"와 함께 사용된다.) -->
            <p><bdo dir="rtl">이 단락은 오른쪽부터 왼쪽 방향으로 써질 것입니다.</bdo></p>
            <blockquote>
            이 단락은 왼쪽부터 오른쪽 방향으로 써질 것입니다.          
            CSS의 사용을 권장한다.
            </blockquote>
            <p></p>
            <p>
            HTML은 HyperText Markup Language의 약자입니다.
            웹 페이지는 HTML 문서라고도 불리며,
            HTML 태그들로 구성됩니다.
            </p>
            <p>
            HTML은 HyperText Markup Language의 약자입니다.<br>
            웹 페이지는 HTML 문서라고도 불리며,<br>
            HTML 태그들로 구성됩니다.
            </p>
            <p></p>
            <button type="button" onclick="alert('Hello World!')">클릭해 보세요!</button>
            <canvas id="myCanvas" style="border: 2px solid black">
            이 문장은 사용자의 웹 브라우저가 canvas 요소를 지원하지 않을 때 나타납니다!
            </canvas>  
            
            <table>
                <caption>분식</caption>
            <tr>
                <th>밥류</th><br>
                <th>면류</th><br>
                <th>분식류</th><br>
            </tr>
            </table>
            <p><cite>Mona Lisa</cite> 레오나르도 다 빈치, 1503년</p>
            <p>다음은 자바 코드의 일부분입니다.</p>
            <code>System.out.println(var);</code>
            <table>
                <colgroup>
                    <col style="background-color: lightgreen">
                    <col span="2" style="background-color: yellow">
                </colgroup>
                <tr>
                    <th>학번</th>
                    <th>이름</th>
                    <th>학과</th>
                </tr>
                <tr>
                    <td>2006123456</td>
                    <td>홍길동</td>
                    <td>전자공학과</td>
                </tr>
            </table>
            <table>
                <colgroup span="2" style="background-color: lightpink"></colgroup>
                <tr>
                    <th>학번</th>
                    <th>이름</th>
                    <th>학과</th>
                </tr>
                <tr>
                    <td>2006123456</td>
                    <td>홍길동</td>
                    <td>전자공학과</td>
                </tr>
            </table>
            <table>
                <ol>
                <li><data value="448">작은 마요네즈</data></li>
                <li><data value="450">큰 마요네즈</data></li>
                <li><data value="449">업소용 마요네즈</data></li>
                </ol>
            </table>
            <form action="/exam ples" method="get">
                학과 : <input type="text" name="st_department" list="depList"><br>
                이름 : <input type="text" name="st_name"><br><br>
                <datalist id="depList">
                    <option value="컴퓨터공학과"></option>
                    <option value="영어영문과"></option>
                    <option value="경영학과"></option>
                    <option value="사회체육과"></option>
                </datalist>
                <button type="submit">제출하기</button>
            </form>
            <p></p>
            <dl>
                <dt>호박</dt>
                <dd>- 박과의 한해살이 덩굴성 채소</dd>
                <dt>상추</dt>
                <dd>- 국화과의 한해살이 또는 두해살이풀</dd>
            </dl>
            <p>이 벽화가 그려진 시기는 <del>청동기</del> <ins>구석기</ins> 시대이다.</p>
            <details>
                <summary>오늘의 환율</summary>
                <ul>
                    <li>달러($) : 1,135.90</li>
                    <li>유로(€) : 1,284.08</li>
                    <li>엔(￥) : 1,014.88</li>
                </ul>
            </details>
            <p><dfn>W3C</dfn>는 월드 와이드 웹(WWW)을 위한 표준을 제정하고 관리하는 중립적인 기관입니다.</p>
            <p><dfn title="World Wide Web Consortium">W3C</dfn>는 
                월드 와이드 웹(WWW)을 위한 표준을 제정하고 관리하는 중립적인 기관입니다.</p>
            <p><dfn><abbr title="World Wide Web Consortium">W3C</abbr></dfn>는
                월드 와이드 웹(WWW)을 위한 표준을 제정하고 관리하는 중립적인 기관입니다.</p>
            <dialog open align="center">
                <h2>돼지 저금통</h2>
                <label for="money">지갑에 동전을 얼마 넣을까요?</label>
                <div><input name="amount" id="money" type="number" min="0" step="100" value="100"></div>
                <div><input name="round" type="checkbox">1,000원 단위로 넣기</div>
                <button type="submit" value="saving">동전 넣기</button>
            </dialog>
            <ul>
                <li>파이썬</li>
                <li>자바</li>
                <li>C++</li>
            </ul>
            <p>웹 브라우저에 어떻게 보이는가를 결정짓는 display 속성을 가집니다.</p><br>
            <div><p>div 요소는 다른 HTML 요소들을 하나로 묶는 데 자주 사용되는 대표적인 블록(block) 요소입니다.</p></div>
            <p>span 요소는 텍스트(text)의 특정 부분을 묶는 데 자주 사용되는 인라인(inline) 요소입니다.</p>
            <p size="10">이제 학교 갈 시간이니 어서 일어나렴. <em>얼른!!</em></p>
           <ul>
            <li>
            <div class="name">
                <p>테스트</p>
            <a href="http://localhost:8080/">
                <img width="66px" height="66px" src="@/assets/logo.png">
            </a>    
            </div>
        <div class="price">
            <strong>
                <span>
                    2500
                </span>
            </strong>
        </div>  
           </li>   
           <li>
            <div class="name">
                <p>테스트</p>
            <a href="http://localhost:8080/">
                <img width="66px" height="66px" src="@/assets/logo.png">
            </a>    
            </div>
        <div class="price">
            <strong>
                <span>
                    3000
                    <span> {{ typedText }} </span>
                </span>
            </strong>
        </div>  
        <div>
            <span>안녕</span>
            <span>방가워</span>
            <p>내릴게</p>
            <span>내려갔니?</span>
        </div>
        <table>
            <td>
                <th>
                    와!|
                </th>
                <th>
                    버거!|
                </th>
                <tr>
                    <del color="red"> 신기하다!|</del>
                </tr>
            </td>
        </table>
           </li>
           </ul> 
           <form action="/examples/media/action_target.php" method="get">
            학과: <input type="text" name="st_department" list="depList"><br>
            이름: <input type="text" name="st_name"><br><br>
            <dd>
                확인용
            </dd>
            <datalist id="depList">
                <option value="컴퓨터공학과"></option>
                <option value="영어영문과"></option>
                <option value="경영학과"></option>
                <option value="사회체육과"></option>
                <option value="영상디자인과"></option>
            </datalist>
            <button type="submit" rounded>제출하기</button>
           </form>
           <form action="/examples/media/action_target.php" method="get">
    여러분의 나이대를 골라보세요.<br>
    <input type="radio" name="ages" id="teen" value="teenage">
    <label for="teen">10대</label><br>
    <input type="radio" name="ages" id="twenty" value="twenties">
    <label for="twenty">20대</label><br>
    <input type="radio" name="ages" id="thirty" value="thirties">
    <label for="thirty">30대</label><br>
    <input type="radio" name="ages" id="forty" value="forties">
    <label for="forty">40대 이상</label><br>
    <input type="submit">
</form>
    </div>    
</template>
<script>
import UserID from '@/components/test/UserID.vue';
import UserPassword from '@/components/test/UserPassword.vue';
import UserPassWordCheck from '@/components/test/UserPassWordCheck.vue';
import UserPasswordHint from '@/components/test/UserPasswordHint.vue';
export default {
    components: {
        UserID,
        UserPassword,
        UserPassWordCheck,
        UserPasswordHint

    },
    setup(){
   let typedText= ref('')
   let txt = '타이핑 효과로 글자가 나타납니다.';
   let i = 0;
   const ViewText=()=> {
     if (i < txt.value.length) {
       typedText.value+= txt.charAt(i);
       i++;
       setTimeout(ViewText, 100);
     }
   onMounted(() => {
     ViewText()
   })
   return{
     typedText
     }
    }
   }
}
</script>
<style scoped>

.html {
    background-color: rgb(202, 202, 202);
}
    
</style>