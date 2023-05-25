<template>
<v-container>
    <div>
        <h1>problem 1</h1>
        <input name="checkBox" type="checkbox" v-model="checked">
        <v-text-field readonly v-if="checked" value="체크박스선택"></v-text-field>
    </div>
    <div>
        <h1>problem 2</h1>
        <v-btn @click="getHi">getHi</v-btn>
    </div>
    <div>
        <h1>problem 3</h1>
        <select v-model="prob3">
            <option value="" selected disabled>select!</option>
            <option value="A">A</option>
            <option value="B">B</option>
        </select>
        <p>{{prob3}}</p>
    </div>
</v-container>
</template>

<script>
import {mapActions} from "vuex";

const basicModule = 'basicModule'

export default {
    name: "ProblemPage",
    data() {
        return {
            checked: 'false',
            prob3: ''
        }
    },
    methods: {
        ...mapActions(basicModule, ['requestGetHi']),
        getHi() {
            this.requestGetHi()
        }
    }

}
</script>

<style scoped>

</style>