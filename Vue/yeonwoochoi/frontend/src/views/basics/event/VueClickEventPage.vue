<template>
    <div>
        <!-- @ 아래 methods가 동작 -->
        <p>{{ count }} 번 클릭했습니다!</p>
        <button @click="clickHandler">카운트하기</button><br> <!-- <br> 개행 -->
        <button @click="alerthandler">경고 메세지 출력하기</button><br>
        <button @click.right="rightClickHandler">오른쪽 클릭</button> 
        <button @click.left="leftcliCkHandlerr">왼쪽 클릭</button> 
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
        alerthandler () {
            alert('누르지마!')
        },
        rightClickHandler (comment) {
            console.log('(' + comment.clientX + ',' + comment.clientY + ')')
        },
        leftcliCkHandlerr (comment) {
            console.log('(' + comment.clientX + ',' + comment.clientY + ')')
        },
    }
}

</script>

<style>

</style>