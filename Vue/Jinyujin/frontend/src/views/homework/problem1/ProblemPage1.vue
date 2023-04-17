<template lang="">
    <div>
        <!-- 1. 덧셈을 수행할 수 있는 Global Component를 만들어보세요. -->
        <global-add-component :first-value = "3" :second-value= "7"/>
    </div>
</template>

<script>

import GlobalAddComponent from '@/components/homework/problem1/GlobalAddComponent.vue'

export default {
    components: { GlobalAddComponent },
}
</script>

<style lang="">
    
</style>