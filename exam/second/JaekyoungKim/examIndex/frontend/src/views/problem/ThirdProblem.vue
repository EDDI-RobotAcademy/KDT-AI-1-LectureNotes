<template lang="">
    <form @submit.prevent="onSubmit">
      <table>
        <tr>
          <td>
            <h3>3번 문제</h3>
            <div>
              <label>select 활용</label>
              <select v-model="selectedData">
                <!--
                이벤트 발생시 알림창이 뜨도록 만들어 졌다.
                select 하위의 option a,b 가 선택 되면 
                그 값이 slectedData로 넘어가고
                알림창에 뜨게 된다.
                -->
                <option selected>A</option>
                <option>B</option>
              </select>
            </div>
          </td>
        </tr>
      </table>
    </form>
  </template>
  
  <script>
  
  export default {
      data () {
          return {
            selectedData: '',
          }
      },
      updated () {
        alert('선택된 정보: ' + this.selectedData)
      }
  }
  
  </script>
  
  <style lang="">
      
  </style>