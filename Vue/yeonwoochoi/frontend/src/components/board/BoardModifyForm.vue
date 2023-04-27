<template lang="">
    <div>
        <!-- 수정할때 어떤것을 열고 닫을지 정하기 
        onSubmit이 동작하게 된다.-->
        <form @submit.prevent="onSubmit">
            <table>
                <tr>
                    <td>게시물 번호</td> <!-- 번호는 고유값이라 바뀌면 안된다. -->
                    <td>
                        <input type="text" :value="board.boardId" disabled/>
                    </td>
                </tr>
                <tr>
                    <td>제목</td>
                    <td>
                        <input type="text" v-model="title"/> <!-- 제목은 수정 가능해서 양방향으로 맵핑해서 v-model로 작성 -->
                    </td>
                </tr>
                <tr>
                    <td>작성자</td>
                    <td>
                        <input type="text" :value="board.writer" disabled/> <!-- 고유값이라 바뀌면 안된다. -->
                    </td>
                </tr>
                <tr>
                    <td>등록일자</td>
                    <td>
                        <input type="text" :value="board.createDate" disabled/>  <!-- 고유값이라 바뀌면 안된다. (보안 차원) -->
                    </td>
                </tr>
                <tr>
                    <td>본문</td>
                    <td>
                        <textarea cols="70" rows="25" v-model="content"/>  <!-- 바뀔 수 있음 -->
                    </td>
                </tr>
            </table>

            <div>
                 <!-- -->
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
            // emit을 하게되면 @submit="onSubmit"/>가 반응 한다.
            // submit은 이름이 같아야한다. (이름과 동일한 이벤트를 발생)
            this.$emit('submit', { title, content, writer })
        }
    }
}
</script>

<style lang="">
    
</style>