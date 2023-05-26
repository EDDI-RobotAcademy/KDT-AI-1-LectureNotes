<!-- 
체크박스 만들기 
체크 박스가 선택되면 '체크 박스 선택'을 출력
-->

<template lang="">
    <div>
      <P>색상</P>  
      <label><input type="checkbox" value="red">빨강</label>
      <v-btn class="teal ligthen-3" rounded @click="checkClick">선택</v-btn>
    </div>
</template>

<script>
export default {
  data () {
        return {
        
            
        }
    },
  methods: {
    checkClick () {
            alert('체크 박스 선택!')
        }
  }
} 
</script>


<style lang="">
    
</style>