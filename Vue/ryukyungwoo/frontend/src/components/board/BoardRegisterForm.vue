<template lang="">
    <div>
        <form @submit.prevent="onSubmit"> <!-- onSubmit 자동 실행 방지 -->
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
                <button type="submit">등록</button> <!-- 누르면 submit 실행 -->
                <router-link :to="{ name: 'BoardListPage' }"> <!-- 누르면 BoardListPage로 이동 -->
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
            title: '제목을 입력하세요', // 각 값들의 기본 세팅
            writer: '누구세요 ?',
            content: '본문을 입력하세요',
        }
    },
    methods: {
        onSubmit () {
            const { title, writer, content } = this 
            // BoardRegisterPage의 @submit은 여기의 submit에 대응함
            this.$emit('submit', { title, writer, content })
        }
    }
}
</script>

<style lang="">
    
</style>