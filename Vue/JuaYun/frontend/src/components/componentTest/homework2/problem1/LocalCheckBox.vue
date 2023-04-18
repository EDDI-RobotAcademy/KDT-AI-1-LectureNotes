<template lang="">
    <div>
        <label> 
            <!-- 컴포넌트 나눠서 해보기 -->
            <input type="checkbox" v-model="isChecked"> {{ isChecked }}
        </label>
    </div>
</template>

<script>

export default {
    data() {
        return {
            isChecked: true,
        }
    }
}
</script>
<style lang="">
    
</style>