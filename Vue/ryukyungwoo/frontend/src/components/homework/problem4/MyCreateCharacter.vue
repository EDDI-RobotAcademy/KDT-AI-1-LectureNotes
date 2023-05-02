<template lang="">    
<div>        
    <div>
        <p>e-mail: </p>
        <textarea v-model="email"></textarea>
    </div>
    <div>
        <p>password: </p>
        <textarea v-model="password"></textarea>
    </div>
    <div>
        <v-btn color="primary" @click="creatCharacterButton">캐릭터 생성</v-btn>
    </div>

    <div v-if="isSuccessToGetData">    
        <p>
            아이디: {{ getemail }}
        </p>
        <p>
            힘: {{ strength }},        
        </p>
        <p>
            민첩: {{ dexterity }},            
        </p>
        <p>
            지능: {{ intelligence }},
        </p>
        <p> 
            운: {{ luck }}
        </p>
    </div>
    <div>
        
    </div>    
</div>
</template>

<script>
import axios from 'axios';
export default {
    data () {
        return {
            getemail: '',
            email: '',
            password: '',
            strength: 0,
            dexterity: 0,
            intelligence: 0,
            luck: 0,
            isSuccessToGetData: false
        }
    },
    methods: {
        creatCharacterButton () {
            const {email, password} = this
            alert('e-mail: ' + email,
                'password: ' + password)
            axios.post('http://localhost:7777/character-create-test/create-new-character',
                {
                    email, password
                }
            )
            .then((res) => {
                console.log('createdCharacter ' + res.data)
                this.getemail = res.data.email
                this.strength = res.data.strength
                this.dexterity = res.data.dexterity
                this.intelligence = res.data.intelligence
                this.luck = res.data.luck
                this.isSuccessToGetData = true
            })
            .catch((res) => {
                alert('데이터 전송 실패!')
            })
        }
    }
}
</script>
<style lang="">
    
</style>