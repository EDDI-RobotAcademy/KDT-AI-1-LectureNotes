<template lang="">
    <div>
        <h3>상품목록</h3>
        <table>
            <tr>
                <th width="5%">상품번호</th>
                <th width="70%">상품명</th>
                <th width="10%">상품가격</th>
            </tr>   
            <tr v-if="!buisnesses || (Array.isArray(buisnesses)&& buisnesses.length === 0)">
                <td colspan="3">
                    현재 등록된 물건이 없습니다!
                </td>
            </tr>
            <tr v-else v-for="buisness in buisnesses" :key="buisness.buisnessId">
                <td>
                    {{buisness.buisnessId}}
                </td>
                <td>
                    <router-link :to="{
                        name: 'BuisnessReadPage', 
                        params: {buisnessId: buisness.buisnessId.toString()}}">
                        {{buisness.buisnessId}}    
                    </router-link>
                </td>
                <td>
                    {{buisness.price}}
                </td>
            </tr>
        </table>
    </div>
</template>
<script>
export default {
    
}
</script>
<style lang="">
    
</style>