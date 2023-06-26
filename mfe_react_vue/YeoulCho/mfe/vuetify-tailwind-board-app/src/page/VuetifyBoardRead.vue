<template lang="">
    <v-container>
        <h2>Vue + TypeScript + Vuetify3 + Spring + Jpa</h2>
        <v-card v-if="board">
            <v-card-title>게시물 정보</v-card-title>
            <v-card-text>
                <v-container>
                    <v-row>
                        <v-col cols="12">
                            <v-text-field
                                v-model="board.title" readOnly label="제목"/>
                        </v-col>
                    </v-row>
                    <v-row>
                        <v-col cols="12">
                            <v-text-field
                                v-model="board.writer" readOnly label="작성자"/>
                        </v-col>
                    </v-row>
                    <v-row>
                        <v-col cols="12">
                            <v-textarea
                                v-model="board.content" readOnly label="내용"/>
                        </v-col>
                    </v-row>
                    <v-row justify="end">
                        <v-col cols="12" class="text-right">
                            <v-btn class="ml-2" color="primary" @click="onSubmit">수정하기</v-btn>
                            <v-btn class="ml-2" color="error" @click="onDelete">삭제</v-btn>
                            <v-btn class="ml-2" color="secondary" @click="onCancle">돌아가기</v-btn>
                        </v-col>
                    </v-row>
                </v-container>
            </v-card-text>
        </v-card>
    </v-container>
</template>
<script>
const boardModule = 'boardModule'
import {mapActions, mapState} from 'vuex'

export default {
    props:{
        boardId:{
            type: String,
            required: true,
        }         
    },
    data(){
        return{
            title: '',
            writer: '',
            content: ''
        }
    },
    computed:{
        ...mapState(boardModule, ['board'])
    },
    methods:{
        ...mapActions(boardModule, ['requestBoardToSpring']),
        async onDelete(){

        },
    },
    created () {
        this.requestBoardToSpring(this.boardId)
    }
}
</script>
<style lang="">
    
</style>