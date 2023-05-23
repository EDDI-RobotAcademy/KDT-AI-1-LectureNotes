<template lang="">
    <div>
        <button @click="count++">You clicked me {{ count }} times.</button>
        
    </div>
</template>
<script>
export default {
    name: "button-counter",
    data() {
        return {
            count: 0
        }
    },

}
</script>
<style lang="">
    
</style>