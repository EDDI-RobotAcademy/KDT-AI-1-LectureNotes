<template lang="">
    <div>
        <h3>게시물 목록</h3>
        <table style="margin: 10px;">
            <tr>
                <th align="center" width="6%">번호</th>
                <th align="center" width="70%">제목</th>
                <th align="center" width="10%">작성자</th>
                <th align="center" width="14%">등록일자</th>
            </tr>
            <!-- 
                boards(게시글 목록)를 확인합니다.
                1. !boards : boards 가 없다. (undefined)
                2. Array.isArray(boards) && boards.length === 0 : boards가 배열이고 그 길이가 0이다.
                
                1번이거나 2번이면 "현재 등록된 게시물이 없습니다!"를 출력,
                아니라면 for문을 돌며 boards를 출력합니다.
            -->
            <tr v-if="!boards || (Array.isArray(boards) && boards.length === 0)">
                <td colspan="4">
                    현재 등록된 게시물이 없습니다!
                </td>
            </tr>
            <tr v-else v-for="board in boards" :key="board.boardId">
                <td align="center">
                    {{ board.boardId }}
                </td>
                <td align="center">
                    <router-link :to="{ 
                        name: 'BoardReadPage', 
                        params: { boardId: board.boardId.toString() }}">
                            {{ board.title }}
                    </router-link>
                </td>
                <td align="center">
                    {{ board.writer }}
                </td>
                <td align="center">
                    {{ board.createDate }}
                </td>
            </tr>
        </table>
    </div>
</template>

<script>
export default {
    props: {
        boards: {
            type: Array
        }
    }
}
</script>

<style lang="">
    
</style>