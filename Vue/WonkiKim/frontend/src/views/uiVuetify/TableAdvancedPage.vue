<template>
    <v-container>
        <v-data-table :headers="headerTitle" :items="boards"
                      :items-per-page="7" class="elevation-1"
                      @click:row="readRow" show-select
                      item-key="boardId" v-model="selectedItems"/>
    </v-container>
</template>

<script>
import router from '@/router';
import { mapActions, mapState } from 'vuex';
const boardModule = 'boardModule'
export default {
    name: "TableAdvancedPage",
    data() {
        return {
            headerTitle: [
                {text: 'id', value: 'boardId', width: "10%"},
                {text: '제목', value: 'title', width: "70%"},
                {text: '작성자', value: 'writer', width: "10%"},
                {text: '등록일자', value: 'createDate', width: "10%"},
            ],
            selectedItems: [],
        }
    },
    computed: {
        ...mapState(boardModule, ['boards'])
    },
    methods: {
        ...mapActions(boardModule, ['requestBoardListToSpring']),
        readRow(readValue) {
            router.push({
                name: 'BoardReadPage',
                params: { boardId: readValue.boardId.toString() }
            })
        }
    }
}
</script>

<style scoped>

</style>