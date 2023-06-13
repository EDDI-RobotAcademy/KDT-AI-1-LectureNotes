<template>
    <div>
        <label><input type="checkbox" v-model ="whichOneChecked" value="옵션 정보 A">A</label>
        <label><input type="checkbox" v-model ="whichOneChecked" value="옵션 정보 B">B</label>
        <p>{{  whichOneChecked }}</p>
    </div>
</template>

<script>

export default {
    data () {
        return {
            whichOneChecked: [],
        }
    }
}
</script>

<style>


</style>