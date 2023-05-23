<template lang="">
    <div>
        <!--
            Domain Service를 사용하는 이유는 아래와 같이 정리 할 수 있습니다.

            1. Entity와 관련이 있지만
               Entity가 자체적으로 수행하기에 표현이 애매해지는 경우를 대처하기 위해 사용합니다.
               
            2. 또한 의존성과 관련한 문제로 변경이 발생하면 해당 파트를 사용하는 모든 부분에 변경이 가해집니다.
               반면 interface인 Domain Service를 사용하여 의존성 자체를 역전시킵니다.
               IoC(Inversion of Control)의 달성에도 도움을 줍니다.
        -->
    </div>
</template>
<script>
export default {
    
}
</script>
<style lang="">
    
</style>