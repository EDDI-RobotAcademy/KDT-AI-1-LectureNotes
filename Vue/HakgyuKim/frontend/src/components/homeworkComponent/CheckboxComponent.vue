<template>
    <div>
        <p>5번</p>
        <label>
            <input type="checkbox" v-model="isCheck"> {{ isCheck }}
        </label>
        <div v-if="isCheck">
            공급가: {{ value }}, 세금: {{ result }}
        </div>
        <div v-else>
            공급가: {{ value }}
        </div>
    </div>
</template>
<script>

export default {
    name: 'CheckboxComponent',

    props: {
        value: Number
    },

    data () {
        return {
            result: 0,
            isCheck: true
        }
    },
    mounted () {
        this.result = this.value * 0.1
    }   
}

</script>

<style>
    
</style>