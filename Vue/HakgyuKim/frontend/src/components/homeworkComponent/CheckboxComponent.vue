<template>
    <div>
        <p>5번</p>
        <input type="checkbox" v-model="isCheck">
        {{ result }}
    </div>
</template>
<script>

export default {
    name: 'CheckboxComponent',

    props: {value: number,},

    data () {
        return {result}
    },
    methods: {
        result () {
        {isCheck ? value * 0.9 : value}
        }
    },

    
}

</script>

<style>
    
</style>