import axiosInst from '@/utility/axiosInst'

export default {
    requestRegisterFileInfoToSpring({ commit }, payload) {
        // 여기서 payload가 뭐지?
        return axiosInst.post('/file-test/uploadImgsWithText', payload)
            .then((res) => {
                alert('파일 저장 요청 성공!')
            })
            .catch(() => {
                alert('문제 발생!')
            })
    },
}