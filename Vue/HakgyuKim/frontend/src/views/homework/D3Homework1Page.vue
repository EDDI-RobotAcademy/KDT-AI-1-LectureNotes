<template lang="">
    <div>
        <exercise-list-form :exerciseList="exerciseList"/>
    </div>
</template>

<script>
import ExerciseListForm from '@/components/homeworkComponent/d3homework1/ExerciseListForm.vue';
import { mapActions, mapState } from 'vuex';

const exerciseModule = 'exerciseModule'

export default {
    date() {
        return {
            isShowGraph: false
        }
    },
    components: {
        ExerciseListForm
    },
    computed: {
        ...mapState(exerciseModule, ['exerciseList']),
    },
    mounted() {
        this.requestExerciseListToSpring()
    },
    methods: {
        ...mapActions(
            exerciseModule, ['requestExerciseListToSpring']
        ),
    }
}

</script>

<style lang="">
    
</style>