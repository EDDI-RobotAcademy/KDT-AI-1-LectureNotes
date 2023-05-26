<template lang="">
    <div>
        <label>
            <input type="checkbox" @check="isChecked">

            <p v-if="isShow">체크 박스 선택.</p>
        </label>
        
    </div>
</template>
<script>
export default {
    methods: {
        isChecked(){
            this.isShow=true

        }

    },
    data() {
        return {
            isShow:false
        }
    },
    
}
</script>
<style lang="">
    
</style>