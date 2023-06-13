<template lang="">
    <div>
        <h2>문제 4번: 
            Spring에서 주사위를 굴려서 결과를 알려주게 되며 vue에서는 이것을 출력하도록 구성합니다.
            작업을 진행하기 위한 Backlog를 작성해보세요.
        </h2>
        <p>
            <p>
                <h4>백로그 태그 : [ROLL-DICE-VUE] [ROLL-DICE-SPRING]</h4>
            </p>
            <div>
                <h4>Vue 파트</h4>
                Title : 사용자가 '주사위 굴리기' 버튼을 클릭하면 랜덤한 주사위의 값을 확인할 수 있습니다 [RDV-1]<br>

                Success criteria : <br>
                    1. 사용자가 '주사위 굴리기' 버튼을 클릭하면, axios를 사용하여 Backend로 데이터 요청을 보냅니다.<br>
                    2. 통신이 잘 되었다면 랜덤한 주사위 값(결과)을 화면에 출력합니다.<br>
                    3. 통신이 안되었다면 "문제 발생!" 이라는 문구를 화면에 출력합니다.<br>

                To-do :<br>
                    1. 주사위 굴리기 버튼 생성<br>
                    2. controller로 데이터를 요청할 axios 매서드 생성<br>
                    3. 응답 데이터에 대한 후속 처리<br>
            </div>
            <p></p>
            <div>
                <h4>Spring 파트</h4>
                Title : 주사위 굴리기 요청이 오면 랜덤한 주사위 값을 생성하여 해당 결과값을 반환합니다. [RDS-1]<br>
                
                Success criteria : <br>
                    1. Front로부터 요청을 수신할 controller를 생성합니다.<br>
                    2. 1부터 6까지의 숫자 중 랜덤한 숫자 하나를 생성하여 resultDiceNumber라는 변수에 저장합니다.<br>
                    3. resultDiceNumber를 return합니다.<br>

                To-do :<br>
                    1. controller 생성<br>
                    2. 랜덤한 숫자를 생성할 코드 작성<br>
                    3. resultDiceNumber이라는 변수 생성 후 해당 값을 저장<br>
            </div>
        </p>
    </div>
</template>
<script>
export default {
    
}
</script>
<style lang="">
    
</style>