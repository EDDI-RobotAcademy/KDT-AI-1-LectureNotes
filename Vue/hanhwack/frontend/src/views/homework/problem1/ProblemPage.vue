<template lang="">
    <div>
        <!-- 1. 덧셈을 수행할 수 있는 Global Component를 만들어보세요. -->
        <global-add-component :first-value="3" :second-value="7"/>
        <!-- 2. 뺄셈을 수행할 수 있는 Local Component를 만들어보세요. -->
        <local-sub-component :first-value="7" :second-value="2"/>
    </div>
</template>
<script>
import GlobalAddComponent from '@/components/homework/problem1/GlobalAddComponent.vue';
import LocalSubComponent from '@/components/homework/problem1/LocalSubComponent.vue'
export default {
    components: { GlobalAddComponent,
                  LocalSubComponent, 
 
    }
}
</script>
<style lang="">
    
</style>