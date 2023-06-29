<template lang="">
  <v-container>
    <h2>안녕 Vue3 TypeScript 기반 Board App이야</h2>
    <div style="text-align: left; margin: 15px;">
      <router-link :to="{ name: 'VuetifyBoardRegister' }">
        게시물 작성
      </router-link>
    </div>
    <v-data-table
        v-model:items-per-page="perPage"
        :headers="headerTitle"
        :items="pagedItems"
        :pagination.sync="pagination"
        class="elevation-1"
        @click:row="readRow"
        item-value="boardId"/>
    <v-pagination
        v-model="pagination.page"
        :length="Math.ceil(boards.length / perPage)"
        color="primary"
        @input="updateItems"/>
  </v-container>
</template>

<script>
import { RouterLink } from 'vue-router';
import { mapActions, mapState } from 'vuex';

const boardModule = 'boardModule'

export default {
    components: {
        RouterLink
    },
    computed: {
        ...mapState(boardModule, ['boards']),
        pagedItems () {
            const startIdx = (this.pagination.page - 1) * this.perPage
            const endIdx = startIdx + this.perPage
            return this.boards.slice(startIdx, endIdx)
        }
    },
    mounted () {
        this.requestBoardListToSpring()
    },
    methods: {
        ...mapActions(boardModule, ['requestBoardListToSpring']),
        readRow (event, { item }) {
            const selectedRowBoardId = item.selectable.boardId

            this.$router.push({
                name: 'VuetifyBoardRead',
                params: { boardId: selectedRowBoardId.toString() }
            })
        }
    },
    data () {
        return {
            headerTitle: [
                { 
                    title: 'No',
                    align: 'start',
                    sortable: true,
                    key: 'boardId',
                },
                { title: '제목', align: 'end', key: 'title' },
                { title: '작성자', align: 'end', key: 'writer' },
                { title: '작성일자', align: 'end', key: 'createDate' },
            ],
            perPage: 5,
            pagination: {
                page: 1,
            }
        }
    }
}

</script>

<style lang="">
    
</style>