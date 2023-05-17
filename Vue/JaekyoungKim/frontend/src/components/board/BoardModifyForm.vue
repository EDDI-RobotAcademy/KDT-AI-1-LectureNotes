<template lang="">
    <div>
        <form @submit.prevent="onSubmit">
            <table>
            <tr><!--게시물 번호와 작성자 등록일자는 변경 불가로 disabled를 걸고
            제목과 본문만 변경 가능하게 한다.-->
                <td>게시물 번호</td>
                <td>
                    <input type="text" :value="board.boardId" disabled/>
                </td>
            </tr>
            <tr>
                <td>제목</td>
                <td>
                    <input type="text" v-model="title" />
                </td>
            </tr>
            <tr>
                <td>작성자</td>
                <td>
                    <input type="text" :value="board.writer" disabled/>
                </td>
            </tr>
            <tr>
                <td>등록일자</td>
                <td>
                    <input type="text" :value="board.createDate" disabled/>
                </td>
            </tr>
            <tr>
                <td>본문</td>
                <td>
                    <textarea cols="80" rows="25" v-model="content" />
                </td>
            </tr>
        </table>
    <div>
        <button type="submit">수정 완료</button>
        <!--수정 취소를 하면 읽기 페이지로 가도록 설정함 수정한 boardId에 맞춰서
        읽히도록 한다.-->
        <router-link :to="{
            name:'BoardReadPage',
            params: {boardId: board.boardId.toString()}
        }">수정 취소</router-link><!-- 리드 페이지로 돌아감 보드 아이디에 맞춰서-->
    </div>
    </form>
    </div>
</template>
<script>
export default {
    props: {
        board: {
            type: Object,
            required: true,
            //required: true-꼭필요하다는 뜻
        }
    },
    data () {
        return {
            title: '',
            content: '',
            writer: '',
            createDate: '',
        }
    },
    created () {
        this.title = this.board.title //스프링에서 id에 맞게 받아온 정보들을 보여주기 위함
        this.content = this.board.content
        this.writer = this.board.writer
        this.createDate = this.board.createDate
    },
    methods: {
        onSubmit () {
            const { title, content, writer } = this
            this.$emit('submit', { title, content, writer })
            //onSubmit을 통해 submit이 활성화됨으로 수정이 완료됨
        }
    }
}
</script>

<style lang="">
    
</style>
