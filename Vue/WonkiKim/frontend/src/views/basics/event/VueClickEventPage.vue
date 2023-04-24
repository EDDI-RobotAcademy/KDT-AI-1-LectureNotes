<template>
  <div>
      <p>{{count}}th click!</p>
      <button @click="clickHandler">count</button><br>
      <button @click="alertHandler">print alert message</button><br>
      <button @click.right="rightClickHandler">print right click</button><br>
      <button @click.left="leftClickHandler">print left click</button>
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
        clickHandler() {
            this.count++
        },
        alertHandler() {
            alert('dont click')
        },
        rightClickHandler (comment) {
            console.log('(' + comment.clientX + ', ' + comment.clientY + ')')
        },
        leftClickHandler (comment) {
            console.log('(' + comment.clientX + ', ' + comment.clientY + ')')
        }
    }
}
</script>