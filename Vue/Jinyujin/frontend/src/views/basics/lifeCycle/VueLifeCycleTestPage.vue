<template lang="">
    <div>
        <ul>
            <li v-for="(monster, index) in monsterList" :key="index">
                ID: {{ monster.id }}, name: {{ monster.name }}, hp: {{ monster.hp }}
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
}
</script>
<style lang="">
    
</style>