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
            <input type="radio" v-model="category" name="radioBtn" value="TOPPING">
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
            <input type="text" v-model="foodName">
            <label>식재료명</label>
          </div>
          <div>
            <input type="number" v-model="foodPrice">
            <label>단위당 가격</label>
          </div>
          <div>
            <input type="text" v-model="foodCalorie">
            <label>단위당 칼로리(Kcal)</label>
          </div>
          <div>
            <input type="file" id="files" ref="files" multiple @change="handleFileUpload"/>
            <label>식재료 이미지 정보</label>
          </div>
        </td>
      </tr>
      <tr>
        <td>
          <h3>단위 정보</h3>
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
            /*
                => formData의 속성(=필드) 이름으로 imageFile, foodInfo가 있다.

                사용자가 추가한 사진 파일들을 하나씩 꺼내서 formData에 넣어주며,
                사진은 imageFile 로 추가되고,

                도메인에 따른 데이터는 foodInfo 로 추가되어 전달된다.
            */
            for (let idx = 0; idx < this.files.length; idx++) {
                formData.append('imageFile', this.files[idx])
            }

            // 불변 객체
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
                /*
                    자바 스크립트에서 Bolb은 이미지, 사운드, 비디오와 같은
                    멀티미디어 데이터를 다룰 때 사용할 수 있다.

                    대게 데이터의 크기(Byte) 및 MIME 타입을 알아내거나,
                    데이터 송수신을 위한 작은 Blob 객체로 나누는 등의 작업에 사용합니다.

                    즉, 데이터 자체라기 보다는 데이터를 간접적으로 접근하기 위한 객체인 것이다.
                */
                "foodInfo",
                new Blob([JSON.stringify(foodInfo)], { type: "application/json" })
            )
            this.$emit('submit', formData)
        },
        handleFileUpload () {
            /*
                vue로 파일을 읽는 방법이며,
                사용 대상을 this.$refs로 접근한다.
                
                this.$refs.[ref이름],[name이름-> 여기서는 id] 
            */
            this.files = this.$refs.files.files
        }
    }
}
</script>

<style lang="">
    
</style>