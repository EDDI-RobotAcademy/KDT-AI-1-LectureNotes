<template lang="">
    <div>
        <h3>주사위 굴리기 게임</h3>
        <v-btn color="primary" @click="startTwoTimesDiceGame">주사위 게임 시작!</v-btn>
        <p>얻은 결과: {{ playingNumber }}</p>
    </div>
</template>

<script>

export default {
    data () {
        return {
            result: '알 수 없음',
            playingNumber : 0,
        }
    },
    methods: {
        startTwoTimesDiceGame () {
            axios.get('http://localhost:7777/dice-game/firstGame')
                .then((res) => {
                    this.result = res.data.result
                    this.playingNumber = res.data.winnerNumber
                })
        }
    }
}

</script>

<style lang="">

</style>