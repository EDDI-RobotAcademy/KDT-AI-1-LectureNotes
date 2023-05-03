<template lang="">
    <div>
        <h3>게시물 목록</h3>
        <table style="margin: 10px;"> <!--margin: boarding(ㅁ) 바깥 여백-->
            <tr>
                <th align="center" width="6%">번호</th>
                <th align="center" width="70%">제목</th>
                <th align="center" width="10%">작성자</th>
                <th align="center" width="14%">등록일자</th>
            </tr>
            <tr v-if="!boards || (Array.isArray(boards) && boards.length === 0)">
                <td colspan="4">
                    현재 등록된 게시물이 없습니다!
                </td>
            </tr>
            <tr v-else v-for="board in boards" :key="board.boardId">
                <!-- <v-for="아이템 in Array" :key="">
                v-for 반복 boards(array)가 반복되면서 board(아이템)를 불러오겠다.
                유니크한 key값을 갖고 있어야한다.
                여기서는 key는 게시물의 게시물아이디로 하겠다
                -->
                <td align="center">
                    {{ board.boardId }}
                </td>
                <td align="center">
                    <!--제목 누르면 라우터링크(router.push() 내장)를 통해 객체를 전달할 것
                    name:BoardReadPage로 가라 & params(파라미터)로 boardId
                    v-bind(:) 부모가 자식에서 주는것
                    BoardListFoam에서 BoardReadPage로 가-->
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