import axiosInst from '@/utility/axiosInst'

export default {
    requestRegisterFileInfoToSpring({ }, payload) {
        // 여기서 payload가 뭐지?
        // 파일 업로드와 함께 서버에 전송될 데이터
        // 클라이언트에서 전송할 파일과 함께 서버에 전송될 데이터가 담겨져 있음
        // FileHandlerPage에서 formData가 payload를 넣음 
        // -> 서버에서 @RequestPart를 통해 받아들일 수 있음
        return axiosInst.post('/file-test/uploadImgsWithText', payload)
            .then((res) => {
                alert('파일 저장 요청 성공!')
            })
            .catch(() => {
                alert('문제 발생!')
            })
    },
    requestImageListToSpring({ }) {
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