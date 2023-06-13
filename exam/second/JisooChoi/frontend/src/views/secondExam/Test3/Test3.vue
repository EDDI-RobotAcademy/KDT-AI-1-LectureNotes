<template lang="">
    <div>
        <!--
            3. vue에서 select option을 사용해서 A, B 두 개의 옵션을 넣고
            옵션을 선택하면 옵션 정보를 출력하도록 만들어봅시다.
        -->
        <label>옵션 선택: </label>
        <select size="1" id="category" @change="handleInput($event)">
            <option value="optionA">A</option>
            <option value="optionB">B</option>
        </select>
    </div>
</template>

<script>
export default {
    data() {
        return {
            selectOption: "",
        }
    },
    methods: {
        handleInput(event) {
            alert(event.target.value);
        }
    }
}
</script>

<style lang="">
    
</style>