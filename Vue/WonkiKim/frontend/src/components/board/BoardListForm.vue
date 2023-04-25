<template>
    <div>
        <h3>게시물 목록</h3>
        <table>
            <tr>
                <th align="center" width="5%">number</th>
                <th align="center" width="70%">title</th>
                <th align="center" width="10%">author</th>
                <th align="center" width="15%">edit date</th>
            </tr>
            <tr v-if="!board ||(Array.isArray(board) && board.length===0)">
                <td colspan="4">
                    no post
                </td>
            </tr>
            <tr v-else v-for="(board, index) in board" :key="index">
                <td align="center">
                    {{ board.boardId }}
                </td>
                <td align="center">
                    {{ board.title }}
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
    name: "BoardListForm",
    props: {
        board: {
            type: Array
        }
    }
}
</script>

<style scoped>

</style>