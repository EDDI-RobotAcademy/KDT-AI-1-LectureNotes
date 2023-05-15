import axiosInst from '@/utility/axiosInst'
// 커밋을 하는 상황이 아니라 액션과 모듈만 필요함
export default {
    requestRegisterFileInfoToSpring ({ commit }, payload) {
        // payload 는 이미지를 전달받음
        return axiosInst.post('/file-test/uploadImgsWithText', payload)       
            .then(() => {
                alert('파일 저장 요청 성공!')
            })
            .catch(() => {
                alert('문제 발생!')
            }) // 여기다 이런식으로 작업하면 사용자에게도 보이므로 좋지않음
    },
    // 쇼는 받은것에 대한 리턴을 바로때림
    requestImageListToSpring({  }) {
        return axiosInst.get('/file-test/giveMeImageList')
        .then((res) => {
            alert('이미지 리스트 요청!' + JSON.stringify(res.data))
            return res.data
        })
        .catch(() => {
            alert('문제 발생')
        })
    }
}