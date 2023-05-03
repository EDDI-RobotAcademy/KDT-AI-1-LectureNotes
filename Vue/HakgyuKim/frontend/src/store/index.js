import Vue from "vue";
import Vuex from "vuex";

import boardModule from "@/store/board/BoardModule.js";
import ImageModule from "@/store/image/ImageModule.js";
import exerciseModule from "./d3Homework1/ExerciseModule";

Vue.use(Vuex);

const store = new Vuex.Store({
  modules: {
    boardModule: boardModule,
    ImageModule: ImageModule,
    exerciseModule: exerciseModule,
  },
});

export default store;
