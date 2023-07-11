<script setup>
import {inject, onMounted} from 'vue';
import CounterApp from './CounterApp.vue'

const eventBus = inject('eventBus');

onMounted(() => {
    console.log('onMounted: ' + eventBus);
    eventBus.on("routing-event", (data) => {
        console.log("Received data in Vue:", data);
        // router.push(data)
    });

    eventBus.on("module-unmount", () => {
        console.log("Received module-unmount event");
        // cleanup();
    });
});

</script>

<template>
    <CounterApp/>
</template>