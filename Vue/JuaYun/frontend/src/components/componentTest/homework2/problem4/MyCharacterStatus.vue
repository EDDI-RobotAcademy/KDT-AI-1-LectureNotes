<template>
  <div>
    <p></p>
    <!--@click="Play = true" ture를 지우니  -->
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
            // this.Button = true
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