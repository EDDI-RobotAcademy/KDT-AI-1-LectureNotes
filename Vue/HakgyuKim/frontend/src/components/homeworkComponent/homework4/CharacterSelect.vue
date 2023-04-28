<template>
    <div>
        <form>
             <v-btn color="blue" @click="characterSelectReady">캐릭터 선택</v-btn>
            <div v-if="isCharacterSelectReady">
                <form>
                <v-list>
                    <v-list-item v-for="(character, index) in characterList">
                        <v-list-item-content>
                            <input type="radio" name="character" @change="selectCharacter($event)" :value="index">
                            <v-list-item-title>
                            {{ character.name }} , 체력,힘,민첩,지능,재주: {{ character.health }}, 
                                                                        {{ character.strength }}, 
                                                                        {{ character.dexterity }}, 
                                                                        {{ character.intelligence }}, 
                                                                        {{ character.skill }}
                            </v-list-item-title>
                        </v-list-item-content>
                    </v-list-item>
                </v-list>
                <v-btn @click="characterSelect(selectedCharacter)">선택하기</v-btn>
                </form>
            </div>
            <ul style="text-align: left;">
                    <li>
                        <p>{{ name }}의 스테이터스:</p>
                    </li>
                    <li>
                        <p>체력: {{ health }}</p>
                    </li>
                    <li>
                        <p>힘: {{ strength }}</p>
                    </li>
                    <li>
                        <p>민첩: {{ dexterity }}</p>
                    </li>
                    <li>
                        <p>지능: {{ intelligence }}</p>
                    </li>
                    <li>
                        <p>재주: {{ skill }}</p>
                    </li>
                </ul>
        </form>
    </div>
</template>
<script>
import axios from 'axios'

export default {
    data () {
        return {
            characterList: [],
            isCharacterSelectReady: false,
            selectedCharacter: 0,
            email: '',
            name: '',
            health: 0,
            strength: 0,
            dexterity: 0,
            intelligence: 0,
            skill: 0, 
            
        }
    },
    methods: {
        selectCharacter(event) {
            this.selectedCharacter = event.target.value;
            console.log(this.selectedCharacter)
        },

        characterSelectReady() {
            this.isCharacterSelectReady = true
            let accountId = localStorage.getItem('loginUserInfo')
            axios.post('http://localhost:7777/character-problem/bringCharacterList',
            {accountId: accountId})
            .then((res) => {
                this.characterList = res.data
            }) 
        },

        characterSelect (selectedCharacterIdx) {
            let accountId = localStorage.getItem('loginUserInfo')
            axios.post('http://localhost:7777/character-problem/characterSelect',
            {accountId: accountId, selectedCharacterIdx})
            .then((res) => {
                this.name = res.data.characterName,
                this.health = res.data.health,
                this.strength = res.data.strength,
                this.dexterity = res.data.dexterity,
                this.intelligence = res.data.intelligence,
                this.skill = res.data.skill,
                localStorage.setItem('currentCharacterInfo', res.data.characterId)
                console.log(res.data)
            })
        }
    }
}
</script>
<style>
    
</style>