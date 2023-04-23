module.exports = {
	env: {
		browser: true,
		es2021: true
	},
	extends: [
		'plugin:vue/essential',
		"eslint:recommended",
	],
	parserOptions: {
		ecmaVersion: 12,
		sourceType: 'module'
	},
	plugins: [
		'vue'
	],
	rules: {
		'vue/multi-word-component-names': ['error', {
			ignores: ['Home']
		}]
	}
}