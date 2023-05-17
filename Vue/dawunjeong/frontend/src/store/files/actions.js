import axiosInst from '@/utility/axiosInst'

export default {
    requestRegisterFileInfoToSpring ({}, payload) {

        return axiosInst.post('/file-test/uploadImgsWithText', payload)
            .then(() => {
                alert('파일 저장 요청 성공!')
            })
            .catch(() => {
                alert('문제 발생!')
            })
    },
}