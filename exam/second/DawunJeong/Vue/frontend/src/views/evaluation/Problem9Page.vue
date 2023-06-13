<template lang="">
    <div>
        <h2>문제 9번: 
            Domain Service를 사용하는 이유에 대해 기술하세요.
        </h2>
        <p>
            답: <br>
            가장 큰 이유는 관심사의 분리입니다.<br>
            Domain을 관리하기 위해서 각 역할에 맞는 기능을 분리할 필요가 있습니다.<br>
            <p></p>
            객체의 행동에 대한 처리를 Entity에서 하기에는 역할과 이름이 매칭되지 않는 문제가 있습니다.<br>
            따라서 DB에 대한 처리는 repository, 객체의 행동에 대한 처리는 service가 하도록 만듭니다.<br>
            이것이 Domain Service를 사용하는 방법입니다.<br>
            이로써 코드의 가독성이 좋아지고 DDD에 맞는 코드를 설계할 수 있습니다.<br>
        </p>
    </div>
</template>

<script>
export default {
    
}
</script>

<style lang="">
    
</style>