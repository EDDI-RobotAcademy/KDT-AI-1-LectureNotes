<template>
    <div>
        <p>{{ initialValue3 }} x 2 = {{ multipleResult }}</p>
    </div>
</template>

<script>
export default {
    name: "LocalComponent2",
    props: {
        initialValue3: Number,
    },
    data () {
        return {
            multipleResult: this.initialValue3 * 2
        }
    }
}
</script>

<style>

</style>