<template lang="">
    <div style="text-align: left;">
        <button @click="addManyMonsters">몬스터 웨이브 추가</button><br>
        <button @click="attackAll">전체 공격</button><br>
        <ul>
            <li v-for="(monster, index) in monsterList" :key="index">
                ID: {{ monster.id }}, name: {{ monster.name }}, hp: {{ monster.hp }}
                <button @click="attackMonster(index)">일반 공격</button>
            </li> <!-- 이렇게 해두면 슬라임 3마리가 보일 것 -->
        </ul>
    </div>
</template>

<script>
export default {
    data() {
        return {
            monsterBook: [ // 몬스터 도감
                { monsterId: 1, name: '슬라임', hp: 30 },
                { monsterId: 2, name: '고블린', hp: 50 },
                { monsterId: 3, name: '오크', hp: 100 },
                { monsterId: 4, name: '흡고블림', hp: 200 },
                { monsterId: 5, name: '스켈레톤', hp: 150 },
                { monsterId: 6, name: '킹 슬라임', hp: 500 },
                { monsterId: 7, name: '골렘', hp: 600 },
                { monsterId: 8, name: '와이번', hp: 900 },
                { monsterId: 9, name: '고스트', hp: 500 },
                { monsterId: 10, name: '리치', hp: 50000 },
            ],
            monsterList: [ 
                {id: 1, name: '슬라임' , hp: 30},
                {id: 2, name: '슬라임' , hp: 30},
                {id: 3, name: '슬라임' , hp: 30},
            ]
        }
    },
    methods: {
        attackMonster (monsterIdx) {
            this.monsterList[monsterIdx].hp -= 10
        },
        attackAll () {
            for (let i = 0; i < this.monsterList.length; i++) {
                this.monsterList[i].hp = this.monsterList[i].hp - 100;       
            }
        },
        checkKilledMonster() {
            console.log('길이: ' + this.monsterList.length)
            for (let i = 0; i < this.monsterList.length; i++) {
                 if (this.monsterList[i].hp <= 0) {
                    // hp가 0이하인 요소를 1개 제거함
                     this.monsterList.splice(i, 1)
                 }
            }
        },
        addManyMonsters() { // 몬스터 10마리 정도 추가
                            // - 위에 만들어놓은 버튼 누르면 10마리 씩 계속 추가됨
                            // - console에는 10마리가 한꺼번에 추가되는 것이 아니라
                            //   한 마리씩 추가되는 것으로 count가 세진다
                            //   그래서 한 번 누르면 처음 시작할 때 3마리 포함 13마리가 나타난다
            let count = 1
            for (let i = 0; i < 10; i++) {
                count = 1
                // a, b가 첫 번째 원소, 두 번째 원소에 해당합니다.
                // 마지막에 0을 배치해서 지속적으로 큰 숫자를 앞으로 땡기는 작업을 진행합니다.
                let max = this.monsterList.reduce((a, b) => {
                    console.log('count: ' + (count++) + ', a: ' + a + ', b: ' + b.id)
                    return a > b.id ? a : b.id
                }, 0)

                // JavaScript에서 랜덤값 활용 (몬스터 도감 개수만큼)
                let idx = Math.floor(Math.random() * this.monsterBook.length)

                // 도감내 존재하는 임의의 몬스터를 추가함
                this.monsterList.push( {
                    id: max + 1,
                    monsterId: idx,
                    name: this.monsterBook[idx].name,
                    hp: this.monsterBook[idx].hp
                })
            }
        }
    },
    beforeCreate() { // 이 라이프 사이클들이 뷰의 가장 기본적인 라이프사이클
        console.log('beforeCreate() 동작!');
    },
    created() {
        console.log('created() 동작!');
    },
    beforeMount() {
        console.log('beforeMount() 동작!');
    },
    mounted() {
        console.log('mounted() 동작!');
    },
    beforeUpdate() {
        console.log('beforeUpdate() 동작!');

        this.checkKilledMonster()
    },
    updated() {
        console.log('updated() 동작!');
    },
    beforeDestroy() {
        console.log('beforeDestroy() 동작!');
    },
    destroyed() {
        console.log('destroyed() 동작!');
    },
}
</script>
<style lang="">
    
</style>