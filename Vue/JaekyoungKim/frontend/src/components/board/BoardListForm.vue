<template lang="">
    <div>
        <h3>게시물 목록</h3>
        <table style="margin: 10px;">
            <tr><!-- 같은 줄에 차지하는 퍼센트 지정해줌-->
                <th align="center" width="6%">번호</th>
                <th align="center" width="70%">제목</th>
                <th align="center" width="10%">작성자</th>
                <th align="center" width="14%">등록일자</th>
            </tr>
            <tr v-if="!boards || (Array.isArray(boards) && boards.length === 0)">
                <!--보드가 비어있으면 등록된 게시물이 없다고 표출해줌 -->
                <td colspan="4">
                    현재 등록된 게시물이 없습니다!
                </td>
            </tr>
            <tr v-else v-for="board in boards" :key="board.boardId">
                <!--그게 아니고 보드가 비어있지 않으면 boards 내부의  board 갯수만큼 반복해서 표출해줌-->
                <td align="center">
                    {{ board.boardId }}
                </td>
                <td align="center">
                    <router-link :to="{ 
                        name: 'BoardReadPage', 
                        params: { boardId: board.boardId.toString() }}">
                            {{ board.title }}<!--제목을 누르면 해당 게시물을 읽을 수 있도록 만들어준 것-->
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