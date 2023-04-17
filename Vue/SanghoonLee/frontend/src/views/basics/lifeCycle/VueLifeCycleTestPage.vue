<template lang="">
    <div style="text-align: left;">
        <ul>
            <li v-for="(monster, index) in monsterList" :key="index">
                ID: {{ monster.id }}, name: {{ monster.name }}, HP: {{ monster.hp }}
            </li>
        </ul>
    </div>
</template>
<script>
export default {
    data () {
        return {
            monsterBook: [
                { monsterId: 1, name: '슬라임', hp: 30 },
                { monsterId: 2, name: '고블린', hp: 50 },
                { monsterId: 3, name: '오크', hp: 100 },
                { monsterId: 4, name: '흡고블린', hp: 200 },
                { monsterId: 5, name: '스켈레톤', hp: 150 },
                { monsterId: 6, name: '킹 슬라임', hp: 500 },
                { monsterId: 7, name: '골렘', hp: 600 },
                { monsterId: 8, name: '와이번', hp: 900 },
                { monsterId: 9, name: '고스트', hp: 500 },
                { monsterId: 10, name: '리치', hp: 50000 },
            ],
            monsterList: [
                { id: 1, name: '슬라임', hp: 30 },
                { id: 2, name: '슬라임', hp: 30 },
                { id: 3, name: '슬라임', hp: 30 },
            ]
        }
    }
}
</script>
<style lang="">
    
</style>