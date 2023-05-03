<template>
    <div>
        <p>{{ count }} 번 클릭했습니다!</p>
        <button @click="clickHandler">카운트하기</button>
        <button @click="alertHandler">경고 메시지 출력하기</button><br>
        <button @click.right="rightClickHandler">오른쪽 클릭</button>
        <button @click.left="leftClickHandler">왼쪽 클릭</button>
    </div>
</template>
<script>
export default {
    data() {
        return {
            count: 0,
        }
    },
    methods: {
        clickHandler () {
            this.count++
        },
        alertHandler (){
            alert('누르지마!')
        },
        rightClickHandler (comments){
            console.log('(' + comments.clirntX + ',' + comments.clirntY + ')')
        },
        leftClickHandler (comments){
            console.log('(' + comments.clirntX + ',' + comments.clirntY + ')')
        },
        

        
    }
}
</script>
<style>

</style>