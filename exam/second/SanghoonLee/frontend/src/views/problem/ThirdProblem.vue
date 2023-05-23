<template lang="">
    <form @submit.prevent="onSubmit">
      <table>
        <tr>
          <td>
            <h3>3번 문제</h3>
            <div>
              <label>select 활용</label>
              <select v-model="selectedData">
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