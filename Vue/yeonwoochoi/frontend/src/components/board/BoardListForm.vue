<template lang="">
    <div>
        <!-- 게시물 목록부터 번호, 제목, 작성자, 등록일자까지 표현 -->
        <h3>게시물 목록</h3>
        <table style="margin: 10px;">
            <tr>
                <!-- 가운데 정렬, 너비 표현 -->
                <th align="center" width="6%">번호</th>
                <th align="center" width="70%">제목</th>
                <th align="center" width="10%">작성자</th>
                <th align="center" width="14%">등록일자</th>
            </tr>
            <!-- 
                게시물이 없으면 등록된 게시물을 출력 한다. 

                v-if="!boards || (Array.isArray(boards) && boards.length === 0
                배열이 비어있는지 확인하는 코드로 '!' 부정문과 함께 사용한다.
                배열이 비어있으면 이 코드는 실행 되지 않는다.

                []자체를 새로 쓸 경우엔, 새로운 빈 배열이 만들어지기 때문에
                빈 배열을 받아오는 조건이 있을 경우엔 boards.length === 0 사용한다.
            -->
            <tr v-if="!boards || (Array.isArray(boards) && boards.length === 0)">
                <!-- 
                    <td> 태그의 colspan 속성은 해당 데이터 셀(data cell)이 확장될 열(column)의 개수를 명시 
                    "4" 번호, 제목, 작성자, 등록일자 
                -->
                <td colspan="4">
                    현재 등록된 게시물이 없습니다!
                </td>
            </tr>
            <!-- 
                for문을 돌면서 배열을 뽑아낸다. 
                v-else 위 코드의 조건이 아니라면 v-for 실행

                "board in boards" :key="board.boardId"

            -->
            <tr v-else v-for="board in boards" :key="board.boardId">
                <td align="center">
                    <!-- 번호 -->
                    {{ board.boardId }}
                </td>
                <td align="center">
                    <!-- router-link :to 이동하는 링크 -->
                    <router-link :to="{ 
                        // 게시물을 등록하고 클릭하면 읽기 페이지('BoardReadPage')로 이동한다. 
                        name: 'BoardReadPage', 
                        // 게시물(board)에 해당 번호(boardId)를 출력한다.
                        params: { boardId: board.boardId.toString() }}">
                            <!-- 제목 -->
                            {{ board.title }}
                    </router-link>
                </td>
                <td align="center">
                     <!-- 작성자 -->
                    {{ board.writer }}
                </td>
                <td align="center">
                     <!-- 등록일자 -->
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
            type: Array // boards는 배열 타입
        }
    }
}
</script>

<style lang="">
    
</style>