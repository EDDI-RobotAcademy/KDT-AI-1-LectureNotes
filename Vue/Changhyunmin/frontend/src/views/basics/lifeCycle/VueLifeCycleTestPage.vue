<template>
    <div style="text-align: left;">
        <button @click="addManyMonster">몬스터 소환</button>
        <button @click="atteckAll">전체공격</button>
        <ul>
            <li v-for="(monster, index) in monsterList" :key="index">
                ID: {{ monster.id }}, name: {{ monster.name }}, HP: {{ monster.hp }}
                <button @click="atteckMonster(index)">일반공격</button>
            </li>
        </ul>
    </div>
</template>
<script>
export default {
    data() {
        return {
            monsterBook: [
                {monsterID: 1, name: '슬라임', hp:30},
                {monsterID: 2, name: '고블린', hp:50},
                {monsterID: 3, name: '오크', hp:100},
                {monsterID: 4, name: '홉고블린', hp:200},
                {monsterID: 5, name: '스켈레톤', hp:150},
                {monsterID: 6, name: '킹 슬라임', hp:500},
                {monsterID: 7, name: '골렘', hp:600},
                {monsterID: 8, name: '와이번', hp:900},
                {monsterID: 9, name: '고스트', hp:500},
                {monsterID: 10, name: '리치', hp:90000},
            ],
            monsterList: [
                {id: 1, name: '슬라임', hp:30},
                {id: 2, name: '슬라임', hp:30},
                {id: 3, name: '슬라임', hp:30},
            ]
        }
    },
    methods: {
        atteckMonster (monsterindex){
            this.monsterList[monsterindex].hp -= 10
        },
        atteckAll(){
            for(let i = 0; i<this.monsterList.length; i++){
                this.monsterList[i].hp = this.monsterList[i].hp -100
            }
        },
        checkKilldeMonster(){
            console.log('길이: ' + this.monsterList.length)
            for(let i = 0; i < this.monsterList.length; i++){
               
                if(this.monsterList[i].hp <=0) {
                    this.monsterList.splice(i,1)
                }
            }
        },
        addManyMonster(){
            let count=1
            for(let i = 0; i < 2; i++){ 
                count =1               
                //a,b가 첫번째 원소, 두 번째 원소에 해당합니다.
                //마지막에 0을 배치해서 지속적으로 큰 숫자를 앞으로 땡기는
                //작업을 진행합니다.
                let max = this.monsterList.reduce((a, b) => {
                    console.log('count: ' + (count++) + ', a: ' + a + ', b: ' + b.id)
                    return a > b.id ? a : b.id
                }, 0)

                 //JavaScript에서 랜덤값 활용 (몬스터 도감 개수만큼)
                let idx = Math.floor(Math.random()*this.monsterBook.length)

                this.monsterList.push({
                    id:max + 1,
                    monsterID: idx,
                    name: this.monsterBook[idx].name,
                    hp: this.monsterBook[idx].hp


                })
            }
        }
    },
    beforeCreate(){
        console.log('beforeCreate() 동작!')
    },
    created(){
        console.log('created() 동작!')
    },
    beforeMount(){
        console.log('beforeMount() 동작!')
    },
    mounted(){
        console.log('mounted() 동작!')
    },
    beforeUpdate(){
        console.log('beforeUpdate() 동작!')
    },
    updated(){
        console.log('updated() 동작!')

        this.checkKilldeMonster()
    },
    beforeDestroy(){
        console.log('beforeDestroy() 동작!')
    },
    destroyed(){
        console.log('destroyed() 동작!')
    }
    
}
</script>
<style>
    
</style>