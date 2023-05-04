<!--
    상품 등록한다고 할 때 상품 이름과 가격만 올라가 있다면? 정보가 너무 없음
    사진과 글자 내역이 같이 올라가야 - 그래서 사진을 올릴 form과 함께 정보를 만든 것 
-->

<template lang="">
     <v-container>
        <h3>Vue File Upload 테스트 - Not AWS S3</h3>
        <div>
            <label>파일
                <input type="file" id="files" ref="files"
                        multiple @change="handleFileUpload"/>
                <!-- 파일 여러개 가져올 수 있도록 멀티 구성 -->     
                <!-- type을 file로 설정하면 알아서 파일 경로 찾아서 선택하도록 함 -->
            </label>

            <button @click="submitFiles">파일 및 문자열 함께 전송!</button>
        </div>
    </v-container>
</template>

<script>
import { mapActions } from 'vuex';

const filesModule = 'filesModule'

export default {
     data() {
        return {
            files: '',
            // 이렇게 만드는 이유가 vue 현재 페이지의 데이터 속성으로 사용하기 위함
        }
    },
    methods: {
        ...mapActions(filesModule, ['requestRegisterFileInfoToSpring']),
        handleFileUpload() {
            this.files = this.$refs.files.files
            // files reference를 하게 되면 input쪽 id와 ref에 있는 files을 가져올 수 있는 것
            // this.$refs.files는 Vue.js에서 ref를 사용할 때 참조하는 방법
            // this.$refs.files.files에서 앞의 files는 
            // input요소에서 선택한 파일들의 정보가 담긴 fileList 객체를 의미함
            // 이 객체는 선택한 파일들의 목록을 나타내어주는 역할
            // 뒤의 files는 그 객체를 배열로 변환해줌
            // 즉, 선택한 파일들의 정보를 가져와 저장하는 배열을 만드는 형태
            // input에 있는 id는 파일을 구분해주기 위한 용도이고  
            // this.$refs.files.files와 직접적인 연관은 없어보임
        },
        submitFiles() {
            // 여기서 데이터 세팅하고 액션이 돌아가는 것
            let formData = new FormData()
            // FormData() 자바스크립트에 내장되어 HTML 양식 데이터를 나타내는 객체
            // formData 객체를 직접 만들어서 보내는 것
            // 아래 append랑 연결됨

            // fileInfo는 emit하면서 얻게 될 것
            // register에서 배웠던 것처럼 하위컴포넌트에서 submit이 발생하면 상위 컴포넌트에서 onSubmit이 동작
            // 그래서 그 전에 어떤 데이터를 작동할지 싹 정리 해놔야 함
            let fileInfo = {
                price: 50000,
                productName: "testProduct",
            }
            for (let idx = 0; idx < this.files.length; idx++) {
                formData.append('imageFileList', this.files[idx])
            // for에서 사진 저장, 아래에서 글자 저장
            // formData.append(name, value): name이 key고 value가 value
            // 사진을 formData에 추가하는 작업
            }
            formData.append(
                "fileInfo",
                new Blob([JSON.stringify(fileInfo)], { type: "application/json" })
                // 타입이 JSON 타입이라는 걸 알려주고 있음
                // Blob은 이미지, 비디오, 오디오와 같이 동적으로 생성된 데이터를 나타내는데 사용되는 객체
                // 큰 데이터 파일을 쉽게 처리할 수 있도록 메모리를 효율적으로 사용하도록 함
                // fileInfo가 key, fileInfo객체를 JSON형식으로 만들어줌
                // 문자열 JSON 형식을 Blob 객체로 변환하는 작업
                // 파일 업로드와 같은 작업에서 사용 
                // 왜 fileInfo를 Blob으로 만드는거지? 이건 사진이 아닌데
                // fileInfo 객체는 문자열 JSON으로 인코딩된 상태이고 이 JSON을 Blob객체로 변환하여
                // formData에 추가하는 것
                // 이진 데이터를 서버로 전송할 때, FormData 객체에 추가하여 전송하는 것이 일반적
                // { type: "application/json" }을 통해 서버에서 JSON.parse() 메서드를 사용하면 변환됨
                // 그리고 formData에 이미지와 상품 정보가 함께 저장되어 전송되는 것
            )
            this.requestRegisterFileInfoToSpring(formData)
            // 날릴 때 폼데이터를 날림
            // formData가 payload가 들어가는 것
        }
    }, 
    // 사진 두 장 다 넣고 요청해보기
    // 실제로 전송이 되는지 볼라면 트리거를 걸어야 함 f12에서 
    // actions 찾아서 return axios 부분에 걸어줘야 함 Source로 들어가서
    // watch에서 payload 검색해서 formData 잘 들어갔는지 확인하기
    // 요청할 때 input에 file이랑 id이름 바꿔보기
}
</script>
<style lang="">
    
</style>