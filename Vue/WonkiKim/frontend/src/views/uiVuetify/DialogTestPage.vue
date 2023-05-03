<template>
    <div>
        <p class="blue lighten-4 red--text">Test</p>
        <p class="green white--text">Test</p>
        <p class="yellow darken-3">Test</p>
        <p class="teal lighten-1 text-center">Test</p>

        <v-btn class="teal lighten-3" rounded @click="btnClick">button</v-btn>

        <v-layout>
            <v-dialog v-model="isDialogOpened">
                <template v-slot:activator="{on}">
                    <v-btn v-on="on">결제</v-btn>
                </template>
                <v-card>
                    <v-card-title class="headline">
                        {{ name }}
                    </v-card-title>
                    <v-card-text>
                        <h2>{{globalAggroTitle}}</h2>
                        <h3>{{ aggroSupport}}</h3>
                        <p>{{aggroFinish}}</p>
                    </v-card-text>
                </v-card>

                <v-card-actions>
                    <v-spacer></v-spacer>
                    <v-btn text @click="btnCancel">cancel</v-btn>
                    <v-btn text @click="btnPay">Pay</v-btn>
                </v-card-actions>
            </v-dialog>
        </v-layout>
    </div>
</template>

<script>
export default {
    name: "DialogTestPage",
    data() {
        return {
            name: 'name!!',
            isDialogOpened: false,
            globalAggroTitle: "globalAggroTitle",
            aggroSupport: "aggroSupport",
            aggroFinish: "aggroFinish",
        }
    },
    methods: {
        btnClick() {
            alert("click");
        },
        btnCancel() {
            alert("cancel")
            this.isDialogOpened=false
        },
        btnPay() {
            alert("Payed")
            this.isDialogOpened=false
        }
    }
}
</script>

<style scoped>

</style>