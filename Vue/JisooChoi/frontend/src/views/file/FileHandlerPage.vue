<template lang="">
    <v-container>
        <h3>Vue File Upload 테스트 - Not AWS S3</h3>
        <div>
            <label>
                <input type="file" id="files" ref="files"
                        multiple @change="handleFileUpload" />
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
        },
        submitFiles () {
            // 여기 작업들은 하위 컴포넌트에서 작업을 하고 emit을 하면 된다.
            let formData = new FormData()

            let fileInfo = {
                price: 50000,
                productName: 'testProduct',
            }

            for(let idx = 0; idx < this.files.length; idx++){
                formData.append('imageFileList', this.files[idx])
            }

            formData.append(
                "fileInfo",
                new Blob([JSON.stringify(fileInfo)], {type: "application/json"})
            )

            this.requestRegisterFileInfoToSpring(formData)
        }
    }
}
</script>

<style lang="">
    
</style>