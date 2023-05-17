<template lang="">
    <div>
        <h2>상품 게시판</h2>
        <div style="text-align: left margin: 15px">
            <router-link :to="{ name: 'BBoardRegisterPage' }">
                게시물 작성
            </router-link>
        </div>
        <bboard-list-form :bboards="bboards"/>
    </div>
</template>

<script>
import { mapActions, mapState } from 'vuex';
import BboardListForm from '@/components/practice/bboard/BboardListForm.vue'

const bboardModule = 'bboardModule'

export default {
     components: { BboardListForm },
    computed: {
        ...mapState(boardModule, ['boards']),
    },
    mounted() {
        this.requestBoardListToSpring()
    },
    methods: {
        ...mapActions(
            boardModule, ['requestBoardListToSpring']
        )
    },
}
</script>

<style lang="">
    
</style>