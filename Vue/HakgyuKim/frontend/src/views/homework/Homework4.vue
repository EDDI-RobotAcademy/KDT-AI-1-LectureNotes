<template>
    <div>
        <form @submit.prevent="makeCharacter">
            <label>  
                이메일: <input type="text" v-model="email" required> <br>
            </label>
            <label>
            비밀번호: <input type="password" v-model="password" required> <br>
            </label>
            <v-btn color="secondary" type="submit">캐릭터 생성</v-btn> 
        </form> <br>
        <form @submit.prevent="bringCharacter">
            <fieldset>
                <legend><v-btn style="text-align: center;" color="secondary" type="submit">플레이</v-btn></legend>
                <ul style="text-align: left;">
                    <li>
                        <p>{{ email }}님의 캐릭터 스테이터스:</p>
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
            password: '',
            health: 0,
            strength: 0,
            dexterity: 0,
            intelligence: 0,
            skill: 0,
        }
    },
    methods: {
        makeCharacter () {
            const{email, password} = this
            axios.post('http://localhost:7777/character-problem/makeCharacter', 
            {email, password})
            .then((res) => {
                alert('생성 완료!')
            })
        },
        bringCharacter () {
            axios.get('http://localhost:7777/character-problem/getCharacterStatus')
            .then((res) => {
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
<style>
    
</style>