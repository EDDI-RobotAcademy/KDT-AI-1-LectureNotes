<template>
    <form @submit.prevent="onSubmit">
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
                        <!--
                            여러 장의 사진을 넣으므로 반복문 사용한다.
                        -->
                    </template>
                </v-img>
            </v-col>
        </v-row>

        <div>
            <button type="submit">상품 구매</button>
        </div>

    </form>
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
    methods: {
        setData (payload) {
            this.productId = payload.id
            this.productName = payload.productName
            this.productPrice = payload.productPrice
            this.productDetails = payload.productDetails
            this.productImagesPathList = payload.productImagesPathList
            // 가져온 데이터 들을 읽기 위해 데이터를 넣어준다.
        },
        onSubmit () {
            const { productId } = this
            axiosInst.post('/orders/register', { productId, accountToken: localStorage.getItem("accountToken") })
                .then((res) => {
                    // 상품 번호와 유저 토큰 전달 한다.
                    if (res.data) {
                        alert('구매 성공!')
                        // 해당 상품과 유저 토큰이 유효한 경우 구매 성공
                    } else {
                        alert('구매 실패')
                    }   // 그게 아닐 경우 구매 실패
                })
        },
    },
    async mounted () {
        const product = await axiosInst.get('/product/read/3')
        // 3번 물품 가져오게 한다.

        console.log('product: ' + JSON.stringify(product.data))
        //물품 데이터 콘솔에 표출
        await this.setData (product.data)
        // 가져온 데이터를 setData 메서드 인자로 전달
    }
}

</script>

<style>

</style>