<template lang="">
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
    data () {
        return {
            headerTitle: [
                { text: '번호', value: 'boardId', width: "70px" },
                { text: '제목', value: 'title', width: "200px" },
                { text: '작성자', value: 'writer', width: "100px" },
                { text: '등록일자', value: 'createDate', width: "100px" },
            ],
            selectedItems: [],
        }
    },
    computed: {
        ...mapState(boardModule, ['boards']),
    },
    mounted () {
        this.requestBoardListToSpring()
    },
    beforeUpdate () {
        console.log('selected: ' + JSON.stringify(this.selectedItems))
    },
    methods: {
        ...mapActions(boardModule, ['requestBoardListToSpring']),
        readRow (readValue) {
            alert('게시물 읽기: ' + JSON.stringify(readValue))

            router.push({
                name: 'BoardReadPage',
                params: { boardId: readValue.boardId.toString() }
            })
        }
    }
}
</script>

<style lang="">
    
</style>