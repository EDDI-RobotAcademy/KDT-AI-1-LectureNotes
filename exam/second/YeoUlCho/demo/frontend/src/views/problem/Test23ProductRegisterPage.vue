<template lang="">
    <v-container >
    <form @submit.prevent="onSubmit" >
      <table align="center">
        <tr>
          <td>
            <v-text-field label="상품명" type="text" v-model="productName"/>
          </td>
        </tr>
        <tr>
          <td>
            <v-text-field label="상품가격" type="number" v-model="productPrice"/>
          </td>
        </tr>
        <tr>
          <td>
            <v-textarea 
            label="상품 세부 정보를 입력하세요" 
            background-color="grey lighten-4" 
            shaped
            filled
            auto-grow
            cols="50" rows="20" 
            v-model="productDetails"/>
          </td>
        </tr>
        <tr>
          <td>
            <v-text-field label="상품이미지" type="file" id="files" ref="files"
                    multiple @change="handleFileUpload"/>
          </td>
        </tr>
      </table>

      <div>
        <button  type="submit">상품 등록</button>
        <label> | </label>
        <button>취소</button>
      </div>
    </form>
  </v-container>
</template>
<script>
import axiosInst from '@/utility/axiosInst'

export default {
    data(){
        return{
            productName: '상품명', 
            productPrice: '1000', 
            productDetails: '',
            files: ''

        }
    },
    methods:{
        onSubmit(){
            let formData = new FormData()
            let productInfo={
                productName: productName, 
                productPrice: productPrice, 
                productDetails: productDetails
            }

            for(let idx =0; idx<this.files.length;i++){
                formData.append('imageFile', this.files[idx])
            }
            formData.append('productInfo',new Blob([JSON.stringify(productInfo)],{types: "application/json"})
            )
            axiosInst.post('product/register', formData)
            .then((res)=>{
                if(res.data){
                    alert('등록 성공')
                }else{
                    alert('사업자 회원으로 로그인 하세요')
                }
            })
           
        },
        handleFileUpload(){
            this.files=this.$ref.files.files
        }
    }
    
}
</script>
<style lang="">
    
</style>