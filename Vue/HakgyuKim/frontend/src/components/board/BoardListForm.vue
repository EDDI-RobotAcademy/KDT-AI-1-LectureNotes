<template lang="">
    <div>
        <h3>게시물 목록</h3>
        <table style="margin: 10px">
            <tr>
                <th text-align="center" width="6%">번호</th>
                <th text-align="center" width="70%">제목</th>
                <th text-align="center" width="10%">작성자</th>
                <th text-align="center" width="14%">등록일자</th>
            </tr>
            <!--
                리스트에 값이 있다면 리스트대로 나오고 
                없다면 등록된 게시물 없다고 나오게 만듬
            -->
            <tr v-if="!boards || (Array.isArray(boards) && boards.length === 0)">
                <td colspan="4">
                    현재 등록된 게시물이 없습니다!
                </td>
            </tr>
            <tr v-else v-for="(board, index) in boards" :key="index">
                <td text-align="center">
                    {{ board.boardId }}
                </td>
                <td text-align="center">
                    <!-- 
                        게시물 제목을 누르면 게시물 읽는 페이지로 넘겨줌
                        param으로 지정한 게시물의 아이디값을 보내
                        지정한 게시물을 불러옴
                    -->
                    <router-link :to="{
                        name: 'BoardReadPage',
                        params: { boardId: board.boardId.toString() }}">
                            {{ board.title }}
                    </router-link>
                </td>
                <td text-align="center">
                    {{ board.writer }}
                </td>
                <td text-align="center">
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