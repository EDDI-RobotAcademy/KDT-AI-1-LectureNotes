<template>
    <div>
        <button type="submit" @click="onSubmit">주사위 굴리기</button>
        <p>
          {{ DiceNubmer }}
        </p>
    </div>
</template>

<script>
import axios from 'axios'
export default {
    data () {
        return {
            DiceNubmer: 0,
        }
    },
    methods: {
        onSubmit () {
            axios.get('http://localhost:7777/vue-test/dice')
                .then((res) => {
                    this.DiceNubmer = res.data
                })
             
        }
    }
}
</script>

<style>
    
</style>