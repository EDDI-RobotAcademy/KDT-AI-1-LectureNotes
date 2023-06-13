<!-- 
    3. vue에서 select option을 사용해서 A, B 두 개의 옵션을 넣고
    옵션을 선택하면 옵션 정보를 출력하도록 만들어봅시다.
-->

<template lang="">
    <v-container>
    <div>
        <select v-model="whatOption" class="select-css">
            <option value = '' disabled selected>== 선택해주세요. ==</option>
            <option value="AA">AA</option>
            <option value="BB">BB</option>
            
        </select>
<br><br>
        {{ whatOption }}
    </div>
    </v-container>
</template>
<script>
export default {

    data() {
        return {
            whatOption: ''
        }
    },

}
</script>
<style scoped>
.select-css {
    background-color: red;
}
</style>