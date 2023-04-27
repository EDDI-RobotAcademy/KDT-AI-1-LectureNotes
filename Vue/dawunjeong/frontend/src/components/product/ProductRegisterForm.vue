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
                    <td>상품 가격</td>
                    <td>
                        <input type="text" v-model="price"/>
                    </td>
                </tr>
                <tr>
                    <td>상품 정보</td>
                    <td>
                        <textarea cols="80" rows="30" v-model="details"/>
                    </td>
                </tr>
            </table>

            <div>
                <button type="submit">등록</button>
                <router-link :to="{ name: 'ProductListPage' }">
                    등록 취소
                </router-link>
            </div>
        </form>
    </div>
</template>

<script>
export default {
    data () {
        return {
            name: '상품명을 입력하세요',
            details: '상품 정보를 입력하세요',
            price: '상품 가격을 입력하세요',
        }
    },
    methods: {
        onSubmit () {
            const { name, details, price } = this
            this.$emit('submit', { name, details, price})
        },
    }
}
</script>

<style lang="">
    
</style>