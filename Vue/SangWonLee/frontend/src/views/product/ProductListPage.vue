<template lang="">
    <div>
        <h2>상품 목록 보기</h2>
        <div style="text-align: left; margin: 15px;">
            <router-link :to="{ name: 'ProductRegisterPage' }">
                상품 등록
            </router-link>
            <!-- 상품 등록 페이지로 이동 -->
        </div>
        <product-list-form :products="products"/>
        <!-- products라는 props를 이용하는 ProductListForm 컴포넌트 -->
        <p>{{ output }}</p>
        <!-- output 데이터 속성의 값을 표시하는 요소 -->
    </div>
</template>

<script>
import { mapActions, mapState } from 'vuex';
/*

mapActions : 컴포넌트 메소드에서 스토어의 액션을 매핑하는데 사용
mapState : 컴포넌트의 계산된 속성에 스토어의 상태를 매핑하는데 사용
인 두개의 함수를 vuex 라이브러리에서 가져온다.

매핑한다 : 한 객체의 속성이나 메소드를 다른 객체의 속성이나 메서드와 연결하는 것을 의미한다.

*/
import ProductListForm from '@/components/product/ProductListForm.vue'
const productModule = 'productModule'
export default {
    components: { ProductListForm },
    data() {
        return {
        }
    },
    // state 관리자인 vuex에 state값(boards)를 모니터링
    computed: {
        ...mapState(productModule, ['products']),
        // 컴포넌트의 계산된 속성(computed property)에 mapState를 사용하여
        // productModule의 products 상태를 매핑한다.

        output() {
            console.log('sadfsadf')
        }
    },
    mounted() {
        // vuex의 action에 있는 method를 호출해서
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