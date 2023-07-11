<template>
  <div>
    <p>나는 Vue Counter Container App</p>
    <div v-if="isLoadingComponent">
      Loading ...... Vue Counter App
    </div>
    <div v-else-if="loadError">
      Failed to load Vue Counter Component.
    </div>
    <div v-else>
      <VueCounterComponent />
    </div>
  </div>
</template>

<script>
import { defineAsyncComponent, ref, onMounted } from 'vue';

export default {
  name: 'VueCounterContainerApp',
  components: {
    VueCounterComponent: defineAsyncComponent(() =>
      import('vueCounterApp/CounterApp')
    ),
  },
  setup() {
    const isLoadingComponent = ref(true);
    const loadError = ref(false);

    onMounted(() => {
      import('vueCounterApp/CounterApp')
        .catch(() => {
          loadError.value = true;
        })
        .finally(() => {
          isLoadingComponent.value = false;
        });
    });

    return {
      isLoadingComponent,
      loadError,
    };
  },
};
</script>