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
            // $는 vue 내장 기능이고 Bulitin Function이라고 부른다.
            // store에 직접 접근하는 방법도 있지만 이와 같이 직접 접근할 때 $를 쓰면 vue 객체에 직접 접근도 가능하다.
            // 코드 타입시스템을 보면 TypeScript에서는 data: string과 같은 형태로 변수: 타입을 표기한다.
            // $emit의 타입은 Emit이고  (event: string, …args: any[]) ⇒ Vue이다.
            // BoardRegisterPage의 @submit은 여기의 submit에 대응 한다.
            // submit 이라는 이벤트를 발생시킨다. 
            this.$emit('submit', { title, writer, content })
        }
    }
}
</script>
<style lang="">
    
</style>