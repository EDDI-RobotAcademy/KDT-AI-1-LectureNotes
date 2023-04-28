<template>
  <div>
    <p>{{ initialValue4 }} + {{ initialValue5 }} = {{ result1 }}</p>
    <p>{{ initialValue4 }} - {{ initialValue5 }} = {{ result2 }}</p>
    <p>{{ initialValue4 }} x {{ initialValue5 }} = {{ result3 }}</p>
    <p>{{ initialValue4 }} / {{ initialValue5 }} = {{ result4 }}</p>
  </div>
</template>

<script>
export default {
    name: "LocalComponent3",
    props: {
        initialValue4: Number,
        initialValue5: Number,
    },
    data () {
        return {
            result1: this.initialValue4 + this.initialValue5,
            result2: this.initialValue4 - this.initialValue5,
            result3: this.initialValue4 * this.initialValue5,
            result4: this.initialValue4 / this.initialValue5
        }
    }

}
</script>

<style>

</style>