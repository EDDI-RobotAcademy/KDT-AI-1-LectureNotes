<template lang="">
    <div>
        <!-- 1. Checkbox가 체크 되었는지 안되었는지 검사해봅시다. -->
        <local-checkbox-component/>
        <!-- 2. input 창에 입력한 숫자가 짝수인지 홀수인지 판정해봅시다. -->
        <local-input-number-component/>
    </div>
</template>

<script>

import LocalCheckboxComponent from './LocalCheckboxComponent.vue';
import LocalInputNumberComponent from './LocalInputNumberComponent.vue';

export default {
    components: {
        LocalCheckboxComponent,
        LocalInputNumberComponent
    }    
}
</script>

<style lang="">
</style>