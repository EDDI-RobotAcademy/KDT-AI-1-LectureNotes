<template lang="">
    <div>
        <h2>Vue + Spring + JPA 게시판</h2>
        <div style="text-align: left; margin: 15px;">
            <router-link :to="{ name: 'BoardRegisterPage' }">
                게시물 작성
            </router-link>
        </div>
        <board-list-form :boards="boards"/>
        <p>{{ output }}</p>
    </div>
</template>

<script>
import { mapActions, mapState } from 'vuex';
import BoardListForm from '@/components/board/BoardListForm.vue'

const boardModule = 'boardModule'

export default {
    components: { BoardListForm },
    data () {
        return {
        }
    },
    // state 관리자인 vuex에 state값(boards)를 모니터링
    computed: {
        ...mapState(boardModule, ['boards']),
        output () {
            console.log('이런식으로 활용도 가능')
        }
    },
    mounted () {
        // vuex의 action 호출
        this.requestBoardListToSpring()
    },
    methods: {
        // vuex의 action을 method에 맵핑
        ...mapActions(
            boardModule, ['requestBoardListToSpring']
        )
    }
}
</script>

<style lang="">
    
</style>