<template lang="">
    <div>
        <!--아래 submit을 사용하기 위해 @submit.prevent="onSubmit"을 넣어줬다-->
        <form @submit.prevent="onSubmit">
            <table>
                <tr>
                    <td>게시물 번호</td>
                    <td>
                        <!--게시물 번호는 고유값이기 때문에 뒤쪽에 disabled를 넣는다-->
                        <input type="text" :value="board.boardId" disabled/>
                    </td>
                </tr>
                <tr>
                    <td>제목</td>
                    <td>
                        <!--제목은 변경해도 되기 때문에 v-model로 넣어주었다.-->
                        <input type="text" v-model="title"/>
                    </td>
                </tr>
                <tr>
                    <td>작성자</td>
                    <td>
                        <!--어뷰징을 할 수 있기 때문에 disabled로 변경을 막아놨다.-->
                        <input type="text" :value="board.writer" disabled/>
                    </td>
                </tr>
                <tr>
                    <td>등록일자</td>
                    <td>
                        <!--중고거래 같은 사람들을 위해 변경을 불가하게 만든다.-->
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
                <!--submit-->
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
            //
            const { title, content, writer } = this            
            //this.$emit('@에서 작성한 emit 명칭', 현재 컴포넌트에서 전송할 Event나 Data 명)
            // 형식으로 보내줄 수 있다.
            this.$emit('submit', { title, content, writer })
        },
    }
}
</script>

<style lang="">
    
</style>