<template>
    <div>
        <pre>{{ message }}</pre>
    </div>
</template>

<script>

import axios from 'axios'

export default {
    data() {
        return {
            message: '',
        }
    },
    mounted() {
        axios.get('/hello')
        .then(res => {
        this.message = res.data
    })
        .catch(error => {
            console.error(error)
        })
    },
}
</script>

<style></style>