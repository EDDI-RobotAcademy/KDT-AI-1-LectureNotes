<template lang="">
    <div>
        <h3>구매내역 조회</h3>
        <table style="margin: 10px;">
            <tr>
                <th align="center" width="6%">번호</th>
                <th align="center" width="70%">상품 이름</th>
                <th align="center" width="10%">상품 가격</th>
            </tr>
            <tr v-if="!orderList || (Array.isArray(orderList) && orderList.length === 0)">
                <td colspan="3">
                    현재 등록된 게시물이 없습니다!
                </td>
            </tr>
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
        const orderList = await axiosInst.get('/orders/list', {
            params: {
                accountToken: localStorage.getItem("accountToken"),
            },
        }).then((res) => {
            this.orderList = res.data
        })

        console.log('orderList: ' + JSON.stringify(this.orderList))

        //await this.setData (product.data)
        console.log('size: ' + this.orderList.length)
    }
}

</script>

<style>

</style>