<template>
    <p>나는 Vue Counter Container App</p>
    <div v-if="!isLoadingComponent">
        Loading ...... Vue Counter App
    </div>
    <div v-else-if="loadError">
        Failed to load Vue Counter Component.
    </div>
    <div v-else>
        <VueCounterComponent/>
    </div>
</template>

<script setup>
import { defineAsyncComponent, ref } from 'vue';

const isLoadingComponent = ref(true)
const loadError = ref(false);
const VueCounterComponent = defineAsyncComponent(() =>
    import("vueCounterApp/VueCounter")
        .catch(() => {
            loadError.value = true;
        })
        .finally(() => {
            isLoadingComponent.value = false
        }
    )
)
</script>