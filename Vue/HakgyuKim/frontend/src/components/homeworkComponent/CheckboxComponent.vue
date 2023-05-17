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
    /* 
    Vue LifeCycle 상에서 mounted는 객체가 만들어져서 변수 값들을 붙이는 상황에 해당합니다.
    그러므로 Component 객체가 구동하게 되면 무조건 mounted를 타게 됩니다.
    여기서 조건 검색을 하기 위해 사용하는 것입니다.
    */
    mounted () {
        this.result = this.value * 0.1
    }   
}

</script>

<style>
    
</style>