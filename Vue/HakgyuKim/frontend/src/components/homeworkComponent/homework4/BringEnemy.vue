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
                <legend>
                <v-btn color="red" block rounded size="large" @click="singleAtk">공격</v-btn>
            </legend>
            </fieldset>
            
        </form>
    </div>
</template>
<script>

import axios from 'axios';

export default {
    data () {
        return {
            enemyList: []
        }
    },
    methods: {
        bringEnemy () {
            axios.get('http://localhost:7777/character-problem/bringEnemy')
            .then((res) => {
                this.enemyList = res.data
                console.log(res.data)
            })
        },
        singleAtk () {
            axios.get('http://localhost:7777/character-problem/singleAtk')
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