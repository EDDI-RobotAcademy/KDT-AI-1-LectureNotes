<template>
  <v-container>
    <div>
      <nav>
        <router-link to="/">Home</router-link> |
        <router-link to="/about">About</router-link> |
        <router-link to="/check-box-page">체크박스선택</router-link> |
        <router-link to="/hi-page">hi</router-link> |
        <router-link to="/options-page">옵션</router-link> |
        <router-link to="/role-dice-page">주사위</router-link> |
        <router-link to="/carousel-test-page">배너</router-link> |
        <router-link to="/image-test-page">갤러리</router-link> |
        <router-link to="/business-account-test-page">사업자계정생성</router-link> |

      </nav>
    </div>
  </v-container>
</template>

<script>

  export default {
    name: 'HomePagre',

    components: {
    },
  }
</script>