<template lang="">
    <div>
        <h2>Vue + Spring + JPA 게시판</h2>
        <div style="text-align: left; margin: 15px;">
            <router-link :to="{ name: 'BoardRegisterPage' }">
                게시물 작성
            </router-link>
        </div>
        <board-list-form :boards="boards"/> 
        </div>
</template>

<script>
// npm install vuex --save-dev
import BoardListForm from '../components/BoardListForm.vue';
import { mapActions, mapState } from 'vuex';

const boardModule = 'boardModule' 

export default {
    components: { BoardListForm },
    computed: { 
        ...mapState(boardModule, ['boards']),
    },
    mounted () {
        this.requestBoardListToSpring()
        // console.log(boardModule.state)
        // console.log(boardModule.actions)
        // //this.requestBoardListToSpring()
        // this.$store.dispatch(`${boardModule}/requestBoardListToSrping`)
    },
    methods: {
        ...mapActions(
            boardModule, ['requestBoardListToSpring']
        )
    }
}
</script>

<style lang="">
    
</style>