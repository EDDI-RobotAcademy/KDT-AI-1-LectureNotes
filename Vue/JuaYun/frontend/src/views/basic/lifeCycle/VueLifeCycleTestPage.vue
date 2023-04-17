<template lang="">
    <div style="text-align: left;">
        <button @click="attackAll">전체공격</button>
        <ul>
            <li v-for="(monster,index) in monsterList" :key="index">
                ID: {{ moster.id }}, name: {{ monster.name }}, HP: {{ moster.hp }}
                <button @click="attackMonster(index)">일반공격</button>
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
                { id: 1, name: '슬라임', hp: 30 },
                { id: 2, name: '슬라임', hp: 30 },
                { id: 3, name: '슬라임', hp: 30 },
            ]
        }
    },
    methods: {
        // 일반공격
        attackMonster (mosterIdx) {
            this.monsterList[monsterIdx].hp -= 10
        },
        // 광역딜
        attackAll () {
            for (let i = 0; i < this.monsterList.length; i++) {
                this.monsterList[i].hp = this.monsterList[i].hp
            }
        },
        checkKilledMonster () {
            for (let i = 0; i < this.monsterList.length; i++) {
                if (this.monsterList[i].hp <= 0) {
                    // 죽은 몬스터를 제거
                    this.monsterList.splice(i, 1)
                }
            }
        } // 루프도는것 때문에 한번에 없어지지않고 남아있는 경우가 발생
    },
    beforeCreate () {
        console.log('beforeCreate() 동작')
    },
    created () {
        console.log('created() 동작')
    },
    beforeMount () {
        console.log('beforeMount() 동작')
    },
    mount () {
        console.log('mount() 동작')
    },
    beforeUpdate () {
        console.log('beforeUpdate() 동작')
    },
    update () {
        console.log('update() 동작')

        this.checkKilledMonster()
    },
    beforeDestroy () {
        console.log('beforeDestroy() 동작')
    },
    destroy () {
        console.log('destroy() 동작')
    },
}
</script>
<style lang="">
    
</style>