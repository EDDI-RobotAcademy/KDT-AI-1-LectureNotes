<template>
<v-container>
    <p>VUE -> SPRING -> PYTHON -> SPRING -> VUE</p>
    <p>{{ data }}</p>
</v-container>
</template>

<script>
import axiosInst from "@/utility/axiosInst";

export default {
    name: "VSPTest",
    data() {
        return {
            data: 0
        }
    },
    async beforeMount() {
        this.data = await axiosInst.get("/fastapi-test/fastapi-integer-request")
            .then(res=>res.data)
    }
}
</script>

<style scoped>

</style>