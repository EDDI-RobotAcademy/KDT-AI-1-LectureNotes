<template lang="">
    <div>
        <!-- 
            prevent를 사용하여 submit 이벤트가 발생하면 
            onSubmit 메소드를 실행하도록 합니다. 

            form을 제출하면 기본적으로 페이지가 새로고침되어 onSubmit 매서드가 실행되지 않습니다.
            @submit.prevent를 설정함으로써 폼 제출이 되지 않고 onSubmit 매서드가 실행되도록 합니다.

            기본 동작을 막고 원하는 동작을 할 수 있도록 prevent를 사용합니다.
        -->
        <form @submit.prevent="onSubmit">
            <table>
                <tr>
                    <!-- 
                        수정이 가능한 제목, 본문은 v-model로 설정하고
                        수정이 불가능한 게시물 번호, 작성자, 등록일자는 비활성화 합니다.
                    -->
                    <td>게시물 번호</td>
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
                <!-- 
                    수정 완료 버튼을 누르면 submit 이벤트가 발생하여 onSubmit 메소드가 실행됩니다. 
                    수정 취소라는 문구를 누르면 router-link에 설정한 'BoardReadPage'로 이동합니다.
                -->
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
    
    // 현재 컴포넌트에서 사용할 props는 board이며 이것은 객체 타입입니다.
    // 이 컴포넌트를 사용할 때 반드시 board라는 이름으로 props를 전달해주어야 합니다. (required: true)
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
    // onSubmit 매서드를 사용하여, submit 이벤트가 발생하였을 때 { title, content, writer }를 emit 합니다.
    // 즉 이 상수값을 연결된 다른 컴포넌트(부모 컴포넌트)로 보내는 행위입니다.
    methods: {
        onSubmit () {
            const { title, content, writer } = this
            this.$emit('submit', { title, content, writer })
        }
    }
}
</script>

<style lang="">
    
</style>