<template lang="">
  <div>
    <form style="text-align: left">
      <fieldset>
        <legend>랜덤 과목 선택</legend>
        <ul>
          <li>
            <label for="subject">과목: </label>

            <select size="2" id="subject" multiple v-model="whichOneSelected">
              <option value="영어를 골랐다">A</option>
              <option value="수학을 골랐다">B</option>
            </select>
          </li>
        </ul>
      </fieldset>
    </form>
    <p>{{ whichOneSelected }}</p>
  </div>
</template>
<script>
export default {
  data() {
    return {
      whichOneSelected: [],
    };
  },
};
</script>
<style lang=""></style>
