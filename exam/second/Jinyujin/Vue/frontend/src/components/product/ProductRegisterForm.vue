<template>
    <form @submit.prevent="onSubmit">
        <table>
            <tr>
                <td>
                    <h3>등록할 상품의 정보를 입력하세요</h3>
                    <hr />
                    <div>
                        <input type="text" v-model="productName">
                        <label>상품명</label>
                    </div>
                    <div>
                        <input type="number" v-model="productPrice">
                        <label>상품 가격</label>
                    </div>
                    <div>
                        <input type="file" id="files" ref="files" multiple @change="handleFileUpload"/>
                        <label>상품 이미지 정보</label>
                    </div>
                </td>
            </tr>
        </table>

        <div>
            <button type="submit">등록</button>
            <router-link :to="{ name: 'home' }">
                취소
            </router-link>
        </div>
    </form>
</template>

<script>
export default {
    data() {
        return {
            productName: '',
            productPrice: '2000',
            files: '',
        }
    },
    methods: {
        onSubmit() {
            let formData = new FormData()
            for (let idx = 0; idx < this.files.length; idx++) {
                formData.append('imageFile', this.files[idx])
            }
            const { productName, productPrice, files } = this
            let productInfo = {
                productName: productName,
                productPrice: productPrice,
            }
            formData.append(
                "productInfo",
                new Blob([JSON.stringify(productInfo)], { type: "application/json" })
            )
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