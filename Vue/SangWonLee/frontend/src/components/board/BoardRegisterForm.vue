<template lang="">
    <div>
        <form @submit.prevent="onSubmit">
<!-- 
@submit.prevent는 submit 이벤트가 발생했을 때 기본 동작을 막고(prevent) onSubmit 메서드를
호출 하는 이벤트 리스너를 추가하는 것을 의미한다. 즉, form 태그 안에서 submit 이벤트가 발생하면
브라우저의 기본 동작이 막혀서 페이지가 새로고침이 되지 않고, 대신 onSubmit 메서드가 호출된다.

이러한 행위를 하는 이유는 폼 데이터를 전송하면 페이지가 새로고침 되는데, 이를 막기 위함이다.
이렇게 하면 페이지가 새로고침 되지 않고도 폼 데이터를 서버로 전송할 수 있음.

-->            
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
                        <textarea cols="80" rows="10" v-model="content"/>
                    </td>
                </tr>
            </table>

            <div>
                <button type="submit">등록</button>
                <router-link :to="{ name: 'BoardListPage' }"><br>
                    취소
                </router-link>
            </div>
        </form>
    </div>
</template>

<script>
export default {
    name: "BoardRegisterForm",
    data() {
        return {
            title: '제목을 입력하세요',
            writer: '누구세요 ?',
            content: '본문을 입력하세요',
        }
    },
    methods: {
        onSubmit() {
            const { title, writer, content } = this
            // BoardRegisterPage의 @submit은 여기의 submit에 대응함
            this.$emit('submit', { title, writer, content })
        }
    }
}
</script>

<style lang="">
    
</style>