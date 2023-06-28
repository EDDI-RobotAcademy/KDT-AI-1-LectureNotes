<template lang="">
  <v-container>
    <v-row>
      <v-col cols="12">
        <v-text-field v-model="title" label="제목"/>
      </v-col>
    </v-row>
    <v-row>
      <v-col cols="12">
        <v-text-field v-model="writer" label="작성자"/>
      </v-col>
    </v-row>
    <v-row>
      <v-col cols="12">
        <v-textarea v-model="content" label="내용" auto-grow/>
      </v-col>
    </v-row>
    <v-row>
      <v-col cols="12" style="text-align: right">
        <v-btn class="ml-2" color="primary" @click="onSubmit">작성 완료</v-btn>
        <v-btn class="ml-2" color="error" @click="onCancel">취소</v-btn>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import { mapActions } from 'vuex';

const boardModule = 'boardModule'

export default {
    data() {
        return {
            title: "",
            writer: "",
            content: ""
        }
    },
    methods: {
        ...mapActions(boardModule, ['requestCreateBoardToSpring']),
        async onSubmit () {
            const payload = {
                title: this.title,
                writer: this.writer,
                content: this.content
            }

            const board = await this.requestCreateBoardToSpring(payload)
            await this.$router.push({
                name: 'VuetifyBoardRead',
                params: { boardId: board.boardId.toString() }
            })
        },
        onCancel () {
            this.$router.go(-1)
        }
    }
    
}
</script>
<style lang="">
    
</style>