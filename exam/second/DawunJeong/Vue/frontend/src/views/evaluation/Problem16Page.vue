<template lang="">
    <div>
        <h2>문제 16번: 
            vue에서 vuex를 사용할 때 Module을 사용하게 됨으로서 얻게되는 이점에 대해 기술해보세요.
        </h2>
        <p>
            답: <br>
            각 도메인에 해당하는 기능을 분리함으로써 코드의 가독성이 좋아지고 DDD 설계가 가능해집니다. <br>
            <p></p>
            게시글 등록, 상품 등록 등 여러개의 비즈니스 서비스를 만들 때<br>
            어떠한 기능을 수행하는 action, mutaion, state이 필요합니다.<br>
            하나의 action에 게시글 등록, 상품 등록이라는 여러 도메인에 대한 모든 기능을 담게 되면<br>
            도메인 분리가 되지 않아 코드의 가독성이 떨어지고, 유지보수에 어려움이 있습니다.<br>
            <p></p>
            따라서 여기서 Module이라는 개념을 도입하여<br>
            boardModule, productModule 등으로 구분하여 각 기능들을 도메인에 맞게 관리합니다.<br>
            즉, Module을 사용하면 도메인을 잘 분리하여 관리할 수 있습니다.<br>
        </p>
    </div>
</template>
<script>
export default {
    
}
</script>
<style lang="">
    
</style>