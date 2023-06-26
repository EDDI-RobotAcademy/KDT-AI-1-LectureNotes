import axiosInst from '@/utility/axiosInst'

export default {
    requestRegisterFileInfoToSpring ({ }, payload) {

        return axiosInst.post('/file-test/uploadImgsWithText', payload)
            .then(() => {
                alert('파일 저장 요청 성공!')
            })
            .catch(() => {
                alert('문제 발생!')
            })
    },
    requestImageListToSpring ({ }) {
        return axiosInst.get('/file-test/giveMeImageList')
            .then((res) => {
                alert('이미지 리스트 요청: ' + JSON.stringify(res.data))
                return res.data
            })
            .catch(() => {
                alert('문제 발생!')
            })
    }
}