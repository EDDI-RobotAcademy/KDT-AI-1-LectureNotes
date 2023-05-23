<template lang="">
    <v-container>
        <h3>Vue File Upload 테스트 - Not AWS S3</h3>
        <div>
            <label>파일
                <input type="file" id="files" ref="files"
                        multiple @change="handleFileUpload"/>
            </label>

            <button @click="submitFiles">파일 및 문자열 함께 전송!</button>
        </div>
    </v-container>
</template>

<script>
import { mapActions } from 'vuex'

const filesModule = 'filesModule'

export default {
    data () {
        return {
            files: '',
        }
    },
    methods: {
        ...mapActions(filesModule, ['requestRegisterFileInfoToSpring']),

        handleFileUpload () {
            this.files = this.$refs.files.files
            // 레퍼런스에 있는 파일을 가져온 것
        },
        submitFiles () {
            let formData = new FormData()

            let fileInfo = {
                price: 50000,
                productName: "testProduct"
                // 이부분은 emit으로 전달됨
            }

            for (let idx = 0; idx < this.files.length; idx++) {
                formData.append('imageFileList', this.files[idx])
            }
            // 실질적으로 위 작업은 하위 컴포넌트에서 작업을 하고 에밋을 하면됨

            formData.append(
                "fileInfo",
                new Blob([JSON.stringify(fileInfo)], { type: "application/json" })
            )

            this.requestRegisterFileInfoToSpring(formData)
            // payload에는 formData가 들어감
        }
    }
}
</script>

<style lang="">
    
</style>