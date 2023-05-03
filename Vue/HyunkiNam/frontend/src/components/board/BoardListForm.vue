<template lang="">
    <div>
        <h3>게시물 목록</h3>
        <table>
            <tr>
                <th align="center" width="5%">번호</th>
                <th align="center" width="70%">제목</th>
                <th align="center" width="10%">작성자</th>
                <th align="center" width="15%">등록일자</th>
            </tr>
            <!-- boards 유효성 검사 -->
            <tr v-if="!boards || (Array.isArray(boards) && boards.length === 0)">
                <td colspan="4">
                    현재 등록된 게시물이 없습니다!
                </td>
            </tr>
            <!-- boards에 있는 정보를 하나씩 꺼냄 키값은 boardId로 설정 -->
            <tr v-else v-for="board in boards" :key="board.boardId">
                <td align="center">
                    {{ board.boardId }}
                </td>
                <td align="center">
                    <!-- BoardReadPage로 이동하는데 boardId를 같이 가지고 감 -->
                    <router-link :to="{
                        name: 'BoardReadPage',
                        params: {boardId: board.boardId.toString()}}">
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
    // boards 타입 Array로
    props: {
        boards: {
            type: Array
        }
    }
}
</script>

<style lang="">
    
</style>