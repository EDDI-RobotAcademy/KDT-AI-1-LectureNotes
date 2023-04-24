<template lang="">
    <div>
        <form @submit.prevent="bringCharacter">
            <fieldset>
                <legend><v-btn color="secondary" type="submit">캐릭터 생성</v-btn></legend>
                <ul style="text-align: left;">
                    <li>
                        <p>{{ email }}님의 {{ name }} 스테이터스:</p>
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
            </fieldset> 
        </form>
    </div>
</template>

<script>

import axios from 'axios';

export default {
    data () {
        return {
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
        bringCharacter () {
            let accountId = localStorage.getItem('loginUserInfo')
            axios.post('http://localhost:7777/character-problem/createCharacter',
            {accountId : accountId})
            .then((res) => {
                this.email = res.data.email,
                this.name = res.data.characterName,
                this.health = res.data.health,
                this.strength = res.data.strength,
                this.dexterity = res.data.dexterity,
                this.intelligence = res.data.intelligence,
                this.skill = res.data.skill
                console.log(res.data)
            })
        }
    }
    
}
</script>
<style lang="">
    
</style>