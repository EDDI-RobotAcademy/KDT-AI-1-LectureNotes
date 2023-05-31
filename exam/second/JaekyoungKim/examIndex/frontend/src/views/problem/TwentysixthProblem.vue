<template>
  <div>
    <table>
      <tr>
        <td>상품 번호</td>
        <td>
          <input type="text" :value="productId" readonly/>
        </td>
        </tr>
        <tr>
          <td>상품명</td>
          <td>
            <input type="text" :value="productName" readonly/>
          </td>
        </tr>
        <tr>
          <td>가격</td>
          <td>
            <input type="number" :value="productPrice" readonly/>
          </td>
        </tr>
        <tr>
          <td>세부 사항</td>
          <td>
            <textarea cols="50" rows="20" :value="productDetails" readonly/>
          </td>
        </tr>
    </table>

    <v-row>
      <v-col v-for="(imagePath, idx) in productImagesPathList" :key="idx" cols="12">
        <v-img :src="require(`@/assets/uploadImgs/${imagePath}`)" aspect-ratio="1" class="grey lighten-2">
          <template v-slot:placeholder>
            <v-row class="fill-height ma-0" align="center" justify="center">
            <v-progress-circular indeterminate color="grey lighten-5"/>
            </v-row>
          </template>
        </v-img>
      </v-col>
    </v-row>

  </div>
</template>

<script>
import axiosInst from '@/utility/axiosInst';

export default {
    data () {
        return {
            productId: 0,
            productName: '',
            productPrice: 0,
            productDetails: '',
            productImagesPathList: null
        }
    },
    // 상품 게시물 이므로 가져온 데이터를 넣어줘야 소비자의 눈에 상품 정보가 보인다.
    methods: {
        setData (payload) {
            this.productId = payload.id
            this.productName = payload.productName
            this.productPrice = payload.productPrice
            this.productDetails = payload.productDetails
            this.productImagesPathList = payload.productImagesPathList
        }
    },
    // 3번 상품 정보를 가져와서 setData 메서드 에 넣어준다.
    async mounted () {
        const product = await axiosInst.get('/product/read/3')

        console.log('product: ' + JSON.stringify(product.data))

        await this.setData (product.data)
    }
}
  
  </script>
  
  <style>
  
  </style>