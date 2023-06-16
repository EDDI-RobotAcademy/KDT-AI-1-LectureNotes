<template>
    <v-container>
        <p>vue -spring</p>
        <p>{{vs}}</p>
        <p>vue - spring - fastapi</p>
        <p>{{vsp}}</p>
        <p>vue - fastapi</p>
        <p>{{vp}}</p>

        <p>result</p>
        <p>{{result}}</p>
        <v-btn @click="alert()"></v-btn>
    </v-container>
</template>

<script>
import axiosInst from "@/utility/axiosInst";
import axios from "axios";

export default {
    name: "VspProblem",
    data() {
        return {
            vs:0,
            vp:0,
            vsp:0,
        }
    },
    computed: {
        result: function() {
            return this.vs * 1.25 + this.vsp * 1.5 + this.vp * 1.75
        }

    },
    async beforeMount() {
        this.vs = await axiosInst.get("/fastapi-test/request-random-number")
            .then(res=> res.data)
        this.vsp = await axiosInst.get("/fastapi-test/request-random-number-to-fastapi")
            .then(res=>res.data)
        this.vp = await axios.get("http://localhost:8000/request-random-number-directly")
            .then(res=> {
                return res.data
            })
    }
}
</script>

<style scoped>

</style>