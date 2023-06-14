<template lang="">
  <div>
    <Problem18Form/>
    <Problem18AccountInfoForm/>
    <Problem18LoginForm/>
  </div>
</template>

<script>
import Problem18Form from '@/components/problem18/Problem18Form.vue';
import Problem18AccoutInfoForm from '@/components/problem18/Problem18AccoutInfoForm.vue';
import Problem18LoginForm from '@/components/problem18/Problem18LoginForm.vue'

export default {
  components: {
    Problem18Form,
    Problem18AccoutInfoForm,
    Problem18LoginForm,
  }
}
</script>
<style lang="">
  
</style>