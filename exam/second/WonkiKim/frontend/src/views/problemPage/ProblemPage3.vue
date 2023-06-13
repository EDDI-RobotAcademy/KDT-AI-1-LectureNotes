<template>
<v-container>
    <div>
        <h1>problem 7</h1>
    <v-row>
        <v-col v-for="(image, idx) in images">
            <v-img :src="image" aspect-ratio="1" :width="50"></v-img>
        </v-col>
    </v-row>
    </div>

    <div>
        <h1>problem 8</h1>
        <v-carousel :cycle="cycle" :interval="interval" :height="height">
            <v-carousel-item v-for="(image, idx) in images">
                <v-img :src="image" aspect-ratio="1" :width="300"></v-img>
            </v-carousel-item>
        </v-carousel>
    </div>
    <div>
        <h1>problem 9</h1>
        도메인 서비스를 사용하는 이유:
        도메인 서비스는 비즈니스 관련된 로직을 분리해서 작성하기 위해 사용된다.
    </div>
</v-container>
</template>

<script>
import VueCarousel from 'vue-carousel';
import Vue from "vue";
Vue.use(VueCarousel)
export default {
    name: "ProblemPage3",
    data() {
        return {
            images: [
                require("@/assets/logo.png"),
                require("@/assets/logo.svg"),
                require("@/assets/logo 2.svg"),
                require("@/assets/logo 2.png"),
                require("@/assets/python.png"),

            ],
            cycle: true,
            interval: 2500,
            height: 200
        }
    }
}
</script>

<style scoped>

</style>