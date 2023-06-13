<template lang="">
    <div>
        <select label="select" @change="setSelect($event)">
        <!-- <option 
        v-for="(item,index) in selectList"
        :key="index"
        :value="item.value">
        {{item.name}}
        </option> -->
        <option selected>select고르기</option>
        <option>A</option>
        <option>B</option>
    </select>
        <span>선택 value: {{selected}}</span>
    </div>
</template>
<script>
export default {
    data(){
        return{
            selected: '',
            // selectList: [
            // { name: "선택해주세요.", value: " " },
            // { name: "A", value: "조여울" },
            // { name: "B", value: "시험보기" },
            // { name: "C", value: "잘하자" },
            //  ],
        }
    },
    methods: {
        setSelect(event) {
      const asisSelect = this.selected;
      this.selected = event.target.value;
      if (this.selected === this.selectList[1].value) {
        this.text = this.selectList[1].value + "선택 불가!";
        this.selected = asisSelect;
      }
    }
    }   
}
</script>
<style scoped>
select{
    width: 200px
}
    
</style>