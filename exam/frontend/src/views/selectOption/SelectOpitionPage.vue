<template>
    <div>
        <label><input type="checkbox" v-model="whichOneChecked" value="A" @click="isClicked">A</label>
        <label><input type="checkbox" v-model="whichOneChecked" value="B" @click="isClicked">B</label>
        <p>{{ whichOneChecked }}</p>
        
    </div>
</template>

<script>

export default {
    data () {
        return {
            whichOneChecked: [],
        }
    },
    methods: {
        isClicked () {
            alert (this.whichOneChecked)
        }
    }
}

</script>

<style>
    
</style>