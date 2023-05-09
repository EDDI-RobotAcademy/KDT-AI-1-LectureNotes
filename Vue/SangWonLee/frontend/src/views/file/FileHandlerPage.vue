<template lang="">
    <v-container>
        <h3>Vue File Upload 테스트 - Not AWS S3</h3>
        <div>
            <label>파일
                <input type="file" id="files" ref="files" class="inputFileCss"
                        multiple @change="handleFileUpload"/>
                        <!-- 
                            id가 files이고 class가 inputFileCss이고, multiple 속성으로 사용자가 여러 파일을 선택할 수 있게한다.
                            Vue.js에서 사용하는 ref 속성은 컴포넌트 인스턴스에 참조를 추가하는데 사용된다.
                            $refs.files를 사용하면 이 input 태그에 접근할 수 있게 된다.
                            @change 이벤트가 있어서 파일이 선택되면 handleFileUpload 함수가 실행된다.
                        -->
            </label>
            <br><br>
            <button color = "red" @click="submitFiles">파일 및 문자열 함께 전송!</button>
            <!-- 버튼 클릭시 @click 이벤트로 submitFiles 함수 실행 -->

        </div>
    </v-container>
</template>

<script>
import { mapActions } from 'vuex'
// Vuex에서 mapActions 메소드를 가져온다.
// this.$store.dispatch('xxx')를 호출하는 대신 this.xxx()를 호출하여 액션을 dispatch 할 수 있다.
//(액션 핸들러를 실행한다는 뜻임)(액션 핸들러는 커밋을 통해 변이를 실행하거나 비동기 작업을 실행할 수 있다)
const filesModule = 'filesModule'

export default {
    data() {
        return {
            files: '', // String
        }
    },
    methods: {
        ...mapActions(filesModule, ['requestRegisterFileInfoToSpring']),
        // filesModule의 requestRegisterFileInfoToSpring 액션을 매핑한다.
        handleFileUpload() {
            this.files = this.$refs.files.files
        }, // 위에 input태그에 있는 파일을 가져온다.
        // this.$refs.files.files 뜻은 ref 속성이 files로 설정된 입력 요소의 files 속성에 접근한다.

        submitFiles() {
            let formData = new FormData() // FormData 객체 생성 (웹 API임)
            let fileInfo = {
                price: 50000,
                productName: "testProduct",
            } // fileInfo 객체에 price와 productName 속성을 정의

            for (let idx = 0; idx < this.files.length; idx++) {
                formData.append('imageFileList', this.files[idx])
            } // imageFileList 필드를 만들어서 this.files를 모두 추가

            formData.append(
                "fileInfo",
                new Blob([JSON.stringify(fileInfo)], { type: "application/json" })
            ) // fileInfo 필드를 만들어서 해당 필드에 Blob 객체를 할당한다.
            // 이 Blob 객체는 JSON.stringify(fileInfo) 로 생성된 문자열을 포함하고,
            // 이 문자열은 fileInfo 객체를 JSON 형식으로 변환한 것이다.
            // Blob 객체 type은 application/json으로 설정된다.

            this.requestRegisterFileInfoToSpring(formData)
            // 위에서 저장된 formData로 action.js에 있는 requestRegisterFileInfoToSpring를 실행
        }
    }
}
</script>

<style scoped>
.inputFileCss {
    border: 2px solid;
    padding: 5px;
}
</style>