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
                    <td>제조사</td>
                    <td>
                        <input type="text" v-model="manufacturer"/>
                    </td>
                </tr>
                <tr>
                    <td>유통기한</td>
                    <td>
                        <input type="text" v-model="expirationDate"/>
                    </td>
                </tr>
                <tr>
                    <td>제조일</td>
                    <td>
                        <input type="text" v-model="productionDate"/>
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
            price: 0,
            manufacturer: '제조사를 입력하세요',
            expirationDate: '유통기한을 입력하세요',
            productionDate: '제조일자를 입력하세요',
            details: '상품 정보를 입력하세요',
        }
    },
    methods: {
        onSubmit () {
            const { name, price, manufacturer,  expirationDate, productionDate, details } = this
            this.$emit('submit', { name, price, manufacturer,  expirationDate, productionDate, details })
        },
    }
}
</script>

<style lang="">
    
</style>