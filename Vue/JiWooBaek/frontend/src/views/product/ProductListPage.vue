<template lang="">
    <div>
        <h2>상품 목록 보기</h2>
        <div style="text-align: left; margin: 15px;">
            <router-link :to="{ name: 'ProductRegisterPage' }">
                상품 등록
            </router-link>
        </div>
        <product-list-form :products="products"/>
        <p>{{ output }}</p>
    </div>
</template>

<script>
import { mapActions, mapState } from 'vuex';
import ProductListForm from '@/components/product/ProductListForm.vue'

const productModule = 'productModule'

export default {
    components: { ProductListForm },
    data () {
        return {

        }
    },
    // state 관리자인 vuex에 state값(boards)를 모니터링
    computed: {
        ...mapState(productModule, ['products']),
        output () {
            console.log('이런식으로 활용도 가능')
        }
    },
    mounted () {
        // vuex의 action 호출
        this.requestProductListToSpring()
    },
    methods: {
        // vuex의 action을 method에 맵핑
        ...mapActions(
            productModule, ['requestProductListToSpring']
        )
    }
        
}

</script>


<style lang="">
    
</style>