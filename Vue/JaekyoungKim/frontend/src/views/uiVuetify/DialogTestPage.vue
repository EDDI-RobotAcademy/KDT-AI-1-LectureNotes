<template lang="">
    <div>
        <p class="blue lighten-4 red--text">text</p>
        <p class="green white--text">text</p>
        <p class="yellow darken-3">text</p>
        <p class="teal lighten-1">text</p>
        <v-btn class="teal ligthen-3" rounded @click="btnClick">버튼</v-btn>

        <v-layout justify-center>
            <v-dialog v-modle="dialog" fullscreen persistent max-width="400">
                <template v-slot:activator="{on}">
                    <v-btn color="primary" dark v-on="on">결재</v-btn>
                </template>

                <v-card>
                    <v-card-title class="headline">{{name}}
                    </v-card-title>
                    <v-card-text> 
                        <h2>22</h2>
                        <h3>33</h3>
                        <p>44</p>

                    </v-card-text>
                    <v-card-action>
                        <v-spacer></v-spacer>
                        <v-btn color="teal darken-1" text @click="btnCancel">
                            취소
                        </v-btn>
                        <v-btn color="teal darken-1" text @click="btnPay">
                            결제    
                        </v-btn>    
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
            nmae: '7박 8일 ',
            isDailogOpened: false
        }
    },
    methods: {
        btnClick () {
            alert('클릭!')
        },
        btnCancel () {
            alert('취소!')
            this.isDialogOpened = false
        },
        btnPay () {
            alert('1000만원이 결제되었습니다! 감사합니다 호갱님!')
            this.isDialogOpened = false
        }
    }
}
</script>

<style lang="">
    
</style>