<!--vue에서 select option을 사용해서 A, B 두 개의 옵션을 넣고 
    옵션을 선택하면 옵션 정보를 출력하도록 만들어봅시다.-->
<template lang="">
    <div v-if="selectOption">
        <select v-model="selectOption">
            <option vlaue="A">A</option>
            <option vlaue="B">B</option>
        </select>
    </div>
</template>
<script>
export default {
    data() {
        return {
            selectOption: null
        }
    }
}
</script>

<style lang="">
    
</style>