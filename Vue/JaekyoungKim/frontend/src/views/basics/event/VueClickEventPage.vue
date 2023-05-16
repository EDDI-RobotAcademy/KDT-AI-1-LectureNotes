<template >
    <div>
        <p>{{ count }} 번 클릭했습니다.</p>
        <button @click="clickHandler">카운트 하기</button><br>
        <button @click="alertHandler">경고 메세지 출력하기</button><br>
        <button @click.right="rightClickHandler">오른쪽 클릭</button><br>
        <button @click.left="leftClickHandler">왼쪽 클릭</button>
    </div>
</template>
<script>
export default {
    data () {
        return {
            count: 0,
        }
    },
    methods: {
        clickHandler () {
            this.count++
        },
        alertHandler(){
            alert('누르지마')
        },
        rightClickHandler(comment){
            //클릭한 시점의 x좌표와 y좌표 콘솔에 출력됨
            console.log('(' + comment.clientX + ', ' + comment.clientY + ')')
        },
        leftClickHandler(comment){
            console.log('(' + comment.clientX + ', ' + comment.clientY + ')')
        }
        
        
    }
    
}
</script>
<style >
    
</style>