<template lang="">
  <v-container>
    <h2>Vue3 + TypeScript + Vuetify3 + Spring + JPA</h2>
    <v-card v-if="board">
      <v-card-title>게시물 수정</v-card-title>
      <v-card-text>
        <v-container>
          <v-row>
            <v-col cols="12">
              <v-text-field v-model="title" label="제목"/>
            </v-col>
          </v-row>
          <v-row>
            <v-col cols="12">
              <v-text-field v-model="board.writer" readonly label="작성자"/>
            </v-col>
          </v-row>
          <v-row>
            <v-col cols="12">
              <v-text-field v-model="board.createDate" readonly label="등록일자"/>
            </v-col>
          </v-row>
          <v-row>
            <v-col cols="12">
              <v-textarea v-model="content" label="내용"/>
            </v-col>
          </v-row>
          <v-row justify="end">
            <v-col cols="auto">
              <v-btn color="primary" @click="onModify">수정완료</v-btn>
            </v-col>
            <v-col cols="auto">
              <router-link :to="{ name: 'VuetifyBoardList' }">
                <v-btn color="secondary">돌아가기</v-btn>
              </router-link>
            </v-col>
          </v-row>
        </v-container>
      </v-card-text>
    </v-card>
  </v-container>
</template>

<script>
import { mapActions, mapState } from 'vuex';

const boardModule = 'boardModule'

export default {
    props: {
        boardId: {
            type: String,
            required: true,
        },
    },
    data () {
        return {
            title: '',
            content: '',
            writer: '',
        }
    },
    computed: {
        ...mapState(boardModule, ['board'])
    },
    methods: {
        ...mapActions(boardModule, ['requestBoardToSpring', 'requestModifyBoardToSpring']),
        async onModify () {
            const payload = {
                title: this.title,
                writer: this.writer,
                content: this.content,
                boardId: this.boardId
            }

            await this.requestModifyBoardToSpring(payload)
            await this.$router.push({
                name: 'VuetifyBoardRead',
                params: { boardId: this.boardId }
            })
        }
    },
    created () {
        this.requestBoardToSpring(this.boardId).then(() => {
            this.title = this.board.title
            this.writer = this.board.writer
            this.content = this.board.content
        })
    }
}
</script>
<style lang="">
    
</style>