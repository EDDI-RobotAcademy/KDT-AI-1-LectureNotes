<template>
    <v-container>
        <div>
            <h1>problem 4, 5, 6</h1>

<!--            title: 클라이언트에서 요청하면 서버에서 주사위 숫자를 전송합니다.-->

<!--            Success Criteria:-->
<!--            클라이언트는 서버로 get요청을 전송합니다.-->
<!--            서버는 get요청을 받으면 무작위 주사위 숫자를 생성하여 응답합니다.-->
<!--            클라이언트는 응답받은 주사위 숫자를 표시합니다.-->

<!--            TODO:-->
<!--            클라이언트에서 get요청을 보내는 axios작성-->
<!--            클라이언트에서 axios를 실행시킬 버튼 작성-->
<!--            서버에서 get요청을 받는 getMapping 작성-->
<!--            랜덤하게 주사위 숫자를 생성하는 메서드 작성-->
<!--            클라이언트에서 respons를 받았을때 화면에 출력하는 컴포넌트 작성-->
        </div>
        <v-btn @click="getDice">roll Dice</v-btn>
        <p>{{diceNumber}}</p>
    </v-container>
</template>

<script>
import axiosInst from "@/utility/axiosInst";

export default {
    name: "problem4Page",
    methods: {
        getDice() {
            axiosInst.get("/basic/get-dice")
                .then((res) => this.diceNumber=res.data)
                .catch((res) =>alert("전송실패"))
        }
    },
    data() {
        return {
            diceNumber: 0
        }
    }
}
</script>

<style scoped>

</style>