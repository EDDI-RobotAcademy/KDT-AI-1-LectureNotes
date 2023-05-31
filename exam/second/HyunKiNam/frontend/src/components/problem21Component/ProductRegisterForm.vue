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
                    <td>가격</td>
                    <td>
                        <input type="text" v-model="price"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="file" id="files" ref="files" multiple @change="handleFileUpload"/>
                        <label>상품 이미지 정보</label>
                    </td>
                </tr>
            </table>

            <div>
                <button type="submit">등록</button>
                <router-link :to="{ name: 'Problem21' }">
                    취소
                </router-link>
            </div>
        </form>
    </div>
</template>

<script>
export default {
    data() {
        return {
            name: '',
            price: '',
            accountId: '',
            files: '',
        }
    },
    mounted() {
        this.accountId = localStorage.getItem("accountId")
        console.log(this.accountId)
    },
    methods: {
        onSubmit() {
            let formData = new FormData()
            for (let idx = 0; idx < this.files.length; idx++) {
                formData.append('imageFile', this.files[idx])
            }
            console.log(this.files[0])
            const { name, price, accountId } = this
            let productInfo = {
                name: name,
                price: price,
                accountId: accountId,
            }
            formData.append(
                "productInfo",
                new Blob([JSON.stringify(productInfo)], { type: "application/json" })
            )
            console.log(formData)
            this.$emit('submit', formData)

        },
        handleFileUpload() {
            this.files = this.$refs.files.files
        }
    }
}
</script>

<style lang="">
    
</style>