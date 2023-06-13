<template lang="">
    <div>
        <p class="blue lighten-4 red--text">Test</p>
        <p class="green white--text">Test</p>
        <p class="yellow darken-3">Test</p>
        <p class="teal lighten-4 text-center">Test</p>

        <v-btn class="teal lighten-3" rounded @click="btnClick">버튼</v-btn>

        <v-layout justify-center>
            <!--fullscreen 옵션을 넣으면 전체 화면으로 처리됨-->
            <!--fullscreen-->
            <v-dialog v-model="isDialogOpened" prsistent max-width="400">
                <template v-slot:activator="{ on }" >
                    <v-dtn class="teal ligthen-3" dark v-on="on">결제</v-dtn>
                </template>
                <!--template는 아래 내용이 나오게 하는 트리거다-->
                <v-card>
                    <v-card-title class="headline">
                        {{name}}
                    </v-card-title>
                    <v-card-text>
                        <h2>{{headLine}}</h2>
                        <h3>{{middle}}</h3>
                        <p>{{endmant}}</p>
                    </v-card-text>
                    <v-card-action>
                        <v-spacer></v-spacer>
                        <v-btn color="teal darked-1" text @click="btnPay">결제</v-btn>
                        <v-btn color="teal darked-1" text @click="btnCancel">취소</v-btn>
                    </v-card-action>
                </v-card>
            </v-dialog>
        </v-layout>
    </div>
</template>
<script>
export default {
    data() {
        return {
            
            name: '즐겁다!',
            headLine: '가입없이 빠른결제!',
            middle: '누구보다 손쉽게 얻을 수 있다!',
            endmant: '지금당장 시작하세요!',
            isDialogOpened: false

        }
    },
    methods: {
        btnClick() {
            alert ('클릭!')
        },
        btnPay() {
            alert('1000원이 결제되었습니다! 감사합니다!')
            this.isDialogOpened = false
        },
        btnCancel(){
            alert('취소!')
            this.isDialogOpened = false
        }
    },
    
}
</script>
<style lang="">
    
</style>