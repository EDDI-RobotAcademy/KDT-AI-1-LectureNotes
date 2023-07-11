<template lang="">
  <v-container>
    <h1>AWS SDK를 활용한 파일 업로드 테스트</h1>
    <h1>AWS 파일 리스트</h1>
    <div v-for="(file, index) in awsFileList" :key="file.Key">
      #{{ index + 1 }} {{ file.Key }}
      <v-btn @click="deleteAwsS3File(file.Key)" color="red" text icon>x</v-btn>
    </div>
    <input id="file-selector" ref="file" type="file" @change="handleFileUpload()" />
    <v-btn @click="uploadAwsS3" color="primary" text>업로드</v-btn><br />
    <v-btn @click="giveMeAwsS3Next" color="purple" text>다음 정보</v-btn>
  </v-container>
</template>

<script>
import AWS from "aws-sdk";

export default {
  name: "AwsSdkFileUpload",
  data() {
    return {
      file: null,
      awsBucketName: "vue-s3-3737",
      awsBucketRegion: "ap-northeast-2",
      awsIdentityPoolId: "ap-northeast-2:80a79c65-d48c-4b8e-88d8-229292796a41",
      s3: null,
      awsFileList: [],
      startAfterAwsS3Bucket: null,
      awsS3NextToken: null,
    };
  },
  methods: {
    handleFileUpload() {
      this.file = this.$refs.file.files[0];
      console.log("file: " + this.file.name);
    },
    awsS3Config() {
      AWS.config.update({
        region: this.awsBucketRegion,
        credentials: new AWS.CognitoIdentityCredentials({
          IdentityPoolId: this.awsIdentityPoolId,
        }),
      });

      this.s3 = new AWS.S3({
        apiVersion: "2006-03-01",
        params: {
          Bucket: this.awsBucketName,
        },
      });
    },
    uploadAwsS3() {
      this.awsS3Config();

      this.s3.upload(
        {
          Key: this.file.name,
          Body: this.file,
          ACL: "public-read",
        },
        (err, data) => {
          if (err) {
            console.log(err);
            return alert("업로드 중 문제 발생 (사진 파일에 문제가 있음)", err.message);
          }
          alert("업로드 성공");
          this.getAwsS3Files();
        }
      );
    },
    getAwsS3Files() {
      this.awsS3Config();

      let res = this.s3.listObjects(
        {
          Delimiter: "/",
          MaxKeys: 1,
        },
        (err, data) => {
          if (err) {
            return alert("AWS 버킷 내에 문제가 있습니다: " + err.message);
          } else {
            this.awsFileList = data.Contents;
            console.log("s3 리스트: ", data);
            this.startAfterAwsS3Bucket = data.NextMarker;
          }
        }
      );
    },
    giveMeAwsS3Next() {
      this.awsS3Config();

      this.s3.listObjects(
        {
          Delimiter: "/",
          MaxKeys: 1,
          Marker: this.startAfterAwsS3Bucket || undefined,
        },
        (err, data) => {
          if (err) {
            return alert("AWS 버킷 내에 문제가 있습니다: " + err.message);
          } else {
            this.awsFileList = data.Contents;
            console.log("s3 리스트: ", data);
            this.startAfterAwsS3Bucket = data.NextMarker;
          }
        }
      );
    },
    deleteAwsS3File(key) {
      this.awsS3Config();

      this.s3.deleteObject(
        {
          Key: key,
        },
        (err, data) => {
          if (err) {
            return alert("AWS 버킷 데이터 삭제에 문제가 발생했습니다: " + err.message);
          }
          alert("AWS 버킷 데이터 삭제가 성공적으로 완료되었습니다");
          this.getAwsS3Files();
        }
      );
    },
  },
  created() {
    this.getAwsS3Files();
  },
};
</script>

<style lang=""></style>
