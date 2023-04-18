module.exports = {
    env. {
        browser: true,
        es2021: true
    }
    extend: [
    'plugin:vue/essential'
    'standard'
    ]
    parserOption: {
        ecmaVersion: 12,
        sourceType: 'module'
    }
    plugins: [
    'vue'
    ]
    rules: {
        'vue/multi-word-component-names': ['error', {
        'ignores': ['Home']
    }]
}
}