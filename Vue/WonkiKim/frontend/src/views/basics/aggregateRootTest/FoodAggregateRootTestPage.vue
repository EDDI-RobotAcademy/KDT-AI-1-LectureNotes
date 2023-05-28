<template>

</template>

<script>
const foodModule
export default {
    name: "FoodAggregateRootTestPage"
    ,methods: {
        ...mapActions(),
        async onSubmit(payload) {
            await this.requestCreateFoodToSpring(payload)
            await this.$router.push( {
                name: 'home',
            })
        }
    },

}
</script>

<style scoped>

</style>