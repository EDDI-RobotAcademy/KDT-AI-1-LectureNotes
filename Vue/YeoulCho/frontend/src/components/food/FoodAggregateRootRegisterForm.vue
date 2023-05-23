<template lang="">

    <form @submit.prevent="onSubmit">
      <table>
        <tr>
          <td>
            <h3>Category</h3>
            <hr/>
            <div>
              <input type="radio" v-model="category" name="radioBtn" value="VEGETABLE">
              <label>채소</label>
            </div>
            <div>
              <input type="radio" v-model="category" name="radioBtn" value="MEAT">
              <label>육류</label>
            </div>
            <div>
              <input type="radio" v-model="category" name="radioBtn" value="TOPING">
              <label>토핑</label>
            </div>
            <div>
              <input type="radio" v-model="category" name="radioBtn" value="ICECREAM">
              <label>아이스크림</label>
            </div>
          </td>
        </tr>
        <tr>
          <td>
            <h3>식재 정보</h3>
            <hr/>
            <div>
              <label>식재료명</label>
              <input type="text" v-model="foodName">
            </div>
            <div>
              <label>단위당 가격</label>
              <input type="number" v-model="foodPrice">
            </div>
            <div>
              <label>단위당 칼로리(Kcal)</label>
              <input type="text" v-model="foodCalorie">
            </div>
            <div>
              <label>식재료 이미지 정보</label>
              <input type="file" id="files" ref="files" multiple @change="handleFileUpload"/>
            </div>
          </td>
        </tr>
        <tr>
          <td>
            <h3>단위 정보</h3>
            <hr/>
            <div>
              <label>최대 수량</label>
              <input type="text" v-model="max"/>
            </div>
            <div>
              <label>최소 수량</label>
              <input type="text" v-model="min"/>
            </div>
            <div>
              <label>측정 단위</label>
              <select v-model="measure">
                <option selected>GRAM</option>
                <option>COUNT</option>
              </select>
            </div>
          </td>
        </tr>
      </table>
  
      <div>
        <button type="submit">등록</button>
        <router-link :to="{ name: 'home' }">
          취소
        </router-link>
      </div>
    </form>

  </template>
  
  <script>
  export default {
      data () {
          return {
              foodName: '',
              category: '',
              measure: 'g',
              max: '10',
              min: '1',
              unit: '2',
              foodPrice: '2000',
              foodCalorie: '10',
              files: '',
          }
      },
      methods: {
          onSubmit () {
              let formData = new FormData()
              for (let idx = 0; idx < this.files.length; idx++) {
                  formData.append('imageFile', this.files[idx])
              }
              const { foodName, category, measure, max, min, unit, foodPrice, foodCalorie, files } = this
              let foodInfo = {
                  foodName: foodName,
                  category: category,
                  measure: measure,
                  max: max,
                  min: min,
                  unit: unit,
                  foodPrice: foodPrice,
                  foodCalorie: foodCalorie,
              }
              formData.append(
                  "foodInfo",
                  new Blob([JSON.stringify(foodInfo)], { type: "application/json" })
                  //JSON형태로 바로 보내면 백엔드 서버에서는 알아볼 수 없기 때문에 stringify를 이용해 보내야 한다.
              )
              this.$emit('submit', formData)
          },
          handleFileUpload () {
              this.files = this.$refs.files.files
          }
      }
  }
  </script>
  
  <style scoped>
  div{
text-align: left;
  }
 
      
  </style>