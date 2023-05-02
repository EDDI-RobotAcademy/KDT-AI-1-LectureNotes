<template>
  <div>
    <p></p>
    <!-- @click="Play = true" ture가 있었기 때문에 정보를 받아오지 못함 -->
    <v-btn color="primary" @click="Play">플레이</v-btn>
    <div v-if="Button">
      <p>체력: {{ hp }}</p>
      <p>힘: {{ strength }}</p>
      <p>지능: {{ intelligent }}</p>
      <p>재능: {{ dexterity }}</p>
      <p>민첩: {{ agility  }}</p>
    </div>   
  </div>
</template>

<script>
import axios from 'axios'

export default {
    data () {
        return {
            Button: false,
            hp: 0,
            strength: 0,
            intelligent: 0,
            dexterity: 0,
            agility: 0,
        }
    },
    methods: {
        Play () {
            // v-if를 사용할때 필수적으로 사용
            // this.Button = true 이부분을 주석처리하면 콘솔에는 받아오지만
            // 웹페이지창에는 뜨지 않음
            this.Button = true
            axios.get('http://localhost:7777/character-test/status')
            .then((res) => {
                console.log('hp: ' + res.data.hp)
                console.log('strength: ' + res.data.strength)
                console.log('intelligent: ' + res.data.intelligent)
                console.log('dexterity: ' + res.data.dexterity)
                console.log('agility: ' + res.data.agility)
                this.hp = res.data.hp
                this.strength = res.data.strength
                this.intelligent = res.data.intelligent
                this.dexterity = res.data.dexterity
                this.agility = res.data.agility
            })
        }
    }

}
</script>

<style>

</style>