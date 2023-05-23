<template>
    <div>
        <label>
            <input type="checkbox" v-model="isChecked"> {{ isChecked }}
        </label>
    </div>
</template>

<script>

export default {
    data () {
        return {
            isChecked: false,
        }
    },
    updated () {
        if (this.isChecked) {
            alert('체크 박스 선택')
        }
    }
}

</script>

<style>
    
</style>