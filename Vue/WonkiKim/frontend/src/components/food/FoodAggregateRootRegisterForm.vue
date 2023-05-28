<template>
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
                    <hr>
                    <div>
                        <input type="text" v-model="foodNmae">
                        <label>재료명</label>
                    </div>
                    <div>
                        <input type="text" v-model="foodPrice">
                        <label>단위당 가격</label>
                    </div>
                    <div>
                        <input type="text" v-model="calories">
                        <label>당위당 칼로리</label>
                    </div>
                    <div>
                        <input type="file" id="files" ref="files" multiple @change="handleFileUpload"/>
                        <label>이미지 정보</label>
                    </div>
                </td>
            </tr>
            <tr>
                <td>
                    <h3>단위 정보</h3>
                </td>
                <div>
                    <label>최대 수량</label>
                    <input type="text" v-model="max">
                </div>
                <div>
                    <label>최소 수량</label>
                    <input type="text" v-model="min">
                </div>
                <div>
                    <label for="">측정 단위</label>
                    <select v-model="measure">
                        <option selected>GRAM</option>
                        <option> COUNT</option>
                    </select>
                </div>
            </tr>
        </table>
        <div>
            <button type="submit">submit </button>
            <router-link :to="{name: 'HomeView'}">cancel</router-link>
        </div>
    </form>
</template>

<script>
export default {
    name: "FoodAggregateRootRegisterForm",
    data() {
        return {
            foodName: '',
            category: '',
            measure: 'g',
            max: '10',
            min: '1',
            unit: '2',
            foodPrice: '2000',
            calories: '10',
            files: ''
        }
    },
    methods: {
        onSubmit() {
            let formData = new FormData()
            for (et idx = 0; idx<this.files.length; idx++) {
                formData.append('imageFile', this.files[idx])
            }
            const {foodName, category, measure, max, min, unit, foodPrice, calories, files} = this
            let foodInfo = {
                foodName: foodName,
                category: category,
                measure: measure,
                max: max,
                min: min,
                unit: unit,
                foodPrice: foodPrice,
                foodCalories: foodCalories,
            }
            formData.append(
                "foodInfo",
                new Blob([JSON.stringify(foodInfo)], {type:"application/json"})
            )
            this.$emit('submit', formData)

        },
        handleFileUpload() {
            this.files = this.$refs.files.files
        }

    }
}
</script>

<style scoped>

</style>