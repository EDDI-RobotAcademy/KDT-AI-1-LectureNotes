<template>
    <!-- vuein 입력하면 자동완성 포맷으로 만들어짐-->
    <div>
        <!-- h 태그 1 ~ 6까지 존재함 -->
        <h3>실제 코드 형태로 입력해보기</h3>
        <h6>원래는 코드 형태 출력이 아닌 실제 코드가 동작해야 합니다</h6>
        <h4>chatGPT 같은 것을 만든다면 필요할지도 모르겠네요</h4>
        <!-- 
             강제 스타일 먹이기는 아래와 같이 style="css속성"
             여기서 css 속성은 text-align으로
             글자를 정렬할 때 사용하며 디폴트로 center 정렬이였으나
             아래 function saveLocal ... 에 대해서는  left 정렬을 적용하는 작업입니다
        -->
        <pre style="text-align: left;">
            function saveLocalData () {
                let second = document.getElementById("second")
                let value = second.value
                loaclStorage.setItem(1, value)
                getLocalData()
            }
        </pre>
        
    </div>
</template>
<script>
export default {
    
}
</script>
<style>
    
</style>