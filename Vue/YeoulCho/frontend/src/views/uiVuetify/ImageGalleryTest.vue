<template lang="">
   <v-container>
    <v-row>
        <v-col v-for="(image, idx) in images" :key="idx" cols="3">
            <v-img :src="image" aspect-ratio="1" class="grey lighten-2">
                <!--placeholder~~v-row는 사진 많이 있을 때 로딩걸려서 뱅글뱅글도는 부분, 사실 당장은 필요없음-->
                <template v-slot:placeholder>
                    <v-row class="fill-height ma-0" align="center" justify="center">
                            <v-progress-circular indeterminate color="grey lighten-5"/>
                            </v-row>
                        </template>
                    </v-img>
                </v-col>
            </v-row>
        </v-col>
    </v-row>
    <!--실질적으로 아래와 같은형태를 많이 쓰게 될것이다-->
    <v-img :src="require(`@/assets/downloadImg/${imageName}`)"
            aspect-ratio="1" class="grey lighten-2"/>
   </v-container>
</template>
<script>
export default {
    data(){
        return{
            imageName: "clound.jpg",
            images: [
            require('@/assets/downloadImg/loz.jpg'),
            require('@/assets/downloadImg/마리오.png'),
            require('@/assets/downloadImg/clound.jpg'),
            require('@/assets/downloadImg/naruto.jpg'),


            ]
        }
    }
    
}
</script>
<style lang="">
    
</style>