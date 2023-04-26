<template lang="">
    <div>
        <h3>게시물 목록</h3>
        <table style="margin: 10px;">
            <tr>
                <th align="center" width="6%">번호</th>
                <th align="center" width="70%">제목</th>
                <th align="center" width="10%">작성자</th>
                <th align="center" width="14%">등록일자</th> <!-- 테이블 만드는 파트-->
            </tr>
            <tr v-if="!boards || (Array.isArray(boards) && boards.length === 0)"> <!-- boards가 아니거나 boards가 array가 아니거나 board의 길이가 0이면-->
                <td colspan="4"> <!-- 위의 4개 테이블을 합치고 -->
                    현재 등록된 게시물이 없습니다!<!-- 이 문구를 보여줌 -->
                </td>
            </tr>
            <tr v-else v-for="board in boards" :key="board.boardId"><!-- 아니라면 boards에 들어있는 board만큼 생성 board의 key는 boardId-->
                <td align="center">
                    {{ board.boardId }} <!-- boardId를 보여줌 -->
                </td>
                <td align="center">
                    <router-link :to="{ 
                        name: 'BoardReadPage',  
                        params: { boardId: board.boardId.toString() }}"> <!-- 누르면 BoardReadPage로 이동 boardId는 Spring으로 받아옴 -->
                            {{ board.title }}
                    </router-link>
                </td>
                <td align="center">
                    {{ board.writer }}<!-- writer를 보여줌 -->
                </td>
                <td align="center">
                    {{ board.createDate }}<!-- createdate를 보여줌 -->
                </td>
            </tr>
        </table>
    </div>
</template>

<script>
export default {
    props: {
        boards: {       
            type: Array     // boards의 타입을 명시해줌
        }
    }
}
</script>

<style lang="">
    
</style>