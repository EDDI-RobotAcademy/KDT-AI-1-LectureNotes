<template>
    <div>
        <form>
            <CharacterSelect/>
             <v-btn color="red" @click="singleAtkReady">지정 공격</v-btn>
            <div v-if="isSingleAtkReady">
                <form>
                <v-list>
                    <v-list-item v-for="(enemy, index) in enemyList">
                        <v-list-item-content>
                            <input type="radio" name="enemy" @change="selectEnemy($event)" :value="index">
                            <v-list-item-title>
                            {{ enemy.name }} , 체력: {{ enemy.health }}
                            </v-list-item-title>
                        </v-list-item-content>
                    </v-list-item>
                </v-list>
                <v-btn @click="singleAtk(targetEnemy)">공격하기</v-btn>
                </form>
            </div>
        </form>
    </div>
</template>
<script>
import axios from 'axios'
import CharacterSelect from '@/components/homeworkComponent/homework4/CharacterSelect.vue'

export default {
    components: {
        CharacterSelect
    },

    data () {
        return {
            enemyList: [],
            isSingleAtkReady: false,
            targetEnemy: 0
            
        }
    },
    methods: {
        selectEnemy(event) {
            this.targetEnemy = event.target.value;
            console.log(this.targetEnemy)
        },

        singleAtkReady() {
            this.isSingleAtkReady = true

            let accountId = localStorage.getItem('loginUserInfo')
            axios.post('http://localhost:7777/character-problem/getEnemyList',
            {accountId: accountId})
            .then((res) => {
                this.enemyList = res.data
            }) 
        },

        singleAtk (targetEnemyIdx) {
            let accountId = localStorage.getItem('loginUserInfo')
            let characterId = localStorage.getItem('currentCharacterInfo')
            axios.post('http://localhost:7777/character-problem/singleAtk',
            {accountId: accountId, targetEnemyIdx, characterId})
            .then((res) => {
                this.enemyList = res.data
                console.log(res.data)
            })
            this.isSingleAtkReady = false
        }
    }
}
</script>
<style>
    
</style>