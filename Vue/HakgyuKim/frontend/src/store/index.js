import Vue from "vue";
import Vuex from "vuex";

import boardModule from "@/store/board/BoardModule.js";
import ImageModule from "@/store/image/ImageModule.js";
import exerciseModule from "./d3Homework1/ExerciseModule";
import filesModule from "./files/FilesModule";
import foodModule from "./food/FoodModule";
import FastApiModule from "./fastapi/FastApiModule";

Vue.use(Vuex);

const store = new Vuex.Store({
  modules: {
    boardModule: boardModule,
    ImageModule: ImageModule,
    exerciseModule: exerciseModule,
    filesModule: filesModule,
    foodModule: foodModule,
    FastApiModule: FastApiModule
  },
});

export default store;
