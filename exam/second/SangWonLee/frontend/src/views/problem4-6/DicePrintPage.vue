<!--
    Spring에서 주사위를 굴려서 결과를 알려주게 되며 vue에서는 이것을 출력하도록 구성합니다.

    4. 작업을 진행하기 위한 Backlog를 작성해보세요.

    5. vue를 활용하여 주사위를 굴릴 수 있는 UI를 만들어봅시다.

    6. 주사위 굴리기 버튼을 누르면 Spring에 요청을 날려서 주사위 값을 출력해봅시다.
-->

<!--
    Backlog 작성

    1. Vue에서 DicePrintPage와 DicePrintForm 을 생성 후 index.js를 수정합니다.
    2. 주사위 굴리기 버튼을 만들어 Spring에 요청을 보냅니다.
    3. Spring에서 DicePrintController를 만들어서 1 ~ 6 까지 랜덤한 값을 반환합니다.
    4. Spring에서 반환한 값을 Vue에서 출력합니다.
-->


<template lang="">
    <div>
        <dice-print-form/>

        
    </div>
</template>
<script>

import DicePrintForm from '@/components/problem4-6/DicePrintForm.vue';
export default {

    components: {
        DicePrintForm
    }

}
</script>
<style lang="">
    
</style>