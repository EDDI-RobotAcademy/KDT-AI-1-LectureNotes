<template lang="">
    <div>
        <h3>게시물 목록</h3>
        <table style="margin: 10px;">
            <tr>
                <th align="center" width="6%">번호</th>
                <th align="center" width="70%">제목</th>
                <th align="center" width="10%">작성자</th>
                <th align="center" width="14%">등록일자</th>
            </tr>
            <!-- 
                v-if 디렉티브는 주어진 조건이 참일 경우에만 해당 요소를 랜더링한다.
            -->
            <!-- 
                !board 는 boards 배열이 존재하지 않을 때를 나타내며 
                Array.isArray(boards) && boards.length === 0 은 
                boards 배열이 존재하고 길이가 0일 때를 나타낸다.
                따라서 이 코드는 boards 배열이 없거나 비어있는 경우에 해당하는 
                HTML 태그를 렌더링한다.
            -->
            <tr v-if="!boards || (Array.isArray(boards) && boards.length === 0)">
                <td colspan="4">
                    현재 등록된 게시물이 없습니다!
                </td>  
            </tr>
            <!--
                v-else 디렉티브는 v-if 디렉티브와 함께 사용되어 주어진 조건이
                거짓일 경우에 해당하는 요소를 렌더링한다.
            -->
            <!--
                v-for 디렉티브는 배열의 각 요소를 반복하며 
                각 요소에 대해 HTML태그를 렌더링한다.
            -->
            <!--
                boards 배열의 각 요소를 board 변수에 할당하고 
                index 변수에 인덱스를 할당한다.
            -->
            <tr v-else v-for="board in boards" :key="board.boardId">
                <td align="center">
                    {{ board.boardId }}
                </td>
                <td align="center">
                    <router-link :to="{
                        name: 'BoardReadPage',
                        params: {boardId: board.boardId.toString()}}">
                            {{  board.title }}
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