<template lang="">
    <div>
        <!-- 
            게시글 읽기 페이지의 기본 양식입니다.
            읽기 페이지므로 모든 값은 readonly로 설정합니다.
        -->
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
    // 현재 컴포넌트에서 사용할 props는 board이며 이것은 객체 타입입니다.
    // 이 컴포넌트를 사용할 때 반드시 board라는 이름으로 props를 전달해주어야 합니다. (required: true)
    name: "BoardReadForm",
    props: {
        board: {
            type: Object,
            required: true,
        }
    }
}
</script>

<style lang="">
    
</style>