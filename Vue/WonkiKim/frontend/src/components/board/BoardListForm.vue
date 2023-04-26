<template>
    <div>
        <h3>게시물 목록</h3>
        <table style="margin: 10px;">
            <tr>
                <th align="center" width="6%">번호</th>
                <th align="center" width="70%">제목</th>
                <th align="center" width="10%">작성자</th>
                <th align="center" width="14%">등록일자</th>
            </tr>
            <!--boards가 null이거나 || boards가 어레이면서 길이가 0이라면-->
            <tr v-if="!boards || (Array.isArray(boards) && boards.length === 0)">
                <td colspan="4">
                    현재 등록된 게시물이 없습니다!
                </td>
            </tr>
            <!--boards를 key로하는 v-for문-->
            <tr v-else v-for="board in boards" :key="board.boardId">
                <td align="center">
                    {{ board.boardId }}
                </td>
                <td align="center">
                    <!--
                    boards.title를 클릭하면 BoardReadPage로 이동한다. router-link에 router.push()가 내장되어 있음
                    boards.Id를 파라미터로 v-bind해준다.
                     -->
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
    // v-bind로 boards Array를 받았음.
    props: {
        boards: {
            type: Array
        }
    }
}
</script>

<style lang="">

</style>