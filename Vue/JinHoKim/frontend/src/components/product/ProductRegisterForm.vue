<template lang="">
    <div>
        <form @submit.prevent="onSubmit">
            <table>
                <tr>
                    <td>상품명</td>
                    <td>
                        <input type="text" v-model="productName"/>
                    </td>
                </tr>
                <tr>
                    <td>가격</td>
                    <td>
                        <input type="text" v-model="price"/>
                    </td>
                </tr>
            </table>

            <div>
                <button type="submit">등록</button>
                <router-link :to="{ name: 'ProductListPage' }">
                    취소
                </router-link>
            </div>
        </form>
    </div>
</template>

<script>
export default {
    name: "ProductRegisterForm",
    data () {
        return {
            productName: '상품명입니다',
            price: 0,
        }
    },
    methods: {
        onSubmit () {
            const { productName, price } = this
            this.$emit('submit', { productName, price })
        }
    }
}
</script>

<style lang="">
    
</style>