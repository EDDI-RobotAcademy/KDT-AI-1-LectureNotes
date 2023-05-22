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
            // 체크 박스가 체크 되어 isChecked 값이 참이 되면 체크 박스 선택 알림 창이 표출 됨
        }
    }
}

</script>

<style>
    
</style>