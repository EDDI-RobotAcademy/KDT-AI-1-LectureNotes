import Vue from "vue";
import { shallowMount } from "@vue/test-utils";
import GlobalComponent from "@/components/componentTest/GlobalComponent.vue";

Vue.component(GlobalComponent.name, GlobalComponent);

describe("GlobalComponent.vue props 테스트", () => {
  it("renders props.counter when passed", () => {
    let counter = 0;
    const wrapper = shallowMount(GlobalComponent, {
      propsData: { initialTest: counter },
    });
    expect(wrapper.props().initialTest).toBe(counter);
  });
});
