<template lang="">
    <div>
        <form @submit.prevent="onSubmit">
            <table>
                <tr>
                    <!-- 
                        수정하는 거니까 바꿀 수 있는 제목이나 내용은 v-model로 바꿔주고
                        나머지는 disabled 처리해서 건들지 못하도록
                    -->
                    <td>게시물 번호</td>
                    <!-- 고유값은 특히나 바꿀 수 없도록 -->
                    <td>
                        <input type="text" :value="board.boardId" disabled/>
                    </td>
                </tr>
                <tr>
                    <td>제목</td>
                    <td>
                        <input type="text" v-model="title"/>
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
        // props에 전달한 것을 가져오도록
        // <board-modify-form v-if="board" :board="board" @submit="onSubmit"/>
        // props에서 board 받는다고 했으니 스프링에서 받아온 데이터들을 :board를 통해 넣어주는 것
    },
    methods: {
        onSubmit () {
            const { title, content, writer } = this
            // const를 통해서 {} 안에 있는 애들을 맵핑해주는 것
            // 맵핑은? 어떤 값을 다른 값에 대응시키는 과정
            // 왜 함? 여기저기서 써먹을라고
            this.$emit('submit', { title, content, writer })
            // emit을 하면 modifyPage에 있는 submit이 반응함
            // emit하는 순간 페이지에 있는 submit이 반응하여 onSubmit이 동작
            // 그리고 수정 동작이 처리되는 것
        }
    }
}
</script>

<style lang="">
    
</style>