<template >
    <div>
    <h1>Homework 0414</h1>
    <add-calculate-component/>
    <SubCalculateComponent/>
    <DoubleCalculateComponent/>
    <UniversalCalculateComponent/>

    </div>
</template>
<script>
import SubCalculateComponent from '@/components/homework414/SubCalculateComponent.vue'
import DoubleCalculateComponent from '@/components/homework414/DoubleCalculateComponent.vue'
import UniversalCalculateComponent from '@/components/homework414/UniversalCalculateComponent.vue'
export default {
    components: { SubCalculateComponent,
        DoubleCalculateComponent,
        UniversalCalculateComponent

    }
}
</script>
<style lang="">
    
</style>