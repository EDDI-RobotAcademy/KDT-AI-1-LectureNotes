<template lang="">
    <div style="text-align: left;">
        <button @click="attackAll">[전체 공격]</button>
        <ul>
            <li v-for="(monster, index) in monsterList" :key="index">
                ID : {{monster.id}}, name: {{monster.name}}, HP: {{monster.hp}}
                <button @click="attackMonster(index)">[일반 공격]</button>
            </li>
        </ul>
    </div>
</template>
<script>
export default {
    data () {
        return {
            monsterBook: [
                {monsterId: 1, name: '슬라임', hp: 30},
                {monsterId: 2, name: '고블린', hp: 50},
                {monsterId: 3, name: '오크', hp: 100},
                {monsterId: 4, name: '홉고블린', hp: 200},
                {monsterId: 5, name: '스켈레톤', hp: 150},
                {monsterId: 6, name: '킹 슬라임', hp: 500},
                {monsterId: 7, name: '골렘', hp: 600},
                {monsterId: 8, name: '와이번', hp: 900},
                {monsterId: 9, name: '고스트', hp: 500},
                {monsterId: 10, name: '리치', hp: 50000},
            ],
            monsterList: [
                {id: 1, name: '슬라임', hp: 30},
                {id: 2, name: '슬라임', hp: 30},
                {id: 3, name: '슬라임', hp: 30},
            ]
        }
    },
    methods: {
        attackMonster (monsterIdx) {
            this.monsterList[monsterIdx].hp -= 10
        },
        attackAll () {
            for(let i = 0; i < this.monsterList.length; i++){
                this.monsterList[i].hp = this.monsterList[i].hp - 100
            }
        },
        checkKilledMonster() {
            console.log('길이: '+this.monsterList.length)
            for(let i = 0; i < this.monsterList.length; i++){
                if(this.monsterList[i].hp <= 0){
                    this.monsterList.splice(i, 1)
                }
            }
        }
    },
    beforeCreate () {
        console.log('beforeCreate() 동작!')
    },
    created () {
        console.log('created() 동작!')
    },
    beforeMount () {
        console.log('beforeMount() 동작!')
    },
    mounted () {
        console.log('mounted() 동작!')
    },
    beforeUpdate () {
        console.log('beforeUpdate() 동작!')

        this.checkKilledMonster()
    },
    updated () {
        console.log('updated() 동작!')
    },
    beforeDestroy () {
        console.log('beforeDestroy() 동작!')
    },
    destroyed () {
        console.log('destroyed() 동작!')
    }
}
</script>
<style lang="">
    
</style>