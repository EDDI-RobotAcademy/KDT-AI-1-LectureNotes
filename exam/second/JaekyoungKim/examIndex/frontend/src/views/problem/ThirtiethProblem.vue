<template lang="">
    <div>
        <h3>구매내역 조회</h3>
        <table style="margin: 10px;">
            <tr>
                <th align="center" width="6%">번호</th>
                <th align="center" width="70%">상품 이름</th>
                <th align="center" width="10%">상품 가격</th>
                <!--
                    %는 번호, 상품 이름, 상품 가격이 차지하는 비율을 지정하는 것이다.
                -->
            </tr>
            <tr v-if="!orderList || (Array.isArray(orderList) && orderList.length === 0)">
                <td colspan="3">
                    <!-- 리스트의 길이가 0과 같다면 아래의 
                    '현재 등록된 게시물이 없습니다! 라는 글이 표출되도록 하는 
                    조건문이다.'-->
                    현재 등록된 게시물이 없습니다!
                </td>
            </tr>
            <!--
                오더리스트의 길이가 0이 아니라면 작동하는 코드
                상품 상품 번호와 이름, 가격이 표출 된다.

            -->
            <tr v-else v-for="order in orderList" :key="order.productId">
                <td align="center">
                    {{ order.productId }}
                </td>
                <td align="center">
                    {{ order.productName }}
                </td>
                <td align="center">
                    {{ order.productPrice }}
                </td>
            </tr>
        </table>
    </div>
</template>

<script>
import axiosInst from '@/utility/axiosInst';

export default {
    data () {
        return {
            orderList: [],
        }
    },
    async mounted () {
        // 순서를 명시하기 위한 비동기 처리 마운트 후에 엑시오스 작동함
        const orderList = await axiosInst.get('/orders/list', {
            params: {
                accountToken: localStorage.getItem("accountToken"),
            },
        }).then((res) => {
            this.orderList = res.data
        })

        console.log('orderList: ' + JSON.stringify(this.orderList))
        //Json으로 받은 정보를 문자열로 변환해서 콘솔에 찍히게 하는것
        //await this.setData (product.data)
        console.log('size: ' + this.orderList.length)
    }
}

</script>

<style>

</style>