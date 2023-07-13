<template>
    <div>
        <div v-if="authorizeRequestHtml">{{ authorizeRequestHtml }}</div>
    </div>
</template>

<script>
export default {
    name: "AfterGithubAuthorizeRequest",
    props: {
        authorizeRequestHtml: {
            type: String,
            required: true,
        },
    },
    computed: {
        parsedAuthorizeRequestHtml() {
            return JSON.parse(this.authorizeRequestHtml || '{}');
        }
    },
    mounted() {
        console.log("AfterGithubAuthorizeRequest: ", this.authorizeRequestHtml);
    }
}
</script>

<style scoped>

</style>