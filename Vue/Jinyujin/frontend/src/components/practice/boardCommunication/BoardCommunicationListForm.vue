<template lang="">
    <div>
        <h3>상품 목록</h3>
        <table style="margin: 10px;">
            <tr>
                <th align="center" width="6%">번호</th>
                <th align="center" width="70%">제목</th>
                <th align="center" width="70%">가격</th>
                <th align="center" width="10%">작성자</th>
                <th align="center" width="14%">등록일자</th>
            </tr>
            <tr v-if="!filteredBoards || (Array.isArray(filteredBoards) && filteredBoards.length === 0)">
                <td colspan="4">
                    현재 등록된 상품이 없습니다!
                </td>
            </tr>
            <tr v-else v-for="board in filteredBoards" :key="board.boardId">
                <td align="center">
                    {{ board.boardId }}
                </td>
                <td align="center">
                    <router-link :to="{ 
                        name: 'BoardCommunicationReadPage', 
                        params: { boardId: board.boardId.toString() }}">
                            {{ board.title }}
                    </router-link>
                </td>
                <td align="center">
                    {{ board.price }}
                </td>
                <td align="center">
                    {{ board.writer }}
                </td>
                <td align="center">
                    {{ board.createDate }}
                </td>
            </tr>
            <input type="text" v-model="searchText" placeholder="찾는 상품명을 입력하세요"></input>
        </table>
    </div>
</template>

<script>
export default {
    data() {
        return {
            searchText:''
        }
    },
    props: {
        boards: {
            type: Array
        }
    },
    computed: {
        filteredBoards() {
            return this.boards.filter(board => {
                return board.title.toLowerCase().includes(this.searchText.toLowerCase());
            });
        }
    }
}
</script>

<style lang="">
</style>