<template lang="">
    <div>
        <p class="pink lighten-4 pink--text">Test</p>
        <p class="green white--text">Test</p>
        <p class="yellow lighten-2">Test</p>
        <p class="teal lighten-3 text-center">Test</p>
        <!-- 
            가운데 정렬했을 때 글씨에 색깔 입히는 법 궁금 
            text에 색을 적용할 때는 단순히 간단한 색깔만 가능할까?
        -->
        <!-- vuetify 색깔 알려주는 곳: https://vuetifyjs.com/en/styles/colors/ -->
        <!-- 
            지금 App.vue에서 #app에 vue 전체 text-align이 center에 쓰이도록 나와있음
            그것을 지웠을 경우 text-center를 쓰면 가운데 정렬이 됨 
         -->
        <v-btn class="purple lighten-4" rounded @click="btnClick">버튼</v-btn>
        <p></p>
        <!-- rounded를 붙이면 둥글게 생성됨 -->
        
        <v-layout justify-center>
        <!-- 완전히 정중앙으로 정렬시켜주는 태그 -->
        <!-- fullesreen 옵션을 넣으면 전체화면으로 처리됨 -->
            <v-dialog v-model="isDialogOpened" fullscreen persistent max-width="400">
            <!-- 최대 폭 400으로 지정 -->
            <!-- 
                persistent 앞에 fullscreen을 빼면 팝업처럼 작게 띄울 수 있음 
                전체 화면으로 만들고 싶은 경우에 쓰면 됨
            -->
                <template v-slot:activator="{on}">
                    <v-btn color="primary" dark v-on="on">결제</v-btn>
                </template>
                <!-- 
                    트리거로 on 생성해주고 이 안에 버튼 생성 
                    v-card가 나타나게 만들어주는 트리거
                -->
                <v-card>
                    <!-- 결제 버튼 누르면 어떤 창이 뜨도록 보여주는게 v-card -->
                    <v-card-title class="headline">
                        {{ name }}
                    </v-card-title>
                    <v-card-text>
                        <h2>{{ globalAggroTitle }}</h2>
                        <h3>{{ aggroSupport }}</h3>
                        <p>{{ aggroFinish }}</p>
                    </v-card-text>      
                    <!-- 문구를 직접 넣는 것보다 아래 return 값에 넣어주면 더 깔끔하게 코드 작성 가능 -->
                    <v-card-actions>
                        <v-spacer></v-spacer>
                        <v-btn color="teal darken-1" text @click="btnCancel">
                            취소
                        </v-btn>
                        <!-- 
                            actions로 구성하고 sapacer로 공간 나누기 그리고 v-card 안에서 취소 버튼을 만들어줌
                            spacer를 빼면 왼쪽에 버튼이 위치하고 넣으면 오른쪽에 위치하게 됨
                            br이 아니라 왼쪽 공간을 띄우는 태그
                        -->
                        <!-- 그리고 취소 버튼 누르면 v-card 창이 꺼지도록 해주는게 isDalogopened -->
                        <v-btn color="teal darken-1" text @click="btnPay">
                            결제
                        </v-btn>
                    </v-card-actions>              
                </v-card>
                <!-- dialog를 작성할 때는 v-card와 같이 사용하는 것이 좋음 -->
            </v-dialog>
        </v-layout>     
    </div>
</template>

<script>
export default {
    data() {
        return {
            globalAggroTitle: '지금 즉시 결제',
            aggroSupport: '오늘만 할인률 50%!!! 오늘만 날입니다.',
            aggroFinish: '두 번 없는 초특급 찬스! 지금 당장 결제하시겠습니까 ?',
            name: '7박 8일 풀 패키지 여행 코스!!!',
            isDialogOpened: false
        }
    },
    methods: {
        btnClick() {
            alert('클릭!')
        },
        btnCancel() {
            alert('취소!')
            this.isDialogOpened = false
        },
        btnPay() {
            alert('1000만원이 결제되었습니다! 감사합니다 호갱님!')
            this.isDialogOpened = false            
        }
    },
}
</script>

<style lang="">
    
</style>