<template lang="">
    <div>
        <!-- submit 이벤트가 발생하면 onSubmit 메소드를 실행하도록 합니다. -->
        <form @submit.prevent="onSubmit">
            <table>
                <tr>
                    <td>제목</td>
                    <td>
                        <input type="text" v-model="title"/>
                    </td>
                </tr>
                <tr>
                    <td>작성자</td>
                    <td>
                        <input type="text" v-model="writer"/>
                    </td>
                </tr>
                <tr>
                    <td>본문</td>
                    <td>
                        <textarea cols="80" rows="30" v-model="content"/>
                    </td>
                </tr>
            </table>

            <div>
                <!-- 
                    등록 버튼을 누르면 submit 이벤트가 발생하여 onSubmit 메소드가 실행됩니다. 
                    취소라는 문구를 누르면 router-link에 설정한 'BoardListPage'로 이동합니다.
                -->
                <button type="submit">등록</button>
                <router-link :to="{ name: 'BoardListPage' }">
                    취소
                </router-link>
            </div>
        </form>
    </div>
</template>

<script>
export default {
    name: "BoardRegisterForm",
    data () {
        return {
            title: '제목을 입력하세요',
            writer: '누구세요 ?',
            content: '본문을 입력하세요',
        }
    },
    methods: {
        onSubmit () {
            // onSubmit 매서드를 사용하여, submit 이벤트가 발생하였을 때 { title, content, writer }를 emit 합니다.
            // 즉 이 상수값을 연결된 다른 컴포넌트(부모 컴포넌트)로 보내는 행위입니다.
            const { title, writer, content } = this
            // BoardRegisterPage의 @submit은 여기의 submit에 대응함
            this.$emit('submit', { title, writer, content })
        }
    }
}
</script>

<style lang="">
    
</style>
