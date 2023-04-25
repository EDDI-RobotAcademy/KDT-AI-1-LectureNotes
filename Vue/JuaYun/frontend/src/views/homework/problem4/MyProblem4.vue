<template>
  <div>
    <my-character-component/>
    <my-character-status/>
  </div>
</template>

<script>
import MyCharacterComponent from '@/components/componentTest/homework2/problem4/MyCharacterComponent.vue'
import MyCharacterStatus from '@/components/componentTest/homework2/problem4/MyCharacterStatus.vue'

export default {
  components: { MyCharacterComponent, MyCharacterStatus },

}
</script>

<style>

</style>