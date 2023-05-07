<template>
    <div>
        <table>
            <tr>
                <td>게시물 번호</td>
                <td>
                    <input type="text" :value="board.boardId" readonly/>
                </td>
            </tr>
            <tr>
                <td>제목</td>
                <td>
                    <input type="text" :value="board.title" readonly/>
                </td>
            </tr>
            <tr>
                <td>작성자</td>
                <td>
                    <input type="text" :value="board.writer" readonly/>
                </td>
            </tr>
            <tr>
                <td>등록일자</td>
                <td>
                    <input type="text" :value="board.createDate" readonly/>
                </td>
            </tr>
            <tr>
                <td>본문</td>
                <td>
                    <textarea cols="80" rows="30" :value="board.content" readonly/>
                </td>
            </tr>
        </table>
    </div>
</template>

<script>
export default {
    name: "BoardReadForm",
    props: {
        board: {
            type: Object,
            // v-bind로 받은 프로퍼티가 반드시 필요한 프로퍼티라면 required를 true로 선언한다.
            required: true,
        }
    }
}
</script>

<style lang="">
    
</style>