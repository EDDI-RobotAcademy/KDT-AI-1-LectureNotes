"use strict";
(self["webpackChunkvue_module_app"] = self["webpackChunkvue_module_app"] || []).push([[912],{

/***/ 912:
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

// ESM COMPAT FLAG
__webpack_require__.r(__webpack_exports__);

// EXPORTS
__webpack_require__.d(__webpack_exports__, {
  mount: () => (/* binding */ mount)
});

// EXTERNAL MODULE: ../node_modules/vue/dist/vue.esm-bundler.js + 6 modules
var vue_esm_bundler = __webpack_require__(117);
;// CONCATENATED MODULE: ../node_modules/vue-loader/dist/index.js??ruleSet[1].rules[4].use[0]!./src/components/Sample.vue?vue&type=script&setup=true&lang=js


const _hoisted_1 = /*#__PURE__*/(0,vue_esm_bundler/* createElementVNode */._)("p", null, "나는 Vue Module App", -1 /* HOISTED */)

;


/* harmony default export */ const Samplevue_type_script_setup_true_lang_js = ({
  __name: 'Sample',
  setup(__props) {

const count = (0,vue_esm_bundler/* ref */.iH)(0)

return (_ctx, _cache) => {
  return ((0,vue_esm_bundler/* openBlock */.wg)(), (0,vue_esm_bundler/* createElementBlock */.iD)(vue_esm_bundler/* Fragment */.HY, null, [
    _hoisted_1,
    (0,vue_esm_bundler/* createElementVNode */._)("button", {
      onClick: _cache[0] || (_cache[0] = $event => (count.value++))
    }, " 빨리 버튼 눌러봐 " + (0,vue_esm_bundler/* toDisplayString */.zw)(count.value) + " 번 눌럿어 ", 1 /* TEXT */)
  ], 64 /* STABLE_FRAGMENT */))
}
}

});
;// CONCATENATED MODULE: ./src/components/Sample.vue?vue&type=script&setup=true&lang=js
 
;// CONCATENATED MODULE: ./src/components/Sample.vue



const __exports__ = Samplevue_type_script_setup_true_lang_js;

/* harmony default export */ const Sample = (__exports__);
;// CONCATENATED MODULE: ./src/bootstrap.js






const mount = (el) => {
    const app = (0,vue_esm_bundler/* createApp */.ri)(Sample)
    app.mount(el)
};

const root = document.querySelector('#vue-module')

if (root) { mount(root) }



/***/ })

}]);
//# sourceMappingURL=912.js.map