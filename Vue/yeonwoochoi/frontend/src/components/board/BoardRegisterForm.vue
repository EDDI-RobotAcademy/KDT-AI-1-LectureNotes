<template lang="">
    <div>
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
                <!-- submit을 누르면 바로 날아가는데 상단에 prevent 를 주어서 
                    바로 못날아가게 만듬 (등록한 화면 그대로 나타냄) -->
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
            const { title, writer, content } = this
            // BoardRegisterPage의 @submit은 여기의 submit에 대응 한다.
            // submit 이라는 이벤트를 발생시킨다. 
            this.$emit('submit', { title, writer, content })
        }
    }
}
</script>
<style lang="">
    
</style>