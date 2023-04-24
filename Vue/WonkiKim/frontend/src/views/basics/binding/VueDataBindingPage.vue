<template>
  <div>
      <p>Hello {{ message }}</p>
      <p>length: {{ message.length }}</p>
      <p>list[2]: {{list[2]}}</p>
      <p>List[{{number}}]: {{list[number]}}</p>
  </div>
</template>
<script>
export default {
    data() {
        return {
            message: 'Vue Programming',
            list: ['apple', 'samsung', 'microsoft'],
            show: true,
            number:1
        }
    }
}
</script>