<template>
    <v-container>

        <!--
            Vue vue = new Vue();
            vue.globalComponent(counter);

            public void globalComponent(int counter){
                initial-test = counter;
            }

            아래 코드는 위 코드와 동의어 입니다.
            initial-test는 v-bind로 맵핑했음

        -->

        <global-component :initial-test="counter" />
        <p>:initial-test는 v-bind:initial-test와 같습니다만 축약 표현입니다.</p>

    </v-container>
</template>

<script>
export default {
    data() {
        return {
            counter: 0
        }
    }
}
</script>

<style></style>