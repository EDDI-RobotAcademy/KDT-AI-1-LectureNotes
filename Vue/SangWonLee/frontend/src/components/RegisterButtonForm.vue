<template lang="">
    <div>
        <v-btn color = "red" @click = "readyToCreateProduct"> 제품 등록 버튼</v-btn>
        <div v-if = "isPressedButton">
        <form @submit.prevent="onSubmit">
        
            <table>
                <tr>
                    <td>상품 명</td>
                    <td>
                        <input type="text" v-model = "name">
                    </td>
                </tr>
                
                <tr>
                    <td>상품 가격</td>
                    <td>
                        <input type="text" v-model = "price">
                    </td>
                </tr>

                <tr>
                    <td>제조사</td>
                    <td>
                        <input type="text" v-model = "company">
                    </td>
                </tr>

                <tr>
                    <td>제조일</td>
                    <td>
                        <input type="text" v-model = "manufactureDate">
                    </td>
                </tr>

                <tr>
                    <td>상품 종류</td>
                    <td>
                        <input type="text" v-model = "category">
                    </td>
                </tr>
            </table>

            <div>
                <button type="submit">상품 등록</button><br>
                <!--
                <router-link : to="{name : ''}"></router-link>
                -->

            </div>
        </form>

        </div>

    </div>
</template>
<script>

export default {
    name: "RegisterButtonForm",
    data() {
        return {
            name: '상품명',
            price: '상품 가격',
            company: '제조사',
            manufactureDate: '제조일',
            category: '상품 종류',
            isPressedButton: false,
        }
    },
    methods: {
        readyToCreateProduct() {
            this.isPressedButton = true
            alert('제품 등록 준비')
        },
        onSubmit() {
            const { name, price, company, manufactureDate, category } = this
            this.$emit('submit', { name, price, company, manufactureDate, category })


        }


    },

}
</script>
<style lang="">
    
</style>