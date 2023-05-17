<template>
    <div>
        <p>입력: 
            <!-- 
                :value은 v-bind:value와 동의어입니다 
                번거롭게 전체를 적을 필요가 없으므로 생략하였습니다.
                v-bind는 우측값을 좌측에 맵핑합니다.
                그러므로 script에 있는 message 값을 input(입력창)의 값으로 맵핑합니다.
            -->
            <input :value="message" @change="handleInput"/>
        </p>
    </div>
</template>

<script>
export default {
    data () {
        return {
            message: '안녕'
        }
    },
    methods: {
        handleInput (event) {
            console.log('event: ' + event)
            this.message = event.target.value
            console.log('event.target.value: ' + event.target.value)
        }
    }
}
</script>

<style>
    
</style>