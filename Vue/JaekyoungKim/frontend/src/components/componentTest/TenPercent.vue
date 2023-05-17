<template>
    <div>
        <!-- <input type="text" v-model="NumberAA"><input type="checkbox" v-bind="Number" @isChecked="tenPercentMinus">
        <p>{{result }}</p> -->
        <div>
        <label>
            <input type="checkbox" v-model="isChecked"> {{ isChecked }}
        </label>
        <div v-if="isChecked">
            <p>금액(VAT 포함): {{ inputAmount }}, 세금: {{ taxAmount }}</p>
        </div>
        <div v-else>
            <p>금액: {{ inputAmount }}</p>
        </div>
    </div>
    </div>
</template>
<script>
export default {
    props: {
        inputAmount: Number
    },
    data () {
        return {
            taxAmount: 0,
            isChecked: true
        }
    },
    mounted () {
        this.taxAmount = this.inputAmount * 0.1
    }

    // props:{
    //     NumberAA:number-aa

    // },

    // data() {
    //     return {
    //         NumberAA:0,
    //         isChecked:true
           
            
    //     }
    // },
    // methods: {
    //     tenPercentMinus(){
    //         result=NumberAA-(NumberAA/10)
    //     }
    // }
    
}
</script>
<style>
    
</style>