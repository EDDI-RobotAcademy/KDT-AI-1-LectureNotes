<template lang="">
  <form @submit.prevent="onSubmit">
    <table>
      <tr>
        <td>
          <h2>test2</h2>
          <div>
            <input type="text" v-model="name" />
            <label>이름</label>
          </div>
          <div>
            <input type="text" v-model="number" />
            <label>번호</label>
          </div>
          <div>
            <input
              type="file"
              id="files"
              ref="files"
              @change="handleFileUpload()"
            />
            <label>이미지</label>
          </div>
        </td>
      </tr>
    </table>
    <button type="submit">등록</button>
  </form>
</template>

<script>
export default {
  data() {
    return {
      name: "",
      number: "",
      files: "",
    };
  },
  methods: {
    onSubmit() {
      const { name, number, files } = this;
      this.$emit("submit", { name, number, files });
      //   let formData = new FormData();
      //   formData.append(this.files);
      //   formData.append(this.name);
    },
    handleFileUpload() {
      this.files = this.$refs.files.files;
    },
  },
};
</script>

<style lang=""></style>
