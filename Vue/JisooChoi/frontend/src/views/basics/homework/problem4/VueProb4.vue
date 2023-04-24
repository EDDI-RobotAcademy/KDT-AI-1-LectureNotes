<template lang="">
    <div>
        <!--
            UI 상에서 캐릭터 생성이라는 버튼을 누르면
            email과 password를 입력하도록 구성

            완료 Submit? 를 누르면 Backend에서 캐릭터 계정을 생성해준다.
            또한 캐릭터 status(능력치)를 만들어준다.
            (status는 랜덤으로 만들면 된다고 한다.)

            UI 파트에서 Play 버튼을 누르면
            캐릭터 status를 가져와서 화면 뿌려준다.
        -->
        <sign-up-prob4 />
    </div>
</template>

<script>
import SignUpProb4 from '@/components/homework/problem4/SignUpProb4.vue';
export default {
    components: {
        SignUpProb4,
    },
    data() {
        return {
            
        }
    }
}
</script>

<style lang="">
    
</style>