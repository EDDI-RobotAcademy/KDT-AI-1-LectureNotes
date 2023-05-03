<template lang="">
    <div>
        <!-- 
        수정할때 어떤것을 열고 닫을지 정하기 
        onSubmit이 동작하게 된다.
        -->
        <form @submit.prevent="onSubmit">
            <table>
                <tr>
                    <td>게시물 번호</td> 
                    <td>
                        <!-- 
                        input 태그의 속성 값에 해당하다. 
                        :value값을 변경하면 경한 값으로 버튼 내부의 글자가 바뀐다. 
                        input에 설정되는 값이라는 의미로 사용되는 것이 value고,
                        vue에서는 v-bind를 통해서 javascript 데이터를 바로 맵핑 한다.

                        v-bind:value=”xxx” 형태는 :value=”xxx” 형태로 축약할 수 있다.
                        예 :table-data="tableData" >> v-bind:table-data="tableData"
                        -->
                        <input type="text" :value="board.boardId" disabled/> <!-- disabled 번호는 고유값이라 바뀌면 안된다. -->
                    </td>
                </tr>
                <tr>
                    <td>제목</td>
                    <td>
                        <!-- 
                            제목은 수정 가능해서 양방향으로 맵핑해서 v-model로 작성 한다.
                        
                            사용자의 입력으로 변경이 필요한 경우 v-model을 써서 data에 들어있는 값을 바꿀 수 있도록 구성한다. 
                            반면 바꿀 필요가 없다면 어차피 사용자가 입력도 못하기 때문에 v-model을 사용할 필요 없이 v-bind면 충분하다.
                        -->
                        <input type="text" v-model="title"/> 
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
                <button type="submit">수정 완료</button>
                <router-link :to="{ 
                    // 수정 완료 하면 BoardReadPage 로 이동
                    name: 'BoardReadPage', 
                    params: { boardId: board.boardId.toString() }
                }">수정 취소</router-link>
            </div>
        </form>
    </div>
</template>

<script>
export default {
    // props 매개변수
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
            // emit을 하게되면 @submit="onSubmit" 반응 한다.
            // submit은 이름이 같아야한다. (이름과 동일한 이벤트를 발생)
            this.$emit('submit', { title, content, writer })
        }
    }
}
</script>

<style lang="">
    
</style>