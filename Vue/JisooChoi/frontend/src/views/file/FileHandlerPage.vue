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
            /*
                $refs로 해당 태그에 접근 할 수 있다.
                즉, 여기서는 files에 접근한다.

                또한 $refs는 컴포넌트가 렌더링 된 후에 접근이 가능하다.
                refs를 활용하여 자식 컴포넌트 DOM에 접근할 수 있다. 
            */
            this.files = this.$refs.files.files // 하위 컴포넌트가 없는데 ??
        },
        submitFiles () {
            // 여기 작업들은 하위 컴포넌트에서 작업을 하고 emit을 하면 된다.
            let formData = new FormData()

            let fileInfo = {
                price: 50000,
                productName: 'testProduct',
            }

            /*
                ● 우리가 선택한 사진의 개수만큼 리스트에 넣는다.
            */
            for(let idx = 0; idx < this.files.length; idx++){
                /*
                    .append() : 선택된 요소의 마지막에 새로운 요소나 콘텐츠를 추가한다.

                    append(이름, 값) 또는 append(Blop, 파일 이름) 형식으로 사용한다.
                */
                formData.append('imageFileList', this.files[idx]) // files가 리스트였나 ??
            }

            formData.append(
                /*
                    Blob : js에서 이미지, 사운드, 비디오와 같은 멀티미디어 데이터를 다룰 때 사용한다.

                    사용 시, new Blob(array, options); 이러한 형태로 생성한다.
                        1. array : 객체 또는 객체가 혼합된 Array
                        2. options : type과 endings를 설정할 수 있다.
                                    (1) type : 데이터의 MIME 타입을 설정하며, 기본 값은 ""이다.
                                    (2) endings : 문자열 처리를 transparant와 native로 지정이 가능하며, 전자가 기본 값이다.
                */
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