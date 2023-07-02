<template>
    <div>
        <h2>Vue Remotes App</h2>
        <p>{{ message }}</p>
    </div>
</template>

<script>
import {ref, onMounted, inject, onUpdated, onUnmounted} from "vue";

let count = 0
export default {
    name: "App",
    setup() {
        const message = ref("");
        const eventBus = inject("eventBus");

        onMounted(() => {
            console.log('onMounted: ' + eventBus + ', count: ' + count++)
            eventBus.on("dataReceived", (data) => {
                console.log("Received data in Vue:", data);
                message.value = data;
            });

            eventBus.on("module-unmount", () => {
                console.log("Received module-unmount event");
                // 이벤트 처리 로직 작성
            });
        });

        // 컴포넌트가 언마운트될 때 실행되는 코드
        onUnmounted(() => {
            console.log('Component unmounted');
        });

        // 컴포넌트가 업데이트될 때 실행되는 코드
        onUpdated(() => {
            console.log('Component updated');
        });

        return {
            message,
        };
    },
};
</script>

<style scoped>
h1 {
    color: blue;
}
</style>
