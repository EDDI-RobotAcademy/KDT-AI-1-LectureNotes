<template>
    <div>
        {{ multipleResult }}
    </div>
</template>

<script>
export default {
    name: "LocalComponent",
    // 파라메터 받는 값
    // :initial-valuenumber1 ->initialvalue
    // :initial-valuenumber2 ->initialvalue2
    props: {
        initialValue: Number,
        initialValue2: Number,
    },
    data () {
        return {
            multipleResult: this.initialValue * this.initialValue2
        }
    }
}

</script>

<style>
    
</style>
