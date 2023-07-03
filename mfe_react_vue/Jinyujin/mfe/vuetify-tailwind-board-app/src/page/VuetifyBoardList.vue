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
        <!-- 
            pagination.sync는 양방향 데이터 바인딩 기능 (Vue에 내장되어 있는 기능)
            v-pagination태그 내에서 현재 페이지를 변경하는 경우,
            pagination.page 속성이 업데이트 됨 
            -> 양방향 동기화되기 때문에 템플릿에 자동으로 반영됨
            이는 페이징 처리를 원활하게 하기 위해 필요한 기능
        -->
    <v-pagination 
        v-model="pagination.page"
        :length="Math.ceil(boards.length / perPage)"
        color="primary"
        @input="updateItems"/>
        <!-- 
            v-model="pagination.page": 이걸로 현재 페이지 번호를 추적할 수 있음
            Math.ceil: 반올림 함수
            boards 배열의 길이를 perPage(5)로 나눈 값으로 총 페이지 수를 계산함
            updateItems: 지금 코드에서는 안쓰이고 있음 
            보통은 페이지 번호 변경에 따른 데이터 업데이트와 관련된 로직을 처리하기 위해 사용됨
         -->
    </v-container>
</template>

<script>
// import { RouterLink } from 'vue-router'
import { mapActions, mapState } from 'vuex'

const boardModule = 'boardModule'

export default {
    // components: {
    //    RouterLink 
    // },
    computed: {
        ...mapState(boardModule, ['boards']),
        pagedItems() {
            const startIdx = (this.pagination.page - 1) * this.perPage
            // perPage는 5로 한 페이지 당 아이템 수
            const endIdx = startIdx + this.perPage
            return this.boards.slice(startIdx, endIdx)
            // boards 배열의 startIdx번째부터 endIdx번째까지의 아이템을 반환
        }
    },
    mounted() {
        this.requestBoardListToSpring()
    },
    methods: {
        ...mapActions(boardModule, ['requestBoardListToSpring']),
        readRow(event, { item }) {
            // event: 예를 들어 클릭 이벤트가 발생한 경우, 클릭한 요소와 관련된 정보를 제공함
            const selectedRowBoardId = item.selectable.boardId
            // selectable: Vue의 내장 기능이 아닌데 사용자가 만들어서 쓸 수 있는 것
            // item 객체를 활용하여 boardId 속성을 가져오는데 쓰임
            this.$router.push({
                name: 'VuetifyBoardRead',
                params: { boardId: selectedRowBoardId.toString() }
            })
        }
    },
    data() {
        return {
            headerTitle: [
                {
                    title: 'No',
                    align: 'start',
                    sortable: true, // 정렬
                    key: 'boardId'
                },
                { title: '제목', align: 'end', key: 'title' },
                { title: '작성자', align: 'end', key: 'writer' },
                { title: '작성일자', align: 'end', key: 'createDate' },
            ],
            perPage: 5,
            pagination: {
                page: 1,
                // 현재 선택된 페이지 나타내기
                // page: 1이라는 것은 초기에 표기되는 페이지가 1번째 페이지라는 것
            }
        }
    }
    
}
</script>
<style lang="">
    
</style>