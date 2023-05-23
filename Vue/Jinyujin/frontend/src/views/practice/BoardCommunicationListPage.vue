
<template lang="">
    <div>
        <h2>상품 통신 연습 게시판</h2>
        <div style="text-align: left; margin: 15px;">
            <router-link :to="{ name: 'BoardCommunicationRegisterPage' }">
                상품 등록
            </router-link>
        </div>
        <board-communication-list-form :boards="boards"/>
    </div>
</template>

<script>
import { mapActions, mapState } from 'vuex';
import BoardCommunicationListForm from '@/components/practice/boardCommunication/BoardCommunicationListForm.vue'

const boardCommunicationModule = 'boardCommunicationModule'

export default {
    components: { BoardCommunicationListForm },
    computed: {
        ...mapState(boardCommunicationModule, ['boards']),
    },
    mounted() {
        this.requestBoardCommunicationListToSpring()
    },
    methods: {
        ...mapActions(
            boardCommunicationModule, ['requestBoardCommunicationListToSpring']
        )
    },
}
</script>

<style lang="">
</style>