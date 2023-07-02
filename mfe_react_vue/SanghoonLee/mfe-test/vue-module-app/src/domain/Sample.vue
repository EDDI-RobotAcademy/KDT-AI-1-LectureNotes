<script setup>
import {inject, onMounted, ref} from 'vue';
import router from "../router";

const count = ref(0);
const eventBus = inject('eventBus');

onMounted(() => {
    console.log('onMounted: ' + eventBus + ', count: ' + count.value);
    eventBus.on("routing-event", (data) => {
        console.log("Received data in Vue:", data);
        router.push(data)
    });

    eventBus.on("module-unmount", () => {
        console.log("Received module-unmount event");
        // cleanup();
    });
});

</script>

<template>
  
  <p>나는 Vue Module App</p>
  <button title="clickTest" @click="count++">
    빨리 버튼 눌러봐 {{ count }} 번 눌럿어
  </button>
  <router-view/>
</template>