<template lang="">
    <div>
        <h2>상품등록</h2>
        <board-register-form @submit="onSubmit"/>
    </div>
</template>

<script>
import Apple from '@/views/testpage/apple.vue'
import { mapActions } from 'vuex';

const boardModule = 'boardModule'

export default {
    components: {
        Apple,
    },
    name: "BoardRegisterPage",
    methods: {
        ...mapActions(
            boardModule, ['requestCreateBoardToSpring']
        ),
        async onSubmit (payload) {
            const board = await this.requestCreateBoardToSpring(payload)
            console.log('typeof(board): ' + typeof(board))
            console.log('board: ' + JSON.stringify(board))
            await this.$router.push({
                name: 'BoardReadPage',
                params: { boardId: board.data.boardId.toString() }

            })
        }
    }
}
</script>

<style lang="">
    
</style>