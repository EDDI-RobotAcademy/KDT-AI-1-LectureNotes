<template lang="">
    <div>
        <!--
            문제 3번:
            vue에서 select option을 사용해서 A, B 두 개의 옵션을 넣고 
            옵션을 선택하면 옵션 정보를 출력하도록 만들어봅시다.
        -->
        <p>
            <label>옵션 종류</label>
            <p>
                <select v-model="measure">
                    <option value="옵션 A의 정보입니다.">옵션 A</option>
                    <option value="옵션 B의 정보입니다.">옵션 B</option>
                </select>
                <p>
                    {{ measure }}
                    {{ value }}
                </p>
            </p>
        </p>
    </div>
</template>

<script>
export default {
    data() {
        return {
            measure:'옵션 정보',
            value: ''
        }
    },
}
</script>

<style lang="">
    
</style>