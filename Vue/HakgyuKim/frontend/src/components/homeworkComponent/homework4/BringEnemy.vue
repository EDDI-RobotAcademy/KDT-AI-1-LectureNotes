<template>
    <div>
        <form>
            <fieldset>
                <legend><v-btn color="blue" @click="bringEnemy">몬스터 생성</v-btn></legend>
                <v-list>
                    <v-list-item v-for="(enemy, index) in enemyList">
                        <v-list-item-content>
                            <v-list-item-title>
                            {{ enemy.name }} , 체력: {{ enemy.health }}
                            </v-list-item-title>
                        </v-list-item-content>
                    </v-list-item>
                </v-list>
            </fieldset>
        </form>
    </div>
</template>
<script>

import axios from 'axios';

export default {
    data () {
        return {
            enemyList: [],
        }
    },
    methods: {
        bringEnemy () {
            let accountId = localStorage.getItem('loginUserInfo')
            axios.post('http://localhost:7777/character-problem/bringEnemy',
            {accountId : accountId})
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