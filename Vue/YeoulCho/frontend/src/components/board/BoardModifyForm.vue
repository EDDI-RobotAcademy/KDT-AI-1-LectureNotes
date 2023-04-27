<template lang="">
    <div>
        <form @submit.prevent="onSubmit">
            <table>
                <tr>
                    <td>게시물 번호</td>
                    <td>
                        <input type="text" :value="board.boardId" disabled/>
                        <!--바뀌면 안되니까 v-bind-->
                    </td>
                </tr>
                <tr>
                    <td>제목</td>
                    <td>
                        <input type="text" v-model="title"/>
                        <!--제목은 수정가능해야하니까 양방향 맵핑-->
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
                        <textarea cols="70" rows="25" v-model="content"/>
                    </td>
                </tr>
            </table>

            <div>
                <button type="submit">수정 완료</button>
                <router-link :to="{ 
                    name: 'BoardReadPage', 
                    params: { boardId: board.boardId.toString() }
                }">수정 취소</router-link>
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
        this.title = this.board.title
        this.content = this.board.content
        this.writer = this.board.writer
        this.createDate = this.board.createDate
    },
    methods: {
        onSubmit () {
            const { title, content, writer } = this
            //emit하면 BoardModifyPage.vue의 onSubmit 작동
            this.$emit('submit', { title, content, writer })
        }
    }
}
</script>

<style lang="">
    
</style>