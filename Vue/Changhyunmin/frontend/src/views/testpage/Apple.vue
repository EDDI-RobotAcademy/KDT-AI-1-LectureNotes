<template lang="">
    <div>
        <form @submit.prevent="onSubmit">
            <table>
                <tr>
                    <td>상품명</td>
                    <td>
                        <input type="text" v-model="name"/>
                    </td>
                </tr>       
                <tr>
                    <td>조리방식</td>
                    <td><input type="text" list="depList">                          
                <datalist id = "depList">
                    <option value="래인지용"></option>
                    <option value="비건용"></option>
                    <option value="냄비용"></option>
                    <option value="에어후라이용"></option>
                </datalist>
                    </td>
                </tr>
                <tr>
                    <td>상품 가격</td>
                    <td>
                        <input type="text">
                    </td>
                </tr>
                <tr>
                    <td>상품 사진</td>
                    <td>
                        <input type="file" accept="image/*"/>
                    </td>
                </tr>        
                <tr>
                    <td>제조사</td>
                    <td>
                        <input type="text">
                    </td>
                </tr>
                <tr>
                    <td>유통기한</td>
                    <td>
                        <input style="width:150px; height:30px;" type="text"> ~
                        <input style="width:150px; height:30px;" type="text">
                    </td>                 
                    <td>
                        
                    </td>
                </tr>
            </table>    
            <!-- <div class="search">
                <input type="text" placeholder="검색어 입력">
                <img src="https://s3.ap-northeast-2.amazonaws.com/cdn.wecode.co.kr/icon/search.png">
            </div> -->

            <!-- <div>
                <button type="submit">등록</button>
                <router-link :to="{ name: 'BoardListPage' }">
                    취소
                </router-link>
            </div> -->
        </form>
    </div>
</template>
<script>
export default {
data() {
    return {
        
    }
},
    
}
</script>
<style scoped>
    .search {
  position: relative;
  width: 300px;
}

input {
  width: 100%;
  border: 1px solid #bbb;
  border-radius: 8px;
  padding: 10px 12px;
  font-size: 14px;
}

img {
  position : absolute;
  width: 17px;
  top: 10px;
  right: 12px;
  margin: 0;
}
</style>