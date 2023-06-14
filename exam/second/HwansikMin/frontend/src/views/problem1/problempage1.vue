<template>
    <div>
        <label>
            <input type="checkbox" v-model="isChecked" @change="handleCheckboxChange">체크 박스
        </label>
    </div>
</template>

<script>
export default {
    props: {

    },
    data () {
        return {
            isChecked: true,
        }
    }
}
</script>

<style>
    
</style>