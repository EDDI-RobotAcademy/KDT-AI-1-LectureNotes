<template>
    <div>
        <label>
            <input type="checkbox" v-model="ischecked">{{ ischecked }}
        </label>
    </div>
</template>
<script>
export default {
    data(){
        return{
            ischecked: true,
        }
    }
    
}
</script>
<style>
    
</style>