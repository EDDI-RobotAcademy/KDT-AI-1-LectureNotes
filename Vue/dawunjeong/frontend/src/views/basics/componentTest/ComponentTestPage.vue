<template>
    <v-container>
        <!-- 
            Vue vue = new Vue();
            vue.globalComponent(counter);

            public void globalComponent(int counter){
                initial-test = counter;
            }

            아래 코드는 위 코드와 동의어입니다.
            // initial-test는 v-bind로 맵핑했음
        -->
        <global-component :initial-test="counter"/>
        <p>:initial-test는 v-bind: initial-test와 같습니다만 축약 표현입니다.</p>
        <!-- 
            public void localComponet(int number1, int number2) {
                System.out.println(number1 * number2);
            }
        -->
        <local-component :initial-value="number1" :initial-value2="number2"/><br>
        <!-- 이후 값이 증가하던 말던 상관없음
            (메서드가 사용된 후 증가되기 때문에 영향을 주지 않음)
        -->
        <button @click="plusNumber1">number1 증가</button>{{ number1 }}<br>
        <button @click="plusNumber2">number2 증가</button>{{ number2 }}<br><br>
        <global-component-add :initial-value1="number3" :initial-value2="number4"/>
        <p>덧셈을 수행할 수 있는 Global Component를 만들었습니다.</p>
        <local-component-subtract :initial-value1="number5" :initial-value2="number6"/>
        <p>뺄셈을 수행할 수 있는 Local Component를 만들었습니다.</p><br>
        <local-component-multi/>
        <p>곱셈을 수행할 수 있는 Local Component를 만들었습니다.</p><br>
    </v-container>
</template>

<script>
import LocalComponent from '@/components/componentTest/LocalComponent.vue'
import LocalComponentSubtract from '@/components/componentTest/LocalComponentSubtract.vue'
import LocalComponentMulti from '@/components/componentTest/LocalComponentMulti.vue'

export default {
    components: {
        'local-component' : LocalComponent,
        'local-component-subtract' : LocalComponentSubtract,
        'local-component-multi' : LocalComponentMulti,
    },
    data () {
        return {
            counter: 0,
            number1: 3,
            number2: 7,
            number3: 2,
            number4: 9,
            number5: 7,
            number6: 3,
        }
    },
    methods: {
        plusNumber1 () {
            this.number1++
        },
        plusNumber2 () {
            this.number2++
        }
    }
}
</script>

<style>
    
</style>