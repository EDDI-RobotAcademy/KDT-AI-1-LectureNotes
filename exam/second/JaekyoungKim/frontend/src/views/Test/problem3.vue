<template lang="">
    <div>
        <select v-model="selectTest">
            <option
        v-for="(item, index) in selectList" :key="index" :value="item.value">
        {{ item.name }}</option
      >
              </select>
    </div>
</template>
<script>
export default {data() {
    return {
        selectTest: "",
      selectList: [
        { name: "A.", value: "A 선택함" },
        { name: "B", value: "B 선택" },
        ],
    }
},
    
}
</script>
<style lang="">
    
</style>