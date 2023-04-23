<template>
    <div>
        <form>
             <v-btn color="red" @click="singleAtkReady">지정 공격</v-btn>
            <div v-if="isSingleAtkReady">
                <form @submit.prevent="singleAtk">
                <v-list>
                    <v-list-item v-for="(enemy, index) in enemyList">
                        <v-list-item-content>
                            <input type="radio" name="enemy" v-model="targetEnemy" value="enemyList.index">
                            <v-list-item-title>
                            {{ enemy.name }} , 체력: {{ enemy.health }}
                            </v-list-item-title>
                        </v-list-item-content>
                    </v-list-item>
                </v-list>
                <v-btn type="submit">공격하기</v-btn>
                </form>
            </div>
        </form>
    </div>
</template>
<script>
import axios from 'axios'

export default {
    data () {
        return {
            enemyList: [],
            isSingleAtkReady: false,
            
        }
    },
    methods: {
        singleAtkReady() {
            this. isSingleAtkReady = true

            let accountId = localStorage.getItem('loginUserInfo')
            axios.post('http://localhost:7777/character-problem/getEnemyList',
            {accountId: accountId})
            .then((res) => {
                this.enemyList = res.data
            }) 
        },

        singleAtk () {
            let accountId = localStorage.getItem('loginUserInfo')
            let targetEnemyIdx = this.targetEnemy
            axios.post('http://localhost:7777/character-problem/singleAtk',
            {accountId: accountId, targetEnemyIdx})
            .then((res) => {
                this.enemyList = res.data
                console.log(res.data)
            })
        }
    }
}
</script>
<style>
    
</style>