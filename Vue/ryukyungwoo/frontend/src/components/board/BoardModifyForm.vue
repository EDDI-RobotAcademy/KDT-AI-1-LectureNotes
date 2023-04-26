<template lang="">
    <div>
        <form @submit.prevent="onSubmit"> <!-- onSubmit이 자동실행 되는 것을 방지 -->
            <table>
                <tr>
                    <td>게시물 번호</td>
                    <td>
                        <input type="text" :value="board.boardId" disabled/><!-- 읽기만 가능-->
                    </td>
                </tr>
                <tr>
                    <td>제목</td>
                    <td>
                        <input type="text" v-model="title"/> <!-- 수정 가능-->
                    </td>
                </tr>
                <tr>
                    <td>작성자</td>
                    <td>
                        <input type="text" :value="board.writer" disabled/> <!-- 읽기만 가능-->
                    </td>
                </tr>
                <tr>
                    <td>등록일자</td>
                    <td>
                        <input type="text" :value="board.createDate" disabled/> <!-- 읽기만 가능-->
                    </td>
                </tr>
                <tr>
                    <td>본문</td>
                    <td>
                        <textarea cols="70" rows="25" v-model="content"/> <!-- 수정 가능 -->
                    </td>
                </tr>
            </table>

            <div>
                <button type="submit">수정 완료</button> <!-- 누르면 submit 실행 -->
                <router-link :to="{ 
                    name: 'BoardReadPage', 
                    params: { boardId: board.boardId.toString() }
                }">수정 취소</router-link> <!-- 누르면 Spring에서 준 boardId 값으로 BoardReadPage로 이동-->
            </div>
        </form>
    </div>
</template>

<script>
export default {
    props: {
        board: {
            type: Object,   // 타입 명시해줌
            required: true,
        }
    },
    data () {
        return {     // 값 초기화
            title: '', 
            content: '',
            writer: '',
            createDate: '',
        }
    },
    created () { // 시작 단계에서 정의해줌                 
        this.title = this.board.title     
        this.content = this.board.content
        this.writer = this.board.writer
        this.createDate = this.board.createDate
    },
    methods: {
        onSubmit () {
            const { title, content, writer } = this // 위의 title, content, writer 불변객체 화
            this.$emit('submit', { title, content, writer }) // submit에 title, content, writer 넣어줌
        }
    }
}
</script>

<style lang="">
    
</style>