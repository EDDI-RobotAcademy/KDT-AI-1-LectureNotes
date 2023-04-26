<template lang="">
    <div>
        <table>
            <tr>
                <td>게시물 번호</td>
                <td>
                    <input type="text" :value="board.boardId" readonly/><!-- 읽기만 가능 -->
                </td>
            </tr>
            <tr>
                <td>제목</td>
                <td>
                    <input type="text" :value="board.title" readonly/><!-- 읽기만 가능 -->
                </td>
            </tr>
            <tr>
                <td>작성자</td>
                <td>
                    <input type="text" :value="board.writer" readonly/><!-- 읽기만 가능 -->
                </td>
            </tr>
            <tr>
                <td>등록일자</td>
                <td>
                    <input type="text" :value="board.createDate" readonly/><!-- 읽기만 가능 -->
                </td>
            </tr>
            <tr>
                <td>본문</td>
                <td>
                    <textarea cols="80" rows="30" :value="board.content" readonly/><!-- 읽기만 가능 -->
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
            type: Object,   // 타입 명시
            required: true,
        }
    }
}
</script>

<style lang="">
    
</style>