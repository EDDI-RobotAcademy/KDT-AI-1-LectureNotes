<template lang="">
    <div>
        <!-- 
            2000원짜리 사과 3개, 10000원짜리 수박 5개를 구매해봅시다.
            Vue에 UI를 구성하고 Spring에서 데이터를 처리해서 총합을 알려주세요.
            어떤 물건을 구했는지 알 수 있어야 합니다.
        -->
        <!-- 일단 과일 값을 조정할 수 있어야 겠다고 생각함 -->
        <fruits-selection-form :kinds-of-fruits="kindsOfFruits"/>
        <!-- 컴포넌트 추가하기 -->
    </div>
</template>

<script>

import FruitsSelectionForm from './FruitsSelectionForm.vue';

export default {
    components: {
        FruitsSelectionForm,
    },
    data () {
        return {
            kindsOfFruits: [
                { "name": "apple", "count": 3 }, 
                { "name": "watermelon", "count": 5 }
            ]
        }
    }
}
</script>
<style lang="">
    
</style>