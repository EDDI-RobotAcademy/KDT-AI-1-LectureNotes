<template lang="">
  <form @submit.prevent="onSubmit">
    <table>
  
      <tr>
        <td>
          <h3>상품 등록</h3>
          <hr/>
          <div>
            <input type="text" v-model="productName">
            <label>상품 이름</label>
          </div>
          <div>
            <input type="number" v-model="price">
            <label> 가격</label>
          </div>
          
          <div>
            <input type="file" id="files" ref="files" multiple @change="handleFileUpload"/>
            <label>이미지 정보</label>
          </div>
        
        
        </td>
      </tr>
      <tr>
        
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
import ProductModule from '@/store/product/ProductModule'
export default {
    data () {
        return {
            productName: '',
            price: '2000',
            files: '',
            imgSrc:''
        }
    },
    methods: {
        onSubmit () {
            const { productName, price, srcImg } = this

            
      
            }
            
        },
        handleFileUpload () {
            this.files = this.$refs.files.files
            this.imgSrc = this.$refs.files.files
        }
    }

</script>

<style lang="">
    
</style>