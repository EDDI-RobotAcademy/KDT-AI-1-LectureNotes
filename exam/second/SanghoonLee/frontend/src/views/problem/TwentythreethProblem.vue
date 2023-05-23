<template lang="">
  <v-container>
    <form @submit.prevent="onSubmit">
      <table>
        <tr>
          <td>상품 이름</td>
          <td>
            <input type="text" v-model="productName"/>
          </td>
        </tr>
        <tr>
          <td>상품 가격</td>
          <td>
            <input type="number" v-model="productPrice"/>
          </td>
        </tr>
        <tr>
          <td>상품 세부 정보</td>
          <td>
            <textarea cols="80" rows="20" v-model="productDetails"/>
          </td>
        </tr>
        <tr>
          <td>상품 이미지</td>
          <td>
            <input type="file" id="files" ref="files"
                    multiple @change="handleFileUpload"/>
          </td>
        </tr>
      </table>

      <div>
        <button type="submit">상품 등록</button>
      </div>
    </form>
  </v-container>
</template>

<script>
import axiosInst from '@/utility/axiosInst'

export default {
    data () {
        return {
            productName: '상품명',
            productPrice: 1000,
            productDetails: '세부정보',
            files: '',
        }
    },
    methods: {
        onSubmit () {
            let formData = new FormData()

            let productInfo = {
                productName: this.productName,
                productPrice: this.productPrice,
                productDetails: this.productDetails,
                accountToken: localStorage.getItem("accountToken")
            }

            for (let idx = 0; idx < this.files.length; idx++) {
                formData.append('imageFileList', this.files[idx])
            }

            formData.append(
                "productInfo",
                new Blob([JSON.stringify(productInfo)], { type: "application/json" })
            )

            axiosInst.post('/product/register', formData)
                .then((res) => {
                    if (res.data) {
                        alert('등록 성공!')
                    } else {
                        alert('사업자 회원으로 로그인하세요')
                    }
                })
        },
        handleFileUpload () {
            this.files = this.$refs.files.files
        },
    }
}
</script>

<style lang="">
    
</style>